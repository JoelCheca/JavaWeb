

********************VALIDACIONES********************************************

********************VALIDAR PUBLICACION***********************************


CREATE PROCEDURE usp_validarpubli
@idpublicacion as char(8)
as
SELECT COUNT(1) FILAS  FROM PUBLICACION WHERE idpublicacion=@idpublicacion

exec usp_validarpubli  "LIB00001";


********************VALIDAR STOCK***********************************

CREATE PROCEDURE usp_validarstock
@idpublicacion as char(8)
as
SELECT STOCK  FROM PUBLICACION WHERE idpublicacion=@idpublicacion

exec usp_validarstock  "LIB00001";


********************VALIDAR PRECIO***********************************

CREATE PROCEDURE usp_validarprecio
@idpublicacion as char(8),
@precio  as money
as
SELECT COUNT(1) FILAS FROM PUBLICACION WHERE   idpublicacion=@idpublicacion and precio=@precio

exec usp_validarprecio  "LIB00001", 50.0000;



********************REGISTRAR VENTA***********************************

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




********************APLICAR PROMOCION***********************************
CREATE PROCEDURE usp_aplicarpromocion
@cantidad as int
as
SELECT [porcentaje] FROM [dbo].[PROMOCION]
WHERE  @cantidad  between  [cantmin] AND [cantmax] 

exec usp_aplicarpromocion  50;


********************GENERAR ID VENTA***********************************
CREATE PROCEDURE usp_generarid
as
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
SELECT ISNULL(max(idventa),0)+1 as idpublicacion FROM venta

exec usp_generarid

********************GENERAR ID EMPLEADO***********************************

CREATE PROCEDURE usp_generaridempleado
@usuario as varchar(20)
as
select [idempleado] as  idempleado from [dbo].[USUARIO] where [usuario]=@usuario


exec usp_generaridempleado 'eaguero'

********************RESTAR DEL STOCK***********************************


CREATE PROCEDURE usp_restarstock
    (@stock as int,
	@idpublicacion  as char(8))
	as
 UPDATE PUBLICACION SET stock = stock - @stock WHERE idpublicacion = @idpublicacion 

 exec usp_restarstock 100, 'LIB00001';


 ********************GENERAR PRECIO***********************************

 CREATE PROCEDURE usp_generarprecio
 @idpublicacion as char(8)
 as
 SELECT PRECIO FROM [dbo].[PUBLICACION] WHERE idpublicacion =@idpublicacion 

  exec usp_generarprecio 'LIB00001';




  ******************************************************************

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
    VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta), @cliente, GETDATE(),
	@idempleado, @idpublicacion, @cantidad, @precio,
	@dcto ,	@subtotal,	@impuesto,	@total);					

END
GO


exec  usp_venta '','joel','',1,'SEP00002',8,20,50,1,30,45



declare @stock int
set @stock = 100
if @stock < (select stock from publicacion where idpublicacion='LIB00001')
		  INSERT INTO [dbo].[VENTA]
    VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta), @cliente, GETDATE(),
	@idempleado, @idpublicacion, @cantidad, @precio,
	@dcto ,	@subtotal,	@impuesto,	@total);	




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
	@total as money
	)
AS 
if  (select stock from publicacion where idpublicacion='SEP00002')>=@cantidad
   INSERT INTO [dbo].[VENTA]
    VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta), @cliente, GETDATE(),
	@idempleado, @idpublicacion, @cantidad, @precio,
	@dcto ,	@subtotal,	@impuesto,	@total);

else 
print 'no hay stock'



exec  usp_venta '','joel','',1,'SEP00002',8,20,50,1,30,45