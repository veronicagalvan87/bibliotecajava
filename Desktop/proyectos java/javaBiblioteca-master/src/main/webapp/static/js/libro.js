$(document).ready(function() {
	editarLibro();
	borrarLib();
	cogerLibrosAJAX();
})

var limpiarModal=function(){
	$('.modal-title').text("Añadir Libro");
	$('#titulo-libro').val('');
	$('#inputId').val('');
}

var cogerLibrosAJAX = function(){
	
	$("#AJAXtitulolibro").on("keyup",function(){
		
		var titulo = $("#AJAXtitulolibro").val();
		
		$.ajax({
            url : 'libros/title='+titulo,
            type : 'GET',
            success: function(response) {
                $('#ajaxOutput').html(response);
            	editarLibro();
            	borrarLib();
            }
        });
        return false;
		
	});
	
}

var cogerId=function(){
	$(document).on("click", ".open-Modal", function() {
		var putita = $(this).data('id');
		var nomfede = $(this).data('nombre');
		$(".modal-body #libro").val(putita);
		$(".modal-body #libroNombre").text(nomfede);
	});
}

var borrarLib=function(){
	cogerId();
	
	$(".btn-borrar").on("click", function() {
		var id = $(".modal-body #libro").val();
		var token = $("meta[name='_csrf']").attr("content");

		var header = $("meta[name='_csrf_header']").attr("content");

		$(document).ajaxSend(function(e, xhr, options) {

			xhr.setRequestHeader(header, token);

		});
		$.ajax({
			url : "/javaBiblioteca/libros/" + id,
			
			type : 'DELETE',
			 error: function(xhr, status, error) {
		            alert(status);
		            alert(this.url);
		            alert(xhr.responseText);
		        },
			success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
			}
		
		});
	})
}

var editarLibro= function() {
	cogerId();
	
	$(".editar-libro").on('click', function() {
		var id = $(this).parents('tr').data('id');
		var url = '/javaBiblioteca/libros/' + id;
		alert(id);

		$.get(url).done(function(libro) {
			dataType: 'json',
			$('.modal-title').text("Editar Libro");
			$('#titulo-libro').val(libro.titulo);
			$('#autor').val(libro.autor.id);
			$('#categoria').val(libro.categoria);
			$('#inputId').val(libro.id);
			
			$('#modal-libro').modal('show');
		}).fail(function(jqXHR, textStatus, errorThrown) {
	        console.log("The following error occured: " + textStatus, errorThrown);
	    });
		$('#modal-libro').on('hide.bs.modal', limpiarModal);

	})

}
