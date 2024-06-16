-- Inserción de datos en la tabla countries
INSERT INTO countries (id, created_at, created_by, state, name) VALUES
(1, NOW(), 1, b'1', 'Estados Unidos'),
(2, NOW(), 1, b'1', 'México'),
(3, NOW(), 1, b'1', 'Canadá');

-- Inserción de datos en la tabla air_ports
INSERT INTO air_ports (id, created_at, created_by, state, iatacode, name, country_id) VALUES
(1, NOW(), 1, b'1', 'JFK', 'John F. Kennedy International Airport', 1),
(2, NOW(), 1, b'1', 'LAX', 'Los Angeles International Airport', 1),
(3, NOW(), 1, b'1', 'MEX', 'Aeropuerto Internacional Benito Juárez', 2),
(4, NOW(), 1, b'1', 'YYZ', 'Toronto Pearson International Airport', 3);

-- Inserción de datos en la tabla cabin_types
INSERT INTO cabin_types (id, created_at, created_by, state, name) VALUES
(1, NOW(), 1, b'1', 'Economy'),
(2, NOW(), 1, b'1', 'Business');

-- Inserción de datos en la tabla air_crafts
INSERT INTO air_crafts (id, created_at, created_by, state, business_seats, economy_seats, make_model, name, total_seats) VALUES
(1, NOW(), 1, b'1', 20, 150, 'Boeing 737', 'B737-800', 170),
(2, NOW(), 1, b'1', 30, 200, 'Airbus A320', 'A320-200', 230);

-- Inserción de datos en la tabla offices
INSERT INTO offices (id, created_at, created_by, state, contact, phone, title, country_id) VALUES
(1, NOW(), 1, b'1', 'John Doe', '555-1234', 'NY Office', 1),
(2, NOW(), 1, b'1', 'Jane Doe', '555-5678', 'LA Office', 1);

-- Inserción de datos en la tabla roles
INSERT INTO roles (id, created_at, created_by, state, title) VALUES
(1, NOW(), 1, b'1', 'Admin'),
(2, NOW(), 1, b'1', 'Customer Service');

-- Inserción de datos en la tabla routes
INSERT INTO routes (id, created_at, created_by, state, distance, flight_time, arrival_airport_id, departure_airport_id) VALUES
(1, NOW(), 1, b'1', '4000 km', '5h', 1, 3),
(2, NOW(), 1, b'1', '4500 km', '6h', 2, 4),
(3, NOW(), 1, b'1', '4000 km', '5h', 3, 1);

-- Inserción de datos en la tabla schedules
INSERT INTO schedules (id, created_at, created_by, state, confirmed, date, economy_price, flight_number, time, air_craft_id, route_id) VALUES
(1, NOW(), 1, b'1', b'1', '2024-07-01 08:00:00', 300.00, 'AA100', '08:00:00', 1, 1),
(2, NOW(), 1, b'1', b'1', '2024-07-02 09:00:00', 350.00, 'AA200', '09:00:00', 2, 2),
(3, NOW(), 1, b'1', b'1', '2024-07-10 09:00:00', 350.00, 'AA200', '09:00:00', 2, 3);

-- Inserción de datos en la tabla users
INSERT INTO users (id, created_at, created_by, state, birthday, email, first_name, last_name, password, offices_id, role_id) VALUES
(1, NOW(), 1, b'1', '1980-01-01', 'admin@example.com', 'Admin', 'User', 'adminpassword', 1, 1),
(2, NOW(), 1, b'1', '1990-02-02', 'johndoe@example.com', 'John', 'Doe', 'password123', 2, 2);

-- Inserción de datos en la tabla tickets
INSERT INTO tickets (id, created_at, created_by, state, booking_reference, confirmed, email, first_name, last_name, passport_number, passport_photo, phone, cabin_type_id, passport_country_id, schedule_id, user_id) VALUES
(1, NOW(), 1, b'1', 'BR123', 'Yes', 'johndoe@example.com', 'John', 'Doe', 'X1234567', 'photo1.jpg', '555-1234', 1, 1, 1, 2),
(2, NOW(), 1, b'1', 'BR124', 'Yes', 'janedoe@example.com', 'Jane', 'Doe', 'X2345678', 'photo2.jpg', '555-5678', 2, 2, 2, 2);
