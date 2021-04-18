/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Kevin', 'Catucuamba', 'catucuambakevin@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Erick', 'Rodriguez', 'rodrifab.doe@gmail.com', '2017-08-02', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Fabian', 'Quelal', 'quiloatoa.@gmail.com', '2017-08-03', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Janeth', 'Cacuango', 'cacuangojj202@gmail.com', '2017-08-04', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Rosa', 'Alba', 'rosaalba@gmail.com', '2017-08-05', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Alejandro', 'Cachipuendo', 'alecachi.gamma@gmail.com', '2017-08-06', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('José', 'Quiguango', 'josterna@gmail.com', '2017-08-07', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Estefany', 'Acero', 'estefy@gmail.com', '2017-08-08', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Wilmer', 'Quilo', 'examwil@gmail.com', '2017-08-09', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Jacob', 'Federico', 'ddavidjacb@gmail.com', '2017-08-010', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Malena', 'Borja', 'uaborja2019@gmail.com', '2017-08-11', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Kiara', 'Borja', 'kkborja2014@gmail.com', '2017-08-12', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Edisson', 'Guaichico', 'ediguaichico@gmail.com', '2017-08-13', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Fabricio', 'Espinoza', 'espinfab@gmail.com', '2017-08-14', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Rodrigo', 'Quilumbango', 'semcares@gmail.com', '2017-08-15', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Guillermo', 'Castro', 'alquilestodo@gmail.com', '2017-08-16', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Luis', 'Benavides', 'luilliquil@gmail.com', '2017-08-17', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Marcelo', 'Ramirez', 'ramicoral@gmail.com', '2017-08-18', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Anita', 'Ramos', 'ramos_personal@gmail.com', '2017-08-19', '');  
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Rocío', 'Quiranza', 'jokeroqui@gmail.com', '2017-08-20', ''); 
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('David', 'Quiranza', 'quiranzadavid@gmail.com', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Javier', 'Torres', 'torresmith@gmail.com', '2017-08-22', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Raul', 'Cruz', 'cruzraul@gmail.com', '2017-08-23', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Mateo', 'Valverde', 'mvalvrd@gmail.com', '2017-08-24', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Mauricio', 'Castillo', 'sacatro@gmail.com', '2017-08-25', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Martillo KNF', 20.45, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('LLave inglesa ERI', 14.45, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Metro Simple', 8.50, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Juego de pinzas RT', 11.50, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Tornillo ERT 14x13', 0.50, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Foco Binaci', 1.50, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Cinta de aislar', 2.00, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Users */

INSERT INTO users (username, password, enabled) VALUES('kevin', '$2a$10$WtuL.RBxyv5/vjXEWBV6Vu27NBm0LMmPGBsxx.wNBd6KCrYT4LTvy', 1);
INSERT INTO users (username, password, enabled) VALUES('admin', '$2a$10$gTxt0ZntTi5I4rcmceIVuuicCaKnXlYatlLYqLYdB3slYdEFFzdd.', 1);

INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(2, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(2, 'ROLE_ADMIN');

