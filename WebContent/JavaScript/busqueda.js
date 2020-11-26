
function buscarCat() {
	var combo = document.getElementById("cat");
	var selected = combo.options[combo.selectedIndex].text;
	if(selected=="Todas"){
		selected=0;
	}
	else if(selected=="Pan"){
		selected=1;
	}
	else{
		selected=2;
	}
	buscar(selected);
}



function buscar(select) {

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

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/FiltrarProdPorCatInv?idCat="+select, true);
        xmlhttp.send();


    return false;
}


function crearPedU(idEmp) {
		console.log(idEmp);
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/VizualiProdCrearPed?idEmp="+idEmp, true);
        xmlhttp.send();


    return false;
}