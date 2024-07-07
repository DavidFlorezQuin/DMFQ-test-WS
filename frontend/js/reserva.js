var ValidarReturn = localStorage.getItem('vueloReturn');
var ValidarVueloIda = localStorage.getItem('vueloIda');
var DataInfo = localStorage.getItem('dataAsiento');

$(document).ready(function () {
    dataVueloIda();
    dataReturn();
    dataTickets();
    listaPaises();

});

function dataVueloIda() {

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

function dataReturn() {

    if (ValidarReturn) {
        const returnContainer = document.getElementById('cointainer-return')
        returnContainer.classList.remove('d-none')

        var dataReturn = JSON.parse(ValidarReturn);

        $('#origenReturn').val(dataReturn.origenAeropuerto);
        $('#destinoReturn').val(dataReturn.destinoAeropuerto);
        $('#numeroReturn').val(dataReturn.flightNumber);
        $('#fechaReturn').val(dataReturn.date);
        $('#horaReturn').val(dataReturn.time);
    }
}

var dataAsiento = JSON.parse(DataInfo);

var numTickets = parseInt(dataAsiento.tickets);

function dataTickets() {

    if (DataInfo) {

        $('#tickets').text(numTickets);
        $('#register').text(numTickets);

    }
}

let pasajeros = [];


function agregarPasajeros() {


var num = 2; 
    if (num != 0) {

        num--;

        let pasajero = {

            nombre: document.getElementById('nombre').value,
            apellido: document.getElementById('apellido').value,
            correo: document.getElementById('correo').value,
            pasaporte: document.getElementById('pasaporte').value,
            pais: document.getElementById('paises').value,
            telefono: document.getElementById('telefono').value,
            foto: document.getElementById('foto').value

        };

        pasajeros.push(pasajero);

        document.getElementById('nombre').value = '';
        document.getElementById('apellido').value = '';
        document.getElementById('correo').value = '';
        document.getElementById('pasaporte').value = '';
        document.getElementById('paises').value = '';
        document.getElementById('telefono').value = '';
        document.getElementById('foto').value = '';

        var html = ``;

        pasajeros.forEach(function (item) {
            html += `<tr>
            <td>${item.nombre}</td>
            <td>${item.apellido}</td>
            <td>${item.correo}</td>
            <td>${item.pasaporte}</td>
            <td>${item.pais}</td>
            <td>${item.telefono}</td>
            <td>${item.foto}</td>
        </tr>`;
        });

        $("#resultData").html(html);
        
        // $('#register').text(numTickets);
    }
    else {
        alert("compra más")
    }

}

function listaPaises() {
    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/countries",
        method: "GET",
        dataType: "json",
        success: function (response) {
            var html = "";
            var data = response.data;

            data.forEach(function (item) {
                html += `<option value="${item.id}">${item.name}</option>`
            });
            $("#paises").html(html)
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function enviarTicketes() {

    var nombre = $('#nombre').val()
    var apellido = $('#apellido').val()
    var pasaporte = $('#pasaporte').val()
    var paises = $('#paises').val()
    var telefono = $('#telefono').val()
    var correo = $('#correo').val()


    var datos = {
        state: true,
        bookingReference: "ADA1",
        confirmed: "YES",
        email: correo,
        firstName: nombre,
        lastName: apellido,
        passportNumber: pasaporte,
        passportPhoto: "xxx",
        phone: telefono,
        cabinTypesId: {
            id: 1
        },
        passportCountryId: {
            id: paises
        },
        schedulesId: {
            id: 1
        },
        userId: {
            id: 1
        }
    }
    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/tickets",
        method: "POST",
        contentType: 'aplicaction/json',
        data: JSON.stringify(datos),
        success: function (response) {
            alert("exitos")
            console.log('Respuesta del servidor:', response);

        },
        error: function (error) {
            console.log(error)
        }
    })

}
