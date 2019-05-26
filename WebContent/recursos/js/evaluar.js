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
			alert(data);
	       var x = JSON.parse(data);
	       $("#iddatos").val(x.dni);
	       // $("#edit_nomrol").val(String.idpersona);
	    });
}
/*function evaluar(x){
    $.get("unv",{"op":1,"idpersona2":x},function (data) {
       var x = JSON.parse(data);
        $("#edit_nomrol").val(x.nombres);
        $("#edit_idrol").val(x.apellidos);
    });
    $("#myModal2").modal('show');
}*/