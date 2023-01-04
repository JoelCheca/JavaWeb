

-----------------BUSQUEDA PUBLICACION--------------------


CREATE PROCEDURE [dbo].[usp_publicacion]
(@descripcion VARCHAR(100))
as
select P.[idpublicacion],P.titulo,P.autor,P.nroedicion,P.precio,P.stock,
T.[descripcion]  from  [dbo].[PUBLICACION] P INNER JOIN [dbo].[TIPO] T
ON  P.idtipo= T.idtipo
where descripcion=@descripcion


exec usp_publicacion  'REVISTA';


-----------------BUSQUEDA FECHAS --------------------

/*CREATE PROCEDURE usp_buscafechas
(@fecha1 as DATETIME,
@fecha2 as DATETIME)
as
select idventa, cliente,   (convert(varchar,convert(date,[fecha]),3)) AS fecha,cantidad,precio,total
from [dbo].[VENTA]
where fecha between @fecha1 + ' 00:00:00.000' and @fecha2 + ' 23:59:59.999'


exec usp_buscafechas '25-09-2022','03-10-2022';*/


CREATE PROCEDURE usp_buscafechas
(@fecha1 as DATE,
@fecha2 as DATE)
as
select idventa, cliente,  (convert(varchar,convert(date,[fecha]),3)) as fecha,cantidad,precio,total
from [dbo].[VENTA]
where (convert(date,[fecha]))   between   (convert(varchar,convert(date,@fecha1),3)) and   (convert(varchar,convert(date,@fecha2),3))  
GO
exec usp_buscafechas '25-09-2022','30-10-2022';





-----------------REGISTRAR FECHAS --------------------


CREATE PROCEDURE usp_venta1    
 (@cliente as VARCHAR(150),
  @idempleado as int,
  @idpublicacion as char(8),
  @cantidad  as int,
  @estado int out,
 @mensaje varchar(2000) out)
  as   
begin
	DECLARE 
	@precio as money, 
	 @total as money,
	 @impuesto as money,
	@subtotal as money,
	 @dcto as money;
	set @estado = 0;
	set @mensaje = 'Proceso ejecutado correctamente.';
	BEGIN TRY 
		-- Inicio de Tx
		BEGIN TRANSACTION

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
		set @estado = 1;
		set @mensaje ='NO HAY STOCK';
		PRINT @mensaje
	END

	COMMIT TRANSACTION; 
	END TRY 
	BEGIN CATCH 
		if( @estado=0 )
		begin
			set @estado = 1;
			set @mensaje = 'Error en el proceso.';
		end;
		ROLLBACK TRANSACTION;
	END CATCH;
end;
go


declare @estado int, @mensaje varchar(2000);
exec  usp_venta1 'MARIAJOSE portilla','2','LIB00005',5, @estado out, @mensaje out;





-----------------MODIFICAR PRECIO --------------------
CREATE PROCEDURE usp_modificarprecio1   
 (@precio as money,
	@idpublicacion as char(8),
  @estado int out,
	@mensaje varchar(2000) out)
  as  
begin
set @estado = 0;
set @mensaje = 'Proceso ejecutado correctamente.';
	
	BEGIN TRY 
	UPDATE PUBLICACION SET precio = @precio WHERE idpublicacion = @idpublicacion
	select * from PUBLICACION
    END TRY 

	BEGIN CATCH 
		if( @estado=0 )
		begin
			set @estado = 1;
			set @mensaje = 'Error en el proceso.';
		end;
		ROLLBACK TRANSACTION;
	END CATCH;
end;
go

 declare @estado int, @mensaje varchar(2000);
 exec  usp_modificarprecio1    55, "LIB00005", @estado out, @mensaje out;







	-----------------listar venta --------------------




	create procedure usp_listarPublicaciones
    @idpublicacion varchar(2000) out,
	@titulo varchar(2000) out,
	@autor varchar(2000) out,
	@precio money out,
    as
	select idpublicacion,titulo,autor,precio from PUBLICACION





	-----------------listar venta --------------------




	create procedure usp_listar
	







	select * from VENTA


	EXEC  calcular 'LIB00001'

ALTER  PROCEDURE calcular   
 ( @idpublicacion as char(8),
  @cantidad  as int,
   @total as money out,
	 @impuesto as money out ,
	@subtotal as money out ,
	 @dcto as money out )
  as   

	DECLARE 
	@precio as money 
	set @precio=0;
		set @dcto=0;
		set @total=0;
		set @subtotal=0;
		set @impuesto=0;

		begin

		set @precio=( SELECT PRECIO FROM [dbo].[PUBLICACION] WHERE idpublicacion =@idpublicacion )
		set @dcto=((SELECT [porcentaje] FROM [dbo].[PROMOCION] WHERE  @cantidad  between  [cantmin] AND [cantmax] )*@precio)
		set @total=((@precio*@cantidad)-(@dcto*@cantidad))
		set @subtotal=(@total/1.18)
		set @impuesto=(@subtotal*0.18)


		end