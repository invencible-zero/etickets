could you translate to snake case this script:

INSERT INTO partner (name, contactEmail, contactPhone) VALUES
                                                           ('Big Cinema Group', 'info@bigcinema.com', '2125551234'),
                                                           ('Elite Theatres', 'contact@elitetheatres.com', '3105555678'),
                                                           ('Movie World', 'support@movieworld.com', '4155558765'),
                                                           ('Cinema Central', 'hello@cinemacentral.com', '7025559876'),
                                                           ('Film Fest Cinemas', 'info@filmfestcinemas.com', '6175554321'),
                                                           ('Cineplex Entertainment', 'contact@cineplex.com', '2025553456'),
                                                           ('Theatre Hub', 'support@theatrehub.com', '3055556789'),
                                                           ('Premier Screens', 'info@premierscreens.com', '6265557890'),
                                                           ('Gold Star Cinemas', 'contact@goldstarcinemas.com', '3125550987'),
                                                           ('Theatre Network', 'info@theatrenetwork.com', '8185552345');


-- Insert sample data into city
INSERT INTO city (name) VALUES
                            ('New York'),
                            ('Los Angeles'),
                            ('Chicago'),
                            ('Houston'),
                            ('Phoenix'),
                            ('Philadelphia'),
                            ('San Antonio'),
                            ('San Diego'),
                            ('Dallas'),
                            ('San Jose');

-- Insert sample data into theatre
INSERT INTO theatre (name, address, cityId, partnerId) VALUES
                                                           ('Broadway Theatre', '123 Broadway', 1, 1),
                                                           ('Hollywood Cinemas', '456 Hollywood Blvd', 2, 2),
                                                           ('Downtown Theatre', '789 Main St', 3, 3),
                                                           ('Elm Street Theatre', '101 Elm St', 4, 4),
                                                           ('Oakwood Cinema', '202 Oak St', 5, 5),
                                                           ('Pine Hill Cinema', '303 Pine St', 6, 6),
                                                           ('Cedar Park Theatre', '404 Cedar St', 7, 7),
                                                           ('Maple Street Theatre', '505 Maple St', 8, 8),
                                                           ('Birchwood Theatre', '606 Birch St', 9, 9),
                                                           ('Willow Creek Cinema', '707 Willow St', 10, 10);


-- Insert sample data into genre
INSERT INTO genre (name) VALUES
                             ('Action'),
                             ('Comedy'),
                             ('Drama'),
                             ('Horror'),
                             ('Romance'),
                             ('Thriller'),
                             ('Sci-Fi'),
                             ('Fantasy'),
                             ('Adventure'),
                             ('Documentary');

-- Insert sample data into language
INSERT INTO language (name) VALUES
                                ('English'),
                                ('Spanish'),
                                ('French'),
                                ('German'),
                                ('Chinese'),
                                ('Japanese'),
                                ('Korean'),
                                ('Italian'),
                                ('Portuguese'),
                                ('Russian');

-- Insert sample data into customer
INSERT INTO customer (name, email, phoneNumber) VALUES
                                                    ('John Smith', 'john.smith@example.com', '2125557890'),
                                                    ('Emily Davis', 'emily.davis@example.com', '3105551234'),
                                                    ('Michael Brown', 'michael.brown@example.com', '4155555678'),
                                                    ('Sarah Wilson', 'sarah.wilson@example.com', '7025556789'),
                                                    ('David Johnson', 'david.johnson@example.com', '6175559876'),
                                                    ('Laura Martinez', 'laura.martinez@example.com', '2025552345'),
                                                    ('Chris Lee', 'chris.lee@example.com', '3055558765'),
                                                    ('Amanda Clark', 'amanda.clark@example.com', '6265550987'),
                                                    ('James Robinson', 'james.robinson@example.com', '3125554567'),
                                                    ('Jessica Lewis', 'jessica.lewis@example.com', '8185556789');


