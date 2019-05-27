var intento=0;
$(document).ready(function (){
});
$("#login").click(function (){
   $("#myModal").modal('show');
   
   
});

$("#send").click(function (){
	intento++;
	alert("Contraseña Incorrecta. Intentos "+intento+"/3")

 // $("#myModal").modal('hide');
});