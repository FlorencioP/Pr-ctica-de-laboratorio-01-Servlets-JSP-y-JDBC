<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Guia Telefonica</title>

    <link rel="stylesheet" type="text/css" href="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioVin.css" />
    <script src='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/JavaScript/busqueda.js'></script>

</head>


<body>


    <p>Menu de Busqueda</p>

    <div id="volver">
        <a href="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/index.html"><img src="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/Recursos/fecha.png"></a>
    </div>

    <form id="cajadecategorias">

        <label for="cat">Seleccione una categoria:</label> <br>
        <select name="cat" id="cat">
        	<option value="s">Todas</option>
            <option value="s">Pan</option>
            <option value="m">Vino</option>
        </select>
        <input type="button" value="Seleccionar categoria" onclick="buscarCat()" /><br>

    </form>

   <!--   <br>

    <form  name="Busqueda" id="busqueda" onsubmit="return buscar()">

        <label for="busqueda ">Busqueda por texto:</label><br>

        <input type="text" id="textoabusc" placeholder="Ingrese una palabra" />

        <input type="button" value="Buscar: " onclick="buscar()" /><br>

    </form>-->

    <div id="informacion">
    		<c:set var="p" scope="request" value="${listaProd}" />
			<% List<Producto> list = (List<Producto>) request.getAttribute("listaProd"); %>
			<% PrintWriter out2= response.getWriter();%>
			<table class='tg' style='width:95%'>
			    <tr>
			        <th class='tg-46ru'>Nombre</th>
			        <th class='tg-46ru'>Precio</th>
			        <th class='tg-46ru'>Descripcion</th>
			        <th class='tg-46ru'>Imagen</th>
			    </tr>
			    <%
		    		for (int i=0;i<list.size();i++){
			    		Producto prod=list.get(i);
			    		out.println("<tr><td class='tg-y698'>"+prod.getNombre()+"</td><td class='tg-y698'>"+prod.getPrecio()+"</td><td" +
			    					" class='tg-y698'>"+prod.getDescripcion()+"</td><td class='tg-y698'><img src='"+prod.getDirImagen()+"'>");
			       	}
			    %>
			</table>
    </div>

</body>


</html>