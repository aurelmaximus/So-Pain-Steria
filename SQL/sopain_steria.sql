-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 16 fév. 2023 à 20:24
-- Version du serveur : 5.7.40
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sopain_steria`
--
CREATE DATABASE IF NOT EXISTS `sopain_steria` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sopain_steria`;

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zip_code` varchar(10) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKravrcdl4ml7ghtfxdr2nx9hyw` (`last_name`,`first_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`type`, `id`, `zip_code`, `number`, `city`, `street`, `email`, `last_name`, `password`, `first_name`, `version`, `points`) VALUES
('Employe', 1, '33000', '4', 'Bordeaux', 'Rue du dragon blanc', 'aurelien.bulme@gmail.com', 'Aurélien', 'Croki19', 'Bulme', 0, 0),
('Employe', 2, '69000', '8', 'Lyon', 'Rue du magicien', 'cedric.devillers@gmail.com', 'Cedric', 'cedric', 'Devillers', 0, 0),
('Employe', 3, '33000', '12', 'Bordeaux', 'Rue cyber', 'farah.benaissa@gmail.com', 'Farah', 'farah', 'Benaissa', 0, 0),
('Employe', 4, '69000', '7bis', 'Lyon', 'Rue ignister', 'youssef.talmat@gmail.com', 'Youssef', 'youssef', 'Talmat', 0, 0),
('Customer', 5, '33000', '1', 'Bordeaux', 'Rue de la victoire', 'prune.pommier@gmail.com', 'prune', 'peche', 'pommier', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

DROP TABLE IF EXISTS `command`;
CREATE TABLE IF NOT EXISTS `command` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `arrived_date` date DEFAULT NULL,
  `command_status` varchar(25) DEFAULT NULL,
  `arrived_hour` time DEFAULT NULL,
  `on_site` tinyint(1) DEFAULT '0',
  `version` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK4adexdu0ttc9l217n3ydn7199` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`numero`, `arrived_date`, `command_status`, `arrived_hour`, `on_site`, `version`, `customer_id`) VALUES
(1, '2023-01-31', 'Termine', '14:30:00', 0, 0, 5),
(2, '2023-01-27', 'EnCours', '16:55:00', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `command_line`
--

DROP TABLE IF EXISTS `command_line`;
CREATE TABLE IF NOT EXISTS `command_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(5,2) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `command_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK63wx5vtqo2p1upm623em6aic` (`command_id`),
  KEY `FKexibn53w35ucgmrpyu3nt47dx` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `command_line`
--

INSERT INTO `command_line` (`id`, `quantity`, `total`, `version`, `command_id`, `product_id`) VALUES
(2, 2, '2.40', 0, 2, 7);

-- --------------------------------------------------------

--
-- Structure de la table `favorite_articles`
--

DROP TABLE IF EXISTS `favorite_articles`;
CREATE TABLE IF NOT EXISTS `favorite_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjx8inxsdb180t84o3uj97rm5y` (`customer_id`),
  KEY `FK8ymrqp3evp7dvak8g2vjw7ne` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `favorite_articles`
--

INSERT INTO `favorite_articles` (`id`, `version`, `customer_id`, `product_id`) VALUES
(1, 0, 1, 7),
(2, 0, 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allergen` tinyint(1) DEFAULT '0',
  `label` varchar(25) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `allergen`, `label`, `version`) VALUES
