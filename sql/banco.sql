
DROP TABLE IF EXISTS VisitasCampo;
DROP TABLE IF EXISTS PlantasMedicinais;
DROP TABLE IF EXISTS PlantasToxicas;
DROP TABLE IF EXISTS Plantas;
DROP TABLE IF EXISTS Botanicos;
DROP TABLE IF EXISTS Regioes;
DROP TABLE IF EXISTS AvaliacoesToxicidade;

CREATE TABLE Plantas (
    Nome VARCHAR(50) NOT NULL PRIMARY KEY,
    AlturaMaximaCm INT NOT NULL,
    Toxicidade INT NOT NULL,
    Origem INT NOT NULL
);

CREATE TABLE PlantasMedicinais (
    ParteUtilizada INT NOT NULL,
    PropriedadeTerapeutica INT NOT NULL,
    PlantaId VARCHAR(50) NOT NULL,
    FOREIGN KEY (PlantaId) REFERENCES Plantas (Nome)
);

CREATE TABLE PlantasToxicas (
    CompostoToxico INT NOT NULL,
    EfeitoColateral INT NOT NULL,
    PlantaId VARCHAR(50) NOT NULL,
    FOREIGN KEY (PlantaId) REFERENCES Plantas (Nome)
);

CREATE TABLE Botanicos (
    Nome VARCHAR(50) NOT NULL PRIMARY KEY,
    AnosExperiencia INT NOT NULL,
    Especialidade INT NOT NULL,
    Titulacao INT NOT NULL
);

CREATE TABLE Regioes (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Ecossistema VARCHAR(50) NOT NULL,
    Uf INT NOT NULL,
    FrequenciaAcidentesPorAno INT NOT NULL,
    Acessivel BIT(1) NOT NULL
);

CREATE TABLE VisitasCampo (
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    RegiaoId INT NOT NULL,
    PlantaId VARCHAR(50) NOT NULL,
    FOREIGN KEY (RegiaoId) REFERENCES Regioes (Sequencial),
    FOREIGN KEY (PlantaId) REFERENCES Plantas (Nome)
);

CREATE TABLE AvaliacoesToxicidade(
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    BotanicoId VARCHAR(50) NOT NULL,
    RegiaoId INT NOT NULL,
    N_plantas_alta_toxicidade INT,
    N_plantas_baixa_toxicidade INT,
    FOREIGN KEY (BotanicoId) REFERENCES Botanicos(Nome),
    FOREIGN KEY (RegiaoId) REFERENCES Regioes(Sequencial));