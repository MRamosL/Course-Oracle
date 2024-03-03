/* 
EJERCICIOS 
1. Crear una base de tados llamada "tallerSQL"
2.Crear una tabala llamada "Clientes2, considerar los atriburos Id, Nombre, Apellido, Direccion, Email
3. Inseratar 10 registros en la tabla creada anteriormente }
4. Mostrar  todos los registros EN LA TABLA ANTERIORMENTE CREADA 
5. Actualizar 5 registros utilizando WHERE 
6. Eliminar 2 registros utilizando el where


*/

CREATE DATABASE TallerSQL 
USE TallerSQL
GO 

CREATE TABLE Clientes(
Id CHAR(5) NOT NULL PRIMARY KEY,
Nombre varchar(30) NOT NULL,
Apellido varchar(30) NOT NULL,
Direccion varchar(50) NOT NULL,
Email varchar(30) NOT NULL
)

SELECT * FROM Clientes


INSERT INTO Clientes values ('00234', 'Alex', 'Obregon', 'Lima', 'Alexobregon@gmail.com'),
                            ('00254', 'Karen', 'Pera', 'Callao', 'KarenperaL@gmail.com'),
							('00984', 'Angel', 'Arellan', 'Huaraz', 'Angelarellan20@gmail.com'),
							('00786', 'Juliet', 'Casique', 'Comas', 'Julicasi12@gmail.com'),
							('00657', 'Karen', 'Ramirez', 'Puente', 'karenramirez@gmail.com'),
						    ('00456', 'Shandler', 'Moscoso', 'Olivos', 'shandlermoscoso90@gamil.com'),
							('00923', 'David', 'Lee', ' Cedar St', 'david@exae.com'),
							('00821', 'Erik', 'Vega', 'Huancayo', 'Erikvega34@gmail.com'),
							('00612', 'Jose', 'Blas', 'Huancavelica', 'Joselimas@senati.pe'),
							('00158', 'Mirko', 'Limas', 'Chacas', 'limasmirko@gmail.com');

SELECT * FROM Clientes

UPDATE Clientes
SET Direccion = 'Ate'
WHERE Id IN ('00234')

UPDATE Clientes
SET Nombre = 'Katerine'
WHERE Id IN ('00254')

          
UPDATE Clientes
SET Nombre = 'Daniel'
WHERE Id IN ('00984')

UPDATE Clientes
SET Direccion = 'San Martín'
WHERE Id IN ('00786')

UPDATE Clientes
SET Email = 'Karen@senati.pe'
WHERE Id IN ('00657')


DELETE FROM Clientes
WHERE Email = 'limasmirko@gmail.com'

DELETE FROM Clientes
WHERE Apellido = 'limas'