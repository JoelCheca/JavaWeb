use bookstore
GO
-- Validar Login
CREATE procedure [dbo].[usp_logon](
	@usuario varchar(15),
	@clave varchar(15),
	@estado int out
) as
begin
	declare @cont int;
	select @cont = count(1)	from USUARIO
		where usuario=@usuario and clave=@clave
		and activo=1;

	set @estado = iif(@cont=1,1,-1);
end;
GO

-- Validar Tipo Publicaciones
CREATE PROCEDURE [dbo].[usp_publicacion]
(@descripcion VARCHAR(100))
as
select P.[idpublicacion],P.titulo,P.autor,P.nroedicion,P.precio,P.stock,
T.[descripcion]  from  [dbo].[PUBLICACION] P INNER JOIN [dbo].[TIPO] T
ON  P.idtipo= T.idtipo
where descripcion=@descripcion
GO

--Cargar Combo tipo publicaciones
CREATE procedure [dbo].[usp_comboTipoPublicaciones]
		as
		select      descripcion    from TIPO
GO


-- Ventas
CREATE PROCEDURE [dbo].[usp_venta2]    
 (@cliente as VARCHAR(150),
   @idempleado  as varchar(20),
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
	set  @idempleado  =( select [idempleado] from [dbo].[USUARIO] where [usuario]= @idempleado  );
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
		set @mensaje ='NO HAY STOCK ';
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
GO

-- Cargar publicaciones por tipo
CREATE procedure  [dbo].[usp_tipoPublicacion]
@tipo  varchar(100)
as
SELECT    P.[idpublicacion], P.[titulo]   

FROM [dbo].[PUBLICACION]  P INNER JOIN TIPO T
ON P.[idtipo]=T.[idtipo]
WHERE [descripcion]=@tipo
GO


-- Traer precio
CREATE procedure [dbo].[usp_traerPrecio]
	@idpublicacion as char(8)
as
		select	[precio] from [dbo].[PUBLICACION] where [idpublicacion]=@idpublicacion
GO


-- Las ultimas 10 ventas
CREATE procedure  [dbo].[usp_ultimasventas]
as
SELECT TOP 10   cliente,fecha,idpublicacion,cantidad,precio,
dcto,subtotal,impuesto,total
FROM venta ORDER BY   fecha  desc
GO


-- Combo Publicacion
CREATE  procedure [dbo].[usp_comboPublicaciones]
		as
		select idpublicacion, titulo      from PUBLICACION
GO


-- Modificar Precio
CREATE PROCEDURE [dbo].[usp_modificarprecio1]   
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
GO

-- Listar publicaciones con precio
CREATE procedure [dbo].[usp_listarPublicaciones]
	as
	select idpublicacion,titulo,autor, precio from PUBLICACION
GO

-- Buscar fechas
CREATE  PROCEDURE [dbo].[usp_buscafechas]
(@fecha1 as DATE,
@fecha2 as DATE)
as
select idventa, cliente,fecha,
cantidad,precio,dcto,subtotal,impuesto,total
from [dbo].[VENTA]
where convert(date,fecha) between @fecha1 and @fecha2
GO
