$(document).ready(function() {
	editarAutor();
	borraAutor();
	buscarAutores();
})

var limpiarModal=function(){
	$('.modal-title').text("Añadir Autor");
	$('#nombre-autor').val('');
	$('#inputId').val('');
}

var cogerId=function(){
	$(document).on("click", ".open-Modal", function() {
		var id = $(this).data('id');
		var nomauto = $(this).data('nombre');
		$(".modal-body #autor").val(putita);
		$(".modal-body #autorNombre").text(nomauto);
	});
}

var buscarAutores = function(){
	$("#AJAXnombreAutor").on("keyup",function(){
		var nombre=$("#AJAXnombreAutor").val();
		$.ajax({
            url : 'autores/name='+nombre,
            type : 'GET',
            success: function(response) {
                $('#ajaxOutput').html(response);
            	editarAutor();
            	borraAutor();
            }
        });
        return false;
	})
}


var borraAutor = function() {
	cogerId();

	$(".btn-borrar").on("click", function() {
		var id = $(".modal-body #autor").val();
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
		$.ajax({
			url : "/javaBiblioteca/autores/" + id,
			type : 'DELETE',
			error : function(xhr, status, error) {
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

var editarAutor = function() {
	cogerId();

	$(".editar-autor").on(
			'click',
			function() {
				var id = $(this).parents('tr').data('id');
				var url = '/javaBiblioteca/autores/' + id;

				$.get(url).done(function(autor) {
					dataType: 'json', $('.modal-title').text("Editar Autor");
					$('#nombre-autor').val(autor.nombre);

					$('#inputId').val(autor.id);
					$('#modal-autor').modal('show');
				}).fail(
						function(jqXHR, textStatus, errorThrown) {
							console.log("The following error occured: "
									+ textStatus, errorThrown);
						});
				$('#modal-autor').on('hide.bs.modal', limpiarModal);

			})

}




