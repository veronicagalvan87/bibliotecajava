$(document).ready(function(){
	$(document).on("click", ".open-Modal", function () {
		var Fede = $(this).data('id');
		var nomfede =$(this).data('nombre');
		$(".modal-body #Fede").val( Fede);
		$(".modal-body #fedenombre").text( nomfede);
		});
	
	$(".btn-borrar").on("click",function(){
		var id=$(".modal-body #Fede").val();
		$.ajax({
			url : "/Pinkfloyd/federaciones/" + id,
			type : 'DELETE',
			success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
			}
		});
	})
	$(".editar-fede").on('click', function() {
		var id = $(this).parents('tr').data('id');
		var url = '/Pinkfloyd/federaciones/'+id;
		console.log("hola");
		
		$.get(url)
			.done(function(federacion) {
				$('.modal-title').text("Editar Federacion");
				$('#nombre-fede').val(federacion.nombre);
				$('#pais-fede').val(federacion.pais);
				$('#imagen-fede').val(federacion.imagen)
				$('#id-fede').val(federacion.id);

				$('#modal-federacion').modal('show');
			})
	})
}) 