-- Insert sample data into screen
INSERT INTO screen (theatreId, screenNumber, capacity) VALUES
                                                           (1, 1, 100),
                                                           (1, 2, 150),
                                                           (2, 1, 200),
                                                           (2, 2, 250),
                                                           (3, 1, 120),
                                                           (3, 2, 180),
                                                           (4, 1, 140),
                                                           (4, 2, 160),
                                                           (5, 1, 220),
                                                           (5, 2, 240),
                                                           (6, 1, 130),
                                                           (6, 2, 170),
                                                           (7, 1, 110),
                                                           (7, 2, 190),
                                                           (8, 1, 210),
                                                           (8, 2, 230),
                                                           (9, 1, 140),
                                                           (9, 2, 150),
                                                           (10, 1, 250),
                                                           (10, 2, 260);


-- Insert sample data into movie
INSERT INTO movie (title, genreId, languageId, duration) VALUES
                                                             ('The Avengers', 1, 1, 143),
                                                             ('Superbad', 2, 1, 113),
                                                             ('The Shawshank Redemption', 3, 1, 142),
                                                             ('Get Out', 4, 1, 104),
                                                             ('Pride and Prejudice', 5, 1, 129),
                                                             ('Inception', 6, 1, 148),
                                                             ('Interstellar', 7, 1, 169),
                                                             ('The Lord of the Rings', 8, 1, 178),
                                                             ('Jurassic Park', 9, 1, 127),
                                                             ('The Social Network', 10, 1, 120);

-- Insert sample data into show
INSERT INTO show (movieId, screenId, showTime, price) VALUES
                                                          (1, 1, '2024-08-01 19:00:00', 12.50),
                                                          (2, 2, '2024-08-01 21:30:00', 10.00),
                                                          (3, 3, '2024-08-02 18:00:00', 15.00),
                                                          (4, 4, '2024-08-02 20:30:00', 13.00),
                                                          (5, 5, '2024-08-03 17:00:00', 9.00),
                                                          (6, 6, '2024-08-03 22:00:00', 14.00),
                                                          (7, 7, '2024-08-04 16:00:00', 11.00),
                                                          (8, 8, '2024-08-04 19:00:00', 16.00),
                                                          (9, 9, '2024-08-05 14:00:00', 8.00),
                                                          (10, 10, '2024-08-05 21:00:00', 17.00);



-- Insert sample data into booking
INSERT INTO booking (showId, customerId, seatsBooked, bookingTime) VALUES
                                                                       (1, 1, 2, '2024-07-30 15:00:00'),
                                                                       (2, 2, 1, '2024-07-30 15:30:00'),
                                                                       (3, 3, 3, '2024-07-30 16:00:00'),
                                                                       (4, 4, 2, '2024-07-30 16:30:00'),
                                                                       (5, 5, 4, '2024-07-30 17:00:00'),
                                                                       (6, 6, 1, '2024-07-30 17:30:00'),
                                                                       (7, 7, 5, '2024-07-30 18:00:00'),
                                                                       (8, 8, 3, '2024-07-30 18:30:00'),
                                                                       (9, 9, 2, '2024-07-30 19:00:00'),
                                                                       (10, 10, 4, '2024-07-30 19:30:00');

INSERT INTO offer (title, description, discountPercentage, startDate, endDate, movieId, theatreId) VALUES
                                                                                                       ('Summer Sale', 'Enjoy 20% off on all movie tickets this summer!', 20.00, '2024-06-01 00:00:00', '2024-08-31 23:59:59', NULL, NULL),
                                                                                                       ('Action Movie Deal', 'Get 15% off on all action movies.', 15.00, '2024-07-01 00:00:00', '2024-07-31 23:59:59', 1, NULL),
                                                                                                       ('Weekend Special', 'Buy 1 get 1 free on all tickets during the weekend.', 50.00, '2024-07-01 00:00:00', '2024-07-31 23:59:59', NULL, 1),
                                                                                                       ('Family Pack', '20% off on tickets for families of 4 or more.', 20.00, '2024-07-01 00:00:00', '2024-07-31 23:59:59', NULL, 2),
                                                                                                       ('Student Discount', '10% off for students with valid ID.', 10.00, '2024-07-01 00:00:00', '2024-07-31 23:59:59', NULL, NULL),
                                                                                                       ('Early Bird Special', '15% off on tickets booked 2 weeks in advance.', 15.00, '2024-07-01 00:00:00', '2024-07-31 23:59:59', NULL, NULL);
