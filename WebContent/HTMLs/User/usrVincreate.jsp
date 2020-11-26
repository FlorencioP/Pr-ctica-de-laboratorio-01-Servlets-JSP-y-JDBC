<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Viñedo del Amanecer</title>

    <link rel="stylesheet" type="text/css" href="../../CSS/ususVin.css" />
    <script src='../../JavaScript/busquedaUsu.js'></script>

</head>


<body>


    <p>Viñedo del Amanecer: Realizar Pedido</p>

    <div id="volver">
        <a href="../../index.html"><img src="../../Recursos/fecha.png"></a>
    </div>


    <form action="">
        <label for="cant">Cantidad:</label><input name="cant" type="text">
    </form>


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