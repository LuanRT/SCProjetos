-- Cria o db da urna.
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
  INDEX `inscricao_idx` (`inscricaoCandidato` ASC) VISIBLE,
  PRIMARY KEY (`inscricaoEleitor`, `inscricaoCandidato`),
  CONSTRAINT `inscricao`
    FOREIGN KEY (`inscricaoCandidato`)
    REFERENCES `Candidato` (`inscricao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voto_Eleitor1`
    FOREIGN KEY (`inscricaoEleitor`)
    REFERENCES `Eleitor` (`inscricao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);