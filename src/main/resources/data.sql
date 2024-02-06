-- Default categories --
INSERT IGNORE INTO categories (id, name, description)
VALUES ('2f7df61f-3d16-4bbb-ab75-90ad9129e4bc', 'TRAVEL', 'Mochila for travel');
INSERT IGNORE INTO categories (id, name, description)
VALUES ('c49a7f43-b583-42b6-87ac-4dfdde37a6f8', 'ELECTRONICS', 'Electronics category');
INSERT IGNORE INTO categories (id, name, description)
VALUES ('9b61273f-ea83-4343-97ae-49a957347a3c', 'CLOTHING', 'Clothing category');
INSERT IGNORE INTO categories (id, name, description)
VALUES ('208de3aa-fbdc-4969-bb6c-727d5e535c1b', 'FOOD', 'Food category');
-- Default roles --
INSERT IGNORE INTO roles(id,name,description) VALUES ('6f5466b0-2e23-48cb-9e6f-effa99e52bb7','USER','Role user');
INSERT IGNORE INTO roles(id,name,description) VALUES ('fba81e33-c09d-431c-b8b6-96644dbc7fce','ADMIN','Role admin');
-- Default users --
INSERT INTO users(id,first_name,last_name,email,password,address,role_id, enable) VALUES
('da59c4c7-7cf5-437d-88b5-ae566c0487c1' ,'Pepe','Torrez','user@gmail.com','$2a$12$icq3ZzQj0JjadQIcQ4Cm7.ry.S/LQ3Upt.VghbFCyDmqRTD3veN5K','La Paz','6f5466b0-2e23-48cb-9e6f-effa99e52bb7',true);
INSERT INTO users(id,first_name,last_name,email,password,address,role_id, enable) VALUES
('fba81e33-c09d-431c-b8b6-96644dbc7fce' ,'Toreto','Velas','admin@gmail.com','$2a$12$icq3ZzQj0JjadQIcQ4Cm7.ry.S/LQ3Upt.VghbFCyDmqRTD3veN5K','Los Angeles','fba81e33-c09d-431c-b8b6-96644dbc7fce',true);
-- Default products --
INSERT INTO products(id,name,description,image_url,price,stock,active,category_id) VALUES ('da59c4c7-7cf5-437d-88b5-ae566c0487c1' ,'Product 1','mi primer product','http://image.url',20.0,1999,true,'208de3aa-fbdc-4969-bb6c-727d5e535c1b');
INSERT INTO products(id,name,description,image_url,price,stock,active,category_id) VALUES ('a9f2e8a3-eb3b-40a7-a660-58f06466527e' ,'Product 2','mi primer product','http://image.url',20.0,1999,true,'208de3aa-fbdc-4969-bb6c-727d5e535c1b');
INSERT INTO products(id,name,description,image_url,price,stock,active,category_id) VALUES ('36bcfc03-4795-491c-a8d1-b966b47949a4' ,'Product 3','mi primer product','http://image.url',20.0,1999,true,'9b61273f-ea83-4343-97ae-49a957347a3c');