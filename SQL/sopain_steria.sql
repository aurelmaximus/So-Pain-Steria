-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 26 jan. 2023 à 16:22
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

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `total` double NOT NULL,
  `date_commande` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `id_client`, `total`, `date_commande`) VALUES
(1, 5, 9.3, '2023-01-18');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `login` varchar(35) NOT NULL,
  `password` varchar(100) NOT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `voie` varchar(30) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `cp` varchar(15) DEFAULT NULL,
  `type_compte` enum('Employe','Client') NOT NULL,
  `metier` enum('Serveur','Boulangerie','Patissier','Apprenti') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `nom`, `prenom`, `login`, `password`, `numero`, `voie`, `ville`, `cp`, `type_compte`, `metier`) VALUES
(1, 'Bulme', 'Aurélien', 'aurelien.bulme@gmail.com', 'Croki19', '4', 'Rue du dragon blanc', 'Bordeaux', '33000', 'Employe', 'Patissier'),
(2, 'Devillers', 'Cedric', 'cedric.devillers@gmail.com', 'cedric', '8', 'Rue du magicien', 'Bordeaux', '69000', 'Employe', 'Boulangerie'),
(3, 'Benaissa', 'Farah', 'farah.benaissa@gmail.com', 'farah', '12', 'Rue cyber', 'Lyon', '33000', 'Employe', 'Patissier'),
(4, 'Talmat', 'Youssef', 'youssef.talmat@gmail.com', 'youssef', '7bis', 'Rue ignister', 'Lyon', '69000', 'Employe', 'Serveur'),
(5, 'pommier', 'prune', 'prune.pommier@gmail.com', 'peche', '25', 'Rue de verger', 'Rennes', '35000', 'Client', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle_ing` varchar(200) NOT NULL,
  `allergene_ing` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `libelle_ing`, `allergene_ing`) VALUES
(1, 'Farine_T55', 1),
(2, 'Farine_T65', 1),
(3, 'Oeuf', 1),
(4, 'Lait', 1),
(5, 'Sucre', 0),
(6, 'Praline', 0),
(7, 'Pate_amande ', 1),
(8, 'Levure_boulangerie', 0),
(9, 'Beurre', 1),
(10, 'Chocolat', 0),
(12, 'Graines_de_pavot', 0),
(13, 'Vanille', 0),
(14, 'Amande_effilée', 1),
(15, 'Sel', 0),
(16, 'Raisin_sec', 0),
(17, 'Sucre_glace', 0),
(18, 'Pommes', 0),
(19, 'Fraise', 0),
(20, 'Canelle', 0),
(21, 'Farine_blé_complet', 1),
(22, 'Rhum', 0),
(23, 'Huile noix', 1),
(24, 'Noix', 1),
(25, 'Maizena', 0),
(26, 'Sirop_sucre ', 0),
(27, 'Kirsch ', 0),
(28, 'Framboise ', 0),
(29, 'Amande ', 1);

-- --------------------------------------------------------

--
-- Structure de la table `prodfinis`
--

DROP TABLE IF EXISTS `prodfinis`;
CREATE TABLE IF NOT EXISTS `prodfinis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle_pf` varchar(150) NOT NULL,
  `cat_pf` enum('pain','gateau','viennoiserie','boisson') NOT NULL,
  `type_pf` enum('maison','importe') NOT NULL,
  `prix_pf` decimal(5,2) NOT NULL,
  `nb_allergene_pf` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `prodfinis`
--

INSERT INTO `prodfinis` (`id`, `libelle_pf`, `cat_pf`, `type_pf`, `prix_pf`, `nb_allergene_pf`) VALUES
(1, 'Expresso', 'boisson', 'importe', '2.00', 0),
(2, 'Coca', 'boisson', 'importe', '2.00', 0),
(3, 'Cristalline', 'boisson', 'importe', '1.50', 0),
(4, 'Jus Fruits', 'boisson', 'importe', '2.50', 0),
(5, 'Thé Menthe', 'boisson', 'importe', '1.50', 0),
(6, 'Oasis', 'boisson', 'importe', '2.00', 0),
(7, 'Orangina', 'boisson', 'importe', '2.00', 0),
(8, 'Ice Tea', 'boisson', 'importe', '2.00', 0),
(9, 'Croissant', 'viennoiserie', 'maison', '1.10', 4),
(10, 'Chocolatine', 'viennoiserie', 'maison', '1.20', 4),
(11, 'Pain aux Raisins', 'viennoiserie', 'maison', '1.40', 4),
(12, 'Chouquette', 'viennoiserie', 'importe', '0.20', 0),
(13, 'Chausson aux pommes', 'viennoiserie', 'maison', '1.80', 3),
(14, 'Brioche Suisse', 'viennoiserie', 'maison', '1.80', 4),
(15, 'Briochette au Chocolat', 'viennoiserie', 'maison', '1.40', 4),
(16, 'Canelé', 'viennoiserie', 'maison', '1.60', 4),
(17, 'Baguette Classique', 'pain', 'maison', '1.00', 1),
(18, 'Baguette Tradition', 'pain', 'maison', '1.20', 1),
(19, 'Pain Campagne', 'pain', 'maison', '2.20', 1),
(20, 'Pain Complet', 'pain', 'maison', '2.20', 2),
(21, 'Pain 6 Céréales', 'pain', 'maison', '2.20', 2),
(22, 'Baguette Sésame', 'pain', 'maison', '1.80', 1),
(23, 'Pain Burger', 'pain', 'maison', '1.50', 4),
(24, 'Pain aux noix', 'pain', 'maison', '3.00', 3),
(25, 'Eclair', 'gateau', 'maison', '2.70', 4),
(26, 'Paris Brest', 'gateau', 'maison', '2.80', 5),
(27, 'Fraisier', 'gateau', 'maison', '3.10', 5),
(28, 'Tartelette Framboise', 'gateau', 'maison', '3.00', 4),
(29, 'Mille Feuille', 'gateau', 'maison', '2.80', 4),
(30, 'Choux Crème', 'gateau', 'maison', '2.90', 4),
(31, 'Religieuse', 'viennoiserie', 'maison', '2.80', 4),
(32, 'Macaron', 'gateau', 'maison', '0.50', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
