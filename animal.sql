CREATE TABLE IF NOT EXISTS `animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `animal` varchar(15) NOT NULL,
  `class` varchar(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO animal (id, animal, class) VALUES (1,"Лев", "Млекопитающее");
INSERT INTO animal (id, animal, class) VALUES (2,"Карась", "Рыба");
INSERT INTO animal (id, animal, class) VALUES (3,"Орёл", "Птица");
INSERT INTO animal (id, animal, class) VALUES (4,"Лягушка", "Земноводное");
INSERT INTO animal (id, animal, class) VALUES (5,"Крокодил", "Рептилия");
