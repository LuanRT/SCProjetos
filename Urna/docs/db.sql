-- Cria o db da urna.
DROP SCHEMA urnadb;
CREATE SCHEMA IF NOT EXISTS urnadb;
USE urnadb;

-- Tabela do eleitor.
CREATE TABLE IF NOT EXISTS Eleitor (
  `inscricao` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`inscricao`),
  UNIQUE INDEX `inscricao_UNIQUE` (`inscricao` ASC) VISIBLE
);

-- Tabela de cargos.
CREATE TABLE IF NOT EXISTS Cargo (
  `codCargo` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`codCargo`),
  UNIQUE INDEX `codCargo_UNIQUE` (`codCargo` ASC) VISIBLE
);

-- Tabela de partidos.
CREATE TABLE IF NOT EXISTS Partido (
  `codPartido` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(80) NULL,
  PRIMARY KEY (`codPartido`)
);

-- Tabela de candidatos.
CREATE TABLE IF NOT EXISTS Candidato (
  `inscricao` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `codCargo` VARCHAR(10) NOT NULL,
  `codPartido` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`inscricao`),
  UNIQUE INDEX `inscricao_UNIQUE` (`inscricao` ASC) VISIBLE,
  INDEX `codCargo_idx` (`codCargo` ASC) VISIBLE,
  INDEX `codPartido_idx` (`codPartido` ASC) VISIBLE,
  CONSTRAINT `codCargo`
    FOREIGN KEY (`codCargo`)
    REFERENCES `Cargo` (`codCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codPartido`
    FOREIGN KEY (`codPartido`)
    REFERENCES `Partido` (`codPartido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Tabela de votos
CREATE TABLE IF NOT EXISTS Voto (
  `inscricaoCandidato` INT,
  `inscricaoEleitor` INT NOT NULL,
  `codCargo` VARCHAR(10),
  INDEX `inscricao_idx` (`inscricaoCandidato` ASC) VISIBLE,
  CONSTRAINT `inscricao`
    FOREIGN KEY (`inscricaoCandidato`)
    REFERENCES `Candidato` (`inscricao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voto_Eleitor1`
    FOREIGN KEY (`inscricaoEleitor`)
    REFERENCES `Eleitor` (`inscricao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voto_Cargo`
    FOREIGN KEY (`codCargo`)
    REFERENCES `Cargo` (`codCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Dados demo:

-- Admin do sistema
INSERT INTO Eleitor (inscricao, nome) VALUES (010203, "Administrador");

INSERT INTO Eleitor (inscricao, nome) VALUES (123456, "Luan Torquato");
INSERT INTO Eleitor (inscricao, nome) VALUES (112233, "Breno");
INSERT INTO Eleitor (inscricao, nome) VALUES (223344, "Daniel");
INSERT INTO Eleitor (inscricao, nome) VALUES (334455, "Lucas");
INSERT INTO Eleitor (inscricao, nome) VALUES (445566, "Joe");
INSERT INTO Eleitor (inscricao, nome) VALUES (556677, "Andrew");

INSERT INTO Cargo (codCargo, nome) VALUES ('pre', 'Presidente');
INSERT INTO Cargo (codCargo, nome) VALUES ('gov', 'Governador');
INSERT INTO Cargo (codCargo, nome) VALUES ('sen', 'Senador');

INSERT INTO Partido (codPartido, nome) VALUES ('ptb', 'Partido Trabalhista Brasileiro');
INSERT INTO Partido (codPartido, nome) VALUES ('pv', 'Partido Verde');
INSERT INTO Partido (codPartido, nome) VALUES ('pp', 'Progressistas');

INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (11, 'Carol', 'pre', 'pp');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (22, 'Roger', 'pre', 'pv');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (33, 'Kevin', 'pre', 'ptb');

INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (111, 'Ana', 'gov', 'pp');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (222, 'Thiago', 'gov', 'pv');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (333, 'Mary', 'gov', 'ptb');

INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (1111, 'Robert', 'sen', 'pp');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (2222, 'Adriana', 'sen', 'pv');
INSERT INTO Candidato (inscricao, nome, codCargo, codPartido) VALUES (3333, 'Peter', 'sen', 'ptb');