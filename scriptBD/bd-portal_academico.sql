CREATE DATABASE IF NOT EXISTS portal_academico;

USE portal_academico;

CREATE TABLE IF NOT EXISTS `aluno`(
	`matricula` int NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) NOT NULL,
    `telefone` varchar(12),
    PRIMARY KEY (`matricula`)
); 

CREATE TABLE IF NOT EXISTS `professor`(
	`matricula` int NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `telefone` varchar(12),
    PRIMARY KEY (`matricula`)
);

CREATE TABLE IF NOT EXISTS `disciplina`(
	`id_disciplina` int NOT NULL AUTO_INCREMENT,
    `descricao` varchar(255) NOT NULL,
    `cargaHoraria` int NOT NULL,
    PRIMARY KEY (`id_disciplina`)
);

CREATE TABLE IF NOT EXISTS `aluno_disciplina`(
	`fk_disciplina` int NOT NULL,
    `fk_matricula` int NOT NULL,
    FOREIGN KEY(`fk_matricula`) REFERENCES `aluno` (`matricula`),
    FOREIGN KEY(`fk_disciplina`) REFERENCES `disciplina` (`id_disciplina`)
);

CREATE TABLE IF NOT EXISTS `professor_disciplina`(
	`fk_disciplina` int NOT NULL,
    `fk_professor` int NOT NULL,
    FOREIGN KEY(`fk_disciplina`) REFERENCES `disciplina` (`id_disciplina`),
    FOREIGN KEY(`fk_professor`) REFERENCES `professor` (`matricula`)
);
