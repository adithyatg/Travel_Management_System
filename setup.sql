CREATE TABLE person (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255)
);

INSERT INTO person (name, email, password, phone_number, address) VALUES
('John Doe', 'johndoe@example.com', 'password123', '1234567890', '123 Main St'),
('Jane Smith', 'janesmith@example.com', 'password456', '0987654321', '456 Elm St');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES person(user_id)
);


INSERT INTO users (user_id, password) VALUES
(1, 'password123'),
(2, 'password456');


CREATE TABLE bookings (
    booking_id SERIAL PRIMARY KEY,
    user_id INT,
    flight_id INT,
    booking_date DATE,
    status VARCHAR(50),
<<<<<<< HEAD
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO bookings (user_id, flight_id, booking_date, status) VALUES
(1, 1, '2024-04-05', 'Confirmed'),
(1, 3, '2024-04-06', 'Pending'),
(2, 2, '2024-04-07', 'Confirmed');
=======
    discount_applied BOOLEAN DEFAULT false, -- Added discount_applied column
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

ALTER TABLE bookings
ADD COLUMN total_price FLOAT;

INSERT INTO bookings (user_id, flight_id, booking_date, total_price, status) VALUES
(1, 1, '2024-04-05',500.00, 'Confirmed'),
(1, 3, '2024-04-06',400.00, 'Pending'),
(2, 2, '2024-04-07',600.00, 'Confirmed');
>>>>>>> origin/main


CREATE TABLE flight (
    flight_id SERIAL PRIMARY KEY,
    source VARCHAR(255),
    destination VARCHAR(255),
    departure_date DATE,
    return_date DATE,
    price FLOAT,
    available_seats INT,
    flight_type VARCHAR(50)
);

INSERT INTO flight (source, destination, departure_date, return_date, price, available_seats, flight_type) VALUES
<<<<<<< HEAD
('New York', 'Los Angeles', '2024-05-01', NULL, 500.00, 200, 'OneWay'),
('Chicago', 'Miami', '2024-06-10', '2024-06-15', 600.00, 150, 'TwoWay'),
('San Francisco', 'Seattle', '2024-07-20', NULL, 400.00, 180, 'OneWay'),
('Boston', 'Dallas', '2024-08-01', NULL, 450.00, 210, 'OneWay'),
('Denver', 'Atlanta', '2024-09-10', '2024-09-20', 550.00, 190, 'TwoWay'),
('Houston', 'Phoenix', '2024-10-20', NULL, 420.00, 175, 'OneWay'),
('Las Vegas', 'Orlando', '2024-11-15', '2024-11-25', 480.00, 160, 'TwoWay'),
('Detroit', 'Minneapolis', '2024-12-05', NULL, 530.00, 205, 'OneWay'),
('Philadelphia', 'San Diego', '2025-01-10', '2025-01-20', 560.00, 195, 'TwoWay'),
('Portland', 'Charlotte', '2025-02-20', NULL, 440.00, 185, 'OneWay'),
('St. Louis', 'Tampa', '2025-03-15', '2025-03-25', 510.00, 170, 'TwoWay'),
('Washington D.C.', 'New Orleans', '2025-04-05', NULL, 470.00, 215, 'OneWay'),
('Salt Lake City', 'Cincinnati', '2025-05-20', '2025-05-30', 540.00, 165, 'TwoWay'),
('Austin', 'San Antonio', '2025-06-10', NULL, 420.00, 180, 'OneWay'),
('Kansas City', 'Raleigh', '2025-07-15', '2025-07-25', 490.00, 170, 'TwoWay'),
('Indianapolis', 'Nashville', '2025-08-01', NULL, 460.00, 200, 'OneWay'),
('Oklahoma City', 'Sacramento', '2025-09-10', '2025-09-20', 530.00, 175, 'TwoWay'),
('El Paso', 'Albuquerque', '2025-10-20', NULL, 410.00, 190, 'OneWay'),
('Louisville', 'Milwaukee', '2025-11-15', '2025-11-25', 490.00, 165, 'TwoWay'),
('Memphis', 'Tulsa', '2025-12-05', NULL, 500.00, 210, 'OneWay'),
('Baltimore', 'Virginia Beach', '2026-01-10', '2026-01-20', 570.00, 185, 'TwoWay'),
('Atlanta', 'Charlotte', '2026-02-20', NULL, 450.00, 175, 'OneWay'),
('Nashville', 'Denver', '2026-03-15', '2026-03-25', 520.00, 160, 'TwoWay'),
('Milwaukee', 'Cleveland', '2026-04-05', NULL, 480.00, 200, 'OneWay'),
('Albuquerque', 'Kansas City', '2026-05-20', '2026-05-30', 550.00, 195, 'TwoWay'),
('Tucson', 'Fresno', '2026-06-10', NULL, 430.00, 180, 'OneWay'),
('Sacramento', 'Omaha', '2026-07-15', '2026-07-25', 500.00, 170, 'TwoWay'),
('Long Beach', 'Mesa', '2026-08-01', NULL, 460.00, 205, 'OneWay'),
('Colorado Springs', 'Raleigh', '2026-09-10', '2026-09-20', 540.00, 160, 'TwoWay'),
('Virginia Beach', 'Miami', '2026-10-20', NULL, 470.00, 190, 'OneWay'),
('Oakland', 'Minneapolis', '2026-11-15', '2026-11-25', 490.00, 180, 'TwoWay'),
('Cleveland', 'Wichita', '2026-12-05', NULL, 510.00, 195, 'OneWay'),
('New Orleans', 'Tucson', '2027-01-10', '2027-01-20', 560.00, 175, 'TwoWay'),
('Bakersfield', 'Arlington', '2027-02-20', NULL, 440.00, 170, 'OneWay'),
('Mesa', 'Tulsa', '2027-03-15', '2027-03-25', 530.00, 185, 'TwoWay'),
('Anaheim', 'Tampa', '2027-04-05', NULL, 480.00, 165, 'OneWay'),
('Arlington', 'Honolulu', '2027-05-20', '2027-05-30', 550.00, 195, 'TwoWay'),
('Wichita', 'Aurora', '2027-06-10', NULL, 450.00, 180, 'OneWay'),
('Tampa', 'Santa Ana', '2027-07-15', '2027-07-25', 510.00, 170, 'TwoWay'),
('Honolulu', 'Anaheim', '2027-08-01', NULL, 470.00, 200, 'OneWay'),
('Aurora', 'Riverside', '2027-09-10', '2027-09-20', 540.00, 190, 'TwoWay'),
('Santa Ana', 'Corpus Christi', '2027-10-20', NULL, 460.00, 175, 'OneWay'),
('Riverside', 'St. Petersburg', '2027-11-15', '2027-11-25', 520.00, 205, 'TwoWay'),
('Corpus Christi', 'Lexington', '2027-12-05', NULL, 480.00, 195, 'OneWay'),
('St. Petersburg', 'Stockton', '2028-01-10', '2028-01-20', 550.00, 180, 'TwoWay'),
('Lexington', 'Pittsburgh', '2028-02-20', NULL, 450.00, 170, 'OneWay'),
('Stockton', 'Cincinnati', '2028-03-15', '2028-03-25', 530.00, 185, 'TwoWay'),
('Pittsburgh', 'Anchorage', '2028-04-05', NULL, 480.00, 195, 'OneWay'),
('Cincinnati', 'Toledo', '2028-05-20', '2028-05-30', 550.00, 190, 'TwoWay'),
('Anchorage', 'St. Paul', '2028-06-10', NULL, 450.00, 180, 'OneWay'),
('Toledo', 'Greensboro', '2028-07-15', '2028-07-25', 520.00, 175, 'TwoWay'),
('St. Paul', 'Newark', '2028-08-01', NULL, 470.00, 200, 'OneWay'),
('Greensboro', 'Plano', '2028-09-10', '2028-09-20', 540.00, 190, 'TwoWay'),
('Newark', 'Fort Wayne', '2028-10-20', NULL, 460.00, 175, 'OneWay'),
('Plano', 'Orlando', '2028-11-15', '2028-11-25', 530.00, 180, 'TwoWay'),
('Fort Wayne', 'Chandler', '2028-12-05', NULL, 480.00, 190, 'OneWay'),
('Orlando', 'Chula Vista', '2029-01-10', '2029-01-20', 550.00, 185, 'TwoWay'),
('Chandler', 'Laredo', '2029-02-20', NULL, 450.00, 180, 'OneWay'),
('Chula Vista', 'Norfolk', '2029-03-15', '2029-03-25', 520.00, 195, 'TwoWay'),
('Laredo', 'Madison', '2029-04-05', NULL, 470.00, 195, 'OneWay'),
('Norfolk', 'Durham', '2029-05-20', '2029-05-30', 540.00, 180, 'TwoWay'),
('Madison', 'Garland', '2029-06-10', NULL, 460.00, 190, 'OneWay'),
('Durham', 'Glendale', '2029-07-15', '2029-07-25', 530.00, 175, 'TwoWay'),
('Garland', 'Reno', '2029-08-01', NULL, 480.00, 185, 'OneWay'),
('Glendale', 'Scottsdale', '2029-09-10', '2029-09-20', 550.00, 195, 'TwoWay'),
('Reno', 'Hialeah', '2029-10-20', NULL, 450.00, 180, 'OneWay'),
('Scottsdale', 'San Bernardino', '2029-11-15', '2029-11-25', 520.00, 190, 'TwoWay'),
('Hialeah', 'Tallahassee', '2029-12-05', NULL, 470.00, 185, 'OneWay'),
('San Bernardino', 'Rochester', '2030-01-10', '2030-01-20', 540.00, 180, 'TwoWay'),
('Tallahassee', 'Akron', '2030-02-20', NULL, 460.00, 190, 'OneWay'),
('Rochester', 'Boise', '2030-03-15', '2030-03-25', 530.00, 175, 'TwoWay'),
('Akron', 'Irving', '2030-04-05', NULL, 480.00, 185, 'OneWay'),
('Boise', 'Fremont', '2030-05-20', '2030-05-30', 550.00, 190, 'TwoWay'),
('Irving', 'San Bernardino', '2030-06-10', NULL, 450.00, 180, 'OneWay'),
('Fremont', 'Richmond', '2030-07-15', '2030-07-25', 520.00, 185, 'TwoWay'),
('San Bernardino', 'Modesto', '2030-08-01', NULL, 470.00, 195, 'OneWay'),
('Richmond', 'Baton Rouge', '2030-09-10', '2030-09-20', 540.00, 180, 'TwoWay'),
('Modesto', 'Shreveport', '2030-10-20', NULL, 460.00, 190, 'OneWay'),
('Baton Rouge', 'Des Moines', '2030-11-15', '2030-11-25', 530.00, 175, 'TwoWay'),
('Shreveport', 'Spokane', '2030-12-05', NULL, 480.00, 185, 'OneWay'),
('Des Moines', 'Tacoma', '2031-01-10', '2031-01-20', 550.00, 190, 'TwoWay'),
('Spokane', 'Montgomery', '2031-02-20', NULL, 450.00, 180, 'OneWay'),
('Tacoma', 'Glendale', '2031-03-15', '2031-03-25', 520.00, 195, 'TwoWay'),
('Montgomery', 'Scottsdale', '2031-04-05', NULL, 470.00, 185, 'OneWay'),
('Glendale', 'Irving', '2031-05-20', '2031-05-30', 540.00, 180, 'TwoWay'),
('Irving', 'Fremont', '2031-06-10', NULL, 460.00, 190, 'OneWay'),
('Fremont', 'Richmond', '2031-07-15', '2031-07-25', 530.00, 175, 'TwoWay'),
('Richmond', 'Baton Rouge', '2031-08-01', NULL, 480.00, 185, 'OneWay'),
('Baton Rouge', 'Des Moines', '2031-09-10', '2031-09-20', 550.00, 190, 'TwoWay'),
('Des Moines', 'Spokane', '2031-10-20', NULL, 450.00, 180, 'OneWay'),
('Spokane', 'Tacoma', '2031-11-15', '2031-11-25', 520.00, 195, 'TwoWay'),
('Tacoma', 'Montgomery', '2031-12-05', NULL, 470.00, 185, 'OneWay'),
('Montgomery', 'Glendale', '2032-01-10', '2032-01-20', 540.00, 180, 'TwoWay'),
('Glendale', 'Irving', '2032-02-20', NULL, 460.00, 190, 'OneWay'),
('Irving', 'Fremont', '2032-03-15', '2032-03-25', 530.00, 175, 'TwoWay'),
('Fremont', 'Richmond', '2032-04-05', NULL, 480.00, 185, 'OneWay'),
('Richmond', 'Baton Rouge', '2032-05-20', '2032-05-30', 550.00, 190, 'TwoWay'),
('Baton Rouge', 'Des Moines', '2032-06-10', NULL, 450.00, 180, 'OneWay'),
('Des Moines', 'Spokane', '2032-07-15', '2032-07-25', 520.00, 195, 'TwoWay'),
('Spokane', 'Tacoma', '2032-08-01', NULL, 470.00, 185, 'OneWay'),
('Tacoma', 'Montgomery', '2032-09-10', '2032-09-20', 540.00, 180, 'TwoWay'),
('Montgomery', 'Glendale', '2032-10-20', NULL, 460.00, 190, 'OneWay'),
('Glendale', 'Irving', '2032-11-15', '2032-11-25', 530.00, 175, 'TwoWay'),
('Irving', 'Fremont', '2032-12-05', NULL, 480.00, 185, 'OneWay'),
('Fremont', 'Richmond', '2033-01-10', '2033-01-20', 550.00, 190, 'TwoWay'),
('Richmond', 'Baton Rouge', '2033-02-20', NULL, 450.00, 180, 'OneWay'),
('Baton Rouge', 'Des Moines', '2033-03-15', '2033-03-25', 520.00, 195, 'TwoWay'),
('Des Moines', 'Spokane', '2033-04-05', NULL, 470.00, 185, 'OneWay'),
('Spokane', 'Tacoma', '2033-05-20', '2033-05-30', 540.00, 180, 'TwoWay'),
('Tacoma', 'Montgomery', '2033-06-10', NULL, 460.00, 190, 'OneWay'),
('Montgomery', 'Glendale', '2033-07-15', '2033-07-25', 530.00, 175, 'TwoWay'),
('Glendale', 'Irving', '2033-08-01', NULL, 480.00, 185, 'OneWay'),
('Irving', 'Fremont', '2033-09-10', '2033-09-20', 550.00, 190, 'TwoWay'),
('Fremont', 'Richmond', '2033-10-20', NULL, 450.00, 180, 'OneWay'),
('Richmond', 'Baton Rouge', '2033-11-15', '2033-11-25', 520.00, 195, 'TwoWay'),
('Baton Rouge', 'Des Moines', '2033-12-05', NULL, 470.00, 185, 'OneWay'),
('Des Moines', 'Spokane', '2034-01-10', '2034-01-20', 540.00, 180, 'TwoWay'),
('Spokane', 'Tacoma', '2034-02-20', NULL, 460.00, 190, 'OneWay'),
('Tacoma', 'Montgomery', '2034-03-15', '2034-03-25', 530.00, 175, 'TwoWay'),
('Montgomery', 'Glendale', '2034-04-05', NULL, 480.00, 185, 'OneWay'),
('Glendale', 'Irving', '2034-05-20', '2034-05-30', 550.00, 190, 'TwoWay'),
('Irving', 'Fremont', '2034-06-10', NULL, 450.00, 180, 'OneWay'),
('Fremont', 'Richmond', '2034-07-15', '2034-07-25', 520.00, 185, 'TwoWay'),
('Richmond', 'Baton Rouge', '2034-08-01', NULL, 470.00, 195, 'OneWay'),
('Baton Rouge', 'Des Moines', '2034-09-10', '2034-09-20', 540.00, 180, 'TwoWay'),
('Des Moines', 'Spokane', '2034-10-20', NULL, 460.00, 190, 'OneWay'),
('Spokane', 'Tacoma', '2034-11-15', '2034-11-25', 530.00, 175, 'TwoWay'),
('Tacoma', 'Montgomery', '2034-12-05', NULL, 480.00, 185, 'OneWay');


CREATE OR REPLACE FUNCTION decrement_available_seats()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE flights
    SET available_seats = available_seats - 1
    WHERE flight_id = NEW.flight_id;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_booking_insert
AFTER INSERT ON bookings
FOR EACH ROW EXECUTE FUNCTION decrement_available_seats();
=======
('New York', 'Los Angeles', '2024-05-01', '2024-05-05', 500.00, 200, 'OneWay'),
('Chicago', 'Miami', '2024-06-10', '2024-06-15', 600.00, 150, 'TwoWay'),
('San Francisco', 'Seattle', '2024-07-20', '2024-07-25', 400.00, 180, 'OneWay');

CREATE TABLE admin (
    user_id SERIAL PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
>>>>>>> origin/main
