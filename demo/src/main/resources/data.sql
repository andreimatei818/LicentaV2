CREATE TABLE `parkingdb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `carNumber` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `parkingdb`.`parking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT,
  `start_date` timestamp,
  `end_date` timestamp,
  `comment` VARCHAR(200) NULL,
  `address` VARCHAR(45) NULL,
  `is_free` boolean,

  PRIMARY KEY (`id`),
  foreign key (user_id) references users(id)
  );

CREATE TABLE `parkingdb`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_parking` INT,
  `start_date` timestamp,
  `end_date` timestamp,


  PRIMARY KEY (`id`),
  foreign key (id_parking) references parking(id)
  );