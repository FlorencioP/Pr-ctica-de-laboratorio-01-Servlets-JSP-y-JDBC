<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<c:set var="u" scope="request" value="${usu}" />
    
    <% Usuario u = (Usuario) request.getAttribute("usu"); %>
    
    <% 
    
    if (u.getFKEmpID() == 1){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioVin.css' />");
    }else if (u.getFKEmpID() == 2){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioAer.css' />");
    }else{
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorio9ci.css' />");
    }
    %>
    <script src='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/JavaScript/busqueda.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		
		 	<% 
    
		    if (u.getFKEmpID() == 1){
		    	out.println("<p>Vi�edo del Amanecer: Menu de Pedidos</p>");
		    }else if (u.getFKEmpID() == 2){
		    	out.println("<p>Aeropostale: Menu de Pedidos</p>");
		    }else{
		    	out.println("<p>Mercado 9cito: Menu de Pedidos</p>");
		    }
		    %>
		 
		 <% PrintWriter out2= response.getWriter();%>
		 
	    <div id="volver">
	        <a href="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/Salir"><img src="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/Recursos/logout.png"></a>
	    </div>
	
	    <div id="verpedidos">
	        <input type="button" value="Ver pedidos" onclick="verPedidos(${u.id})" /><br>
	    </div>
	    
	    <div id="crearpedidos">
	        <input type="button" value="Crear pedidos" onclick="crearPedU(${u.FKEmpID})" /><br>
	    </div>
	    
	    <div id="crear">
		 	<%  
		 	   out.println("<input type='button' id='btnCrear' value='Confirmar Pedido' style='display:none' onclick='confirmar("+
		 					u.getId()+","+u.getFKEmpID()+")' /><br>");
		 	%>
	    </div>
	    
	    <div id="pantalla">
	    	
	    </div>
	</body>
</html>