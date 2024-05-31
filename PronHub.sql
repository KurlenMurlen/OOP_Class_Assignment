CREATE DATABASE IF NOT EXISTS PronHub;

USE PronHub;

CREATE TABLE IF NOT EXISTS Admin (
    idAdmin INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO Admin (nome, email, senha) VALUES ('Admin1', 'admin1@example.com', 'senha123');

CREATE TABLE IF NOT EXISTS Vendedor (
    idVendedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    dataCadastro DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO Vendedor (nome, sobrenome, dataNascimento, telefone, CPF, cidade, estado, pais, endereco, dataCadastro, email, senha) VALUES ('João', 'Silva', '1990-05-10', '+5511987654321', '123.456.789-00', 'São Paulo', 'SP', 'Brasil', 'Rua das Flores, 123', '2024-05-19', 'joao@example.com', 'senha123');

CREATE TABLE IF NOT EXISTS Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    dataCadastro DATE NOT NULL
);

INSERT INTO Cliente (nome, sobrenome, dataNascimento, telefone, CPF, cidade, estado, pais, endereco, numero, email, senha, dataCadastro) VALUES ('Maria', 'Souza', '1985-08-20', '+551188888888', '987.654.321-00', 'Rio de Janeiro', 'RJ', 'Brasil', 'Av. das Palmeiras, 456', 101, 'maria@example.com', 'senha456', '2024-05-19');

CREATE TABLE IF NOT EXISTS Fornecedor (
    idFornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nomeFantasia VARCHAR(255) NOT NULL,
    razaoSocial VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(18) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    dataCadastro DATE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO Fornecedor (nomeFantasia, razaoSocial, CNPJ, email, telefone, cidade, estado, pais, endereco, numero, dataCadastro, senha) VALUES ('FornecedorX', 'Empresa X LTDA', '12.345.678/0001-00', 'fornecedorx@example.com', '+5511999999999', 'São Paulo', 'SP', 'Brasil', 'Av. Comercial, 789', 201, '2024-05-19', 'senha789');

CREATE TABLE IF NOT EXISTS Produto (
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    fornecedorId INT NOT NULL,
    FOREIGN KEY (fornecedorId) REFERENCES Fornecedor(idFornecedor)
);

INSERT INTO Produto (descricao, quantidade, preco, fornecedorId) VALUES ('ProdutoA', 50, 29.99, 1);

CREATE TABLE IF NOT EXISTS Venda (
    idVenda INT AUTO_INCREMENT PRIMARY KEY,
    clienteId INT NOT NULL,
    vendedorId INT NOT NULL,
    tipoPagamento ENUM('credito', 'debito', 'dinheiro') NOT NULL,
    FOREIGN KEY (clienteId) REFERENCES Cliente(idCliente),
    FOREIGN KEY (vendedorId) REFERENCES Vendedor(idVendedor)
);

INSERT INTO Venda (clienteId, vendedorId, tipoPagamento) VALUES (1, 1, 'credito');

CREATE TABLE IF NOT EXISTS ItemVenda (
    idItemVenda INT AUTO_INCREMENT PRIMARY KEY,
    vendaId INT NOT NULL,
    produtoId INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (vendaId) REFERENCES Venda(idVenda),
    FOREIGN KEY (produtoId) REFERENCES Produto(idProduto)
);

CREATE TABLE IF NOT EXISTS PagCredito (
    idPagCredito INT AUTO_INCREMENT PRIMARY KEY,
    vendaId INT NOT NULL,
    numeroCartao VARCHAR(16) NOT NULL,
    quantidadeParcelas INT NOT NULL,
    FOREIGN KEY (vendaId) REFERENCES Venda(idVenda)
);

CREATE TABLE IF NOT EXISTS PagDebito (
    idPagDebito INT AUTO_INCREMENT PRIMARY KEY,
    vendaId INT NOT NULL,
    numeroCartao VARCHAR(16) NOT NULL,
    FOREIGN KEY (vendaId) REFERENCES Venda(idVenda)
);

CREATE TABLE IF NOT EXISTS PagDinheiro (
    idPagDinheiro INT AUTO_INCREMENT PRIMARY KEY,
    vendaId INT NOT NULL,
    FOREIGN KEY (vendaId) REFERENCES Venda(idVenda)
);