$(document).ready(function(){
	$(document).on("click", ".open-Modal", function () {
		var Fede = $(this).data('id');
		var nomfede =$(this).data('nombre');
		$(".modal-body #equipo").val( Fede);
		$(".modal-body #equipoNombre").text( nomfede);
		});
	
	$(".btn-borrar").on("click",function(){
		var id=$(".modal-body #equipo").val();
		$.ajax({
			url : "/Pinkfloyd/equipos/" + id,
			type : 'DELETE',
			success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
			}
		});
	})
	
	
	$(".editar-equi").on('click', function() {
		var id = $(this).parents('tr').data('id');
		var url = '/Pinkfloyd/equipos/'+id;
		console.log("hola");
		
		$.get(url)
			.done(function(equipo) {
				$('.modal-title').text("Editar Federacion");
				$('#nombre-equipo').val(equipo.nombre);
				$('#estadio-equipo').val(equipo.estadio);
				$('#presupuesto-equipo').val(equipo.presupuesto)
				$('#imagen-equipo').val(equipo.imagen)
				$('#id-equipo').val(equipo.id)
				$('#fede-equipo').val(equipo.fede.id);

				$('#modal-equipo').modal('show');
			})
	})
})