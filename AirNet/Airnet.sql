create database Airnet;
use Airnet; 

CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(10)
);

-- Passenger table (inherits from User) make passport PK but can change to passenger_id
CREATE TABLE Passenger (
    passport_number VARCHAR(20) PRIMARY KEY,
    username VARCHAR(50),
    date_of_birth DATE,
    FOREIGN KEY (username) REFERENCES Users(username)
    );


CREATE TABLE Aircraft (
    aircraft_code VARCHAR(10) PRIMARY KEY,
    model VARCHAR(50),
    total_seats INT
);

CREATE TABLE Route (
    route_id VARCHAR(10) PRIMARY KEY,
    departure_city VARCHAR(50),
    arrival_city VARCHAR(50),
    departure_time TIME,
    arrival_time TIME,
    gate_number VARCHAR(5),
    airline VARCHAR(50),
    terminal VARCHAR(5)
);

CREATE TABLE Flight (
    flight_number VARCHAR(10) PRIMARY KEY,
    aircraft_code VARCHAR(10),
    route_id VARCHAR(10),
    flight_date DATE,
    flight_status VARCHAR(20),
    FOREIGN KEY (aircraft_code) REFERENCES Aircraft(aircraft_code),
    FOREIGN KEY (route_id) REFERENCES Route(route_id)
);

CREATE TABLE Booking (
    confirmation_number VARCHAR(10) PRIMARY KEY,
    passport_number VARCHAR(20),
    flight_number VARCHAR(10),
    seat_number VARCHAR(5),
    seat_class VARCHAR(20),
    booking_date DATE,
    checked_in BOOLEAN,
    FOREIGN KEY (passport_number) REFERENCES Passenger(passport_number),
    FOREIGN KEY (flight_number) REFERENCES Flight(flight_number)
);

CREATE TABLE Baggage (
    confirmation_number VARCHAR(10),
    baggage_number VARCHAR(10),
    type VARCHAR(20),
    weight DECIMAL(5,2),
    PRIMARY KEY (confirmation_number, baggage_number),
    FOREIGN KEY (confirmation_number) REFERENCES Booking(confirmation_number)
);

INSERT INTO Users (username, password, email, phone) VALUES 
('elliot', 'mrrobot123', 'elliot@allsafe.com', '5551234567'),
('darlene', 'dolores123', 'darlene@fsoc.net', '5559876543'),
('angela', 'qwerty789', 'angela@allsafe.com', '5552345678'),
('tyrell', 'joanna123', 'tyrell@ecorp.com', '5553456789'),
('phillip', 'ecorp123', 'price@ecorp.com', '5554567890');

INSERT INTO Passenger (passport_number, username, date_of_birth) VALUES
('USA123456', 'elliot', '1986-09-17'),
('USA789012', 'darlene', '1990-11-05'),
('USA345678', 'angela', '1988-02-27'),
('SWE901234', 'tyrell', '1982-07-15'),
('USA567890', 'phillip', '1962-05-08');

INSERT INTO Aircraft (aircraft_code, model, total_seats) VALUES
('B737', 'Boeing 737', 180),
('A320', 'Airbus A320', 150),
('B777', 'Boeing 777', 300),
('A321', 'Airbus A321', 200),
('B787', 'Boeing 787', 330);

INSERT INTO Route (route_id, departure_city, arrival_city, departure_time, arrival_time, gate_number, airline, terminal) VALUES 
('NY to LA', 'New York', 'Los Angeles', '08:00', '11:30', 'B12', 'Delta', 'T4'),
('LA to NY', 'Los Angeles', 'New York', '14:00', '22:30', 'C15', 'Delta', 'T2'),
('NY to CHI', 'New York', 'Chicago', '09:30', '11:00', 'A5', 'United', 'T3'),
('CHI to NY', 'Chicago', 'New York', '16:00', '19:30', 'D8', 'United', 'T1'),
('NY to LN', 'New York', 'London', '22:00', '10:30', 'E1', 'British Air', 'T7');

INSERT INTO Flight (flight_number, aircraft_code, route_id, flight_date, flight_status) VALUES
('DL101', 'B737', 'NY to LA', '2024-03-15', 'On Time'),
('DL102', 'A320', 'LA to NY', '2024-03-15', 'Delayed'),
('UA201', 'B777', 'NY to CHI', '2024-03-16', 'Scheduled'),
('UA202', 'A321', 'CHI to NY', '2024-03-16', 'On Time'),
('BA301', 'B787', 'NY to LN', '2024-03-17', 'Scheduled');

INSERT INTO Booking (confirmation_number, passport_number, flight_number, seat_number, seat_class, booking_date, checked_in) VALUES
('ABC123', 'USA123456', 'DL101', '12A', 'Economy', '2024-02-20', false),
('ABC124', 'USA789012', 'DL102', '15F', 'Economy', '2024-02-21', true),
('ABC125', 'USA345678', 'UA201', '1A', 'Business', '2024-02-22', false),
('ABC126', 'SWE901234', 'UA202', '2C', 'Business', '2024-02-23', true),
('ABC127', 'USA567890', 'BA301', '5D', 'First', '2024-02-24', false);

INSERT INTO Baggage (confirmation_number, baggage_number, type, weight) VALUES
('ABC123', 'BAG001', 'Checked', 23.5),
('ABC123', 'BAG002', 'Carry-on', 8.0),
('ABC124', 'BAG001', 'Checked', 20.0),
('ABC125', 'BAG001', 'Checked', 25.0),
('ABC126', 'BAG001', 'Carry-on', 10.0),
('ABC127', 'BAG001', 'Checked', 22.0),
('ABC127', 'BAG002', 'Checked', 21.5);
