
$(document).ready(function (){
});
$("#login").click(function (){
   $("#myModal").modal('show');
});
$("#idlogin").click(function (){
    var x = $("#user").val();
    var y = $("#pass").val();
    alert("HOLA");
    $.post("home",{"user":x,"pass":y,"op":1});

   $("#myModal").modal('hide');
});