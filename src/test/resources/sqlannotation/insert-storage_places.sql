INSERT INTO users (id, name, email) VALUES (1, "megu", "megu@neko.com");
INSERT INTO users (id, name, email) VALUES (2, "deji", "deji@neko.com");
INSERT INTO users (id, name, email) VALUES (3, "mopu", "mopu@neko.com");

INSERT INTO materials (id, material_name) VALUES (1, "shiryo1");
INSERT INTO materials (id, material_name) VALUES (2, "shiryo2");
INSERT INTO materials (id, material_name) VALUES (3, "shiryo3");
INSERT INTO materials (id, material_name) VALUES (4, "shiryo4");
INSERT INTO materials (id, material_name) VALUES (5, "shiryo5");
INSERT INTO materials (id, material_name) VALUES (6, "shiryo6");

INSERT INTO storage_places (id, storage_date, storage_place, user_id, material_id) VALUES (1, "2023-11-01", "書庫1-1", 1, 1);
INSERT INTO storage_places (id, storage_date, storage_place, user_id, material_id) VALUES (2, "2023-11-01", "書庫2-1", 2, 2);
INSERT INTO storage_places (id, storage_date, storage_place, user_id, material_id) VALUES (3, "2023-11-03", "書庫2-1", 1, 3);
INSERT INTO storage_places (id, storage_date, storage_place, user_id, material_id) VALUES (4, "2023-11-03", "書庫1-1", 1, 4);
INSERT INTO storage_places (id, storage_date, storage_place, user_id, material_id) VALUES (5, "2023-11-05", "書庫1-2", 2, 5);
