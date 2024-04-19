--
-- Base de données: SIRH
--
CREATE DATABASE SIRH DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE SIRH;
CREATE USER 'sirh_util'@'localhost' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON SIRH.* to 'sirh_util'@'localhost';

-- --------------------------------------------------------

--
-- Structure de la table `Categorie`
--

CREATE TABLE IF NOT EXISTS `Categorie` (
  `Code` varchar(2) NOT NULL DEFAULT '',
  `Libelle` varchar(16) DEFAULT NULL,
  `salaireMini` double DEFAULT NULL,
  `CaisseDeRetraite` varchar(5) DEFAULT NULL,
  `PrimeResultat` int(1) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Categorie`
--

INSERT INTO `Categorie` (`Code`, `Libelle`, `salaireMini`, `CaisseDeRetraite`, `PrimeResultat`) VALUES 
('C1', 'Cadre moyen', 2500, 'AGIRC', 1),
('C2', 'Cadre supérieur', 3500, 'AGIRC', 1),
('E1', 'Employé niveau 1', 1600, 'ARRCO', 0),
('E2', 'Employé niveau 2', 2100, 'ARRCO', 0);

-- --------------------------------------------------------

--
-- Structure de la table `Formation`
--

CREATE TABLE IF NOT EXISTS `Formation` (
  `Code` varchar(3) NOT NULL DEFAULT '',
  `Nom` varchar(44) DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `Nbrejours` int(1) DEFAULT NULL,
  `CoutJourForm` double DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Formation`
--

INSERT INTO `Formation` (`Code`, `Nom`, `DateDebut`, `Nbrejours`, `CoutJourForm`) VALUES
('F01', 'Java débutant', '2024-02-05', 4, 1200),
('F02', 'Java initié', '2024-05-20', 5, 1200),
('F03', 'Administration d''un réseau local sous Linux', '2021-09-14', 6, 1300),
('F04', 'Symfony', '2024-05-10', 4, 1200),
('F05', 'La conduite d''un projet informatique', '2024-05-17', 3, 1900),
('F06', 'SQL Server', '2024-02-25', 4, 1500),
('F07', 'SAGE', '2024-03-14', 3, 1100),
('F08', 'Anglais débutant', '2024-02-25', 8, 1000),
('F09', 'Anglais avancé', '2024-04-05', 3, 1300),
('F10', 'Relations clientèle', '2024-05-08', 3, 1500),
('F11', 'La fiscalité des PME', '2024-10-17', 2, 1500),
('F12', 'Fixer des objectifs à votre force de vente', '2024-10-20', 1, 1250),
('F13', 'Optimiser son portefeuille clients', '2024-01-02', 3, 1000),
('F14', 'Utiliser un logiciel de gestion de clientèle', '2024-02-09', 5, 1300);

-- --------------------------------------------------------

--
-- Structure de la table `Salarie`
--

CREATE TABLE IF NOT EXISTS `Salarie` (
  `Code` varchar(3) NOT NULL DEFAULT '',
  `Nom` varchar(7) DEFAULT NULL,
  `Prenom` varchar(8) DEFAULT NULL,
  `DateNaiss` date DEFAULT NULL,
  `DateEmbauche` date DEFAULT NULL,
  `Fonction` varchar(23) DEFAULT NULL,
  `TauxHoraire` double DEFAULT NULL,
  `situationFamiliale` varchar(11) DEFAULT NULL,
  `NbrEnfants` int(1) DEFAULT NULL,
  `NumCat` varchar(2) DEFAULT NULL,
  `CodeServ` int(3) DEFAULT NULL,
  PRIMARY KEY (`Code`),
  KEY `CodeServ` (`CodeServ`),
  KEY `NumCat` (`NumCat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Salarie`
--

INSERT INTO `Salarie` (`Code`, `Nom`, `Prenom`, `DateNaiss`, `DateEmbauche`, `Fonction`, `TauxHoraire`, `situationFamiliale`, `NbrEnfants`, `NumCat`, `CodeServ`) VALUES
('S01', 'RETAIS', 'Claude', '1962-03-31', '2015-09-01', 'Chef de projet', 32.5, 'Marié.e', 3, 'C2', 1),
('S02', 'BERNARD', 'Céline', '1972-08-14', '2015-09-01', 'Directrice commerciale', 32.5, 'Marié.e', 2, 'C2', 3),
('S03', 'RETAIS', 'Jérôme', '1978-09-14', '2015-09-01', 'Ingénieur informatique', 28, 'Divorcé.e', 4, 'C1', 1),
('S04', 'DOMARD', 'Marie', '1960-06-14', '2015-09-01', 'Directrice générale', 40.5, 'Marié.e', 3, 'C2', 2),
('S05', 'LALOIS', 'Régis', '1982-07-25', '2015-09-01', 'Chef comptable', 30.3, 'Célibataire', 0, 'C2', 2),
('S06', 'DUPONT', 'Henri', '1988-11-15', '2015-09-01', 'Développeur', 21.6, 'Marié.e', 2, 'E2', 1),
('S07', 'AJAVAR', 'Karima', '1996-11-25', '2016-08-01', 'Standardiste', 10.2, 'Célibataire', 1, 'E1', 2),
('S08', 'FALERT', 'Maud', '1985-08-25', '2017-01-01', 'Développeuse', 20.3, 'Marié.e', 2, 'E2', 1),
('S09', 'MALE', 'Emilie', '1995-01-14', '2017-02-01', 'Assistante comptable', 15.7, 'Divorcé.e', 2, 'E1', 2),
('S10', 'MOUDA', 'Mustapha', '1973-01-14', '2017-05-01', 'Ingénieur commercial', 25.6, 'Marié.e', 3, 'C1', 3),
('S11', 'AJAVAR', 'Médhi', '1988-02-14', '2017-06-01', 'Développeur', 20, 'Marié.e', 4, 'E2', 1),
('S12', 'WANG', 'Vinthan', '1995-07-22', '2018-06-01', 'Développeur', 18, 'Marié.e', 1, 'E2', 1),
('S13', 'SAVOY', 'Marilyne', '1985-07-16', '2018-01-01', 'Secrétaire commerciale', 15.7, 'Marié.e', 3, 'E1', 3),
('S14', 'ESTOUDE', 'Sophie', '1991-08-17', '2018-01-01', 'Assistante de direction', 20, 'Divorcé.e', 2, 'E2', 2),
('S15', 'PETIT', 'Sylvie', '1979-05-28', '2018-01-01', 'Technico-commerciale', 20, 'Marié.e', 0, 'E2', 3),
('S16', 'GIRARDO', 'Elisa', '1990-08-14', '2018-05-01', 'Administratrice réseau', 20.1, 'Célibataire', 1, 'E1', 1),
('S17', 'ZOARD', 'Farid', '1998-07-23', '2020-10-01', 'Développeur stagiaire', 10, 'Célibataire', 0, 'E1', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Service`
--

CREATE TABLE IF NOT EXISTS `Service` (
  `Code` int(1) NOT NULL DEFAULT '0',
  `Designation` varchar(13) DEFAULT NULL,
  `Email` varchar(27) DEFAULT NULL,
  `Tel` char(10) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Service`
--

INSERT INTO `Service` (`Code`, `Designation`, `Email`, `Tel`) VALUES
(1, 'Informatique', 'informatique@infoware.com', '0169983212'),
(2, 'Adminstration', 'administration@infoware.com', '0169983210'),
(3, 'Commercial', 'commercial@infoware.com', '0169983215'),
(4, 'Comptable', 'comptable@infoware.com', '0169983218');

-- --------------------------------------------------------

--
-- Structure de la table `Suivre`
--

CREATE TABLE IF NOT EXISTS `Suivre` (
  `CodeSal` varchar(3) NOT NULL DEFAULT '',
  `CodeForm` varchar(3) NOT NULL DEFAULT '',
  PRIMARY KEY (`CodeSal`,`CodeForm`),
  KEY `CodeSal` (`CodeSal`),
  KEY `CodeForm` (`CodeForm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Suivre`
--

INSERT INTO `Suivre` (`CodeSal`, `CodeForm`) VALUES
('S01', 'F04'),
('S02', 'F10'),
('S02', 'F12'),
('S03', 'F05'),
('S05', 'F11'),
('S06', 'F01'),
('S06', 'F02'),
('S07', 'F08'),
('S09', 'F07'),
('S10', 'F08'),
('S11', 'F04'),
('S13', 'F14'),
('S14', 'F09'),
('S15', 'F13'),
('S16', 'F03'),
('S17', 'F06');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Salarie`
--
ALTER TABLE `Salarie`
  ADD CONSTRAINT `Salarie_ibfk_1` FOREIGN KEY (`NumCat`) REFERENCES `Categorie` (`Code`),
  ADD CONSTRAINT `Salarie_ibfk_2` FOREIGN KEY (`CodeServ`) REFERENCES `Service` (`Code`);

--
-- Contraintes pour la table `Suivre`
--
ALTER TABLE `Suivre`
  ADD CONSTRAINT `Suivre_ibfk_2` FOREIGN KEY (`CodeForm`) REFERENCES `Formation` (`Code`),
  ADD CONSTRAINT `Suivre_ibfk_1` FOREIGN KEY (`CodeSal`) REFERENCES `Salarie` (`Code`);
