<%-- 
    Document   : p.jsp
    Created on : 31/05/2018, 07:02:08 PM
    Author     : alum.fial1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%String nombre = (String)session.getAttribute("nombres"); %>
    <%String ape = (String)session.getAttribute("ape"); %>
    <%String nom = (String)session.getAttribute("nom"); %>
    <%String rol = (String)session.getAttribute("rol"); %>
    <%String user = (String)session.getAttribute("user"); %>
        <h1>Perfil Usuario <%= nombre %></h1>
        <hr>
        <div style="max-width: 400px;">
                <div class="form-group">
                    <label>Apellidos:</label>
                    <input type="text" class="form-control" id="apell" value="<%= ape %>">
                </div>
                <div class="form-group">
                    <label>Nombres:</label>
                    <input type="text" class="form-control" id="nom" value="<%= nom %>">
                </div>
                <div class="form-group">
                    <label>Rol:</label>
                    <select id="rol"  class="form-control">
                        <option ><%= rol %></option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Usuario:</label>
                    <input type="text" class="form-control" id="user" value="<%= user %>">
                </div>
                <div class="form-group">
                    <label>Clave:</label>
                    <input type="password" class="form-control" id="pass" value="yyyy" onclick ="this.value''">
                </div>
        </div>
    </body>
</html>
