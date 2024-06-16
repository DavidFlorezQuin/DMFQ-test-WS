// Recuperar el objeto guardado en localStorage
let vuelo = JSON.parse(localStorage.getItem('vuelo'));

// Obtener referencias a los elemezntos <span> en tu HTML
let origenSpan = document.getElementById('origen');
let destinoSpan = document.getElementById('destino');
let tipoCabinaSpan = document.getElementById('tipoCabina');
let fechaSpan = document.getElementById('fecha');
let numeroVueloSpan = document.getElementById('numeroVuelo');

origenSpan.textContent = vuelo.routes;  
tipoCabinaSpan.textContent = vuelo.businessSeats > 0 ? 'business' : 'economy';  
fechaSpan.textContent = vuelo.date;  
numeroVueloSpan.textContent = vuelo.flightNumber;  
