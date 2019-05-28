$(document).ready(function (){
	var nombre2=$("#idnom_user").val();
	var a=dividirCadena(nombre2, " ");
	buscarid(a);
});
function dividirCadena(cadenaADividir,separador) {
	   var arrayDeCadenas = cadenaADividir.split(separador);
	   return arrayDeCadenas[0];
	}
function buscarid(nombre2) {
	//alert(nombre2);
	$.get("unv",{"opc":1,"nombre":nombre2},function (data) {
			
	       var x = JSON.parse(data);
	       $("#iddatos").val(x.dni);
	       
	    });
}


function actualizar(){
	var nombre=$("#nom").val();
	var apellido=$("#apell").val();
	var password=$("#pass").val();
	$.post("unv",{"nom":nombre,"apell":apellido,"pass":password,opc:3},function (data) {
		
		alert("Actualizacion Exitosa!!");
		
		
    });

}