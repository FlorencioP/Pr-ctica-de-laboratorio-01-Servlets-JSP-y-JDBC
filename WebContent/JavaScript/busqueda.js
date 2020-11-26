function buscarPorCedula() {

}



function buscar() {

    var mail = document.getElementById("textoabusc").value;



    if (mail == "") {

        document.getElementById("informacion").innerHTML = " <b>No se a detectado el Mail</b>";


    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/JSPs/CargarTablaInvitados.jsp", true);
        xmlhttp.send();
    }
    return false;
}