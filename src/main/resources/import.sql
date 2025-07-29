-- Categorias
INSERT INTO tb_category (name, inclusion_date) VALUES ('Moradia', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Alimentação', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Transporte', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Saúde', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Telefonia', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Reserva / Poupança', '2025-07-29');
INSERT INTO tb_category (name, inclusion_date) VALUES ('Roupas e Calçados', '2025-07-29');

--Itens
-- Moradia (id: 1)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Aluguel', 1200.00, '2025-06-01', 1);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Conta de Luz', 130.00, '2025-06-01', 1);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Conta de Água', 85.00, '2025-06-01', 1);

-- Alimentação (id: 2)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Supermercado', 850.00, '2025-06-01', 2);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Delivery', 150.00, '2025-06-01', 2);

-- Transporte (id: 3)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Combustível', 350.00, '2025-06-01', 3);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Uber', 80.00, '2025-06-01', 3);

-- Saúde (id: 4)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Plano de Saúde', 300.00, '2025-06-01', 4);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Farmacia', 200.0, '2025-06-01', 4);


-- Telefonia (id: 5)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Recarga de celular', 30.00, '2025-06-01', 5);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Celular / Plano', 57.60, '2025-06-01', 5);


-- Reserva / Poupança (id: 6)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Poupança mensal', 300.00, '2025-06-01', 6);

-- Roupas e Calçados (id: 7)
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Tênis novo', 220.00, '2025-06-01', 7);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Vestuário', 200.0, '2025-06-01', 7);
INSERT INTO tb_item (description, amount, date, category_id) VALUES ('Vestuário', 200.0, '2025-06-01', 7);
