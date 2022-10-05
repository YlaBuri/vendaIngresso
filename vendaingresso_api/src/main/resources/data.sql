INSERT INTO endereco (estado,cidade,cep,numero)
VALUES
('Rio Grande do Sul','Rio Grande','97553-886','57'),
('Paraíba','Santa Rita','58342-425','37'),
('Rio Grande do Sul','Canoas','93791-639','85'),
('Pernambuco','Recife','53917-484','23');

INSERT INTO cliente (nome,email,senha,cpf,habilitado_reserva,endereco_id)
VALUES
('Miranda Hebert','mirandahebert6126@protonmail.org','UMU78MQO5JO','935.718.222-53','true',1),
('Nomlanga Galloway','nomlangagalloway4050@outlook.net','WQT37OZQ2NQ','488.141.984-17','false',2),
('Bruno Hodges','brunohodges6545@google.edu','KDT99KYU7AO','718.850.115-82','true',3),
('Clementine Goodwin','clementinegoodwin2202@aol.com','LKH41JLJ1JU','053.059.627-88','true',4);

INSERT INTO poltrona (localizacao,valor)
VALUES
('FH11','6.39'),
('RM49','5.66'),
('IB38','27.42'),
('KQ24','15.84'),
('FW36','9.53'),
('DF34','6.92'),
('CE11','9.17'),
('JP54','13.94'),
('DA13','17.04'),
('QL67','5.94');

INSERT INTO evento (nome, data_evento)
VALUES
('evento 1', '07-05-10 03:43:36'),
('evento 2', '26-11-19 09:35:41'),
('evento 3', '11-06-20 02:56:42');

INSERT INTO ingresso(valor_ingresso, evento_id) VALUES
('100.45', 1),
('100.45', 1),
('100.45', 1);

INSERT INTO ingresso_poltrona (ingresso_id, poltrona_id) VALUES
(1, 1),
(1, 2),
(1, 3);

-- INSERT INTO evento_poltrona(evento_id, poltrona_id) VALUES
-- (1, 1),
-- (1, 2),
-- (1, 3);

INSERT INTO compra(data_compra, reserva, entrega_domicilio, cliente_id, ingresso_id) VALUES
('1954-11-19 20:26:22.878307', false, false, 2, 1);