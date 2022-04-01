-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 01 avr. 2022 à 11:03
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
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`password`, `username`, `nom`, `prenom`, `adresse`, `telephone`) VALUES
('h', 'm', 'huck', 'Martin', '97 quai de seine', '0652768198'),
('li', 'me', 'Thirard', 'Melissa', 'truc', '0652768198'),
('test', 'test', 'test', 'test', 'test', '0652768198'),
('test', 'test2', 'test', 'test', 'test', '0652768198'),
('test', 'test3', 'test', 'test', 'test', '0652768198'),
('t', 'test4', 'test', 'test', 'test', '0652768198'),
('test', 'test5', 'test', 'test', 'test', '0652768198'),
('t', 'test6', 'test', 'test', 'test', '0652768198'),
('t', 'test7', 'f', 'tet', 'ff', '0652768198'),
('gre', 'test8', 'sg', 'fd', 'fsg', '0652768198'),
('hed', 'test9', 'fze', 'dgvs', 'gvzr', '0652768198'),
('u', 'y', 't', 'ma', 'dfsgd', '0652768198');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `usernameclient` varchar(30) NOT NULL,
  `referenceP` varchar(200) NOT NULL,
  KEY `commande_ibfk_1` (`referenceP`),
  KEY `usernameclient` (`usernameclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `usernameclient` varchar(30) NOT NULL,
  `refproduit` varchar(200) NOT NULL,
  `date` varchar(40) NOT NULL,
  KEY `facture_ibfk_2` (`refproduit`),
  KEY `usernameclient` (`usernameclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`usernameclient`, `refproduit`, `date`) VALUES
