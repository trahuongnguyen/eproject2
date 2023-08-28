CREATE TABLE `authors` (
  `id` integer PRIMARY KEY,
  `full_name` varchar(150),
  `birthday` date
);

CREATE TABLE `publishers` (
  `id` integer PRIMARY KEY,
  `name` varchar(150),
  `address` varchar(250),
  `email` varchar(250),
  `phone_number` varchar(15)
);

CREATE TABLE `categories` (
  `id` integer PRIMARY KEY,
  `title` varchar(150),
  `located_in` varchar(150)
);

CREATE TABLE `books` (
  `id` integer PRIMARY KEY,
  `title` varchar(150),
  `category_id` integer,
  `publishers_id` integer,
  `language` varchar(50),
  `author_id` integer,
  `quantity` integer,
  `lost_or_broken` integer
);

CREATE TABLE `card_members` (
  `id` integer PRIMARY KEY,
  `full_name` varchar(150),
  `phone_number` varchar(20),
  `address` varchar(250),
  `birthday` date,
  `due_date` date
);

CREATE TABLE `borrowes` (
  `id` integer PRIMARY KEY,
  `books_id` integer,
  `card_members_id` integer,
  `librarian_id` integer,
  `borrow_from_date` date,
  `borrow_to_date` date,
  `actual_returned_date` date,
  `other_note` varchar(350),
  `late_fee` float,
  `borrow_fee` float,
  `total` float
);

CREATE TABLE `librarians` (
  `id` integer PRIMARY KEY,
  `full_name` varchar(150),
  `address` varchar(250),
  `phone_number` varchar(25),
  `birthday` date,
  `email` varchar(250)
);

CREATE TABLE `admin` (
  `id` integer PRIMARY KEY,
  `username` varchar(150),
  `password` varchar(500),
  `email` varchar(250),
  `address` varchar(250)
);

ALTER TABLE `books` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `books` ADD FOREIGN KEY (`publishers_id`) REFERENCES `publishers` (`id`);

ALTER TABLE `books` ADD FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`);

ALTER TABLE `borrowes` ADD FOREIGN KEY (`books_id`) REFERENCES `books` (`id`);

ALTER TABLE `borrowes` ADD FOREIGN KEY (`card_members_id`) REFERENCES `card_members` (`id`);

ALTER TABLE `borrowes` ADD FOREIGN KEY (`librarian_id`) REFERENCES `librarians` (`id`);
