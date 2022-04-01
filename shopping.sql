-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 28 mars 2022 à 13:57
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `shopping`
--

-- --------------------------------------------------------

--
-- Structure de la table `cbancaire`
--

DROP TABLE IF EXISTS `cbancaire`;
CREATE TABLE IF NOT EXISTS `cbancaire` (
  `NumCarte` varchar(16) NOT NULL,
  `datefinvalide` varchar(5) NOT NULL,
  `Cryptogramme` varchar(4) NOT NULL,
  `NomProprio` varchar(100) NOT NULL,
  PRIMARY KEY (`NumCarte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cbancaire`
--

INSERT INTO `cbancaire` (`NumCarte`, `datefinvalide`, `Cryptogramme`, `NomProprio`) VALUES
('0', '1', '2', '3'),
('65478', '08/21', '402', '');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `password` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`password`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`password`, `username`, `nom`, `prenom`, `adresse`, `telephone`) VALUES
('aden', 'yolo', 'oue', 'okk', 'adresse', 'telephone'),
('adrien', 'bouga', 'Roumi', 'Adrien', 'dans Paris', '0652768198'),
('adrien', 'yolo', 'oue', 'okk', 'adresse', 'telephone'),
('chat', 'meli', 'b', 'a', 'c', '0652768198'),
('guyyyyy', 'guyguy', 'pareil', 'guyguy', 'chez lui', '0652768198'),
('m', 't', 'NOM', 'martin', '98 quai de seine', '0652768199'),
('mdp', 'feffer', 'gzer', 'eziho', 'zerg', '0652768198'),
('mdp', 'titi', 'zhuck', 'tintin', 'herblay', '0652898'),
('passwrd', 'usern', 'nomm', 'prenomm', 'adresseee', 'teleph');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `passwordC` varchar(30) NOT NULL,
  `referenceP` varchar(200) NOT NULL,
  KEY `referenceP` (`referenceP`),
  KEY `commande_ibfk_2` (`passwordC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`passwordC`, `referenceP`) VALUES
('passwrd', '0455646'),
('passwrd', '045567'),
('passwrd', '045567'),
('chat', '04119'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221'),
('m', '0221');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `mdpclient` varchar(30) NOT NULL,
  `refproduit` varchar(200) NOT NULL,
  `date` varchar(40) NOT NULL,
  KEY `refproduit` (`refproduit`),
  KEY `facture_ibfk_1` (`mdpclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`mdpclient`, `refproduit`, `date`) VALUES
('passwrd', '0455646', '25/03/2022 12:18'),
('passwrd', '045567', '25/03/2022 12:18'),
('passwrd', '045567', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0221', '25/03/2022 12:18'),
('m', '0411789', '25/03/2022 12:18'),
('m', '0411789', '25/03/2022 12:18'),
('passwrd', '0455646', '25/03/2022 12:20'),
('passwrd', '045567', '25/03/2022 12:20'),
('passwrd', '045567', '25/03/2022 12:20'),
('m', '0411789', '25/03/2022 12:20'),
('m', '0411789', '25/03/2022 12:20'),
('m', '0411789', '25/03/2022 12:20'),
('m', '0411789', '25/03/2022 12:20'),
('m', '0411789', '25/03/2022 12:20'),
('m', '04119', '25/03/2022 12:20'),
('m', '04119', '25/03/2022 12:20'),
('passwrd', '0455646', '25/03/2022 13:37'),
('passwrd', '045567', '25/03/2022 13:37'),
('passwrd', '045567', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('m', '0221', '25/03/2022 13:37'),
('passwrd', '0455646', '26/03/2022 19:58'),
('passwrd', '045567', '26/03/2022 19:58'),
('passwrd', '045567', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('m', '0411789', '26/03/2022 19:58'),
('m', '0411789', '26/03/2022 19:58'),
('m', '0411789', '26/03/2022 19:58'),
('m', '0411789', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '04119', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('m', '0221', '26/03/2022 19:58'),
('passwrd', '0455646', '27/03/2022 23:58'),
('passwrd', '045567', '27/03/2022 23:58'),
('passwrd', '045567', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0221', '27/03/2022 23:58'),
('m', '0011', '27/03/2022 23:58'),
('m', '0011', '27/03/2022 23:58'),
('m', '0011', '27/03/2022 23:58'),
('m', '0011', '27/03/2022 23:58'),
('m', '0011', '27/03/2022 23:58'),
('m', '0013', '27/03/2022 23:58'),
('m', '0013', '27/03/2022 23:58'),
('m', '0013', '27/03/2022 23:58'),
('m', '0014', '27/03/2022 23:58'),
('m', '0014', '27/03/2022 23:58'),
('m', '0014', '27/03/2022 23:58'),
('m', '005', '27/03/2022 23:58'),
('m', '005', '27/03/2022 23:58'),
('m', '005', '27/03/2022 23:58'),
('m', '005', '27/03/2022 23:58'),
('m', '005', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '002', '27/03/2022 23:58'),
('m', '001', '27/03/2022 23:58'),
('passwrd', '0455646', '28/03/2022 09:20'),
('passwrd', '045567', '28/03/2022 09:20'),
('passwrd', '045567', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('m', '0221', '28/03/2022 09:20'),
('passwrd', '0455646', '28/03/2022 14:21'),
('passwrd', '045567', '28/03/2022 14:21'),
('passwrd', '045567', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0221', '28/03/2022 14:21'),
('m', '0411789', '28/03/2022 14:21'),
('m', '0411789', '28/03/2022 14:21'),
('m', '0411789', '28/03/2022 14:21'),
('m', '0411789', '28/03/2022 14:21');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `reference` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `prix` float NOT NULL,
  `promotion` float NOT NULL,
  `peremption` varchar(10) NOT NULL,
  `stock` int(255) NOT NULL,
  PRIMARY KEY (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`reference`, `nom`, `type`, `prix`, `promotion`, `peremption`, `stock`) VALUES
('001', 'poulet', 'Viande', 4, 2, '12/12/2022', 50),
('0010', 'Seche', 'Poisson', 6.5, 2, '11/05/2022', 30),
('0011', 'Homard', 'Poisson', 9, 2, '02/05/2022', 30),
('0012', 'Lessive', 'Menager', 2, 2, '06/12/2023', 100),
('0013', 'Haddock', 'Poisson', 7, 3, '28/04/2022', 60),
('0014', 'Saumon', 'Poisson', 20, 2, '26/04/2022', 20),
('0015', 'Maquereau', 'Poisson', 2.5, 6, '30/04/2022', 100),
('0016', 'Roussette', 'Poisson', 15, 2, '30/06/2022', 30),
('0017', 'Bar', 'Poisson', 4.5, 3, '17/05/2022', 60),
('0018', 'Poulpe', 'Poisson', 8, 2, '11/05/2022', 60),
('0019', 'Araignee', 'Poisson', 14.9, 2, '05/05/2022', 20),
('002', 'Steak', 'Viande', 1.5, 4, '12/12/2022', 50),
('0020', 'Gel WC', 'Menager', 2.3, 2, '05/05/2025', 100),
('0023', 'Savon', 'Menager', 3.25, 2, '11/02/2025', 100),
('003', 'Porc', 'Viande', 1.5, 4, '12/12/2022', 50),
('004', 'Boeuf', 'Viande', 5, 2, '12/10/2022', 100),
('005', 'Agneau', 'Viande', 4.5, 2, '02/10/2022', 100),
('006', 'Veau', 'Viande', 3.2, 4, '02/09/2022', 100),
('007', 'Volaille', 'Viande', 5, 2, '02/08/2022', 100),
('008', 'Dinde', 'Viande', 4.75, 4, '12/05/2022', 50),
('009', 'Chorizo', 'Viande', 6, 2, '02/09/2022', 50),
('0221', 'orange', 'fruit', 0.2, 8, '07/09/2022', 100),
('0411789', 'kiwi', 'fruit', 0.5, 4, '15/07/2022', 200),
('04119', 'kaki', 'fruit', 0.5, 4, '15/07/2022', 200),
('0455646', 'banane', 'fruit', 0.25, 5, '08/09/35', 198),
('045567', 'mangue', 'fruit', 1, 2, '14/06/22', 100),
('0456', 'pomme', 'fruit', 0.25, 6, '15/07/2022', 200),
('04587', 'melon', 'fruit', 1, 6, '15/07/2022', 200),
('04589', 'pasteque', 'fruit', 1, 4, '15/07/2022', 200),
('0477', 'ananas', 'fruit', 1.5, 2, '15/07/2022', 200);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`referenceP`) REFERENCES `produit` (`reference`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`passwordC`) REFERENCES `client` (`password`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`mdpclient`) REFERENCES `client` (`password`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facture_ibfk_2` FOREIGN KEY (`refproduit`) REFERENCES `produit` (`reference`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