('m', '045567', '28/03/2022 22:05'),
('m', '045567', '28/03/2022 22:05'),
('m', '045567', '28/03/2022 22:05'),
('m', '045567', '28/03/2022 22:05'),
('m', '045567', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '04119', '28/03/2022 22:05'),
('m', '001', '28/03/2022 22:05'),
('m', '001', '28/03/2022 22:05'),
('m', '04589', '28/03/2022 22:05'),
('m', '04589', '28/03/2022 22:05'),
('m', '04589', '28/03/2022 22:05'),
('m', '04589', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0477', '28/03/2022 22:05'),
('m', '0411789', '28/03/2022 22:05'),
('m', '0411789', '28/03/2022 22:05'),
('m', '0411789', '28/03/2022 22:05'),
('m', '0411789', '28/03/2022 22:05'),
('m', '006', '28/03/2022 22:05'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '0221', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('y', '005', '29/03/2022 17:31'),
('m', '0011', '30/03/2022 17:18'),
('m', '0011', '30/03/2022 17:18'),
('m', '0011', '30/03/2022 17:18'),
('m', '0011', '30/03/2022 17:18'),
('m', '0011', '30/03/2022 17:18'),
('m', '0018', '30/03/2022 17:18'),
('m', '0018', '30/03/2022 17:18'),
('m', '0010', '30/03/2022 17:18'),
('m', '0010', '30/03/2022 17:18'),
('m', '0010', '30/03/2022 17:18'),
('m', '0010', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '002', '30/03/2022 17:18'),
('m', '007', '30/03/2022 17:18'),
('m', '0455646', '30/03/2022 17:18'),
('m', '0455646', '30/03/2022 17:18'),
('m', '0455646', '30/03/2022 17:18'),
('m', '0455646', '30/03/2022 17:18'),
('m', '0455646', '30/03/2022 17:18'),
('me', '0031', '31/03/2022 22:39'),
('me', '0031', '31/03/2022 22:39'),
('me', '0031', '31/03/2022 22:39'),
('me', '0031', '31/03/2022 22:39'),
('me', '0031', '31/03/2022 22:39'),
('me', '0047', '31/03/2022 22:39'),
('me', '0047', '31/03/2022 22:39'),
('me', '0411789', '31/03/2022 22:39'),
('me', '0411789', '31/03/2022 22:39'),
('me', '0411789', '31/03/2022 22:39'),
('me', '045567', '31/03/2022 22:39'),
('me', '045567', '31/03/2022 22:39'),
('me', '045567', '31/03/2022 22:39'),
('me', '045567', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0411789', '31/03/2022 22:39'),
('me', '0411789', '31/03/2022 22:39'),
('me', '04119', '31/03/2022 22:39'),
('me', '0455646', '31/03/2022 22:39'),
('me', '0456', '31/03/2022 22:39'),
('me', '04587', '31/03/2022 22:39'),
('me', '04589', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:39'),
('me', '0477', '31/03/2022 22:39'),
('me', '0477', '31/03/2022 22:39'),
('me', '0477', '31/03/2022 22:39'),
('me', '0477', '31/03/2022 22:39'),
('me', '001', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '002', '31/03/2022 22:39'),
('me', '04589', '31/03/2022 22:39'),
('me', '04587', '31/03/2022 22:39'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:47'),
('me', '0411789', '31/03/2022 22:47'),
('me', '0411789', '31/03/2022 22:47'),
('me', '0411789', '31/03/2022 22:47'),
('me', '0411789', '31/03/2022 22:47'),
('me', '0221', '31/03/2022 22:50'),
('me', '0221', '31/03/2022 22:50'),
('me', '0411789', '31/03/2022 22:50'),
('me', '0411789', '31/03/2022 22:50'),
('me', '04119', '31/03/2022 22:54'),
('me', '04119', '31/03/2022 22:54'),
('me', '0456', '31/03/2022 22:54'),
('me', '045567', '31/03/2022 23:12'),
('me', '0456', '31/03/2022 23:12'),
('me', '0456', '31/03/2022 23:12');

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
  `prixpromotion` float NOT NULL,
  `stock` int(255) NOT NULL,
  PRIMARY KEY (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`reference`, `nom`, `type`, `prix`, `promotion`, `peremption`, `prixpromotion`, `stock`) VALUES
('001', 'poulet', 'Viande', 4, 2, '12/12/2022', 6.99, 50),
('0010', 'Seche', 'Poisson', 6.5, 2, '11/05/2022', 10, 30),
('0011', 'Homard', 'Poisson', 9, 2, '02/05/2022', 15, 30),
('0012', 'Lessive', 'Menager', 2, 2, '06/12/2023', 3.5, 100),
('0013', 'Haddock', 'Poisson', 7, 3, '28/04/2022', 18, 60),
('0014', 'Saumon', 'Poisson', 20, 2, '26/04/2022', 35, 20),
('0015', 'Maquereau', 'Poisson', 2.5, 6, '30/04/2022', 10, 100),
('0016', 'Roussette', 'Poisson', 15, 2, '30/06/2022', 25, 30),
('0017', 'Bar', 'Poisson', 4.5, 3, '17/05/2022', 11.99, 60),
('0018', 'Poulpe', 'Poisson', 8, 2, '11/05/2022', 13.99, 60),
('0019', 'Araignee', 'Poisson', 14.9, 2, '05/05/2022', 24.99, 20),
('002', 'Steak', 'Viande', 1.5, 4, '12/12/2022', 4.99, 50),
('0020', 'Gel WC', 'Menager', 2.3, 2, '05/05/2025', 3.99, 100),
('0023', 'Savon', 'Menager', 3.25, 2, '11/02/2025', 5.99, 100),
('0024', 'Dentifrice', 'Menager', 1.95, 3, '18/11/2026', 4.99, 200),
('0025', 'Shampoing', 'Menager', 1.79, 3, '02/09/2026', 3.99, 200),
('0026', 'Gel Douche', 'Menager', 1.49, 3, '27/07/2025', 3.49, 200),
('0027', 'Papier WC', 'Menager', 0.67, 24, '27/07/2025', 10.99, 500),
('0028', 'Eponge', 'Menager', 0.99, 6, '27/07/2025', 4.99, 300),
('0029', 'Poele 28 cm', 'Menager', 15.99, 2, '27/07/2032', 24.99, 150),
('003', 'Porc', 'Viande', 1.5, 4, '12/12/2022', 4.99, 50),
('0030', 'Aubergine', 'Legumes', 0.99, 3, '27/07/2032', 2.49, 150),
('0031', 'Poivron', 'Legumes', 0.39, 4, '29/07/2024', 0.99, 150),
('0032', 'Artichaut', 'Legumes', 1.6, 2, '05/06/2022', 2.49, 150),
('0033', 'Concombre', 'Legumes', 0.39, 3, '17/08/2022', 0.69, 150),
('0034', 'Carotte', 'Legumes', 0.1, 12, '15/08/2022', 0.99, 150),
('0035', 'Poireau', 'Legumes', 0.5, 2, '12/08/2022', 0.79, 150),
('0036', 'Courge', 'Legumes', 0.89, 2, '12/08/2022', 1.25, 150),
('0038', 'Choux', 'Legumes', 0.95, 2, '18/06/2022', 1.5, 100),
('0039', 'Celeri', 'Legumes', 0.35, 3, '18/05/2022', 0.79, 100),
('004', 'Boeuf', 'Viande', 5, 2, '12/10/2022', 7.99, 100),
('0040', 'MuffinChoco', 'Patisserie', 1.5, 4, '18/04/2022', 4.99, 100),
('0041', 'PainChoco', 'Patisserie', 0.5, 4, '11/04/2022', 1.65, 200),
('0042', 'Croissant', 'Patisserie', 0.35, 4, '11/04/2022', 1.25, 200),
('0043', 'Paris Brest', 'Patisserie', 1.2, 3, '16/04/2022', 2.99, 50),
('0044', 'EclairChoco', 'Patisserie', 0.5, 6, '14/04/2022', 2.25, 100),
('0045', 'Cookie', 'Patisserie', 0.5, 6, '20/04/2022', 2.25, 100),
('0046', 'Brownie', 'Patisserie', 1.9, 2, '20/04/2022', 2.99, 100),
('0047', 'Fraisier', 'Patisserie', 9.99, 2, '20/04/2022', 15.99, 30),
('0048', 'Macaron', 'Patisserie', 0.4, 8, '31/04/2022', 2.49, 100),
('005', 'Agneau', 'Viande', 4.5, 2, '02/10/2022', 6.99, 100),
('006', 'Veau', 'Viande', 3.2, 4, '02/09/2022', 11.99, 100),
('007', 'Volaille', 'Viande', 5, 2, '02/08/2022', 9.99, 100),
('008', 'Dinde', 'Viande', 4.75, 4, '12/05/2022', 15.99, 50),
('009', 'Chorizo', 'Viande', 6, 2, '02/09/2022', 8.99, 50),
('0221', 'orange', 'fruit', 1.2, 8, '07/09/2022', 1.3, 98),
('0411789', 'kiwi', 'fruit', 0.75, 4, '15/07/2022', 1.99, 200),
('04119', 'kaki', 'fruit', 0.5, 4, '15/07/2022', 1.5, 200),
('0455646', 'banane', 'fruit', 0.25, 5, '08/09/35', 0.99, 198),
('045567', 'mangue', 'fruit', 1, 2, '14/06/22', 1.5, 100),
('0456', 'pomme', 'fruit', 0.25, 6, '15/07/2022', 1.25, 200),
('04587', 'melon', 'fruit', 1, 6, '15/07/2022', 4.99, 200),
('04589', 'pasteque', 'fruit', 1, 4, '15/07/2022', 2.99, 200),
('0477', 'ananas', 'fruit', 1.5, 2, '15/07/2022', 2.5, 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`referenceP`) REFERENCES `produit` (`reference`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`usernameclient`) REFERENCES `client` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_2` FOREIGN KEY (`refproduit`) REFERENCES `produit` (`reference`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facture_ibfk_3` FOREIGN KEY (`usernameclient`) REFERENCES `client` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
