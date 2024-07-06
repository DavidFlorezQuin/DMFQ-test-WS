
function dataVueloIda(){

    var ValidarVueloIda = localStorage.getItem('vueloIda');
    
    if (ValidarVueloIda) {

        var dataIda = JSON.parse(ValidarVueloIda);
        
        console.log(dataIda)
        $('#origen').val(dataIda.origenAeropuerto);
        $('#destino').val(dataIda.destinoAeropuerto);
        $('#numero').val(dataIda.flightNumber);
        $('#fecha').val(dataIda.date);
        $('#hora').val(dataIda.time);
    }
}

function dataReturn(){

    var ValidarReturn = localStorage.getItem('vueloReturn');
    
    if(ValidarReturn){
        const returnContainer = document.getElementById('cointainer-return')

        returnContainer.classList.remove('d-none')
        returnContainer.classList.add('d-flex')
        
    }
}

$(document).ready(function() {
    dataVueloIda();
    dataReturn();
});


