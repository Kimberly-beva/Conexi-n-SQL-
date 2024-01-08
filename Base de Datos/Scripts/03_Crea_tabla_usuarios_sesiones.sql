CREATE TABLE UsuarioSesiones(
	IdSesion INT IDENTITY(1,1)
	, Modulo VARCHAR(30) NOT NULL
	, FechaInicio DATETIME NOT NULL
	, FechaFin DATETIME NULL
	, IdUsuario INT NOT NULL
)

CREATE UNIQUE CLUSTERED INDEX CIX_UsuarioSesiones ON dbo.UsuarioSesiones(IdSesion)
