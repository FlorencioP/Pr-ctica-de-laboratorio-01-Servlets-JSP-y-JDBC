<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioVin.css" />
    <script src='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/JavaScript/busqueda.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		 <c:set var="u" scope="request" value="${usu}" />
		 <p>Vi�edo del Amanecer: Menu de Pedidos</p>
	
	    <div id="volver">
	        <a href="../../index.html"><img src="../../Recursos/logout.png"></a>
	    </div>
	
	
	    <div id="verpedidos">
	        <input type="button" value="Ver pedidos" onclick="buscarCat()" /><br>
	    </div>
	    
	    <div id="crearpedidos">
	        <input type="button" value="Crear pedidos" onclick="crearPedU(1)" /><br>
	    </div>
	    <div id="pantalla">
	    	
	    </div>
	</body>
</html>