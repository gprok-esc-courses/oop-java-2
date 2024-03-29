

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `title` varchar(250) NOT NULL,
  `publication_date` varchar(20) NOT NULL,
  `pages` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_isbn_idx` (`isbn`);


ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;


