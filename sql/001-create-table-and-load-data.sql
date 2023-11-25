DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, email) VALUES ("negu", "negu@neko.com");
INSERT INTO users (name, email) VALUES ("deji", "deji@neko.com");
INSERT INTO users (name, email) VALUES ("mopu", "mopu@neko.com");

DROP TABLE IF EXISTS materials;

CREATE TABLE materials (
  id int unsigned AUTO_INCREMENT,
  material_name VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO materials (material_name) VALUES ("shiryo1");
INSERT INTO materials (material_name) VALUES ("shiryo2");
INSERT INTO materials (material_name) VALUES ("shiryo3");
INSERT INTO materials (material_name) VALUES ("shiryo4");
INSERT INTO materials (material_name) VALUES ("shiryo5");

DROP TABLE IF EXISTS storage_places;

CREATE TABLE storage_places (
  id int unsigned AUTO_INCREMENT,
  storage_date DATE NOT NULL,
  user_id int unsigned NOT NULL,
  material_id int unsigned NOT NULL,
  PRIMARY KEY(id),

  CONSTRAINT fk_storage_user_id
  FOREIGN KEY (user_id)
      REFERENCES users(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT,

  CONSTRAINT fk_storage_material_id
  FOREIGN KEY (material_id)
      REFERENCES materials(id)
      ON DELETE RESTRICT ON UPDATE RESTRICT
);

INSERT INTO storage_places (storage_date, user_id, material_id) VALUES ("2023-11-01", 1, 1);
INSERT INTO storage_places (storage_date, user_id, material_id) VALUES ("2023-11-01", 2, 2);
INSERT INTO storage_places (storage_date, user_id, material_id) VALUES ("2023-11-03", 1, 3);
INSERT INTO storage_places (storage_date, user_id, material_id) VALUES ("2023-11-03", 1, 4);
INSERT INTO storage_places (storage_date, user_id, material_id) VALUES ("2023-11-05", 2, 5);
