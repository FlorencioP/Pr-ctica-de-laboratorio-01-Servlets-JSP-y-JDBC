<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<c:set var="e" scope="request" value="${idEmp}" />
	<h1>Crear Producto</h1>		
	
	<FORM id="formularioM" >
	
		<h5>Nombre del Producto: </h5> 
		<input name="nombre" type="text" />
		
		<h5>Precio del Producto: </h5> 
		<input name="precio" type="text" />
		
		<h5>Descripcion del Producto: </h5> 
		<input name="desc" type="text" />
		
		<!--  <h5>Imagen del Producto: </h5> -->
		<input name="img" type="hidden" value="o" />
		
		<input name="empl" type= "hidden" value= "${e}"/>
		
		<h5>Selecione la categoria del producto: </h5> 
		
		
		<select name="sel">
	  		<option value="2">Vino</option> 
		  	<option value="1">Pan</option>
		  	<option value="3">Quesos</option>
		</select>
	
	
		<INPUT type="button" onclick="guardarDatos()"  value="Guardar"/>
		
	</FORM>
		
		
	<!-- prod_id, prod_nombre, prod_precio, prod_descripcion, prod_im, empresas_emp_id, categorias_cat_id -->
	
