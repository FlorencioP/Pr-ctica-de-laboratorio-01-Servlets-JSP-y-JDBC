<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    <p>Viñedo del Amanecer: Menu de Pedidos</p>

    <div id="volver">
        <a href="../../index.html"><img src="../../Recursos/logout.png"></a>
    </div>


    <form id="verpedidos">
        <input type="button" value="Ver pedidos" onclick="buscarCat()" /><br>
    </form>



    <form id="verpedidos">
        <input type="button" value="Crear pedidos" onclick="buscarCat()" /><br>
    </form>



	<c:set var="u" scope="request" value="${usu}" />
	<h1>Persona encontrada</h1>		

	<p>Id: ${u.id}</p>
	<p>Nombre: ${u.nombre}</p>
	<p>Apellido: ${u.apellido}</p>
	<p>Correo: ${u.correo}</p>
	<p>Password: ${u.password}</p>
	<p>Rol: ${u.rol}</p>
	<p>EmpresaID: ${u.FKEmpID}</p>







</body>
</html>