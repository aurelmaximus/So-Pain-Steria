-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 31 jan. 2023 à 19:29
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

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
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tnhfvr29l1fykbohmss0lwlb9` (`label`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

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
(11, 0, 'Graines_de_pavot', 0),
(12, 0, 'Vanille', 0),
(13, 1, 'Amande_effilée', 0),
(14, 0, 'Sel', 0),
(15, 0, 'Raisin_sec', 0),
(16, 0, 'Sucre_glace', 0),
(17, 0, 'Pommes', 0),
(18, 0, 'Fraise', 0),
(19, 0, 'Canelle', 0),
(20, 1, 'Farine_blé_complet', 0),
(21, 0, 'Rhum', 0),
(22, 1, 'Huile noix', 0),
(23, 1, 'Noix', 0),
(24, 0, 'Maizena', 0),
(25, 0, 'Sirop_sucre ', 0),
(26, 0, 'Kirsch ', 0),
(27, 0, 'Framboise ', 0),
(28, 1, 'Amande ', 0);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient_line`
--

DROP TABLE IF EXISTS `ingredient_line`;
CREATE TABLE IF NOT EXISTS `ingredient_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `ingredient_label` varchar(25) DEFAULT NULL,
  `product_label` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk7fgi9mw6vpy4u928quqru5rd` (`ingredient_label`),
  KEY `FKnbyonsb9ecj93iosvmj1fs4aw` (`product_label`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `version` int(11) DEFAULT NULL,
  `share_number` int(11) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cs1mwlnde9i5eg2a8bh44lkpn` (`label`),
  UNIQUE KEY `UKlkl5hm0ed36aan92yhhquksjt` (`price`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`type`, `id`, `label`, `price`, `version`, `share_number`, `category`) VALUES
('basic', 1, 'Choux Crème', '2.90', 0, NULL, 'Gateau'),
('basic', 2, 'Religieuse', '2.80', 0, NULL, 'Viennoiserie'),
('basic', 3, 'Mille Feuille', '2.80', 0, NULL, 'Gateau'),
('basic', 4, 'Tartelette Framboise', '3.00', 0, NULL, 'Gateau'),
('basic', 5, 'Macaron', '0.50', 0, NULL, 'Gateau'),
('basic', 6, 'Croissant', '1.10', 0, NULL, 'Viennoiserie'),
('basic', 7, 'Chocolatine', '1.20', 0, NULL, 'Viennoiserie'),
('basic', 8, 'Pain aux Raisins', '1.40', 0, NULL, 'Viennoiserie'),
('basic', 9, 'Fraisier', '3.10', 0, NULL, 'Gateau'),
('basic', 10, 'Chausson aux pommes', '1.80', 0, NULL, 'Viennoiserie'),
('basic', 11, 'Brioche Suisse', '1.80', 0, NULL, 'Viennoiserie'),
('basic', 12, 'Briochette au Chocolat', '1.40', 0, NULL, 'Viennoiserie'),
('basic', 13, 'Canelé', '1.60', 0, NULL, 'Viennoiserie'),
('basic', 14, 'Baguette Classique', '1.00', 0, NULL, 'Pain'),
('basic', 15, 'Baguette Tradition', '1.20', 0, NULL, 'Pain'),
('basic', 16, 'Pain Campagne', '2.20', 0, NULL, 'Pain'),
('basic', 17, 'Pain Complet', '2.20', 0, NULL, 'Pain'),
('basic', 18, 'Pain 6 Céréales', '2.20', 0, NULL, 'Pain'),
('basic', 19, 'Baguette Sésame', '1.80', 0, NULL, 'Pain'),
('basic', 20, 'Pain Burger', '1.50', 0, NULL, 'Pain'),
('basic', 21, 'Pain aux noix', '3.00', 0, NULL, 'Pain'),
('basic', 22, 'Eclair', '2.70', 0, NULL, 'Gateau'),
('basic', 23, 'Paris Brest', '2.80', 0, NULL, 'Gateau');

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
