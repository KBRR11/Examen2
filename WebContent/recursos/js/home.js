$(document).ready(function (){
});
$("#login").click(function (){
   $("#myModal").modal('show');
});
$("#sigin").click(function (){
    var x = $("#user").val();
    var y = $("#pass").val();
    if (x === "" || y === ""){
    	$("#user").popover({
			  trigger: 'focus',
			  content: 'Porfavor, Ingrese Un Usuario y Contraseña',
			  placement:'top',
		        title:  'ATENCION!!'
		});
		$("#user").popover('show');
	}else{
		alert("espera");
	}
    
    $.post("main",{"user":x,"pass":y,"op":1});

  /* $("#myModal").modal('hide');*/
   
  
});