CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0 NOT NULL
);

CREATE TABLE cobranca (
    id SERIAL PRIMARY KEY,
    originator_id INT NOT NULL REFERENCES usuario(id),
    recipient_cpf VARCHAR(11) NOT NULL,
    value DECIMAL(10, 2) NOT NULL,
    description TEXT,
    status VARCHAR(20) CHECK (status IN ('Pendente', 'Paga', 'Cancelada')) DEFAULT 'Pendente',
    criacao_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    cobranca_id INT NOT NULL REFERENCES cobranca(id),
    metodo_pagamento VARCHAR(20) CHECK (metodo_pagamento IN ('Saldo', 'Cartão')),
    status VARCHAR(20) CHECK (status IN ('Aprovado', 'Rejeitado')),
    transacao_id VARCHAR(255),
    criacao_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transacao (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES usuario(id),
    type VARCHAR(20) CHECK (type IN ('Depósito', 'Estorno')),
    quantidade DECIMAL(10, 2) NOT NULL,
    criacao_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);