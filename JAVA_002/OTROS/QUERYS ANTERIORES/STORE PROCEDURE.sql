



alter procedure usp_comboPublicaciones
		as
		select idpublicacion, titulo      from PUBLICACION
		
		
ALTER procedure usp_comboTipoPublicaciones
		as
		select      descripcion    from TIPO


			   		 

		exec usp_comboPublicaciones





CREATE procedure usp_traerPrecio  'LIB00001'
	@idpublicacion as char(8)
as
		select	[precio]		 from [dbo].[PUBLICACION] where [idpublicacion]=@idpublicacion































/*CREATE PROCEDURE usp_publicacion
(@idtipo char(3))
as
select [idpublicacion],[titulo] , [autor],[precio],[nroedicion], [stock]  from  [dbo].[PUBLICACION] 
where idtipo=@idtipo


exec usp_publicacion  'REV';*/




/*CREATE PROCEDURE usp_buscafecha
(@fecha datetime)
as
select  cliente from [dbo].[VENTA]
where  fecha=@fecha



exec usp_buscafecha  '2022-09-05 09:11:18.680';*/


/*CREATE PROCEDURE usp_buscafechas
(@fecha1 as datetime,
@fecha2 as datetime)
as
select  cliente from [dbo].[VENTA]
where fecha   between @fecha1   and @fecha2*/



/*exec usp_buscafechas '2022-09-05 09:11:18.680','2022-09-05 09:11:18.683';*/



/*
CREATE PROCEDURE usp_buscafechas
(@fecha1 as datetime,
@fecha2 as datetime)
as
select idventa, cliente, fecha,idpublicacion,cantidad,precio,total
from [dbo].[VENTA]
where fecha   between @fecha1   and @fecha2*/









/*CREATE PROCEDURE usp_buscafechas3
(@fecha1 as date,
@fecha2 as date)
as
select idventa, cliente,  (convert(varchar,convert(date,[fecha]),3)) as fecha,cantidad,precio,total
from [dbo].[VENTA]
where (convert(varchar,convert(date,[fecha]),3))    between  (convert(varchar, convert (date, @fecha1),3))  
and (convert(varchar, convert (date, @fecha2),3))



exec usp_buscafechas '2022-09-05','2022-09-05';

exec usp_buscafechas3 '09-05-2022','09-05-2022';

exec usp_buscafechas3 '05-09-2022','05-09-2022';*/


/*CREATE PROCEDURE usp_buscafechas
(@fecha1 as date,
@fecha2 as date)

as
select idventa, cliente,  (convert(varchar,convert(date,[fecha]),3)) as fecha,cantidad,precio,total
from [dbo].[VENTA]
where (convert(varchar,convert(date,[fecha]),3))    between (convert(varchar,(@fecha1),3)) and  (convert(varchar,(@fecha2),3))


exec usp_buscafechas '05-09-2022','03-10-2022';

exec usp_buscafechas '09-05-2022','09-05-2022'*/


 SET DATEFORMAT  DMY

CREATE PROCEDURE usp_buscafechas
(@fecha1 as DATE,
@fecha2 as DATE)
as
select idventa, cliente,  (convert(varchar,convert(date,[fecha]),3)) as fecha,cantidad,precio,total
from [dbo].[VENTA]
where (convert(date,[fecha]))   between   (convert(varchar,convert(date,@fecha1),3)) and   (convert(varchar,convert(date,@fecha2),3))  

exec usp_buscafechas '25-09-2022','30-10-2022';




-------------------------------

CREATE PROCEDURE usp_publicacion
(@descripcion VARCHAR(100))
as
select P.[idpublicacion],



P.[autor],
P.[nroedicion],
P.[precio],
P.[stock],
T.[descripcion]    
from  [dbo].[PUBLICACION] P INNER JOIN [dbo].[TIPO] T
ON  P.idtipo= T.idtipo 
where descripcion=@descripcion


