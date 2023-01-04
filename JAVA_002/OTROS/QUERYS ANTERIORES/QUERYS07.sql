
CREATE PROCEDURE usp_venta    
 (@cliente as VARCHAR(150),
  @idempleado as int,
  @idpublicacion as char(8),
  @cantidad  as int)
  as 
declare  
 @precio as money, 
 @total as money,
 @impuesto as money,
 @subtotal as money,
 @dcto as money,
 @mensaje as varchar(15)

set @precio=( SELECT PRECIO FROM [dbo].[PUBLICACION] WHERE idpublicacion =@idpublicacion )
set @dcto=((SELECT [porcentaje] FROM [dbo].[PROMOCION] WHERE  @cantidad  between  [cantmin] AND [cantmax] )*@precio)
set @total=((@precio*@cantidad)-(@dcto*@cantidad))
set @subtotal=(@total/1.18)
set @impuesto=(@subtotal*0.18)

if  (select stock from publicacion where idpublicacion=@idpublicacion)>=@cantidad	
	BEGIN
		 INSERT INTO [dbo].[VENTA]  VALUES ((SELECT ISNULL(max(idventa),0)+1 FROM venta), @cliente, GETDATE(),
		 @idempleado, @idpublicacion, @cantidad, @precio, @dcto ,	@subtotal,	@impuesto,	@total)	

		SELECT * from [dbo].[VENTA] where fecha = (select max(fecha) from VENTA)
		UPDATE PUBLICACION SET stock = stock - @cantidad WHERE idpublicacion = @idpublicacion 
		set @mensaje ='REGISTRO CORRECTO'
		PRINT @mensaje
	END
ELSE
	BEGIN
		set @mensaje ='NO HAY STOCK'
		PRINT @mensaje
	END


exec  usp_venta 'MARIAJOSE','2','LIB00005',100









select * from [dbo].[VENTA] where fecha = (select max(fecha) from VENTA) 
	


exec  usp_venta 'juankkkkito','2','LIB00003',20


select * from [dbo].[VENTA] where fecha = (select max(fecha) from VENTA)







	CREATE PROCEDURE usp_modificarprecio 
	(@precio as money,
	@idpublicacion as char(8))
	as	
	UPDATE PUBLICACION SET precio = @precio WHERE idpublicacion = @idpublicacion

	exec usp_modificarprecio  53,'LIB00003'