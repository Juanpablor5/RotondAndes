DROP TABLE Espacio;
DROP TABLE Preferencias;
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
DROP TABLE Categoria;
DROP TABLE Zona;


CREATE TABLE Zona(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
CONSTRAINT PK_Zona PRIMARY KEY ( id )
);

CREATE TABLE Categoria(
id INTEGER NOT NULL,
nombre VARCHAR2(100) NOT NULL UNIQUE,
CONSTRAINT PK_Categoria PRIMARY KEY ( id )
);

CREATE TABLE Producto(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
descripcion VARCHAR2(1000) NOT NULL,
CHECK (descripcion <> ''),
traduccion VARCHAR2(1200) NOT NULL,
CHECK (traduccion <> ''),
tiempoPreparacion INTEGER NOT NULL,
CHECK (tiempoPreparacion > 0),
categoria_id INTEGER NOT NULL,
CONSTRAINT FK_Producto1 FOREIGN KEY ( categoria_id ) REFERENCES Categoria( id ),
CONSTRAINT PK_Producto PRIMARY KEY ( id )
);

CREATE TABLE Ingrediente(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
CONSTRAINT PK_Ingrediente PRIMARY KEY ( id )
);

CREATE TABLE Producto_Ingrediente(
ingredientes_id INTEGER NOT NULL,
CONSTRAINT FK_Producto_Ingrediente FOREIGN KEY ( ingredientes_id ) REFERENCES  Producto( id ),
productos_id INTEGER NOT NULL,
CONSTRAINT FK_Producto_Ingrediente2 FOREIGN KEY ( productos_id ) REFERENCES  Ingrediente( id ),
CONSTRAINT PK_Producto_Ingrediente PRIMARY KEY ( ingredientes_id , productos_id )
);

CREATE TABLE TipoComida(
id INTEGER NOT NULL,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
CONSTRAINT PK_TipoComida PRIMARY KEY ( id )
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
CONSTRAINT FK_Cliente1 FOREIGN KEY ( registro_codigo ) REFERENCES Usuario( codigo ),
CONSTRAINT FK_Cliente1_U UNIQUE ( registro_codigo ),
CONSTRAINT PK_Cliente PRIMARY KEY ( cedula )
);

CREATE TABLE Pedido(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
fechahora VARCHAR2(100) DEFAULT SYSDATE NOT NULL,
cliente_cedula INTEGER NOT NULL,
CONSTRAINT FK_Pedido1 FOREIGN KEY ( cliente_cedula ) REFERENCES Cliente( cedula ),
CONSTRAINT PK_Pedido PRIMARY KEY ( id )
);

CREATE TABLE Restaurante(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
nombre VARCHAR2(100) NOT NULL,
CHECK (nombre <> ''),
paginaWeb VARCHAR2(100) NOT NULL,
CHECK (paginaWeb <> ''),
registro_codigo INTEGER NOT NULL,
CONSTRAINT FK_Restaurante1 FOREIGN KEY ( registro_codigo ) REFERENCES Usuario( codigo ),
CONSTRAINT FK_Restaurante1_U UNIQUE ( registro_codigo ),
CONSTRAINT PK_Restaurante PRIMARY KEY ( id )
);

CREATE TABLE Menu(
id INTEGER NOT NULL,
cantidad INTEGER NOT NULL,
CHECK (cantidad > 0),
costoProduccion NUMBER NOT NULL,
CHECK (costoProduccion > 0),
valorAlPublico NUMBER NOT NULL,
CHECK (valorAlPublico > 0),
productoEntrada_id INTEGER NOT NULL,
CONSTRAINT FK_Menu1 FOREIGN KEY ( productoEntrada_id ) REFERENCES Producto( id ),
productoFuerte_id INTEGER NOT NULL,
CONSTRAINT FK_Menu2 FOREIGN KEY ( productoFuerte_id ) REFERENCES Producto( id ),
productoBebida_id INTEGER NOT NULL,
CONSTRAINT FK_Menu3 FOREIGN KEY ( productoBebida_id ) REFERENCES Producto( id ),
productoPostre_id INTEGER NOT NULL,
CONSTRAINT FK_Menu4 FOREIGN KEY ( productoPostre_id ) REFERENCES Producto( id ),
productoAcompanamiento_id INTEGER NOT NULL,
CONSTRAINT FK_Menu5 FOREIGN KEY ( productoAcompanamiento_id ) REFERENCES Producto( id ),
restaurante_id INTEGER NOT NULL,
CONSTRAINT FK_Menu6 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ),
CONSTRAINT PK_Menu PRIMARY KEY ( id )
);

CREATE TABLE Pedido_Menu(
pedidos_id INTEGER NOT NULL,
CONSTRAINT FK_Pedido_Menu FOREIGN KEY ( pedidos_id ) REFERENCES  Pedido( id ),
Menus_id INTEGER NOT NULL,
CONSTRAINT FK_Pedido_Menu2 FOREIGN KEY ( Menus_id ) REFERENCES  Menu( id ),
CONSTRAINT PK_Pedido_Menu PRIMARY KEY ( pedidos_id , Menus_id )
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
CONSTRAINT FK_Representante1 FOREIGN KEY ( restaurante_id ) REFERENCES Restaurante( id ),
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
zona_id INTEGER NOT NULL,
CONSTRAINT FK_Reserva1 FOREIGN KEY ( zona_id ) REFERENCES Zona( id ),
menu_id INTEGER NOT NULL,
CONSTRAINT FK_Reserva2 FOREIGN KEY ( menu_id ) REFERENCES Menu( id ),
CONSTRAINT PK_Reserva PRIMARY KEY ( id )
);

CREATE TABLE Preferencias(
id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY,
precioMenor NUMBER NOT NULL,
CHECK (precioMenor >= 0),
precioMayor NUMBER NOT NULL,
CHECK (precioMayor >= 0),
cliente_cedula INTEGER NOT NULL,
CONSTRAINT FK_Preferencias1 FOREIGN KEY ( cliente_cedula ) REFERENCES Cliente( cedula ),
CONSTRAINT FK_Preferencias1_U UNIQUE ( cliente_cedula ),
CONSTRAINT PK_Preferencias PRIMARY KEY ( id )
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
CONSTRAINT FK_Espacio1 FOREIGN KEY ( zona_id ) REFERENCES Zona( id ),
CONSTRAINT PK_Espacio PRIMARY KEY ( id )
);

COMMIT;


INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('ADMIN','12345','example@example.com',3);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('RESTAURANTEROCHA','12345','example@example.com',2);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('PIZERRIAALPES','12345','example@example.com',2);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('CAMILO','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('JUAN','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('ENRIQUE','12345','example@example.com',1);
INSERT INTO USUARIO ( NICKNAME,CONTRASENIA,CORREO,PERMISOS) VALUES ('MARIA','12345','example@example.com',1);

INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (1,'camilo','19/05/2000',4);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (2,'juan','23/07/2005',5);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (3,'enrique','12/08/2007',6);
INSERT INTO CLIENTE ( CEDULA,NOMBRE,FECHAINGRESO,REGISTRO_CODIGO ) VALUES (4,'maria','27/01/2010',7);

INSERT INTO RESTAURANTE (NOMBRE,PAGINAWEB,REGISTRO_CODIGO) VALUES ('pizzeria los alpes','https://pizzeriadelosalpes.wixsite.com/pizzeriadelosalpes',3);
INSERT INTO RESTAURANTE (NOMBRE,PAGINAWEB,REGISTRO_CODIGO) VALUES ('la tiendita de rocha','https://que_es_esa_mierda',2);

COMMIT;
