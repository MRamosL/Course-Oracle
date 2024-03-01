/*
Ejercicio 02. Listar a todos los customers que sean de los paises:
France, Germany, Swedwen. Guardar el archivo como "ejercicio02.sql" y
subes a tu repositorio
*/


select * from Customers 
where Country like 'France'
or Country like 'Germany'
or Country like 'Sweden'