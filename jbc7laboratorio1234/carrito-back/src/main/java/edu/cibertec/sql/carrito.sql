DROP DATABASE `carrito`;

CREATE SCHEMA `carrito`; 
 
use carrito; 
 
CREATE TABLE `carrito`.`categoria` ( 
  `idcategoria` INT NOT NULL AUTO_INCREMENT, 
  `nomcategoria` VARCHAR(50) NOT NULL, 
  PRIMARY KEY (`idcategoria`)) 
COMMENT = 'Maestro de categorías'; 
 
 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Portatil'); 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Tableta'); 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Audifonos'); 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Celular'); 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Cámara'); 
INSERT INTO `carrito`.`categoria` (`nomcategoria`) VALUES ('Accesorio'); 
 
CREATE TABLE `carrito`.`producto` ( 
  `idproducto` INT NOT NULL AUTO_INCREMENT, 
  `nomproducto` VARCHAR(50) NOT NULL, 
  `idcategoria` INT NULL, 
  `preproducto` DECIMAL(15,2) NULL, 
  `antpreproducto` DECIMAL(15,2) NULL, 
  `nueproducto` INT NULL, 
  `imgproducto` VARCHAR(50) NULL, 
  PRIMARY KEY (`idproducto`), 
  INDEX `FK_categoria_idx` (`idcategoria` ASC) VISIBLE, 
  CONSTRAINT `FK_categoria` 
    FOREIGN KEY (`idcategoria`) 
    REFERENCES `carrito`.`categoria` (`idcategoria`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
COMMENT = 'Maetro de productos'; 
 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Laptop HP 766i8', '1', '1523.36', '1600', '0', './img/product03.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Laptop Lenovo 15u776', '1', '1852', '1925.36', '1', './img/product01.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Laptop Acer 5468445', '1', '8500', '8500', '1', './img/product03.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Laptop HP 876876', '1', '2560', '2600', '0', './img/product01.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Tablet HP 8676788', '2', '1200', '1250', '0', './img/product04.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Tablet Samsung rrw4545', '2', '1350', '1450', '1', './img/product04.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Tablet LG OO88', '2', '1800', '1820', '1', './img/product04.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Tablet Lenovo hh5454', '2', '1500', '1550', '1', './img/product04.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Audifono HHY 76767', '3', '500', '536.36', '1', './img/product05.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Audifonos DJ 8787', '3', '7500', '7863', '1', './img/product05.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Audifonos UJY 65', '3', '700', '750', '1', './img/product05.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Audifonos Skullcandy 888', '3', '1250', '1350', '1', './img/product05.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Celular LG 76767', '4', '850', '855', '1', './img/product07.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Celular PO 8978', '4', '900', '900', '1', './img/product07.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Celular Huawey 9955', '4', '1800', '1853', '1', './img/product07.png'); 
INSERT INTO `carrito`.`producto` (`nomproducto`, `idcategoria`, `preproducto`, `antpreproducto`, `nueproducto`, `imgproducto`) VALUES ('Celular iPhone 9', '4', '3520', '3600', '1', './img/product07.png'); 

CREATE TABLE `carrito`.`usuario` ( 
  `idusuario` INT NOT NULL AUTO_INCREMENT, 
  `nomusuario` VARCHAR(15) NOT NULL, 
  `clausuario` VARCHAR(100) NOT NULL, 
  `nomcomusuario` VARCHAR(50) NOT NULL, 
  PRIMARY KEY (`idusuario`));
  
INSERT INTO `carrito`.`usuario` (`nomusuario`, `clausuario`, `nomcomusuario`) VALUES 
('usuario', '$2a$10$9p.YypMUo0bu159u8cJrl.8Yygx6Gq0BdG/RU2inDSCjNll5nz6u.', 'Usuario 
Administrador'); 