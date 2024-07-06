
var origenID; 
var destinoID

function aeropuerto(){
    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/airpots",
        method: "GET",
        dataType: "json",
        success: function (response){
            var data = response.data;
            var autocomplete = []

            data.forEach(function (item){
                autocomplete.push({ label: item.name, value: item.id });
            });

            $("#origen").autocomplete({
                source: autocomplete,
                select: function(event, ui) {
                    $(this).val(ui.item.label);
                    origenID = ui.item.value
                    return false;
                }
            })

            $("#destino").autocomplete({
                source: autocomplete,
                select: function(event, ui) {
                    $(this).val(ui.item.label);
                    destinoID = ui.item.value
                    return false;
                }
            })

        },
        error: function(error) {
            console.error(error);
        }
    });
}

function envioFormulario(){

    var inicioInput = $('#inicio').val();
    var finInput = $('#fin').val();

    var datos = {
        "origen": origenID,
        "destino": destinoID,
        "inicio": inicioInput,
        "fin": finInput
    };

    var datosJson = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:9000/amonic/v1/api/schedules/serchFlight",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: datosJson,
        success: function(response){

            var html = ``

            response.data.forEach(function(item){
                html += `<tr>
                <td> ${item.origenAeropuerto}</td>
                <td> ${item.destinoAeropuerto}</td>
                <td> ${item.flightNumber}</td>
                <td> ${item.date} </td>
                <td> ${item.time}</td>
                </tr>`

            });

        $("#tablaData").html(html);
        }, 
        error: function(xhr, status, error) {
            console.error("Error en la solicitud:", error);
        }
    })

}