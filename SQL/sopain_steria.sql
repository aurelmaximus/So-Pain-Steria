-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 08 fév. 2023 à 17:13
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
  `version` int(11) DEFAULT NULL,
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
('customer', 5, '33000', '1', 'Bordeaux', 'Rue de la victoire', 'prune.pommier@gmail.com', 'prune', 'peche', 'pommier', 0, 0);

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
  `version` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK4adexdu0ttc9l217n3ydn7199` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`numero`, `arrived_date`, `command_status`, `arrived_hour`, `on_site`, `version`, `customer_id`) VALUES
(1, '2023-01-31', '2', '14:30:00', 0, 0, 5),
(2, '2023-01-27', '0', '16:55:00', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `command_line`
--

DROP TABLE IF EXISTS `command_line`;
CREATE TABLE IF NOT EXISTS `command_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(5,2) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `command_id` int(11) DEFAULT NULL,
  `product_label` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK63wx5vtqo2p1upm623em6aic` (`command_id`),
  KEY `FKlkg0ltfcvxcdcn6ww7dse6qem` (`product_label`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `command_line`
--

INSERT INTO `command_line` (`id`, `quantity`, `total`, `version`, `command_id`, `product_label`) VALUES
(1, 2, '2.40', 0, 2, 'Chocolatine');

-- --------------------------------------------------------

--
-- Structure de la table `favorite_articles`
--

DROP TABLE IF EXISTS `favorite_articles`;
CREATE TABLE IF NOT EXISTS `favorite_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_label` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjx8inxsdb180t84o3uj97rm5y` (`customer_id`),
  KEY `FKp5dp4oi1xmj3i1i7dt7e03ii2` (`product_label`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `favorite_articles`
--

INSERT INTO `favorite_articles` (`id`, `version`, `customer_id`, `product_label`) VALUES
(1, 0, 1, 'Chocolatine'),
(2, 0, 1, 'Croissant');

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allergen` tinyint(1) DEFAULT '0',
  `label` varchar(25) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tnhfvr29l1fykbohmss0lwlb9` (`label`)
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
  `version` int(11) DEFAULT '0',
  `ingredient_label` varchar(25) DEFAULT NULL,
  `product_label` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk7fgi9mw6vpy4u928quqru5rd` (`ingredient_label`),
  KEY `FKnbyonsb9ecj93iosvmj1fs4aw` (`product_label`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient_line`
--

INSERT INTO `ingredient_line` (`id`, `version`, `ingredient_label`, `product_label`) VALUES
(1, 0, 'Farine_T55', 'Croissant'),
(2, 0, 'Oeuf', 'Croissant'),
(3, 0, 'Lait', 'Croissant'),
(4, 0, 'Sucre', 'Croissant'),
(5, 0, 'Sel', 'Croissant'),
(6, 0, 'Levure_boulangerie', 'Croissant'),
(7, 0, 'Beurre', 'Croissant'),
(8, 0, 'Farine_T55', 'Chocolatine'),
(9, 0, 'Oeuf', 'Chocolatine'),
(10, 0, 'Lait', 'Chocolatine'),
(11, 0, 'Sucre', 'Chocolatine'),
(12, 0, 'Sel', 'Chocolatine'),
(13, 0, 'Levure_boulangerie', 'Chocolatine'),
(14, 0, 'Beurre', 'Chocolatine'),
(15, 0, 'Chocolat', 'Chocolatine'),
(16, 0, 'Farine_T55', 'Pain_aux_Raisins'),
(17, 0, 'Oeuf', 'Pain_aux_Raisins'),
(18, 0, 'Lait', 'Pain_aux_Raisins'),
(19, 0, 'Sucre', 'Pain_aux_Raisins'),
(20, 0, 'Sel', 'Pain_aux_Raisins'),
(21, 0, 'Levure_boulangerie', 'Pain_aux_Raisins'),
(22, 0, 'Beurre', 'Pain_aux_Raisins'),
(23, 0, 'Raisin_sec', 'Pain_aux_Raisins'),
(24, 0, 'Vanille', 'Pain_aux_Raisins'),
(25, 0, 'Pommes', 'Chausson_aux_pommes'),
(26, 0, 'Oeuf', 'Chausson_aux_pommes'),
(27, 0, 'Sucre_glace', 'Chausson_aux_pommes'),
(28, 0, 'Sucre', 'Chausson_aux_pommes'),
(29, 0, 'Canelle', 'Chausson_aux_pommes'),
(30, 0, 'Beurre', 'Chausson_aux_pommes'),
(31, 0, 'Farine_T55', 'Chausson_aux_pommes'),
(32, 0, 'Sel', 'Chausson_aux_pommes'),
(33, 0, 'Farine_T55', 'Brioche_Suisse'),
(34, 0, 'Oeuf', 'Brioche_Suisse'),
(35, 0, 'Lait', 'Brioche_Suisse'),
(36, 0, 'Sucre', 'Brioche_Suisse'),
(37, 0, 'Sel', 'Brioche_Suisse'),
(38, 0, 'Levure_boulangerie', 'Brioche_Suisse'),
(39, 0, 'Beurre', 'Brioche_Suisse'),
(40, 0, 'Vanille', 'Brioche_Suisse'),
(41, 0, 'Farine_T55', 'Briochette_au_Chocolat'),
(42, 0, 'Oeuf', 'Briochette_au_Chocolat'),
(43, 0, 'Lait', 'Briochette_au_Chocolat'),
(44, 0, 'Sucre', 'Briochette_au_Chocolat'),
(45, 0, 'Sel', 'Briochette_au_Chocolat'),
(46, 0, 'Levure_boulangerie', 'Briochette_au_Chocolat'),
(47, 0, 'Beurre', 'Briochette_au_Chocolat'),
(48, 0, 'Vanille', 'Briochette_au_Chocolat'),
(49, 0, 'Farine_T55', 'Canele'),
(50, 0, 'Oeuf', 'Canele'),
(51, 0, 'Lait', 'Canele'),
(52, 0, 'Sucre', 'Canele'),
(53, 0, 'Sel', 'Canele'),
(54, 0, 'Rhum', 'Canele'),
(55, 0, 'Beurre', 'Canele'),
(56, 0, 'Vanille', 'Canele'),
(57, 0, 'Farine_T55', 'Baguette_Classique'),
(58, 0, 'Sel', 'Baguette_Classique'),
(59, 0, 'Levure_boulangerie', 'Baguette_Classique'),
(60, 0, 'Farine_T65', 'Baguette_Tradition'),
(61, 0, 'Sel', 'Baguette_Tradition'),
(62, 0, 'Levure_boulangerie', 'Baguette_Tradition'),
(63, 0, 'Farine_T55', 'Pain_Campagne'),
(64, 0, 'Sel', 'Pain_Campagne'),
(65, 0, 'Levure_boulangerie', 'Pain_Campagne'),
(91, 0, 'Farine_T55', 'Baguette_Sésame'),
(92, 0, 'Sel', 'Baguette_Sésame'),
(93, 0, 'Levure_boulangerie', 'Baguette_Sésame'),
(94, 0, 'Graines_bio', 'Baguette_Sésame'),
(95, 0, 'Farine_T55', 'Pain_6_Céréales'),
(96, 0, 'Sel', 'Pain_6_Céréales'),
(97, 0, 'Levure_boulangerie', 'Pain_6_Céréales'),
(98, 0, 'Graines_bio', 'Pain_6_Céréales'),
(99, 0, 'Huile_noix', 'Pain_6_Céréales'),
(100, 0, 'Farine_T55', 'Pain_Burger'),
(101, 0, 'Oeuf', 'Pain_Burger'),
(102, 0, 'Lait', 'Pain_Burger'),
(103, 0, 'Sucre', 'Pain_Burger'),
(104, 0, 'Sel', 'Pain_Burger'),
(105, 0, 'Levure_boulangerie', 'Pain_Burger'),
(106, 0, 'Beurre', 'Pain_Burger'),
(107, 0, 'Graines_bio', 'Pain_Burger'),
(108, 0, 'Farine_T55', 'Pain_aux_noix'),
(109, 0, 'Sel', 'Pain_aux_noix'),
(110, 0, 'Levure_boulangerie', 'Pain_aux_noix'),
(111, 0, 'Huile_noix', 'Pain_aux_noix'),
(112, 0, 'Noix', 'Pain_aux_noix'),
(113, 0, 'Farine_T65', 'Eclair'),
(114, 0, 'Oeuf', 'Eclair'),
(115, 0, 'Sucre', 'Eclair'),
(116, 0, 'Sel', 'Eclair'),
(117, 0, 'Beurre', 'Eclair'),
(119, 0, 'Lait', 'Eclair'),
(121, 0, 'Chocolat', 'Eclair'),
(122, 0, 'Farine_T55', 'Paris_Brest'),
(123, 0, 'Oeuf', 'Paris_Brest'),
(124, 0, 'Lait', 'Paris_Brest'),
(125, 0, 'Sucre', 'Paris_Brest'),
(126, 0, 'Sel', 'Paris_Brest'),
(127, 0, 'Beurre', 'Paris_Brest'),
(128, 0, 'Amande_effilee', 'Paris_Brest'),
(129, 0, 'Praline', 'Paris_Brest'),
(130, 0, 'Maizena', 'Paris_Brest'),
(131, 0, 'Farine_T55', 'Tartelette_Framboise'),
(132, 0, 'Oeuf', 'Tartelette_Framboise'),
(133, 0, 'Lait', 'Tartelette_Framboise'),
(134, 0, 'Sucre', 'Tartelette_Framboise'),
(135, 0, 'Sel', 'Tartelette_Framboise'),
(136, 0, 'Beurre', 'Tartelette_Framboise'),
(137, 0, 'Vanille', 'Tartelette_Framboise'),
(138, 0, 'Framboise ', 'Tartelette_Framboise'),
(139, 0, 'Sucre', 'Fraisier'),
(140, 0, 'Beurre', 'Fraisier'),
(141, 0, 'Lait', 'Fraisier'),
(142, 0, 'Oeuf', 'Fraisier'),
(143, 0, 'Maizena', 'Fraisier'),
(144, 0, 'Fraise', 'Fraisier'),
(145, 0, 'Sucre_glace', 'Fraisier'),
(146, 0, 'Pate_amande ', 'Fraisier'),
(147, 0, 'Sirop_sucre ', 'Fraisier'),
(148, 0, 'Kirsch ', 'Fraisier'),
(149, 0, 'Farine_T55', 'Fraisier'),
(150, 0, 'Levure_boulangerie', 'Fraisier'),
(151, 0, 'Sel', 'Fraisier'),
(152, 0, 'Farine_T55', 'Mille_Feuille'),
(153, 0, 'Sucre_glace', 'Mille_Feuille'),
(154, 0, 'Chocolat', 'Mille_Feuille'),
(155, 0, 'Sucre', 'Mille_Feuille'),
(156, 0, 'Sel', 'Mille_Feuille'),
(157, 0, 'Beurre', 'Mille_Feuille'),
(158, 0, 'Farine_T65', 'Mille_Feuille'),
(159, 0, 'Oeuf', 'Mille_Feuille'),
(160, 0, 'Lait', 'Mille_Feuille'),
(161, 0, 'Vanille', 'Mille_Feuille'),
(162, 0, 'Farine_T55', 'Choux_Crème'),
(163, 0, 'Oeuf', 'Choux_Crème'),
(164, 0, 'Lait', 'Choux_Crème'),
(165, 0, 'Sucre', 'Choux_Crème'),
(166, 0, 'Sel', 'Choux_Crème'),
(167, 0, 'Vanille', 'Choux_Crème'),
(168, 0, 'Beurre', 'Choux_Crème'),
(169, 0, 'Sucre_glace', 'Macaron'),
(170, 0, 'Oeuf', 'Macaron'),
(171, 0, 'Amande ', 'Macaron'),
(172, 0, 'Sucre', 'Macaron'),
(173, 0, 'Lait', 'Religieuse'),
(174, 0, 'Sucre', 'Religieuse'),
(175, 0, 'Sucre_glace', 'Religieuse'),
(176, 0, 'Farine_T65', 'Religieuse'),
(177, 0, 'Oeuf', 'Religieuse'),
(178, 0, 'Chocolat', 'Religieuse'),
(179, 0, 'Beurre', 'Religieuse'),
(180, 0, 'Farine_T55', 'Religieuse'),
(181, 0, 'Sel', 'Religieuse'),
(182, 0, 'Farine_T55', 'Pain_Complet'),
(183, 0, 'Farine_ble_complet', 'Pain_Complet'),
(184, 0, 'Sel', 'Pain_Complet'),
(185, 0, 'Levure_boulangerie', 'Pain_Complet'),
(186, 0, 'Graines_bio', 'Pain_Complet'),
(187, 0, 'Farine_T55', 'Chouquette'),
(188, 0, 'Oeuf', 'Chouquette'),
(189, 0, 'Sucre', 'Chouquette'),
(190, 0, 'Sel', 'Chouquette'),
(191, 0, 'Levure_boulangerie', 'Chouquette'),
(192, 0, 'Beurre', 'Chouquette'),
(199, 0, 'Fraise', 'Jus_Fruits'),
(200, 0, 'Orange', 'Jus_Fruits'),
(201, 0, 'Banane', 'Jus_Fruits'),
(202, 0, 'Kiwi', 'Jus_Fruits'),
(203, 0, 'Pommes', 'Jus_Fruits'),
(204, 0, 'Poires', 'Jus_Fruits'),
(205, 0, 'The_vert', 'The_glace'),
(206, 0, 'Menthe', 'The_glace'),
(207, 0, 'Citron', 'The_glace'),
(208, 0, 'Sucre', 'The_glace'),
(209, 0, 'The_exotique', 'The_glace'),
(210, 0, 'The_vert', 'The_Menthe'),
(211, 0, 'Menthe', 'The_Menthe'),
(212, 0, 'Sucre', 'The_Menthe'),
(213, 0, 'Lait', 'Expresso'),
(214, 0, 'Grain_cafe', 'Expresso');

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
  `version` int(11) DEFAULT '0',
  `share_number` int(11) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cs1mwlnde9i5eg2a8bh44lkpn` (`label`),
  UNIQUE KEY `UKlkl5hm0ed36aan92yhhquksjt` (`price`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`type`, `id`, `label`, `price`, `version`, `share_number`, `category`) VALUES
('basic', 1, 'Choux_Crème', '2.90', 0, NULL, 'Gateau'),
('basic', 2, 'Religieuse', '2.80', 0, NULL, 'Viennoiserie'),
('basic', 3, 'Mille_Feuille', '2.80', 0, NULL, 'Gateau'),
('basic', 4, 'Tartelette_Framboise', '3.00', 0, NULL, 'Gateau'),
('basic', 5, 'Macaron', '0.50', 0, NULL, 'Gateau'),
('basic', 6, 'Croissant', '1.10', 0, NULL, 'Viennoiserie'),
('basic', 7, 'Chocolatine', '1.20', 0, NULL, 'Viennoiserie'),
('basic', 8, 'Pain_aux_Raisins', '1.40', 0, NULL, 'Viennoiserie'),
('basic', 9, 'Fraisier', '3.10', 0, NULL, 'Gateau'),
('basic', 10, 'Chausson_aux_pommes', '1.80', 0, NULL, 'Viennoiserie'),
('basic', 11, 'Brioche_Suisse', '1.80', 0, NULL, 'Viennoiserie'),
('basic', 12, 'Briochette_au_Chocolat', '1.40', 0, NULL, 'Viennoiserie'),
('basic', 13, 'Canelé', '1.60', 0, NULL, 'Viennoiserie'),
('basic', 14, 'Baguette_Classique', '1.00', 0, NULL, 'Pain'),
('basic', 15, 'Baguette_Tradition', '1.20', 0, NULL, 'Pain'),
('basic', 16, 'Pain_Campagne', '2.20', 0, NULL, 'Pain'),
('basic', 17, 'Pain_Complet', '2.20', 0, NULL, 'Pain'),
('basic', 18, 'Pain_6_Céréales', '2.20', 0, NULL, 'Pain'),
('basic', 19, 'Baguette_Sésame', '1.80', 0, NULL, 'Pain'),
('basic', 20, 'Pain_Burger', '1.50', 0, NULL, 'Pain'),
('basic', 21, 'Pain_aux_noix', '3.00', 0, NULL, 'Pain'),
('basic', 22, 'Eclair', '2.70', 0, NULL, 'Gateau'),
('basic', 23, 'Paris_Brest', '2.80', 0, NULL, 'Gateau'),
('basic', 24, 'Expresso', '2.00', 0, NULL, 'boisson'),
('basic', 25, 'Jus_Fruits', '2.50', 0, NULL, 'boisson'),
('basic', 26, 'The_Menthe', '1.50', 0, NULL, 'boisson'),
('basic', 27, 'The_glace', '2.00', 0, NULL, 'boisson'),
('basic', 28, 'Chouquette', '0.20', 0, NULL, 'viennoiserie');

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
  `version` int(11) DEFAULT NULL,
  `command_numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdob2ycgta2211ce6fe41oy7mc` (`command_numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `withtout_account`
--

INSERT INTO `withtout_account` (`id`, `email`, `last_name`, `first_name`, `version`, `command_numero`) VALUES
(2, 'odin.ragnar@hotmail.fr', 'Odin', 'Ragnar', 0, 2);

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
  ADD CONSTRAINT `FKlkg0ltfcvxcdcn6ww7dse6qem` FOREIGN KEY (`product_label`) REFERENCES `product` (`label`);

--
-- Contraintes pour la table `favorite_articles`
--
ALTER TABLE `favorite_articles`
  ADD CONSTRAINT `FKjx8inxsdb180t84o3uj97rm5y` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `FKp5dp4oi1xmj3i1i7dt7e03ii2` FOREIGN KEY (`product_label`) REFERENCES `product` (`label`);

--
-- Contraintes pour la table `ingredient_line`
--
ALTER TABLE `ingredient_line`
  ADD CONSTRAINT `FKk7fgi9mw6vpy4u928quqru5rd` FOREIGN KEY (`ingredient_label`) REFERENCES `ingredient` (`label`),
  ADD CONSTRAINT `FKnbyonsb9ecj93iosvmj1fs4aw` FOREIGN KEY (`product_label`) REFERENCES `product` (`label`);

--
-- Contraintes pour la table `withtout_account`
--
ALTER TABLE `withtout_account`
  ADD CONSTRAINT `FKdob2ycgta2211ce6fe41oy7mc` FOREIGN KEY (`command_numero`) REFERENCES `command` (`numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
