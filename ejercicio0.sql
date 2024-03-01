/*
Ejercicio 0. Listar todos los orders que el campos ShipRegion no sena NULL.
Guardar el archivo como "ejercicio00.sql" y lo subes a tu repositorio
*/
select * from Orders 
where ShipRegion is not NULL