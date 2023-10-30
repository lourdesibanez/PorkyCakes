INSERT INTO `porkydb`.`categoria` (`id`, `nombre`) VALUES
(1, 'Tortas'),
(2, 'Galletas'),
(3, 'Cupcakes');

INSERT INTO `porkydb`.`producto` (`codigo`, `nombre`, `precio`, `id_categoria`) VALUES
(1, 'Torta de Chocolate', 2999, 1),
(2, 'Galletas de Vainilla', 599, 2),
(3, 'Cupcake de Fresa', 249, 3);

INSERT INTO `porkydb`.`receta` (`nombre`, `tiempo_prep`, `porciones`, `codigo_producto`) VALUES
('Torta de Chocolate', 60, 12, 1),
('Galletas de Vainilla', 30, 24, 2);

INSERT INTO `porkydb`.`paso` (`numero`, `instruccion`, `id_receta`) VALUES
(1, 'Batir la crema', 1),
(2, 'Hornear la torta', 1),
(3, 'Mezclar los ingredientes', 2);

INSERT INTO `porkydb`.`ingrediente` (`codigo`, `nombre`) VALUES
(1, 'Chocolate'),
(2, 'Harina'),
(3, 'Azúcar'),
(4, 'Vainilla');

INSERT INTO `porkydb`.`ingredientesxreceta` (`id_receta`, `codigo_ingrediente`, `cantidad`, `tipo_unidad`) VALUES
(1, 1, 200, 'gramos'),
(1, 2, 300, 'gramos'),
(1, 3, 150, 'gramos'),
(2, 2, 250, 'gramos'),
(2, 3, 100, 'gramos');

INSERT INTO `porkydb`.`metodo_de_pago` (`id`, `nombre`) VALUES
(1, 'Tarjeta de crédito'),
(2, 'Efectivo'),
(3, 'Transferencia bancaria');

INSERT INTO `porkydb`.`usuario` (`nombre_usuario`, `nombre`, `apellido`) VALUES
('juan_perez1', 'Juan', 'Pérez'),
('maria_g22', 'María', 'González');

INSERT INTO `porkydb`.`pedido` (`fecha_pedido`, `fecha_entrega`, `comentario`, `id_metodo_de_pago`, `nombre_usuario`) VALUES
('2023-10-06', '2023-10-10', '', 1, 'juan_perez1'),
('2023-10-07', '2023-10-12', '', 2, 'maria_g22');

INSERT INTO `porkydb`.`productosxpedido` (`codigo_producto`, `numero_pedido`, `cantidad`) VALUES
(1, 3, 1),
(2, 4, 2),
(3, 4, 2);

INSERT INTO `porkydb`.`estado` (`id`, `nombre`) VALUES
(1, 'Pendiente'),
(2, 'En proceso'),
(3, 'Entregado');

INSERT INTO `porkydb`.`estadoxpedido` (`numero_pedido`, `id_estado`, `fecha`) VALUES
(3, 1, '2023-10-06'),
(3, 2, '2023-10-07'),
(4, 1, '2023-10-07'),
(4, 3, '2023-10-10');
