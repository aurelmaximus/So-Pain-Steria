-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 28 fév. 2023 à 12:04
-- Version du serveur : 8.0.31
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
  `id` int NOT NULL AUTO_INCREMENT,
  `zip_code` varchar(10) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `version` int NOT NULL,
  `points` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKravrcdl4ml7ghtfxdr2nx9hyw` (`last_name`,`first_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`type`, `id`, `zip_code`, `number`, `city`, `street`, `email`, `last_name`, `password`, `first_name`, `version`, `points`) VALUES
('employe', 1, '33000', '4', 'Bordeaux', 'Rue du dragon blanc', 'aurelien.bulme@gmail.com', 'Aurélien', 'Croki19', 'Bulme', 0, 0),
('employe', 2, '69000', '8', 'Lyon', 'Rue du magicien', 'cedric.devillers@gmail.com', 'Cedric', 'cedric', 'Devillers', 0, 0),
('employe', 3, '33000', '12', 'Bordeaux', 'Rue cyber', 'farah.benaissa@gmail.com', 'Farah', 'farah', 'Benaissa', 0, 0),
('employe', 4, '69000', '7bis', 'Lyon', 'Rue ignister', 'youssef.talmat@gmail.com', 'Youssef', 'youssef', 'Talmat', 0, 0),
('customer', 5, '33000', '1', 'Bordeaux', 'Rue de la victoire', 'prune.pommier@gmail.com', 'prune', 'peche', 'pommier', 0, 0),
('customer', 6, '75000', '777', 'Paris', 'Rue des Ansériformes', 'jordaninou.tpt@gmail.com', 'Abidou', 'coincoin', 'Jordaninou', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

DROP TABLE IF EXISTS `command`;
CREATE TABLE IF NOT EXISTS `command` (
  `numero` int NOT NULL AUTO_INCREMENT,
  `arrived_date` date DEFAULT NULL,
  `command_status` varchar(25) DEFAULT NULL,
  `arrived_hour` time DEFAULT NULL,
  `on_site` tinyint(1) DEFAULT '0',
  `version` int NOT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK4adexdu0ttc9l217n3ydn7199` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`numero`, `arrived_date`, `command_status`, `arrived_hour`, `on_site`, `version`, `customer_id`) VALUES
(1, '2023-01-31', 'EnCours', '12:30:00', 0, 1, 5),
(2, '2023-01-31', 'Prete', '16:55:00', 0, 1, 6),
(3, '2023-01-31', 'Termine', '11:30:00', 0, 0, 5),
(4, '2023-01-27', 'EnCours', '12:55:00', 0, 0, 6),
(5, '2023-01-31', 'Termine', '13:30:00', 0, 0, 6),
(6, '2023-01-27', 'Prete', '18:55:00', 0, 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `command_line`
--

DROP TABLE IF EXISTS `command_line`;
CREATE TABLE IF NOT EXISTS `command_line` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `total` decimal(5,2) DEFAULT NULL,
  `version` int NOT NULL,
  `command_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK63wx5vtqo2p1upm623em6aic` (`command_id`),
  KEY `FKexibn53w35ucgmrpyu3nt47dx` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `command_line`
--

INSERT INTO `command_line` (`id`, `quantity`, `total`, `version`, `command_id`, `product_id`) VALUES
(1, 2, '20.00', 0, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `favorite_articles`
--

DROP TABLE IF EXISTS `favorite_articles`;
CREATE TABLE IF NOT EXISTS `favorite_articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `version` int NOT NULL,
  `customer_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjx8inxsdb180t84o3uj97rm5y` (`customer_id`),
  KEY `FK8ymrqp3evp7dvak8g2vjw7ne` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `favorite_articles`
--

INSERT INTO `favorite_articles` (`id`, `version`, `customer_id`, `product_id`) VALUES
(1, 0, 5, 7),
(2, 0, 5, 6);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `allergen` tinyint(1) DEFAULT '0',
  `label` varchar(25) DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;

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
  `id` int NOT NULL AUTO_INCREMENT,
  `version` int NOT NULL,
  `ingredient_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfw602n9nfuq3hifulp8e58gwl` (`ingredient_id`),
  KEY `FKdu629s77exd2v9d7sfv157g4m` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb3;

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
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(25) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `version` int NOT NULL,
  `category` varchar(25) DEFAULT NULL,
  `share_number` int DEFAULT NULL,
  `description` varchar(4000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image_ref` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlkl5hm0ed36aan92yhhquksjt` (`price`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`type`, `id`, `label`, `price`, `version`, `category`, `share_number`, `description`, `image_ref`) VALUES
('basic', 1, 'Choux Crème', '2.90', 2, 'Gateau', NULL, ' <i>À base de crème fouettée enrobée d\'une pâte à choux légère, ces choux à la crème sont de petits délices qui s’apprécient à toutes les occasions. </i><br>\n                    Étiquettes: Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\cream-puffs-427181_1920.jpg'),
('basic', 2, 'Canelé', '2.80', 0, 'Viennoiserie', NULL, '<i>Texture croustillante à l\'extérieur et moelleuse à l\'intérieur des canelés, une douceur bordelaise incontournable.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\canele.jpg'),
('basic', 3, 'Mille Feuille', '2.80', 1, 'Gateau', NULL, ' <i>Pâte Feuilletée, Ganache Montée vanille, Caramel Tendre à la fleur de Sel</i>\n                    Comment résister à son feuilletage si finement croustillant et à sa crème légère ?\n                    <br><br>\n                    <br>Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\millefeuille2.jpeg'),
('basic', 4, 'Tartelette Framboise', '3.00', 1, 'Gateau', NULL, '<i> Pâtisserie subtilement vanillée, accompagnée de framboises fraîches.</i><br><br>\n                  Existe en version individuelle et à partager.<br>\n                  Pâte Sucrée à la Fleur de Sel, Compotée de Framboises, crème Madame (crème pâtissière et crème fouettée) Framboises Fraîches.\n                  <br>Etiquette: Gluten, Oeufs, Lait', '..\\..\\assets\\images\\tarteframboise2.webp'),
('basic', 5, 'Macaron', '0.50', 0, 'Gateau', NULL, '<i>Coque croquante et  ganache onctueuse à la saveur intense de noisette grillée, pour une expérience gustative unique en son genre.</i><br><br>\n                  Étiquettes : Gluten,Lait,Oeufs,Noix', '..\\..\\assets\\images\\macarons.jpeg'),
('basic', 6, 'Croissant', '1.10', 0, 'Viennoiserie', NULL, '<i>Le croissant traditionnel par excellence.</i><br><br>\n              Pâte feuilletée,2 barres de chocolat noir 66%<br>\n              Étiquettes: Gluten,Lait,Oeufs<br><br><br><br>', '..\\..\\assets\\images\\croissant2.jpg'),
('basic', 7, 'Chocolatine', '1.20', 0, 'Viennoiserie', NULL, '<i>Son feuilletage et ses barrettes de chocolat sont à croquer.</i><br><br>\n                2 barres de chocolat noir 66%<br>\n                Étiquettes: Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\chocolatine.jpeg'),
('basic', 8, 'Pain aux Raisins', '1.40', 1, 'Viennoiserie', NULL, '<i>Feuilleté au Beurre pur agrémenté de raisins blonds sur leur lit de crème pâtissière légère vanillée.</i><br><br>\n                Pâte Feuilletée, Raisin,Crème Pâtissière<br>\n                Étiquettes:Arachides,Fruits à coques,Gluten,Lait,Oeufs<br><br>', '..\\..\\assets\\images\\painauxraisins2.jpeg'),
('basic', 9, 'Fraisier', '3.10', 0, 'Gateau', NULL, ' <i>Sa génoise légèrement imbibée de sirop de fraise et sa crème mousseline vanillée sauront vous charmer en toute délicatesse, pour un plaisir gustatif absolu.\"</i><br>\n                  Étiquettes : Gluten, Lait, Oeufs', '..\\..\\assets\\images\\fraisier.webp'),
('basic', 10, 'Chausson aux pommes', '1.80', 1, 'Viennoiserie', NULL, '<i>Le chausson aux pommes traditionnel relevé d’une vanille gourmande.</i><br><br>\n                Pâte Feuilletée, Composée de Pommes Fraiche<br>\n                Étiquettes:Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\chaussonauxpommes2.jpeg'),
('basic', 11, 'Brioche Suisse', '1.80', 1, 'Viennoiserie', NULL, '<i>La délicieuse brioche suisse, avec son moelleux incomparable et son cœur de crème pâtissière fondante qui vous fera craquer à chaque bouchée.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes : Gluten,Lait,Oeufs', '..\\..\\assets\\images\\brioche-suisse.jpeg'),
('basic', 12, 'Briochette au Chocolat', '1.40', 1, 'Viennoiserie', NULL, NULL, NULL),
('basic', 13, 'Canelé', '1.60', 0, 'Viennoiserie', NULL, ' <i>Texture croustillante à l\'extérieur et moelleuse à l\'intérieur des canelés, une douceur bordelaise incontournable.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\canele.jpg'),
('basic', 14, 'Baguette Classique', '1.00', 1, 'Pain', NULL, 'Notre baguette classique est cuite dans notre four à sole comme tous les autres pains.<br>\n                Elle a une mie blanche, plus compacte et plus dense que la baguette 6 céréales et sa croûte est plus fine.', '..\\..\\assets\\images\\baguetteclassique.jpeg'),
('basic', 15, 'Baguette Tradition', '1.20', 1, 'Pain', NULL, 'Une baguette aux saveurs riches, ancrée dans notre savoir-faire.<br>', '..\\..\\assets\\images\\BaguetteTradition.jpeg'),
('basic', 16, 'Pain Campagne', '2.20', 1, 'Pain', NULL, 'Délice artisanal, préparé avec des ingrédients soigneusement sélectionnés pour vous offrir une mie moelleuse, aérée et savoureuse, ainsi qu\'une croûte croustillante et rustique.', '..\\..\\assets\\images\\painn.jpeg'),
('basic', 17, 'Pain Complet', '2.20', 1, 'Pain', NULL, 'Mie dense et nourrissante ainsi qu\'une saveur riche et authentique. Avec son goût rustique et sa texture satisfaisante, notre pain complet sera parfait pour accompagner vos repas sains et savoureux.', '..\\..\\assets\\images\\complet.jpg'),
('basic', 18, 'Pain 6 Céréales', '2.20', 1, 'Pain', NULL, 'Le délicieux pain 6 Céréales, <br>agrémentée de graines de sésame, pavot, millet, lin blond et lin brun.<br>', '..\\..\\assets\\images\\pexels-mariana-kurnyk-1775035.jpg'),
('basic', 19, 'Baguette Sésame', '1.80', 1, 'Pain', NULL, 'Combinaison parfaite de la saveur subtile des graines de sésame et d\'une mie moelleuse et légère. Avec son extérieur croustillant et son goût unique, notre pain sésame apportera une touche de raffinement à tous vos sandwichs et plats.', '..\\..\\assets\\images\\sesame.jpg'),
('basic', 20, 'Pain Burger', '1.50', 1, 'Pain', NULL, 'Frais et moelleux, spécialement conçu pour préparer vos burgers.\n                Avec sa mie aérée et son extérieur légèrement croustillant, il saura vous faire fondre de plaisir à chaque bouchée.', '..\\..\\assets\\images\\burger.jpg'),
('basic', 21, 'Pain aux noix', '3.00', 1, 'Pain', NULL, 'Que vous le dégustiez nature, grillé ou accompagné d\'un fromage fin, ce pain artisanal aux noix saura vous combler à chaque bouchée.', '..\\..\\assets\\images\\graines.jpg'),
('basic', 22, 'Eclair', '2.70', 0, 'Gateau', NULL, ' <i>Son craquelin de pâte sablée & son crémeux au chocolat noir 66% de cacao vont vous faire chavirer en toute simplicité.</i><br><br>\n                    Étiquettes: Gluten,Lait,Oeufs,Soja', '..\\..\\assets\\images\\eclair3.webp'),
('basic', 23, 'Paris Brest', '2.80', 1, 'Gateau', NULL, ' <i>Pâte à choux croquante et crème mousseline pralinée onctueuse. Laissez-vous séduire par sa forme en couronne élégante et sa saveur subtile de noisette grillée.</i><br><br>\n                  Étiquettes:Gluten,Lait,Oeufs,Noix<br><br><br>', '..\\..\\assets\\images\\parisbrest.png'),
('basic', 24, 'Expresso', '2.00', 0, 'Boisson', NULL, NULL, NULL),
('basic', 25, 'Jus Fruits', '2.50', 1, 'Boisson', NULL, NULL, NULL),
('basic', 26, 'The Menthe', '1.50', 1, 'Boisson', NULL, NULL, NULL),
('basic', 27, 'The glace', '2.00', 1, 'Boisson', NULL, NULL, NULL),
('basic', 28, 'Chouquette', '0.20', 0, 'Viennoiserie', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `withtout_account`
--

DROP TABLE IF EXISTS `withtout_account`;
CREATE TABLE IF NOT EXISTS `withtout_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `version` int NOT NULL,
  `command_numero` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdob2ycgta2211ce6fe41oy7mc` (`command_numero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

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