CREATE PROCEDURE [dbo].[usp_publicacion]
(@descripcion VARCHAR(100))
as
select P.[idpublicacion],P.[titulo],P.[autor],
T.[descripcion]  
from  [dbo].[PUBLICACION] P INNER JOIN [dbo].[TIPO] T
ON  P.idtipo= T.idtipo
where descripcion=@descripcion





CREATE PROCEDURE usp_buscafechas2
  
(@fecha1 as DATE,
@fecha2 as DATE)
as

select idventa
from [dbo].[VENTA]
where (convert(varchar,convert(date,[fecha]),3))
between   (convert(varchar,convert(date,@fecha1),3)) 
and   (convert(varchar,convert(date,@fecha2),3))  


exec usp_buscafechas2 '25-09-2022','03-10-2022';





CREATE PROCEDURE usp_buscafechas3
(@fecha1 as DATE,
@fecha2 as DATE)
as
select idventa, cliente,  (convert(varchar,convert(date,[fecha]),3)) as fecha,cantidad,precio,total
from [dbo].[VENTA]
where (convert(date,[fecha]))   between   (convert(date,@fecha1)) and   (convert(date,@fecha1)) 


exec usp_buscafechas3 '09-25-2022','03-10-2022';


select idventa, cliente, (convert(varchar,convert(date,[fecha]),3)),cantidad,precio,total
from [dbo].[VENTA]
where fecha between '25/09/2022' + ' 00:00:00.000' and '30/09/2022' + ' 23:59:59.999'



CREATE PROCEDURE usp_buscafechas
(@fecha1 as DATETIME,
@fecha2 as DATETIME)
as
select idventa, cliente,   (convert(varchar,convert(date,[fecha]),3)) AS fecha,cantidad,precio,total
from [dbo].[VENTA]
where fecha between @fecha1 + ' 00:00:00.000' and @fecha2 + ' 23:59:59.999'


exec usp_buscafechas '25-09-2022','03-10-2022';


---------------------------------------------






CREATE PROCEDURE usp_prueba
@idempleado int 
if idempleado=@idempleado from empleados =
*********************************************************


CREATE PROCEDURE usp_venta
    (@idventa as int,
    @cliente as VARCHAR(150),
    @fecha as datetime,
    @idempleado as int,
    @idpublicacion as char(8),
    @cantidad  as int,
    @precio as money,
	@dcto as money,
	@subtotal  as money,
	@impuesto as money,
	@total as money)
AS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE

    INSERT INTO [dbo].[VENTA]
    VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta), @cliente, @fecha, @idempleado, @idpublicacion, @cantidad, @precio,
	@dcto ,	@subtotal,	@impuesto,	@total);					

END
GO


exec  usp_venta '','joel','2022-09-04 09:11:18.680',1,'SEP00002',8,20,50,1,30,45

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
 INSERT INTO [dbo].[VENTA]
    VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta),'joel',GETDATE(),1,'SEP00002',
8,20,50,1,30,45)



********************VALIDAR PUBLICACION***********************************

CREATE PROCEDURE usp_validarpubli
@idpublicacion as char(8)
as
SELECT COUNT(1) FILAS  FROM PUBLICACION WHERE idpublicacion=@idpublicacion

exec usp_validarpubli  "LIB00001";


********************VALIDAR STOCK***********************************

SELECT STOCK  FROM PUBLICACION WHERE idpublicacion='LIB00001'





********************LISTAR ULTIMA VENTA***********************************


select * from [dbo].[VENTA] where fecha = (select max(fecha) from VENTA)


create procedure usp_listarPublicaciones
    @idpublicacion varchar(2000) out,
	@titulo varchar(2000) out,
	@autor varchar(2000) out,
	@precio money out,






		CREATE procedure usp_listarultimaventa
		as
		select * from [dbo].[VENTA] where fecha = (select max(fecha) from VENTA) 


		exec usp_listarultimaventa