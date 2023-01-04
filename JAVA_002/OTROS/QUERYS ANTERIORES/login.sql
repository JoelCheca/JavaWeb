

create procedure usp_logon(
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
go

select * from [dbo].[USUARIO]

declare @estado int;
exec usp_logon 'eaguero', 'cazador', @estado out;
print @estado
go