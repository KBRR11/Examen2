    var intentos=0;
$("#idenviar2").click(function (){
	alert("Hola");
    if (intentos<3) {
    	 var usuario = $("#idnomuser").val();
    	 var pass = $("#pass1").val(); 
    	 console.log(usuario,pass);
    	 $.post("home",{"user":usuario,"pass":pass,"opc":1});
    	 $("#myModal").modal('hide');
	} else {
		$("#myModal").modal('hide');

	}
});