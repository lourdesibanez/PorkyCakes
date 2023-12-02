-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2023 a las 03:38:09
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `porkydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Tortas'),
(2, 'Galletas'),
(3, 'Cupcakes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`) VALUES
(1, 'Pendiente'),
(2, 'En proceso'),
(3, 'Entregado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoxpedido`
--

CREATE TABLE `estadoxpedido` (
  `numero_pedido` int(10) UNSIGNED NOT NULL,
  `id_estado` int(10) UNSIGNED NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estadoxpedido`
--

INSERT INTO `estadoxpedido` (`numero_pedido`, `id_estado`, `fecha`) VALUES
(1, 1, '2023-10-06'),
(1, 2, '2023-10-07'),
(2, 1, '2023-10-07'),
(2, 3, '2023-10-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `codigo` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `unidad` varchar(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `umbralMinimo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`codigo`, `nombre`, `unidad`, `cantidad`, `umbralMinimo`) VALUES
(1, 'Chocolate', 'gr', 400, 1000),
(2, 'Harina', 'gr', 200, 1000),
(3, 'Azúcar', 'gr', 500, 1000),
(4, 'Vainilla', 'ml', 200, 200),
(9999, 'nulo', 'gr', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientesxreceta`
--

CREATE TABLE `ingredientesxreceta` (
  `id_receta` int(10) UNSIGNED NOT NULL,
  `codigo_ingrediente` int(10) UNSIGNED NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `tipo_unidad` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingredientesxreceta`
--

INSERT INTO `ingredientesxreceta` (`id_receta`, `codigo_ingrediente`, `cantidad`, `tipo_unidad`) VALUES
(1, 1, 200, 'gramos'),
(1, 2, 300, 'gramos'),
(1, 3, 150, 'gramos'),
(2, 2, 250, 'gramos'),
(2, 3, 100, 'gramos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_de_pago`
--

CREATE TABLE `metodo_de_pago` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `metodo_de_pago`
--

INSERT INTO `metodo_de_pago` (`id`, `nombre`) VALUES
(1, 'Tarjeta de crédito'),
(2, 'Efectivo'),
(3, 'Transferencia bancaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paso`
--

CREATE TABLE `paso` (
  `numero` int(10) UNSIGNED NOT NULL,
  `instruccion` text NOT NULL,
  `id_receta` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paso`
--

INSERT INTO `paso` (`numero`, `instruccion`, `id_receta`) VALUES
(1, 'Batir la crema', 1),
(2, 'Hornear la torta', 1),
(3, 'Mezclar los ingredientes', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `numero` int(10) UNSIGNED NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `comentario` text DEFAULT NULL,
  `id_metodo_de_pago` int(10) UNSIGNED NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`numero`, `fecha_pedido`, `fecha_entrega`, `comentario`, `id_metodo_de_pago`, `nombre_usuario`) VALUES
(1, '2023-10-06', '2023-10-10', '', 1, 'juan_perez1'),
(2, '2023-10-07', '2023-10-12', '', 2, 'maria_g22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `precio` float DEFAULT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombre`, `precio`, `id_categoria`) VALUES
(1, 'Torta de Chocolate', 2999, 1),
(2, 'Galletas de Vainilla', 599, 2),
(3, 'Cupcake de Fresa', 249, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosxpedido`
--

CREATE TABLE `productosxpedido` (
  `codigo_producto` int(10) UNSIGNED NOT NULL,
  `numero_pedido` int(10) UNSIGNED NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productosxpedido`
--

INSERT INTO `productosxpedido` (`codigo_producto`, `numero_pedido`, `cantidad`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tiempo_prep` int(11) NOT NULL,
  `porciones` int(11) NOT NULL,
  `codigo_producto` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `nombre`, `tiempo_prep`, `porciones`, `codigo_producto`) VALUES
(1, 'Torta de Chocolate', 60, 12, 1),
(2, 'Galletas de Vainilla', 30, 24, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetasbasexreceta`
--

CREATE TABLE `recetasbasexreceta` (
  `id_receta_principal` int(10) UNSIGNED NOT NULL,
  `id_receta_base` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `tipo`) VALUES
(1, 'admin'),
(2, 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombre_usuario` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(70) NOT NULL,
  `rol_id` int(11) NOT NULL,
  `contrasena` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre_usuario`, `nombre`, `apellido`, `rol_id`, `contrasena`) VALUES
('admin', 'Jhon', 'Doe', 1, '12345'),
('juan_perez1', 'Juan', 'Pérez', 2, ' '),
('lucia', 'Lucia', 'Miraques', 1, 'lucia123'),
('maria_g22', 'María', 'González', 2, ' ');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estadoxpedido`
--
ALTER TABLE `estadoxpedido`
  ADD PRIMARY KEY (`numero_pedido`,`id_estado`),
  ADD KEY `fk_pedido_has_estado_estado1` (`id_estado`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `ingredientesxreceta`
--
ALTER TABLE `ingredientesxreceta`
  ADD PRIMARY KEY (`id_receta`,`codigo_ingrediente`),
  ADD KEY `fk_receta_has_ingrediente_ingrediente1` (`codigo_ingrediente`);

--
-- Indices de la tabla `metodo_de_pago`
--
ALTER TABLE `metodo_de_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `paso`
--
ALTER TABLE `paso`
  ADD PRIMARY KEY (`numero`,`id_receta`),
  ADD KEY `fk_paso_receta1` (`id_receta`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `fk_pedido_metodo_de_pago1` (`id_metodo_de_pago`),
  ADD KEY `fk_pedido_usuario1` (`nombre_usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_producto_categoria1` (`id_categoria`);

--
-- Indices de la tabla `productosxpedido`
--
ALTER TABLE `productosxpedido`
  ADD PRIMARY KEY (`codigo_producto`,`numero_pedido`),
  ADD KEY `fk_producto_has_pedido_pedido1` (`numero_pedido`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_receta_producto1` (`codigo_producto`);

--
-- Indices de la tabla `recetasbasexreceta`
--
ALTER TABLE `recetasbasexreceta`
  ADD PRIMARY KEY (`id_receta_principal`),
  ADD KEY `fk_receta_has_receta_receta2` (`id_receta_base`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombre_usuario`),
  ADD KEY `fk_usuario_rol1` (`rol_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  MODIFY `codigo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `numero` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `codigo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadoxpedido`
--
ALTER TABLE `estadoxpedido`
  ADD CONSTRAINT `fk_pedido_has_estado_estado1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_has_estado_pedido1` FOREIGN KEY (`numero_pedido`) REFERENCES `pedido` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ingredientesxreceta`
--
ALTER TABLE `ingredientesxreceta`
  ADD CONSTRAINT `fk_receta_has_ingrediente_ingrediente1` FOREIGN KEY (`codigo_ingrediente`) REFERENCES `ingrediente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_receta_has_ingrediente_receta1` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paso`
--
ALTER TABLE `paso`
  ADD CONSTRAINT `fk_paso_receta1` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_metodo_de_pago1` FOREIGN KEY (`id_metodo_de_pago`) REFERENCES `metodo_de_pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_usuario1` FOREIGN KEY (`nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_categoria1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productosxpedido`
--
ALTER TABLE `productosxpedido`
  ADD CONSTRAINT `fk_producto_has_pedido_pedido1` FOREIGN KEY (`numero_pedido`) REFERENCES `pedido` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_has_pedido_producto1` FOREIGN KEY (`codigo_producto`) REFERENCES `producto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `fk_receta_producto1` FOREIGN KEY (`codigo_producto`) REFERENCES `producto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recetasbasexreceta`
--
ALTER TABLE `recetasbasexreceta`
  ADD CONSTRAINT `fk_receta_has_receta_receta1` FOREIGN KEY (`id_receta_principal`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_receta_has_receta_receta2` FOREIGN KEY (`id_receta_base`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
