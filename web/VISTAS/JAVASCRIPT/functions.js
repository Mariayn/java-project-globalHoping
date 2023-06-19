/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function verifyPass(){
    var pass1 = document.getElementById("pass").value;
    var pass2 = document.getElementById("pass2").value;
        if(pass1 !== pass2){
            //event.preventDefault();
            alert("Las claves introducidas no son iguales");
            return false;
    }
}

function displayRadioValue() {
        var ele = document.getElementsByName('radioName');
          
        for(i = 0; i < ele.length; i++) {
            if(ele[i].checked)
            alert("Gender: "+ele[i].value);
        }
}

function showMge(){
    var cif =  document.getElementById("cif").value;
    var address = document.getElementById("address").value;
    var phone = document.getElementById("phone").value;
    
    if(cif =="" || address =="" || phone==""){
        //alert("vacio");
        var link = document.getElementById("linker");
        link.setAtributte = ("href","#");
        
        var styles = {

//.tooltip:hover .tooltiptext
    tooltipHoverTooltiptextClass: {
            visibility: "visible"
    }
}
    }
}

function closeModal(){
const cont_cookies  = document.querySelector('.cookies-box');
cont_cookies.style.display = "none";

window.location="../setCookieController";
 }
  

