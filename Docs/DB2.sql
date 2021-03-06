DROP TABLE Espacio;
DROP TABLE IngredienteSimilitud;
DROP TABLE Preferencias;
DROP TABLE ProductoSimilitud;
DROP TABLE Reserva;
DROP TABLE Representante;
DROP TABLE Pedido_Menu;
DROP TABLE Menu;
DROP TABLE Restaurante;
DROP TABLE Pedido;
DROP TABLE Cliente;
DROP TABLE Usuario;
DROP TABLE TipoComida;
DROP TABLE Producto_Ingrediente;
DROP TABLE Ingrediente;
DROP TABLE Producto;
DROP TABLE Zona;


CREATE TABLE Zona(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
CONSTRAINT PK_Zona PRIMARY KEY ( id )
);

CREATE TABLE Producto(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL UNIQUE,
CHECK (nombre <> ''),
descripcion VARCHAR2(1000) NOT NULL,
CHECK (descripcion <> ''),
traduccion VARCHAR2(1200) NOT NULL,
CHECK (traduccion <> ''),
tiempoPreparacion INTEGER NOT NULL,
CHECK (tiempoPreparacion > 0),
categoria VARCHAR2(100) NOT NULL,
CONSTRAINT PK_Producto PRIMARY KEY ( id )
);

CREATE TABLE Ingrediente(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
descripcion VARCHAR2(1000) NOT NULL,
traduccion VARCHAR2(1200) NOT NULL,
CONSTRAINT PK_Ingrediente PRIMARY KEY ( id )
);

CREATE TABLE Producto_Ingrediente(
productos_id INTEGER NOT NULL,
CONSTRAINT FK_Producto_Ingrediente FOREIGN KEY ( productos_id ) REFERENCES  Producto( id ) ON DELETE CASCADE,
ingredientes_id INTEGER NOT NULL,
CONSTRAINT FK_Producto_Ingrediente2 FOREIGN KEY ( ingredientes_id ) REFERENCES  Ingrediente( id ) ON DELETE CASCADE,
CONSTRAINT PK_Producto_Ingrediente PRIMARY KEY ( productos_id , ingredientes_id )
);

CREATE TABLE TipoComida(
nombre VARCHAR2(100) NOT NULL,
CONSTRAINT PK_TipoComida PRIMARY KEY ( nombre )
);

CREATE TABLE Usuario(
codigo INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nickName VARCHAR2(100) NOT NULL UNIQUE,
CHECK (nickName <> ''),
contrasenia VARCHAR2(100) NOT NULL,
CHECK (contrasenia <> ''),
correo VARCHAR2(100) NOT NULL,
CHECK (correo <> ''),
permisos INTEGER NOT NULL,
CHECK (permisos BETWEEN 0 AND 3),
CONSTRAINT PK_Usuario PRIMARY KEY ( codigo )
);

CREATE TABLE Cliente(
cedula INTEGER NOT NULL,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
fechaIngreso DATE DEFAULT SYSDATE NOT NULL,
registro_codigo INTEGER NOT NULL,
CONSTRAINT FK_Cliente1 FOREIGN KEY ( registro_codigo ) REFERENCES Usuario( codigo ) ON DELETE CASCADE ,
CONSTRAINT FK_Cliente1_U UNIQUE ( registro_codigo ),
CONSTRAINT PK_Cliente PRIMARY KEY ( cedula )
);

CREATE TABLE Pedido(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
fechahora VARCHAR2(100) DEFAULT SYSDATE NOT NULL,
cliente_cedula INTEGER,
CONSTRAINT FK_Pedido1 FOREIGN KEY ( cliente_cedula ) REFERENCES Cliente( cedula ) ON DELETE SET NULL ,
CONSTRAINT PK_Pedido PRIMARY KEY ( id )
);

CREATE TABLE Restaurante(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
paginaWeb VARCHAR2(100),
CHECK (paginaWeb <> ''),
registro_codigo INTEGER NOT NULL,
CONSTRAINT FK_Restaurante1 FOREIGN KEY ( registro_codigo ) REFERENCES Usuario( codigo ) ON DELETE CASCADE ,
CONSTRAINT FK_Restaurante1_U UNIQUE ( registro_codigo ),
tipoComida_nombre VARCHAR2(100),
CONSTRAINT FK_Restaurante2 FOREIGN KEY ( tipoComida_nombre ) REFERENCES TipoComida( nombre ) ON DELETE SET NULL ,
CONSTRAINT PK_Restaurante PRIMARY KEY ( id )
);

