CREATE TABLE partner (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         contact_email VARCHAR(255) NOT NULL,
                         contact_phone VARCHAR(20)
);

CREATE TABLE city (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE theatre (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address VARCHAR(255),
                         city_id INT,
                         partner_id INT,
                         FOREIGN KEY (city_id) REFERENCES city(id),
                         FOREIGN KEY (partner_id) REFERENCES partner(id)
);

CREATE TABLE screen (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        theatre_id INT,
                        screen_number INT,
                        capacity INT,
                        FOREIGN KEY (theatre_id) REFERENCES theatre(id)
);

CREATE TABLE genre (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE language (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE movie (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       genre_id INT,
                       language_id INT,
                       duration INT,
                       FOREIGN KEY (genre_id) REFERENCES genre(id),
                       FOREIGN KEY (language_id) REFERENCES language(id)
);

CREATE TABLE show (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      movie_id INT,
                      screen_id INT,
                      show_time TIMESTAMP,
                      price DECIMAL(10, 2),
                      FOREIGN KEY (movie_id) REFERENCES movie(id),
                      FOREIGN KEY (screen_id) REFERENCES screen(id)
);

CREATE TABLE customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          phone_number VARCHAR(20)
);

CREATE TABLE booking (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         show_id INT,
                         customer_id INT,
                         seats_booked INT,
                         booking_time TIMESTAMP,
                         FOREIGN KEY (show_id) REFERENCES show(id),
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE offer (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       discount_percentage DECIMAL(5, 2),
                       start_date TIMESTAMP,
                       end_date TIMESTAMP,
                       movie_id INT,
                       theatre_id INT,
                       FOREIGN KEY (movie_id) REFERENCES movie(id),
                       FOREIGN KEY (theatre_id) REFERENCES theatre(id)
);
