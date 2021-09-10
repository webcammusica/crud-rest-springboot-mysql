-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql-46915-db.mysql-46915:18824
-- Tiempo de generación: 03-09-2021 a las 14:22:06
-- Versión del servidor: 5.7.34-0ubuntu0.18.04.1
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `country`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `population` int(11) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(100) DEFAULT NULL,
  `last_modified_date` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `countries`
--

INSERT INTO `countries` (`id`, `name`, `population`, `create_by`, `last_modified_by`, `created_date`, `last_modified_date`) VALUES
(1, 'Alemania', 79778000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(2, 'Colombia', 50000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(3, 'EEUU', 200000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(4, 'Finlandia', 3000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(5, 'Egipto', 80000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