CREATE TABLE Menu(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
cantidad INTEGER NOT NULL,
CHECK (cantidad > 0),
costoProduccion NUMBER NOT NULL,
CHECK (costoProduccion > 0),
valorAlPublico NUMBER NOT NULL,
CHECK (valorAlPublico > 0),
productoEntrada_id INTEGER,
CONSTRAINT FK_Menu1 FOREIGN KEY ( productoEntrada_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
productoFuerte_id INTEGER,
CONSTRAINT FK_Menu2 FOREIGN KEY ( productoFuerte_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
productoBebida_id INTEGER,
CONSTRAINT FK_Menu3 FOREIGN KEY ( productoBebida_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
productoPostre_id INTEGER,
CONSTRAINT FK_Menu4 FOREIGN KEY ( productoPostre_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
productoAcompanamiento_id INTEGER,
CONSTRAINT FK_Menu5 FOREIGN KEY ( productoAcompanamiento_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
restaurante_id INTEGER,
CONSTRAINT FK_Menu6 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ) ON DELETE SET NULL ,
CONSTRAINT PK_Menu PRIMARY KEY ( id )
);

CREATE TABLE Pedido_Menu(
Menus_id INTEGER NOT NULL,
CONSTRAINT FK_Pedido_Menu FOREIGN KEY ( Menus_id ) REFERENCES  Pedido( id ) ON DELETE CASCADE,
pedidos_id INTEGER NOT NULL,
CONSTRAINT FK_Pedido_Menu2 FOREIGN KEY ( pedidos_id ) REFERENCES  Menu( id ) ON DELETE CASCADE,
CONSTRAINT PK_Pedido_Menu PRIMARY KEY ( Menus_id , pedidos_id )
);

CREATE TABLE Representante(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
telefono INTEGER NOT NULL,
CHECK (telefono > 0),
correo VARCHAR2(100) NOT NULL,
CHECK (correo <> ''),
restaurante_id INTEGER NOT NULL,
CONSTRAINT FK_Representante1 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ) ON DELETE CASCADE ,
CONSTRAINT FK_Representante1_U UNIQUE ( restaurante_id ),
CONSTRAINT PK_Representante PRIMARY KEY ( id )
);

CREATE TABLE Reserva(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
fechahora VARCHAR2(100) DEFAULT SYSDATE NOT NULL,
duracion INTEGER NOT NULL,
CHECK (duracion > 0),
comensales INTEGER NOT NULL,
CHECK (comensales > 0),
nombreReservante VARCHAR2(100) NOT NULL,
CHECK (nombreReservante <> ''),
telefonoReservante INTEGER NOT NULL,
CHECK (telefonoReservante > 0),
zona_id INTEGER,
CONSTRAINT FK_Reserva1 FOREIGN KEY ( zona_id ) REFERENCES Zona( id ) ON DELETE SET NULL ,
menu_id INTEGER,
CONSTRAINT FK_Reserva2 FOREIGN KEY ( menu_id ) REFERENCES Menu( id ) ON DELETE SET NULL ,
CONSTRAINT PK_Reserva PRIMARY KEY ( id )
);

CREATE TABLE ProductoSimilitud(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
restaurante_id INTEGER,
CONSTRAINT FK_ProductoSimilitud1 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ) ON DELETE SET NULL ,
producto_id INTEGER,
CONSTRAINT FK_ProductoSimilitud2 FOREIGN KEY ( producto_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
producto2_id INTEGER,
CONSTRAINT FK_ProductoSimilitud3 FOREIGN KEY ( producto2_id ) REFERENCES Producto( id ) ON DELETE SET NULL ,
CONSTRAINT PK_ProductoSimilitud PRIMARY KEY ( id )
);

CREATE TABLE Preferencias(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
precioMenor NUMBER NOT NULL,
CHECK (precioMenor >= 0),
precioMayor NUMBER NOT NULL,
CHECK (precioMayor >= 0),
cliente_cedula INTEGER,
CONSTRAINT FK_Preferencias1 FOREIGN KEY ( cliente_cedula ) REFERENCES Cliente( cedula ) ON DELETE SET NULL ,
CONSTRAINT FK_Preferencias1_U UNIQUE ( cliente_cedula ),
CONSTRAINT PK_Preferencias PRIMARY KEY ( id )
);

CREATE TABLE IngredienteSimilitud(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
restaurante_id INTEGER,
CONSTRAINT FK_IngredienteSimilitud1 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ) ON DELETE SET NULL ,
ingrediente_id INTEGER,
CONSTRAINT FK_IngredienteSimilitud2 FOREIGN KEY ( ingrediente_id ) REFERENCES Ingrediente( id ) ON DELETE SET NULL ,
ingrediente2_id INTEGER,
CONSTRAINT FK_IngredienteSimilitud3 FOREIGN KEY ( ingrediente2_id ) REFERENCES Ingrediente( id ) ON DELETE SET NULL ,
CONSTRAINT PK_IngredienteSimilitud PRIMARY KEY ( id )
);

CREATE TABLE Espacio(
id INTEGER NOT NULL,
acondicionamiento VARCHAR2(500) NOT NULL,
CHECK (acondicionamiento <> ''),
abierto INTEGER NOT NULL,
capacidad INTEGER NOT NULL,
CHECK (capacidad > 0),
necesidadesEspeciales INTEGER NOT NULL,
condicionesTecnicas VARCHAR2(500) NOT NULL,
CHECK (condicionesTecnicas <> ''),
zona_id INTEGER NOT NULL,
CONSTRAINT FK_Espacio1 FOREIGN KEY ( zona_id ) REFERENCES Zona( id ) ON DELETE CASCADE ,
CONSTRAINT PK_Espacio PRIMARY KEY ( id )
);

COMMIT;

INSERT INTO TIPOCOMIDA (NOMBRE) VALUES ('indu');
INSERT INTO TIPOCOMIDA (NOMBRE) VALUES ('arabe');
INSERT INTO TIPOCOMIDA (NOMBRE) VALUES ('vegetariana');
INSERT INTO TIPOCOMIDA (NOMBRE) VALUES ('marina');
INSERT INTO TIPOCOMIDA (NOMBRE) VALUES ('rapida');

INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('ADMIN','12345','example@example.com',3);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('RESTAURANTEROCHA','12345','example@example.com',2);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('PIZERRIAALPES','12345','example@example.com',2);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('CAMILO','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('JUAN','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('ENRIQUE','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('MARIA','12345','example@example.com',1);

INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO) VALUES (1,'camilo','19/05/2000',4);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (2,'juan','23/07/2005',5);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (3,'enrique','12/08/2007',6);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (4,'maria','27/01/2010',7);

INSERT INTO RESTAURANTE (NOMBRE,PAGINAWEB,REGISTRO_CODIGO,TIPOCOMIDA_NOMBRE) VALUES ('pizzeria los alpes','https://pizzeriadelosalpes.wixsite.com/pizzeriadelosalpes',3,'rapida');
INSERT INTO RESTAURANTE (NOMBRE,PAGINAWEB,REGISTRO_CODIGO,TIPOCOMIDA_NOMBRE) VALUES ('la tiendita de rocha','https://que_es_esa_mierda',2,'marina');

INSERT INTO REPRESENTANTE (NOMBRE,TELEFONO,CORREO,RESTAURANTE_ID) VALUES ('rocha',123456,'nomeacuedo@uniandes.edu.co',1);

INSERT INTO INGREDIENTE (NOMBRE,DESCRIPCION,TRADUCCION) VALUES ('AMOR','EL INGREDIENTE MAS IMPORTANTES (VALIDO PARA TODOS LOS PRODUCTS DE ROTONDANTES)','THE MOST IMPORTANT INGREDIENT (VALID FOR ALL ROTONDANTES PRODUCTS)');
INSERT INTO INGREDIENTE (NOMBRE,DESCRIPCION,TRADUCCION) VALUES ('QUESO','ALIMENTO S�LIDO QUE SE OBTIENE POR MADURACI�N DE LA CUAJADA DE LA LECHE UNA VEZ ELIMINADO EL SUERO; SUS DIFERENTES VARIEDADES DEPENDEN DEL ORIGEN DE LA LECHE EMPLEADA, DE LOS M�TODOS DE ELABORACI�N SEGUIDOS Y DEL GRADO DE MADUREZ ALCANZADO.','SOLID FOOD OBTAINED BY MATURATION OF THE MILK CURD AFTER THE SERUM IS ELIMINATED; ITS VARIOUS VARIANTS DEPEND ON THE ORIGIN OF THE MILK USED, THE METHODS OF PROCESSING FOLLOWED AND THE DEGREE OF MATURITY REACHED.');
INSERT INTO INGREDIENTE (NOMBRE,DESCRIPCION,TRADUCCION) VALUES ('PAPA','TUBERCULO COMESTIBLE DESPUES DE UNA COCCION DETERMINADA','EDIBLE TUBERCULUS AFTER A CERTAIN COOKING.');
INSERT INTO INGREDIENTE (NOMBRE,DESCRIPCION,TRADUCCION) VALUES ('TOMATE','BAYA CASI ROJA, FRUTO DE LA TOMATERA, DE SUPERFICIE LISA Y BRILLANTE, EN CUYA PULPA HAY NUMEROSAS SEMILLAS ALGO APLASTADAS Y AMARILLAS.','ALMOST RED BERRY, FRUIT OF THE TOMATERA, WITH SMOOTH AND SHINY SURFACE, IN WHOSE PULP THERE ARE NUMEROUS SEEDS SOMEWHAT CRUSHED AND YELLOW.');
INSERT INTO INGREDIENTE (NOMBRE,DESCRIPCION,TRADUCCION) VALUES ('POLLO',' ES EL NOMBRE QUE RECIBEN LAS CR�AS DE LAS GALLINAS Y DE OTRAS AVES.','IS THE NAME GIVEN TO THE OFFSPRING OF HENS AND OTHER BIRDS.');

INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('pizza','Comida que consiste en una base de masa de pan, generalmente delgada y redonda, que se recubre con salsa de tomate, queso mozzarella o similar y diversos ingredientes troceados y se cuece al horno; es de origen italiano.','Food consisting of a base of bread dough, usually thin and round, covered with tomato sauce, mozzarella or similar cheese and various ingredients chopped and baked; is of Italian origin.',15,'PLATOFUERTE');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('hamburgesa','Comida que se prepara con carne picada de animales vacunos, cerdo o aves, generalmente condimentada con sal, pimienta, ajo y perejil, y forma redonda y plana; suele asarse a la plancha o fre�rse.','Food prepared with minced beef, pork or poultry, usually seasoned with salt, pepper, garlic and parsley, and round and flat shape; usually grilled or fried.',20,'PLATOFUERTE');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('ajiaco santafere�o',' el ajiaco santafere�o es una platillo t�pico de la ciudad de Bogot�, Colombia. Su nombre lo toma de Santa F�, como en tiempos coloniales se le conoci� a esta capital suramericana.Con el pollo y tres clases de papa como su componente esencial, el ajiaco santafere�o es una receta que usted deber�a probar','the ajiaco santafere�o is a typical dish of the city of Bogot�, Colombia. Its name takes it from Santa Fe, as in colonial times it was known to this South American capital.With chicken and three kinds of potato as its essential component, Santa Fe chili is a recipe that you should try.',30,'PLATOFUERTE');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('patacones','es una comida a base de trozos aplanados fritos de pl�tano verde','is a meal based on flat fried pieces of green banana',10,'ENTRADA');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('chorizos',' es un producto embutido, curado, elaborado a partir de carnes frescas de cerdo graso','is an in-built, cured product made from fresh fatty pork meats',10,'ENTRADA');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('brownie con helado','brownie helado','brownie 6 ice cream',15,'POSTRE');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('chicha','bebidas derivadas principalmente de la fermentaci�n no destilada del ma�z y otros cereales originarios de Am�rica','beverages derived mainly from the non-distilled fermentation of maize and other cereals originating in the Americas',15,'BEBIDA');
INSERT INTO PRODUCTO (NOMBRE,DESCRIPCION,TRADUCCION,TIEMPOPREPARACION,CATEGORIA) VALUES ('huevo frito','huevo frito','fried egg',15,'ACOMPANAMIENTO');

INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (1,1);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (1,2);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (1,3);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (2,1);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (3,1);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (3,5);
INSERT INTO PRODUCTO_INGREDIENTE (INGREDIENTES_ID,PRODUCTOS_ID) VALUES (3,3);

INSERT INTO ZONA (NOMBRE) VALUES ('COMIDARAPIDA');
INSERT INTO ZONA (NOMBRE) VALUES ('ZONA T');
INSERT INTO ZONA (NOMBRE) VALUES ('HIPPSTER');
INSERT INTO ZONA (NOMBRE) VALUES ('VEGANOS');

INSERT INTO MENU (CANTIDAD,COSTOPRODUCCION,VALORALPUBLICO,PRODUCTOENTRADA_ID,PRODUCTOFUERTE_ID,PRODUCTOPOSTRE_ID ,PRODUCTOBEBIDA_ID,PRODUCTOACOMPANAMIENTO_ID,RESTAURANTE_ID) VALUES (30,3000,5000,NULL,1,NULL,NULL,NULL,1);
INSERT INTO MENU (CANTIDAD,COSTOPRODUCCION,VALORALPUBLICO,PRODUCTOENTRADA_ID,PRODUCTOFUERTE_ID,PRODUCTOPOSTRE_ID ,PRODUCTOBEBIDA_ID,PRODUCTOACOMPANAMIENTO_ID,RESTAURANTE_ID) VALUES (6,5000,20000,5,3,6,7,8,2);

COMMIT;