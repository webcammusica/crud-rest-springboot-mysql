-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql-46915-db.mysql-46915:18824
-- Tiempo de generación: 12-09-2021 a las 21:46:02
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
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `population` int(11) NOT NULL,
  `create_by` varchar(100) NOT NULL,
  `last_modified_by` varchar(100) NOT NULL,
  `created_date` varchar(100) NOT NULL,
  `last_modified_date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `countries`
--

INSERT INTO `countries` (`id`, `name`, `population`, `create_by`, `last_modified_by`, `created_date`, `last_modified_date`) VALUES
(1, 'Alemania', 79778000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(2, 'Colombia', 50340001, 'carlos', 'carlos', '2021-09-05 16:26:45.263027', '2021-09-05 16:26:45.263027'),
(4, 'Finlandia', 3000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(5, 'Egipto', 80000000, 'carlos', 'carlos', '2021-09-02 12:00:00', '2021-09-02 12:00:00'),
(6, 'Sudáfrica', 58560000, 'carlos', 'carlos', '2021-09-05 16:26:45.26302', '2021-09-05 16:26:45.26302');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `country_id` bigint(20) NOT NULL,
  `persona_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`country_id`, `persona_id`) VALUES
(1, 1),
(1, 2),
(4, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `tipo_documento` varchar(2) DEFAULT NULL,
  `num_documento` bigint(20) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direcccion` varchar(600) DEFAULT NULL,
  `create_by` varchar(255) NOT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Solo el nombre es obligatorio';

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `tipo_documento`, `num_documento`, `apellido`, `edad`, `correo_electronico`, `telefono`, `direcccion`, `create_by`, `last_modified_by`) VALUES
(1, 'Nombre Nombre1', 'CC', 1000000000, 'Apellido Apellido1', 111, 'usuario@servidor.com', '1234567890', 'Calle 00 # 00-00 abcdefgh ijklmn opqrst uvwxyz', '', NULL),
(2, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL),
(3, 'Matt', 'TI', 0, 'Díaz R.', 888, 'guiltyspark2@outlook.tk', '3070', 'Subiendo la subida.', 'carlos', 'carlos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`country_id`,`persona_id`),
  ADD KEY `FKjb6wk9s9pyn2m4nrb98tijoa6` (`persona_id`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `FKdi0v8g5xag3mpkhjf30wo2dql` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`),
  ADD CONSTRAINT `FKjb6wk9s9pyn2m4nrb98tijoa6` FOREIGN KEY (`persona_id`) REFERENCES `personas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
