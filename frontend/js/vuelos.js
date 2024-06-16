
document.getElementById("vuelosFormulario").addEventListener("submit", function(event){
    event.preventDefault();
  });

function loadData(){

    var departureAirportCode = document.getElementById('departureAirportCode').value;
    var arrivalAirportCode = document.getElementById('arrivalAirportCode').value;
    var cabinType = document.getElementById('cabinType').value;
    var departureDate = document.getElementById('departureDate').value;

    
    var url = new URL('http://localhost:9000/amonic/v1/api/schedules/search');
    url.searchParams.append('departureAirportCode', departureAirportCode);
    url.searchParams.append('arrivalAirportCode', arrivalAirportCode);
    url.searchParams.append('cabinType', cabinType);
    url.searchParams.append('departureDate', departureDate);
    
    fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
      .then(data => {
        var html = '';
        
        const flights = data.data
    
        flights.forEach((item1) => {
            html += `<tr>
            <td>`+ item1.departureAirportCode + `</td>
            <td>`+ item1.arrivalAirportCode + `</td>
            <td>`+ item1.departureDate + `</td>
            <td>`+ item1.cabinType + `</td>
            <td>`+ item1.flightNumber + `</td>
            <td>`+ item1.economyPrice + `</td>
            </tr>`;
        });
    
        document.getElementById('resultData').innerHTML = html;
    
      })
      .catch(error => {
        console.error('Error en la solicitud:', error);
      });
}

function loadReturnData(){
    
    var codigoSalida = document.getElementById('arrivalAirportCode').value;
    var codigoLlegada = document.getElementById('departureAirportCode').value;
    var cabina = document.getElementById('cabinType').value;
    var fecha = document.getElementById('returnDate').value;

    
    var url = new URL('http://localhost:9000/amonic/v1/api/schedules/searchReturn');
    url.searchParams.append('departureAirportCode', codigoSalida);
    url.searchParams.append('arrivalAirportCode', codigoLlegada);
    url.searchParams.append('cabinType', cabina);
    url.searchParams.append('departureDate', fecha);
    
    fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
      }
      return response.json();
    })
      .then(data => {
        var html = '';
        
        const flightsCome = data.data
    
        flightsCome.forEach((item2) => {

            html += `<tr>
            <td>`+ item2.departureAirportCode + `</td>
            <td>`+ item2.arrivalAirportCode + `</td>
            <td>`+ item2.departureDate + `</td>
            <td>`+ item2.cabinType + `</td>
            <td>`+ item2.flightNumber + `</td>
            <td>`+ item2.economyPrice + `</td>
            </tr>`;
        });
    
        document.getElementById('resultDataReturn').innerHTML = html;
    
      })
      .catch(error => {
        console.error('Error en la solicitud:', error);
      });
}

function showTable() {
    const notRetorno = document.getElementById('notRetorno');
    const returnOutputData = document.getElementById('returnOutputData');
    const searchBotton = document.getElementById('searchBotton');


    if (notRetorno.checked) {
        returnOutputData.classList.add('d-none');
        searchBotton.setAttribute('onclick', 'loadData()');
    } else {
        returnOutputData.classList.remove('d-none');
        searchBotton.setAttribute('onclick', 'buscarAmbosVuelos()');
    }
}

function buscarAmbosVuelos(){
    loadData();
    console.log("ejecutando segundo")
    loadReturnData();
}

document.getElementById('buscarVuelos').addEventListener('click', function() {
    // Obtener valores del formulario
    var departureAirportCode = document.getElementById('departureAirportCode').value;
    var arrivalAirportCode = document.getElementById('arrivalAirportCode').value;
    var cabinType = document.getElementById('cabinType').value;

    // Construir la URL con parámetros
    var url = 'http://127.0.0.1:5500/reserva.html?' +
              'departureAirportCode=' + encodeURIComponent(departureAirportCode) +
              '&arrivalAirportCode=' + encodeURIComponent(arrivalAirportCode) +
              '&cabinType=' + encodeURIComponent(cabinType);

    // Redireccionar a la página reserva.html con los parámetros en la URL
    window.location.href = url;
});