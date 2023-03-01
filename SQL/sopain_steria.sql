-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 01 mars 2023 à 09:12
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`type`, `id`, `zip_code`, `number`, `city`, `street`, `email`, `last_name`, `password`, `first_name`, `version`, `points`) VALUES
('employe', 1, '33000', '4', 'Bordeaux', 'Rue du dragon blanc', 'aurelien.bulme@gmail.com', 'Aurélien', 'Croki19', 'Bulme', 0, 0),
('employe', 2, '69000', '8', 'Lyon', 'Rue du magicien', 'cedric.devillers@gmail.com', 'Cedric', 'cedric', 'Devillers', 0, 0),
('employe', 3, '33000', '12', 'Bordeaux', 'Rue cyber', 'farah.benaissa@gmail.com', 'Farah', 'farah', 'Benaissa', 0, 0),
('employe', 4, '69000', '7bis', 'Lyon', 'Rue ignister', 'youssef.talmat@gmail.com', 'Youssef', 'youssef', 'Talmat', 2, 0),
('customer', 5, '33000', '1', 'Bordeaux', 'Rue de la victoire', 'prune.pommier@gmail.com', 'prune', 'peche', 'pommier', 0, 0),
('customer', 6, '75000', '777', 'Paris', 'Rue des Ansériformes', 'jordaninou.tpt@gmail.com', 'Abidou', 'coincoin', 'Jordaninou', 0, 0),
('customer', 13, '33000', '7', 'Bordeaux', 'Rue maréchal Maunoury', 'axelle@gmail.com', 'Daniel Lacombe', 'croki', 'Axelle', 1, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`numero`, `arrived_date`, `command_status`, `arrived_hour`, `on_site`, `version`, `customer_id`) VALUES
(1, '2023-01-31', 'EnCours', '12:30:00', 0, 1, 5),
(2, '2023-01-31', 'Prete', '16:55:00', 0, 1, 6),
(3, '2023-01-31', 'Prete', '11:30:00', 0, 1, 5),
(4, '2023-01-27', 'EnCours', '12:55:00', 0, 2, 6),
(5, '2023-01-31', 'Termine', '13:30:00', 0, 2, 6),
(6, '2023-01-27', 'Termine', '18:55:00', 0, 2, 6);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
(1, 0, 5, 7),
(2, 0, 5, 6);

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
  `version` int(11) NOT NULL,
  `category` varchar(25) DEFAULT NULL,
  `share_number` int(11) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `image_ref` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlkl5hm0ed36aan92yhhquksjt` (`price`,`label`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`type`, `id`, `label`, `price`, `version`, `category`, `share_number`, `description`, `image_ref`) VALUES
('basic', 1, 'Choux Crème', '2.90', 2, 'Gateau', NULL, ' <i>À base de crème fouettée enrobée d\'une pâte à choux légère, ces choux à la crème sont de petits délices qui s’apprécient à toutes les occasions. </i><br>\n                    Étiquettes: Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\cream-puffs-427181_1920.jpg'),
('basic', 2, 'Canelé', '2.99', 1, 'Viennoiserie', NULL, '<i>Texture croustillante à l\'extérieur et moelleuse à l\'intérieur des canelés, une douceur bordelaise incontournable.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\canele.jpg'),
('basic', 3, 'Mille Feuille', '2.80', 1, 'Gateau', NULL, ' <i>Pâte Feuilletée, Ganache Montée vanille, Caramel Tendre à la fleur de Sel</i>\n                    Comment résister à son feuilletage si finement croustillant et à sa crème légère ?\n                    <br><br>\n                    <br>Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\millefeuille2.jpeg'),
('basic', 4, 'Tartelette Framboise', '3.00', 1, 'Gateau', NULL, '<i> Pâtisserie subtilement vanillée, accompagnée de framboises fraîches.</i><br><br>\n                  Existe en version individuelle et à partager.<br>\n                  Pâte Sucrée à la Fleur de Sel, Compotée de Framboises, crème Madame (crème pâtissière et crème fouettée) Framboises Fraîches.\n                  <br>Etiquette: Gluten, Oeufs, Lait', '..\\..\\assets\\images\\tarteframboise2.webp'),
('basic', 5, 'Macaron', '0.50', 0, 'Gateau', NULL, '<i>Coque croquante et  ganache onctueuse à la saveur intense de noisette grillée, pour une expérience gustative unique en son genre.</i><br><br>\n                  Étiquettes : Gluten,Lait,Oeufs,Noix', '..\\..\\assets\\images\\macarons.jpeg'),
('basic', 6, 'Croissant', '1.10', 0, 'Viennoiserie', NULL, '<i>Le croissant traditionnel par excellence.</i><br><br>\n              Pâte feuilletée,2 barres de chocolat noir 66%<br>\n              Étiquettes: Gluten,Lait,Oeufs<br><br><br><br>', '..\\..\\assets\\images\\croissant2.jpg'),
('basic', 7, 'Chocolatine', '1.20', 0, 'Viennoiserie', NULL, '<i>Son feuilletage et ses barrettes de chocolat sont à croquer.</i><br><br>\n                2 barres de chocolat noir 66%<br>\n                Étiquettes: Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\chocolatine.jpeg'),
('basic', 8, 'Pain aux Raisins', '1.40', 1, 'Viennoiserie', NULL, '<i>Feuilleté au Beurre pur agrémenté de raisins blonds sur leur lit de crème pâtissière légère vanillée.</i><br><br>\n                Pâte Feuilletée, Raisin,Crème Pâtissière<br>\n                Étiquettes:Arachides,Fruits à coques,Gluten,Lait,Oeufs<br><br>', '..\\..\\assets\\images\\painauxraisins2.jpeg'),
('basic', 9, 'Fraisier', '3.10', 0, 'Gateau', NULL, ' <i>Sa génoise légèrement imbibée de sirop de fraise et sa crème mousseline vanillée sauront vous charmer en toute délicatesse, pour un plaisir gustatif absolu.\"</i><br>\n                  Étiquettes : Gluten, Lait, Oeufs', '..\\..\\assets\\images\\fraisier.webp'),
('basic', 10, 'Chausson aux pommes', '1.80', 1, 'Viennoiserie', NULL, '<i>Le chausson aux pommes traditionnel relevé d’une vanille gourmande.</i><br><br>\n                Pâte Feuilletée, Composée de Pommes Fraiche<br>\n                Étiquettes:Gluten,Lait,Oeufs<br><br><br>', '..\\..\\assets\\images\\chaussonauxpommes2.jpeg'),
('basic', 11, 'Brioche Suisse', '1.80', 1, 'Viennoiserie', NULL, '<i>La délicieuse brioche suisse, avec son moelleux incomparable et son cœur de crème pâtissière fondante qui vous fera craquer à chaque bouchée.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes : Gluten,Lait,Oeufs', '..\\..\\assets\\images\\brioche-suisse.jpeg'),
('basic', 13, 'Canelé', '1.60', 0, 'Viennoiserie', NULL, ' <i>Texture croustillante à l\'extérieur et moelleuse à l\'intérieur des canelés, une douceur bordelaise incontournable.</i><br><br>\n                Pâte Feuilletée,Pépite de Chocolat,Crème Pâtissière.<br>\n                Étiquettes: Gluten,Lait,Oeufs', '..\\..\\assets\\images\\canele.jpg'),
('basic', 14, 'Baguette Classique', '1.00', 1, 'Pain', NULL, 'Notre baguette classique est cuite dans notre four à sole comme tous les autres pains.<br>\n                Elle a une mie blanche, plus compacte et plus dense que la baguette 6 céréales et sa croûte est plus fine.', '..\\..\\assets\\images\\baguetteclassique.jpeg'),
('basic', 15, 'Baguette Tradition', '1.20', 1, 'Pain', NULL, 'Une baguette aux saveurs riches, ancrée dans notre savoir-faire.<br>', '..\\..\\assets\\images\\BaguetteTradition.jpeg'),
('basic', 16, 'Pain Campagne', '2.20', 1, 'Pain', NULL, 'Délice artisanal, préparé avec des ingrédients soigneusement sélectionnés pour vous offrir une mie moelleuse, aérée et savoureuse, ainsi qu\'une croûte croustillante et rustique.', '..\\..\\assets\\images\\painn.jpeg'),
('basic', 17, 'Pain Complet', '2.20', 1, 'Pain', NULL, 'Mie dense et nourrissante ainsi qu\'une saveur riche et authentique. Avec son goût rustique et sa texture satisfaisante, notre pain complet sera parfait pour accompagner vos repas sains et savoureux.', '..\\..\\assets\\images\\complet.jpg'),
('basic', 18, 'Pain 6 Céréales', '2.20', 1, 'Pain', NULL, 'Le délicieux pain 6 Céréales, <br>agrémentée de graines de sésame, pavot, millet, lin blond et lin brun.<br>', '..\\..\\assets\\images\\pexels-mariana-kurnyk-1775035.jpg'),
('basic', 19, 'Baguette Sésame', '1.80', 1, 'Pain', NULL, 'Combinaison parfaite de la saveur subtile des graines de sésame et d\'une mie moelleuse et légère. Avec son extérieur croustillant et son goût unique, notre pain sésame apportera une touche de raffinement à tous vos sandwichs et plats.', '..\\..\\assets\\images\\sesame.jpg'),
('basic', 20, 'Pain Burger', '1.50', 1, 'Pain', NULL, 'Frais et moelleux, spécialement conçu pour préparer vos burgers.\n                Avec sa mie aérée et son extérieur légèrement croustillant, il saura vous faire fondre de plaisir à chaque bouchée.', '..\\..\\assets\\images\\burger.jpg'),
('basic', 21, 'Pain aux noix', '3.00', 1, 'Pain', NULL, 'Que vous le dégustiez nature, grillé ou accompagné d\'un fromage fin, ce pain artisanal aux noix saura vous combler à chaque bouchée.', '..\\..\\assets\\images\\graines.jpg'),
('basic', 22, 'Eclair', '2.70', 4, 'Gateau', NULL, ' <i>Son craquelin de pâte sablée & son crémeux au chocolat noir 66% de cacao vont vous faire chavirer en toute simplicité.</i><br><br>\n                    Étiquettes: Gluten,Lait,Oeufs,Soja', '..\\..\\assets\\images\\eclair3.webp'),
('basic', 23, 'Paris Brest', '2.80', 1, 'Gateau', NULL, ' <i>Pâte à choux croquante et crème mousseline pralinée onctueuse. Laissez-vous séduire par sa forme en couronne élégante et sa saveur subtile de noisette grillée.</i><br><br>\n                  Étiquettes:Gluten,Lait,Oeufs,Noix<br><br><br>', '..\\..\\assets\\images\\parisbrest.png');

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
