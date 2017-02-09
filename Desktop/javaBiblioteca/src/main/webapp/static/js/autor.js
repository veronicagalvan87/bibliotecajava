$(document).ready(function() {
	editarJugador();
	borraJug();
})

var limpiarModal=function(){
	$('.modal-title').text("Añadir Autor");
	$('#nombre-jugador').val('');
	$('#inputId').val('');
}

var cogerId=function(){
	$(document).on("click", ".open-Modal", function() {
		var putita = $(this).data('id');
		var nomfede = $(this).data('nombre');
		$(".modal-body #autor").val(putita);
		$(".modal-body #autorNombre").text(nomfede);
	});
}

var borraJug=function(){
	cogerId();
	
	$(".btn-borrar").on("click", function() {
		var id = $(".modal-body #autor").val();
		$.ajax({
			url : "/javaBiblioteca/autores/" + id,
			
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

var editarJugador= function() {
	cogerId();
	
	$(".editar-autor").on('click', function() {
		var id = $(this).parents('tr').data('id');
		var url = '/javaBiblioteca/autores/' + id;
		console.log("hola");

		$.get(url).done(function(autor) {
			dataType: 'json',
			$('.modal-title').text("Editar Autor");
			$('#nombre-autor').val(autor.nombre);
			
			$('#inputId').val(autor.id);
			$('#modal-autor').modal('show');
		}).fail(function(jqXHR, textStatus, errorThrown) {
	        console.log("The following error occured: " + textStatus, errorThrown);
	    });
		$('#modal-autor').on('hide.bs.modal', limpiarModal);

	})

}



