-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2024 at 04:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gimnasio`
--

-- --------------------------------------------------------

--
-- Table structure for table `asistencia`
--

CREATE TABLE `asistencia` (
  `ID_Clase` int(11) NOT NULL,
  `ID_Socio` int(11) NOT NULL,
  `ID_Asistencia` int(11) NOT NULL,
  `FechaHora` datetime NOT NULL,
  `ID_Membresia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `clases`
--

CREATE TABLE `clases` (
  `ID_Clase` int(11) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `ID_Entrenador` int(11) NOT NULL,
  `Horario` time NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entrenadores`
--

CREATE TABLE `entrenadores` (
  `ID_Entrenador` int(11) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Apellido` varchar(15) NOT NULL,
  `Especialidad` varchar(30) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `membresias`
--

CREATE TABLE `membresias` (
  `ID_Membresía` int(11) NOT NULL,
  `ID_Socio` int(11) NOT NULL,
  `Costo` decimal(10,0) NOT NULL,
  `CantidadPases` int(11) NOT NULL,
  `Fecha_Inicio` date NOT NULL,
  `Fecha_Fin` date NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `socios`
--

CREATE TABLE `socios` (
  `ID_Socio` int(11) NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Apellido` varchar(15) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Correo` varchar(40) NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`ID_Asistencia`),
  ADD KEY `idAsistencia` (`ID_Clase`),
  ADD KEY `idAsistencia2` (`ID_Membresia`),
  ADD KEY `idAsistencia3` (`ID_Socio`);

--
-- Indexes for table `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD KEY `id_clases` (`ID_Entrenador`);

--
-- Indexes for table `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`ID_Entrenador`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indexes for table `membresias`
--
ALTER TABLE `membresias`
  ADD PRIMARY KEY (`ID_Membresía`),
  ADD KEY `id_socio` (`ID_Socio`);

--
-- Indexes for table `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`ID_Socio`),
  ADD UNIQUE KEY `Dni` (`Dni`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `ID_Asistencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clases`
--
ALTER TABLE `clases`
  MODIFY `ID_Clase` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entrenadores`
--
ALTER TABLE `entrenadores`
  MODIFY `ID_Entrenador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `membresias`
--
ALTER TABLE `membresias`
  MODIFY `ID_Membresía` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `socios`
--
ALTER TABLE `socios`
  MODIFY `ID_Socio` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `idAsistencia` FOREIGN KEY (`ID_Clase`) REFERENCES `clases` (`ID_Clase`),
  ADD CONSTRAINT `idAsistencia2` FOREIGN KEY (`ID_Membresia`) REFERENCES `membresias` (`ID_Membresía`),
  ADD CONSTRAINT `idAsistencia3` FOREIGN KEY (`ID_Socio`) REFERENCES `socios` (`ID_Socio`);

--
-- Constraints for table `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `id_clases` FOREIGN KEY (`ID_Entrenador`) REFERENCES `entrenadores` (`ID_Entrenador`);

--
-- Constraints for table `membresias`
--
ALTER TABLE `membresias`
  ADD CONSTRAINT `id_socio` FOREIGN KEY (`ID_Socio`) REFERENCES `socios` (`ID_Socio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