(1, 1, 'Farine_T55', 0),
(2, 1, 'Farine_T65', 0),
(3, 1, 'Oeuf', 0),
(4, 1, 'Lait', 0),
(5, 0, 'Sucre', 0),
(6, 0, 'Praline', 0),
(7, 1, 'Pate_amande ', 0),
(8, 0, 'Levure_boulangerie', 0),
(9, 1, 'Beurre', 0),
(10, 0, 'Chocolat', 0),
(11, 0, 'Graines_bio', 0),
(12, 0, 'Vanille', 0),
(13, 1, 'Amande_effilee', 0),
(14, 0, 'Sel', 0),
(15, 0, 'Raisin_sec', 0),
(16, 0, 'Sucre_glace', 0),
(17, 0, 'Pommes', 0),
(18, 0, 'Fraise', 0),
(19, 0, 'Canelle', 0),
(20, 1, 'Farine_ble_complet', 0),
(21, 0, 'Rhum', 0),
(22, 1, 'Huile_noix', 0),
(23, 1, 'Noix', 0),
(24, 0, 'Maizena', 0),
(25, 0, 'Sirop_sucre ', 0),
(26, 0, 'Kirsch ', 0),
(27, 0, 'Framboise ', 0),
(28, 1, 'Amande ', 0),
(29, 0, 'Orange', 0),
(30, 0, 'Banane', 0),
(31, 0, 'Kiwi', 0),
(32, 0, 'Poires', 0),
(33, 1, 'Grain_cafe', 0),
(34, 1, 'The_vert', 0),
(35, 0, 'Menthe', 0),
(36, 0, 'Citron', 0),
(37, 1, 'The_exotique', 0);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient_line`
--

DROP TABLE IF EXISTS `ingredient_line`;
CREATE TABLE IF NOT EXISTS `ingredient_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `ingredient_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfw602n9nfuq3hifulp8e58gwl` (`ingredient_id`),
  KEY `FKdu629s77exd2v9d7sfv157g4m` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient_line`
--

INSERT INTO `ingredient_line` (`id`, `version`, `ingredient_id`, `product_id`) VALUES
(1, 0, 1, 8),
(2, 0, 3, 8),
(3, 0, 4, 8),
(4, 0, 5, 8),
(5, 0, 14, 8),
(6, 0, 8, 8),
(7, 0, 9, 8),
(8, 0, 1, 7),
(9, 0, 3, 7),
(10, 0, 4, 7),
(11, 0, 5, 7),
(12, 0, 14, 7),
(13, 0, 8, 7),
(14, 0, 9, 7),
(15, 0, 10, 7),
(16, 0, 1, 8),
(17, 0, 3, 8),
(18, 0, 4, 8),
(19, 0, 5, 8),
(20, 0, 14, 8),
(21, 0, 8, 8),
(22, 0, 9, 8),
(23, 0, 15, 8),
(24, 0, 12, 8),
(25, 0, 17, 10),
(26, 0, 3, 10),
(27, 0, 27, 10),
(28, 0, 5, 10),
(29, 0, 19, 10),
(30, 0, 9, 10),
(31, 0, 1, 10),
(32, 0, 14, 10),
(33, 0, 1, 11),
(34, 0, 3, 11),
(35, 0, 4, 11),
(36, 0, 5, 11),
(37, 0, 14, 11),
(38, 0, 8, 11),
(39, 0, 9, 11),
(40, 0, 12, 11),
(41, 0, 1, 12),
(42, 0, 3, 12),
(43, 0, 4, 12),
(44, 0, 5, 12),
(45, 0, 14, 12),
(46, 0, 8, 12),
(47, 0, 9, 12),
(48, 0, 12, 12),
(49, 0, 1, 13),
(50, 0, 3, 13),
(51, 0, 4, 13),
(52, 0, 5, 13),
(53, 0, 14, 13),
(54, 0, 21, 13),
(55, 0, 9, 13),
(56, 0, 12, 13),
(57, 0, 1, 14),
(58, 0, 14, 14),
(59, 0, 8, 14),
(60, 0, 2, 15),
(61, 0, 14, 15),
(62, 0, 8, 15),
(63, 0, 1, 16),
(64, 0, 14, 16),
(65, 0, 8, 16),
(66, 0, 1, 19),
(67, 0, 14, 19),
(68, 0, 8, 19),
(69, 0, 11, 19),
(70, 0, 1, 18),
(71, 0, 14, 18),
(72, 0, 8, 18),
(73, 0, 11, 18),
(74, 0, 22, 18),
(75, 0, 1, 20),
(76, 0, 3, 20),
(77, 0, 4, 20),
(78, 0, 5, 20),
(79, 0, 14, 20),
(80, 0, 8, 20),
(81, 0, 9, 20),
(82, 0, 11, 20),
(83, 0, 1, 21),
(84, 0, 14, 21),
(85, 0, 8, 21),
(86, 0, 22, 21),
(87, 0, 23, 21),
(88, 0, 2, 22),
(89, 0, 3, 22),
(90, 0, 5, 22),
(91, 0, 14, 22),
(92, 0, 9, 22),
(93, 0, 4, 22),
(94, 0, 10, 22),
(95, 0, 1, 23),
(96, 0, 3, 23),
(97, 0, 4, 23),
(98, 0, 5, 23),
(99, 0, 14, 23),
(100, 0, 9, 23),
(101, 0, 13, 23),
(102, 0, 6, 23),
(103, 0, 24, 23),
(104, 0, 1, 4),
(105, 0, 3, 4),
(106, 0, 4, 4),
(107, 0, 5, 4),
(108, 0, 14, 4),
(109, 0, 9, 4),
(110, 0, 12, 4),
(111, 0, 27, 4),
(112, 0, 5, 9),
(113, 0, 9, 9),
(114, 0, 4, 9),
(115, 0, 3, 9),
(116, 0, 24, 9),
(117, 0, 18, 9),
(118, 0, 27, 9),
(119, 0, 7, 9),
(120, 0, 25, 9),
(121, 0, 26, 9),
(122, 0, 1, 9),
(123, 0, 8, 9),
(124, 0, 14, 9),
(125, 0, 1, 3),
(126, 0, 27, 3),
(127, 0, 10, 3),
(128, 0, 5, 3),
(129, 0, 14, 3),
(130, 0, 9, 3),
(131, 0, 2, 3),
(132, 0, 3, 3),
(133, 0, 4, 3),
(134, 0, 12, 3),
(135, 0, 1, 1),
(136, 0, 3, 1),
(137, 0, 4, 1),
(138, 0, 5, 1),
(139, 0, 14, 1),
(140, 0, 12, 1),
(141, 0, 9, 1),
(142, 0, 27, 5),
(143, 0, 3, 5),
(144, 0, 28, 5),
(145, 0, 5, 5),
(146, 0, 4, 2),
(147, 0, 5, 2),
(148, 0, 27, 2),
(149, 0, 2, 2),
(150, 0, 3, 2),
(151, 0, 10, 2),
(152, 0, 9, 2),
(153, 0, 1, 2),
(154, 0, 14, 2),
(155, 0, 1, 17),
(156, 0, 20, 17),
(157, 0, 14, 17),
(158, 0, 8, 17),
(159, 0, 11, 17),
(160, 0, 1, 28),
(161, 0, 3, 28),
(162, 0, 5, 28),
(163, 0, 14, 28),
(164, 0, 8, 28),
(165, 0, 9, 28),
(166, 0, 18, 25),
(167, 0, 29, 25),
(168, 0, 30, 25),
(169, 0, 31, 25),
(170, 0, 17, 25),
(171, 0, 32, 25),
(172, 0, 34, 27),
(173, 0, 35, 27),
(174, 0, 36, 27),
(175, 0, 5, 27),
(176, 0, 37, 27),
(177, 0, 34, 26),
(178, 0, 35, 26),
(179, 0, 5, 26),
(180, 0, 4, 24),
(181, 0, 33, 24);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(25) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `category` varchar(25) DEFAULT NULL,
  `share_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlkl5hm0ed36aan92yhhquksjt` (`price`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`type`, `id`, `label`, `price`, `version`, `category`, `share_number`) VALUES
('basic', 1, 'Choux_Crème', '2.90', 1, 'Gateau', NULL),
('basic', 2, 'Religieuse', '2.80', 0, 'Viennoiserie', NULL),
('basic', 3, 'Mille_Feuille', '2.80', 0, 'Gateau', NULL),
('basic', 4, 'Tartelette_Framboise', '3.00', 0, 'Gateau', NULL),
('basic', 5, 'Macaron', '0.50', 0, 'Gateau', NULL),
('basic', 6, 'Croissant', '1.10', 0, 'Viennoiserie', NULL),
('basic', 7, 'Chocolatine', '1.20', 0, 'Viennoiserie', NULL),
('basic', 8, 'Pain_aux_Raisins', '1.40', 0, 'Viennoiserie', NULL),
('basic', 9, 'Fraisier', '3.10', 0, 'Gateau', NULL),
('basic', 10, 'Chausson_aux_pommes', '1.80', 0, 'Viennoiserie', NULL),
('basic', 11, 'Brioche_Suisse', '1.80', 0, 'Viennoiserie', NULL),
('basic', 12, 'Briochette_au_Chocolat', '1.40', 0, 'Viennoiserie', NULL),
('basic', 13, 'Canelé', '1.60', 0, 'Viennoiserie', NULL),
('basic', 14, 'Baguette_Classique', '1.00', 0, 'Pain', NULL),
('basic', 15, 'Baguette_Tradition', '1.20', 0, 'Pain', NULL),
('basic', 16, 'Pain_Campagne', '2.20', 0, 'Pain', NULL),
('basic', 17, 'Pain_Complet', '2.20', 0, 'Pain', NULL),
('basic', 18, 'Pain_6_Céréales', '2.20', 0, 'Pain', NULL),
('basic', 19, 'Baguette_Sésame', '1.80', 0, 'Pain', NULL),
('basic', 20, 'Pain_Burger', '1.50', 0, 'Pain', NULL),
('basic', 21, 'Pain_aux_noix', '3.00', 0, 'Pain', NULL),
('basic', 22, 'Eclair', '2.70', 0, 'Gateau', NULL),
('basic', 23, 'Paris_Brest', '2.80', 0, 'Gateau', NULL),
('basic', 24, 'Expresso', '2.00', 0, 'Boisson', NULL),
('basic', 25, 'Jus_Fruits', '2.50', 0, 'Boisson', NULL),
('basic', 26, 'The_Menthe', '1.50', 0, 'Boisson', NULL),
('basic', 27, 'The_glace', '2.00', 0, 'Boisson', NULL),
('basic', 28, 'Chouquette', '0.20', 0, 'Viennoiserie', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `withtout_account`
--

DROP TABLE IF EXISTS `withtout_account`;
CREATE TABLE IF NOT EXISTS `withtout_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `command_numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdob2ycgta2211ce6fe41oy7mc` (`command_numero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `withtout_account`
--

INSERT INTO `withtout_account` (`id`, `email`, `last_name`, `first_name`, `version`, `command_numero`) VALUES
(1, 'odin.ragnar@hotmail.fr', 'Odin', 'Ragnar', 0, 2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `command`
--
ALTER TABLE `command`
  ADD CONSTRAINT `FK4adexdu0ttc9l217n3ydn7199` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `command_line`
--
ALTER TABLE `command_line`
  ADD CONSTRAINT `FK63wx5vtqo2p1upm623em6aic` FOREIGN KEY (`command_id`) REFERENCES `command` (`numero`),
  ADD CONSTRAINT `FKexibn53w35ucgmrpyu3nt47dx` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Contraintes pour la table `favorite_articles`
--
ALTER TABLE `favorite_articles`
  ADD CONSTRAINT `FK8ymrqp3evp7dvak8g2vjw7ne` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKjx8inxsdb180t84o3uj97rm5y` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `ingredient_line`
--
ALTER TABLE `ingredient_line`
  ADD CONSTRAINT `FKdu629s77exd2v9d7sfv157g4m` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKfw602n9nfuq3hifulp8e58gwl` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`);

--
-- Contraintes pour la table `withtout_account`
--
ALTER TABLE `withtout_account`
  ADD CONSTRAINT `FKdob2ycgta2211ce6fe41oy7mc` FOREIGN KEY (`command_numero`) REFERENCES `command` (`numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
