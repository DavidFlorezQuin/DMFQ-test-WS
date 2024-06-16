function obtenerParametroUrl(nombre) {
    var urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(nombre);
}

// Obtener parámetros y mostrarlos en la segunda vista
window.addEventListener('DOMContentLoaded', function() {
    var origen = obtenerParametroUrl('departureAirportCode');
    var destino = obtenerParametroUrl('arrivalAirportCode');
    var tipoCabina = obtenerParametroUrl('cabinType');
    
    // Mostrar los valores en los spans correspondientes
    document.getElementById('origen').textContent = " " + origen;
    document.getElementById('destino').textContent = " " + destino;
    document.getElementById('tipoCabina').textContent = " " + tipoCabina;
});