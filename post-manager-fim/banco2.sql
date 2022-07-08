-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.35-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para facebook
DROP DATABASE IF EXISTS `facebook`;
CREATE DATABASE IF NOT EXISTS `facebook` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `facebook`;

-- Copiando estrutura para tabela facebook.cargos
DROP TABLE IF EXISTS `cargos`;
CREATE TABLE IF NOT EXISTS `cargos` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCargo` varchar(2000) DEFAULT NULL,
  `descricaoCargo` varchar(5000) DEFAULT NULL,
  `salarioCargo` float DEFAULT NULL,
  `cargaHorariaSemanalCargo` float DEFAULT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela facebook.cargos: 6 rows
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` (`idCargo`, `nomeCargo`, `descricaoCargo`, `salarioCargo`, `cargaHorariaSemanalCargo`) VALUES
	(1, 'Adm4', 'Administrador4', 4000, 40),
	(2, 'Jornalista22', 'escreve22', 2200, 22),
	(14, 'Diretor10', 'diretor da empresa10', 1000, 10);
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;

-- Copiando estrutura para tabela facebook.companies
DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `role` varchar(128) NOT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela facebook.companies: 1 rows
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` (`id`, `name`, `role`, `start`, `end`, `user_id`) VALUES
	(1, 'Empresa 1', 'Empresa 1', '2022-05-03', '2022-04-25', 1);
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;

-- Copiando estrutura para tabela facebook.posts
DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `post_date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela facebook.posts: 8 rows
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`, `content`, `post_date`, `user_id`) VALUES
	(1, 'Olá do Emerson', '2022-05-10', 1),
	(2, 'Olá da Luiza', '2022-05-10', 2),
	(3, 'Olá da Denise', '2022-05-10', 3),
	(4, 'Olá do Noé', '2022-05-10', 4),
	(5, 'Olá da Rosânia', '2022-05-10', 5),
	(6, 'Olá da Rosânia 1', '2022-05-10', 5),
	(7, 'Olá da Rosânia 2', '2022-05-10', 5),
	(8, 'Olá da Rosânia 3', '2022-05-10', 5);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;

-- Copiando estrutura para tabela facebook.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_users_cargos` (`cargo`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela facebook.users: 6 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `nome`, `sexo`, `email`, `cargo`) VALUES
	(1, 'Emerson Carvalho', 'M', 'emerson@mail.com', 2),
	(2, 'Luiza Carvalho', 'F', 'lu@mail.com', 2),
	(3, 'Denise Carvalho', 'F', 'de@mail.com', 1),
	(4, 'Noé Carvalho', 'M', 'noe@mail.com', 14),
	(5, 'Rosânia Carvalho', 'F', 'ro@mail.com', 2),
	(8, 'fdf', NULL, '', NULL),
	(9, 'aaa', 'M', 'aa', 1),
	(10, 'sdaaa', 'F', 'asadad@dsfsdff.sdsff', 1),
	(11, 'asasa', 'F', 'asadad@dsfsdff.sdsff', 1),
	(12, 'asasa', 'F', 'asadad@dsfsdff.sdsff', 16),
	(13, 'sss', 'M', 'sssdfdf@dfdf.sfsdf', 1),
	(14, 'teste', 'M', 'teste@teste.com', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
