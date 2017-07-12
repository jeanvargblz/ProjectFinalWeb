$(document).ready(function(){
	$("#saveCiudad").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombreCiudad']" ).val(),
		url = $form.attr( "action" );
		$("#subcuerpoLugar").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"nombre": nombre},
				success: function(data){
					$("#subcuerpoLugar").html(data);
				}
		});
	});
	$("#savePaquete").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombrePlato']" ).val(),
		tipo = $form.find( "select[name='tipo']" ).val(),
		descripcion = $form.find( "textarea[name='descripcion']" ).val(),
		precio = $form.find( "input[name='precio']" ).val(),
		url = $form.attr( "action" );
		$("#cuerpoAgregarPlato").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"nombre": nombre,"tipo": tipo,"descripcion": descripcion,
				"precio": precio},
				success: function(data){
					$("#cuerpoAgregarPlato").html(data);
				}
		});
	});
	$("#saveHospedaje").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		nombre = $form.find( "input[name='nombreHospedaje']" ).val(),
		tipo = $form.find( "select[name='tipoHospedaje']" ).val(),
		descripcion = $form.find( "textarea[name='descripcionHospedaje']" ).val(),
		precio = $form.find( "input[name='precioHospedaje']" ).val(),
		url = $form.attr( "action" );
		$("#cuerpoAgregarBebida").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');	
		$.ajax({
			type: "POST",
			url: url,
			data: {"nombreHospedaje": nombre,"tipoHospedaje": tipo,"descripcionHospedaje": descripcion,
				"precioHospedaje": precio},
				success: function(data){
					$("#cuerpoAgregarBebida").html(data);
				}
		});
	});
	
	$("#saveImagenHospedaje").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		file = $form.find( "input[name='myFile']" ).val(),
		url = $form.attr( "action" );

		$.ajax({
			type: "POST",
			url: url,
			data: {"myFile": file},
				success: function(data){
					$("#anadirImagenHospedaje").html(data);
				}
		});
	});
	$("#saveImagen").submit(function(event) {

		event.preventDefault();
		var $form = $(this),
		file = $form.find( "input[name='myFile']" ).val(),
		url = $form.attr( "action" );
			
		$.ajax({
			type: "POST",
			url: url,
			data: {"myFile": file},
				success: function(data){
					$("#anadirImagenBebida").html(data);
				}
		});
	});
});