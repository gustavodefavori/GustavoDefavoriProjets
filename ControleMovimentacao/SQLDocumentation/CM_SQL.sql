-- Criando o Banco de Dados Controle_Movimentacao
CREATE DATABASE `Controle_Movimentacao`;
-- Fim da Criação do Banco de Dados Controle_Movimentacao


USE `Controle_Movimentacao`;

-- Criacao a Tabela Conteiner
CREATE TABLE `Conteiner` (
	`cnt_num` VARCHAR(11) NOT NULL UNIQUE,
	`cnt_tipo` INT NOT NULL,
	`cnt_status` BOOLEAN NOT NULL,
	`cnt_cli_id` INT NOT NULL,
	`cnt_categoria` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`cnt_num`)
);
-- Fim da Criacao da Tabela Conteiner

-- Criando da Tabela Clientes
CREATE TABLE `Clientes` (
	`cli_id` INT NOT NULL AUTO_INCREMENT,
	`cli_cnpj` VARCHAR(18) NOT NULL UNIQUE,
	`cli_razaosocial` VARCHAR(100) NOT NULL,
	`cli_endereco` VARCHAR(100) NOT NULL,
	`cli_bairro` VARCHAR(50) NOT NULL,
	`cli_cidade` VARCHAR(100) NOT NULL,
	`cli_estado` VARCHAR(2) NOT NULL,
	`cli_cep` VARCHAR(10) NOT NULL,
	`cli_responsavel` VARCHAR(50) NOT NULL,
	`cli_email` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`cli_id`)
);
-- Fim da Criacao da Tabela Clientes

-- Criacao da Tabela Movimentacao
CREATE TABLE `Movimentacao` (
	`mvt_id` INT NOT NULL AUTO_INCREMENT,
	`mvt_tpm_id` INT NOT NULL,
	`mvt_dtinicio` DATETIME NOT NULL,
	`mv_dtfim` DATETIME NOT NULL,
	`mvt_cnt_num` VARCHAR(11) NOT NULL,
	`mvt_fun_id` INT NOT NULL,
	PRIMARY KEY (`mvt_id`)
);
-- Fim da Criacao da Tabela Movimetacao

-- Criacao a Tabela Tipo_Movimentacao
CREATE TABLE `Tipo_Movimentacao` (
	`tpm_id` INT NOT NULL AUTO_INCREMENT,
	`tpm_descricao` VARCHAR(50) NOT NULL,
	`tpm_tipo` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`tpm_id`)
);
-- Fim da Criacao da Tabela Tipo_Movimentacao

-- Criacao a Tabela Funcionario
CREATE TABLE `Funcionario` (
	`fun_id` INT NOT NULL AUTO_INCREMENT,
	`fun_nome` VARCHAR(30) NOT NULL,
	`fun_cpf` VARCHAR(14) NOT NULL UNIQUE,
	`fun_dtnasc` DATE NOT NULL,
	PRIMARY KEY (`fun_id`)
);
-- Fim da Criacao da Tabela Funcionario

-- Criacao de chaves estrangeiras
ALTER TABLE `Conteiner` ADD CONSTRAINT `Conteiner_fk0` FOREIGN KEY (`cnt_cli_id`) REFERENCES `Clientes`(`cli_id`);
ALTER TABLE `Movimentacao` ADD CONSTRAINT `Movimentacao_fk0` FOREIGN KEY (`mvt_tpm_id`) REFERENCES `Tipo_Movimentacao`(`tpm_id`);
ALTER TABLE `Movimentacao` ADD CONSTRAINT `Movimentacao_fk1` FOREIGN KEY (`mvt_cnt_num`) REFERENCES `Conteiner`(`cnt_num`);
ALTER TABLE `Movimentacao` ADD CONSTRAINT `Movimentacao_fk2` FOREIGN KEY (`mvt_fun_id`) REFERENCES `Funcionario`(`fun_id`);
-- Fim da criacao de chaves estrangeiras

