
var origenID;
var destinoID;

$(document).ready( function () {
    $('#miTabla').DataTable();
    $('#miTabla2').DataTable();
} );

function autoComplete() {
    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/airpots",
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            var autocomplete = []

            data.forEach(function (item) {
                autocomplete.push({ label: item.name, value: item.id });
            });

            $("#origen").autocomplete({
                source: autocomplete,
                select: function (event, ui) {
                    $(this).val(ui.item.label);
                    origenID = ui.item.value
                    return false;
                }
            })

            $("#destino").autocomplete({
                source: autocomplete,
                select: function (event, ui) {
                    $(this).val(ui.item.label);
                    destinoID = ui.item.value
                    return false;
                }
            })

        },
        error: function (error) {
            console.error(error);
        }
    });
}

function showTable() {
    const notRetorno = document.getElementById('notRetorno');
    const returnOutputData = document.getElementById('returnOutputData');
    const btn = document.getElementById('btn-regreso');


    if (notRetorno.checked) {
        returnOutputData.classList.add('d-none');
        btn.classList.remove('d-flex');
        btn.classList.add('d-none');
        // searchBotton.setAttribute('onclick', 'loadData()');
    } else {
        returnOutputData.classList.remove('d-none');
        btn.classList.add('d-flex');
        // searchBotton.setAttribute('onclick', 'buscarAmbosVuelos()');
    }
}


function envioFormulario() {

    const notRetorno = document.getElementById('notRetorno');

    if (notRetorno.checked) {
        vueloIda()
    } else {
        vueloIda()
        vueloRetorno();
    }
}


function vueloIda() {

    var inicioInput = $('#inicio').val();

    var datos = {
        "origen": origenID,
        "destino": destinoID,
        "fecha": inicioInput,
    };

    var datosJson = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/schedules/Flight",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: datosJson,
        success: function (response) {
            var html = ``;
            response.data.forEach(function (item, index) {
                html += `<tr id="row-${index}">
                    <td>${item.origenAeropuerto}</td>
                    <td>${item.destinoAeropuerto}</td>
                    <td>${item.flightNumber}</td>
                    <td>${item.date}</td>
                    <td>${item.time}</td>
                </tr>`;

            });

            $("#tablaData").html(html);
            response.data.forEach(function (item, index) {

                document.getElementById(`row-${index}`).addEventListener('click', function () {
                    if (this.classList.contains('table-active')) {
                        this.classList.remove('table-active');
                    } else {
                        document.querySelectorAll('tr').forEach(row => {
                            this.classList.add('table-active');
                        });
                    }

                    const data = {
                        origenAeropuerto: item.origenAeropuerto,
                        destinoAeropuerto: item.destinoAeropuerto,
                        flightNumber: item.flightNumber,
                        date: item.date,
                        time: item.time,
                        id: item.id
                    };

                    localStorage.setItem('vueloIda', JSON.stringify(data));

                });
            });


        },
        error: function (xhr, status, error) {
            console.error("Error en la solicitud:", error);
        }
    })

    console.log(datosJson)
}

function vueloRetorno() {
    var finInput = $('#fin').val();

    var datosRetorno = {
        "origen": destinoID,
        "destino": origenID,
        "fecha": finInput,
    };

    var datosJsonRetorno = JSON.stringify(datosRetorno);

    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/schedules/Flight",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: datosJsonRetorno,
        success: function (response) {
            var html = ``;
            response.data.forEach(function (item, index) {
                html += `<tr id="row-${index}">
                    <td>${item.origenAeropuerto}</td>
                    <td>${item.destinoAeropuerto}</td>
                    <td>${item.flightNumber}</td>
                    <td>${item.date}</td>
                    <td>${item.time}</td>
                </tr>`;
            });

            $("#tablaDataRetorno").html(html);

            response.data.forEach(function (item, index) {

                document.getElementById(`row-${index}`).addEventListener('click', function () {
                    if (this.classList.contains('table-active')) {
                        this.classList.remove('table-active');
                    } else {
                        document.querySelectorAll('tr').forEach(row => {
                            this.classList.add('table-active');
                        });
                    }

                    const dataReturn = {
                        origenAeropuerto: item.origenAeropuerto,
                        destinoAeropuerto: item.destinoAeropuerto,
                        flightNumber: item.flightNumber,
                        date: item.date,
                        time: item.time,
                        id: item.id
                    };
                    localStorage.setItem('vueloReturn', JSON.stringify(dataReturn));

                    console.log(JSON.stringify(data));
                });
            });

        },
        error: function (xhr, status, error) {
            console.error("Error en la solicitud:", error);
        }
    });

}

function almacenarPuestos(){

    var tickets = $('#tickets').val();
    var tipoSilla = $('#cabinType').val();
    var ValidarVueloIda = localStorage.getItem('vueloIda');
    var dataIda = JSON.parse(ValidarVueloIda);
    var id = dataIda.id
    

    datosJson = {
        id: id,
        ticketsComprar: tickets,
        silla: tipoSilla
    }

    var datos = JSON.stringify(datosJson);


    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/tickets/consultaSillas",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: datos,
        success: function (response) {
            var tickets = $('#tickets').val();

            var data = response.data;

            if (data.disponible > tickets){

                var tickets = $('#tickets').val();
                var asiento = $('#cabinType').val();
            
                if (tickets.trim() !== '') {
            
                    var dataAsiento = {
                        tickets: tickets, 
                        asientos: asiento
                    }
                    localStorage.setItem('dataAsiento', JSON.stringify(dataAsiento));
            
                    window.location.href = 'http://127.0.0.1:5500/reserva.html';
                } else {
                    Swal.fire({
                        icon: "info",
                        title: "Oops...",
                        text: "Indicanos cuantos ticketes deseas!",
                      });
                }
            } else{
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Ticketes sobre pasados, la cantidad disponible es: "+data.disponible ,
                    footer: 'Puedes comprar otra categoría'
                  });
            }

            console.log(response);

        },
        error: function (error) {
            console.log(error)
        }
    })
}