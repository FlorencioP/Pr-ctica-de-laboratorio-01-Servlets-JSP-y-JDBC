<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<c:set var="p" scope="request" value="${listaProd}" />
	
	
	<label for="cat">Seleccione una categoria para buscar:</label>
        <select name="cat" id="cat">
        	<option value="1">Pan</option>
            <option value="2">Vino</option>
            <option value="3">Quesos</option>
        </select>
        
    <label for="busc">Ingrese una palabra o letra: </label>
    <input name="busc" type="text"/>
        
    <input type="button" value="Buscar: " onclick="buscarProds()"/><br>
	
	
			<% List<Producto> list = (List<Producto>) request.getAttribute("listaProd"); %>
			<% PrintWriter out2= response.getWriter();%>
			<table class='tg' style='width:95%'>
			    <tr>
			        <th class='tg-46ru'>Nombre</th>
			        <th class='tg-46ru'>Precio</th>
			        <th class='tg-46ru'>Descripcion</th>
			        <th class='tg-46ru'>Imagen</th>
			        <th class='tg-46ru'>Categoria</th>
			        <th class='tg-46ru'>Editar</th>
			        <th class='tg-46ru'>Eliminar</th>
			       
			    </tr>




			    <%
		    		for (int i=0;i<list.size();i++){
			    		Producto prod=list.get(i);
			    		int id = prod.getId();
			    		out.println("<tr><form> <td class='tg-y698'><input name='nombre"+id+"' type='text' value ='"+prod.getNombre()+"'/></td>"+
			    		"<td class='tg-y698' ><input name='precio"+id+"' type='text' value ='"+prod.getPrecio()+"'/></td><td" +
			    					" class='tg-y698' ><input name='descrip"+id+"' type='text' value ='"+prod.getDescripcion()+"'/></td><td class='tg-y698' ><input name='img"+id+"' type='text' value ='"+prod.getDirImagen()+"'/></td>" +
			    						"<td class='tg-y698'><select name='sel"+id+"'> <option value='1'>Pan</option> <option value='2'>Vino</option>  <option value='3'>Quesos</option></select></td>"+
			    							"<td class='tg-y698'><BUTTON onclick='editarprod("+id+")'>Guardar Edicion</BUTTON></td><td class='tg-y698'><BUTTON onclick='eliminarprod("+id+")'>ELIMINAR</BUTTON></form></td>");
			       	}
			    %>
			
			</table>


