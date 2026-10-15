-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2026 at 02:18 PM
-- Server version: 8.0.30
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `geets_pilatesstudio`
--

-- --------------------------------------------------------

--
-- Table structure for table `instruktur`
--

CREATE TABLE `instruktur` (
  `id_instruktur` int NOT NULL,
  `nama` varchar(50) NOT NULL,
  `spesialisasi` varchar(50) NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `status` enum('Aktif','Nonaktif') NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `domisili` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `instruktur`
--

INSERT INTO `instruktur` (`id_instruktur`, `nama`, `spesialisasi`, `jenis_kelamin`, `status`, `no_telepon`, `domisili`) VALUES
(1, 'Gita', 'Mat Pilates', 'Perempuan', 'Aktif', '', ''),
(2, 'Gita', 'Mat Pilates', 'Perempuan', 'Aktif', '085248335528', 'Samarinda'),
(3, 'Sienna Sipro', 'reformer pilates', 'Laki-laki', 'Aktif', '074185201596', 'samarinda');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelas`
--

CREATE TABLE `jenis_kelas` (
  `id_jenis` int NOT NULL,
  `nama` varchar(50) NOT NULL,
  `level` enum('Beginner','Intermediate','Advanced') NOT NULL,
  `durasi` varchar(10) NOT NULL,
  `status` enum('Tersedia','Tidak Tersedia') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jenis_kelas`
--

INSERT INTO `jenis_kelas` (`id_jenis`, `nama`, `level`, `durasi`, `status`) VALUES
(1, 'Mat Pilates', 'Beginner', '90 Menit', 'Tersedia'),
(2, 'Reformer Pilates', 'Intermediate', '60 Menit', 'Tersedia'),
(3, 'hot mat pilates', 'Beginner', '90', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelas_private`
--

CREATE TABLE `jenis_kelas_private` (
  `id_jenis` int NOT NULL,
  `jenis_sesi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jenis_kelas_private`
--

INSERT INTO `jenis_kelas_private` (`id_jenis`, `jenis_sesi`) VALUES
(1, 'One to One'),
(3, 'one to one ');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelas_publik`
--

CREATE TABLE `jenis_kelas_publik` (
  `id_jenis` int NOT NULL,
  `kapasitas` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jenis_kelas_publik`
--

INSERT INTO `jenis_kelas_publik` (`id_jenis`, `kapasitas`) VALUES
(2, 15);

-- --------------------------------------------------------

--
-- Table structure for table `kelas_pilates`
--

CREATE TABLE `kelas_pilates` (
  `id_kelas` int NOT NULL,
  `id_member` int NOT NULL,
  `id_instruktur` int NOT NULL,
  `id_jenis` int NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` datetime NOT NULL,
  `status` enum('Terjadwal','Selesai','Batal') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kelas_pilates`
--

INSERT INTO `kelas_pilates` (`id_kelas`, `id_member`, `id_instruktur`, `id_jenis`, `tanggal`, `waktu`, `status`) VALUES
(1, 1, 2, 1, '2026-10-16', '2026-10-16 10:00:00', 'Terjadwal');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_member` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_telepon` varchar(20) NOT NULL,
  `usia` int NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `nama`, `no_telepon`, `usia`, `jenis_kelamin`, `status`) VALUES
(1, 'Davi', '085248335528', 19, 'Laki-laki', 'Aktif'),
(2, 'git', '085248669955', 12, 'Perempuan', 'Aktif'),
(3, 'Alya Hauranisa', '085224455887', 25, 'Perempuan', 'Aktif');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `instruktur`
--
ALTER TABLE `instruktur`
  ADD PRIMARY KEY (`id_instruktur`);

--
-- Indexes for table `jenis_kelas`
--
ALTER TABLE `jenis_kelas`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `jenis_kelas_private`
--
ALTER TABLE `jenis_kelas_private`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `jenis_kelas_publik`
--
ALTER TABLE `jenis_kelas_publik`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `kelas_pilates`
--
ALTER TABLE `kelas_pilates`
  ADD PRIMARY KEY (`id_kelas`),
  ADD KEY `id_member` (`id_member`),
  ADD KEY `id_instruktur` (`id_instruktur`),
  ADD KEY `id_jenis` (`id_jenis`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jenis_kelas_private`
--
ALTER TABLE `jenis_kelas_private`
  ADD CONSTRAINT `jenis_kelas_private_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_kelas` (`id_jenis`);

--
-- Constraints for table `jenis_kelas_publik`
--
ALTER TABLE `jenis_kelas_publik`
  ADD CONSTRAINT `jenis_kelas_publik_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_kelas` (`id_jenis`);

--
-- Constraints for table `kelas_pilates`
--
ALTER TABLE `kelas_pilates`
  ADD CONSTRAINT `kelas_pilates_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`),
  ADD CONSTRAINT `kelas_pilates_ibfk_2` FOREIGN KEY (`id_instruktur`) REFERENCES `instruktur` (`id_instruktur`),
  ADD CONSTRAINT `kelas_pilates_ibfk_3` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_kelas` (`id_jenis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
