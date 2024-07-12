var ValidarReturn = localStorage.getItem('vueloReturn');
var ValidarVueloIda = localStorage.getItem('vueloIda');
var DataInfo = localStorage.getItem('dataAsiento');


var dataIda = JSON.parse(ValidarVueloIda);
var dataAsiento = JSON.parse(DataInfo);

var numTickets = parseInt(dataAsiento.tickets);
var tipoAsiento = parseInt(dataAsiento.asientos);


$(document).ready(function () {
    dataVueloIda();
    dataReturn();
    dataTickets();
    listaPaises();

});

function dataVueloIda() {

    if (ValidarVueloIda) {


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

function dataTickets() {

    if (DataInfo) {

        $('#tickets').text(numTickets);
        $('#register').text(numTickets);

    }
}

let pasajeros = [];


function agregarPasajeros() {


    if (numTickets != 0) {

        numTickets--;

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

         $('#register').text(numTickets);
    }
    else {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "No puedes agregar más pasajeros!",
            footer: '<a href="../routes.html">Comprar más tickets</a>'
          });
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

    
    pasajeros.forEach(function(pasajero){

        var datos = {
            state: true,
            bookingReference: "ADA1",
            confirmed: "YES",
            email: pasajero.correo,
            firstName: pasajero.nombre,
            lastName: pasajero.apellido,
            passportNumber: pasajero.pasaporte,
            passportPhoto: pasajero.foto,
            phone: pasajero.telefono,
            cabinTypesId: {
                id: tipoAsiento
            },
            passportCountryId: {
                id: pasajero.pais
            },
            schedulesId: {
                id: dataIda.id
            },
            userId: {
                id: 1
            }
        };

    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/tickets",
        method: "POST",
        contentType: 'application/json',
        data: JSON.stringify(datos),
        success: function (response) {
            Swal.fire({
                title: "Buen Viaje!",
                text: "Tickete exitosamente registrado!",
                icon: "success"
              }).then((result) => {
                if (result.isConfirmed) {
                    localStorage.removeItem('vueloReturn'); 
                    localStorage.removeItem('vueloIda'); 
                    localStorage.removeItem('dataAsiento'); 
                    window.location.href = "http://127.0.0.1:5500/routes.html"; 
                }
            });
        },
        error: function (error) {
            console.log(error)
        }
    })
});

}

function cargarDataVuelo(){

    var factura = {
        tickets: parseInt(dataAsiento.tickets),
        silla: tipoAsiento,
        vuelo: dataIda.id
    }

    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/tickets/facturacion",
        method: "POST",
        contentType: 'application/json',
        data: JSON.stringify(factura),
        success: function (response) {

            datos = response.data 

            $("#origenFactura").text(dataIda.origenAeropuerto);
            $("#destinoFactura").text(dataIda.destinoAeropuerto);
            $("#horaFactura").text(dataIda.time);
            $("#ticketFactura").text(parseInt(dataAsiento.tickets));
            $("#precioUnitario").text(datos.precioUnitario);
            $("#precioFactura").text(datos.precioTotal);

        },
        error: function (error) {
            console.log(error)
        }
    })    



}