-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : mar. 17 jan. 2023 à 16:40
-- Version du serveur :  5.7.34
-- Version de PHP : 7.4.21

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
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `num_commande` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `total` double NOT NULL,
  `date_commande` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` int(11) NOT NULL,
  `login` varchar(35) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type_compte` enum('Employe','Client') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

CREATE TABLE `ingredient` (
  `num_ing` int(11) NOT NULL,
  `libelle_ing` varchar(200) NOT NULL,
  `allergene` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `prodfinis`
--

CREATE TABLE `prodfinis` (
  `num_prod` int(11) NOT NULL,
  `libelle_pf` varchar(150) NOT NULL,
  `type_prod` enum('pain','gateau','viennoiserie','boisson') NOT NULL,
  `cat_prod` enum('maison','importe') NOT NULL,
  `prix_prod` double NOT NULL,
  `allergene` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `prodfinis`
--

INSERT INTO `prodfinis` (`num_prod`, `libelle_pf`, `type_prod`, `cat_prod`, `prix_prod`, `allergene`) VALUES
(1, 'Expresso', 'boisson', 'importe', 2, 0),
(2, 'Coca', 'boisson', 'importe', 2, 0),
(3, 'Cristalline', 'boisson', 'importe', 1.5, 0),
(4, 'Jus Fruits', 'boisson', 'importe', 2.5, 0),
(5, 'Thé Menthe', 'boisson', 'importe', 1.5, 0),
(6, 'Oasis', 'boisson', 'importe', 2, 0),
(7, 'Orangina', 'boisson', 'importe', 2, 0),
(8, 'Ice Tea', 'boisson', 'importe', 2, 0),
(9, 'Croissant', 'viennoiserie', 'maison', 1.1, 0),
(10, 'Chocolatine', 'viennoiserie', 'maison', 1.2, 0),
(11, 'Pain aux Raisins', 'viennoiserie', 'maison', 1.4, 0),
(12, 'Chouquette', 'viennoiserie', 'importe', 0.2, 0),
(13, 'Chausson aux pommes', 'viennoiserie', 'maison', 1.8, 0),
(14, 'Brioche Suisse', 'viennoiserie', 'maison', 1.8, 0),
(15, 'Briochette au Chocolat', 'viennoiserie', 'maison', 1.4, 0),
(16, 'Canelé', 'viennoiserie', 'maison', 1.6, 0),
(17, 'Baguette Classique', 'pain', 'maison', 1, 0),
(18, 'Baguette Tradition', 'pain', 'maison', 1.2, 0),
(19, 'Pain Campagne', 'pain', 'maison', 2.2, 0),
(20, 'Pain Complet', 'pain', 'maison', 2.2, 0),
(21, 'Pain 6 Céréales', 'pain', 'maison', 2.2, 0),
(22, 'Baguette Sésame', 'pain', 'maison', 1.8, 0),
(23, 'Pain Burger', 'pain', 'maison', 1.5, 0),
(24, 'Pain aux noix', 'pain', 'maison', 3, 0),
(25, 'Eclair', 'gateau', 'maison', 2.7, 0),
(26, 'Paris Brest', 'gateau', 'maison', 2.8, 0),
(27, 'Fraisier', 'gateau', 'maison', 3.1, 0),
(28, 'Tartelette Framboise', 'gateau', 'maison', 3, 0),
(29, 'Mille Feuille', 'gateau', 'maison', 2.8, 0),
(30, 'Choux Crème', 'gateau', 'maison', 2.9, 0),
(31, 'Religieuse', 'viennoiserie', 'maison', 2.8, 0),
(32, 'Amandine', 'gateau', 'maison', 2.7, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`num_commande`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`num_ing`);

--
-- Index pour la table `prodfinis`
--
ALTER TABLE `prodfinis`
  ADD PRIMARY KEY (`num_prod`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `num_commande` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `num_ing` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `prodfinis`
--
ALTER TABLE `prodfinis`
  MODIFY `num_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