-- Inicio dos inserts
INSERT INTO `tipo_movimentacao` VALUES (1,'EMBARQUE','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (2,'DESCARGA','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (3,'GATE IN','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (4,'GATE OUT','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (5,'REPOSICIONAMENTO','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (6,'PESAGEM','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (7,'SCANNER','SAIDA');
INSERT INTO `tipo_movimentacao` VALUES (8,'EMBARQUE','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (9,'DESCARGA','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (10,'GATE IN','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (11,'GATE OUT','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (12,'REPOSICIONAMENTO','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (13,'PESAGEM','ENTRADA');
INSERT INTO `tipo_movimentacao` VALUES (14,'SCANNER','ENTRADA');

INSERT INTO `Funcionario` VALUES(1,'JOSE DA SILVA', '270.128.010-93', '1991-06-06');
INSERT INTO `Funcionario` VALUES(2,'CLAUDIO DUARTE', '195.806.750-40', '1981-07-26');
INSERT INTO `Funcionario` VALUES(3,'MAIANA MARIA LIMA', '502.213.340-76', '1948-12-01');
INSERT INTO `Funcionario` VALUES(4,'MIRIAM HELAN SOUZA', '762.128.040-95', '1974-11-06');
INSERT INTO `Funcionario` VALUES(5,'DINO DA SILVA SAURO', '253.100.770-90', '2001-01-01');

INSERT INTO `clientes` VALUES (1,'15.442.432/0001-20','Giovanni e Raimundo Doces & Salgados Ltda','Rua Catiguá, 670','Vila Celso Mauad','Catanduva','SP', '15809-190', 'João Silva Santos','giovanni@docessalgadosltda.com.br');
INSERT INTO `clientes` VALUES (2,'50.811.522/0001-41','Larissa e Mariana Entulhos Ltda','Rua Altani Lara Nogueira, 195','Conjunto Residencial Dom Pedro I','São José dos Campos','SP', '15809-190', 'Larissa','ouvidoria@larissaemarianaentulhosltda.com.br');
INSERT INTO `clientes` VALUES(3, '87.409.193/0001-17', 'Caminho de Lima', 'Rua Silva Duarte, 156', 'Bairro Novo', 'Adamantina', 'SP', '13.598-78', 'Joao Lima', 'joaolima@gmail.com');
INSERT INTO `clientes` VALUES(4, '08.785.470/0001-10', 'Importacao da Silva', 'Rua Um, 16', 'Bairro Velho', 'Andradina', 'RS', '08.098-78', 'Joao Soares', 'joaosoares@gmail.com');
INSERT INTO `clientes` VALUES(5, '35.844.855/0001-83', 'Chines Express', 'Rua Nova, 16', 'Bairro Velho', 'Andradina', 'RS', '08.098-78', 'Joao Soares', 'joaosoares@gmail.com');

INSERT INTO `Conteiner` VALUES('ABCF7875744',20,0,1,'IMPORTACAO');
INSERT INTO `Conteiner` VALUES('PROF1258796',40,0,2,'EXPORTACAO');
INSERT INTO `Conteiner` VALUES('PROF2563149',20,1,3,'IMPORTACAO');
INSERT INTO `Conteiner` VALUES('BGFH1254896',40,0,4,'IMPORTACAO');
INSERT INTO `Conteiner` VALUES('ABCF5263894',20,1,5,'EXPORTACAO');

INSERT INTO `Movimentacao` VALUES(1,1,'2021-01-02 12:00:00.000','2021-01-02 12:30:00.000','ABCF5263894',5);
INSERT INTO `Movimentacao` VALUES(2,2,'2021-01-02 13:00:00.000','2021-01-02 13:30:00.000','ABCF7875744',4);
INSERT INTO `Movimentacao` VALUES(3,3,'2022-01-02 12:00:00.000','2022-01-02 12:30:00.000','BGFH1254896',3);
INSERT INTO `Movimentacao` VALUES(4,4,'2022-01-02 13:00:00.000','2022-01-02 13:30:00.000','PROF1258796',2);
INSERT INTO `Movimentacao` VALUES(5,5,'2022-01-02 14:00:00.000','2022-01-02 14:30:00.000','PROF2563149',1);
--Fim dos interts