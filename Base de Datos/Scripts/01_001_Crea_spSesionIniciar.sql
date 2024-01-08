IF EXISTS(SELECT TOP 1 1 FROM SYSOBJECTS WHERE NAME = 'spSesionIniciar')
BEGIN
DROP PROCEDURE [dbo].[spSesionIniciar]
END
GO
-- =============================================
-- Author:		Kimberly Beltran
-- Create date:	04/01/2024
-- Description:	Crear spSesionIniciar
-- =============================================

CREATE PROCEDURE [dbo].[spSesionIniciar]
@pUsuario VARCHAR(30),
@pPassword VARCHAR(30)
AS 
BEGIN
    --INICIO DE CODIGO
	
	IF EXISTS (SELECT TOP 1 1 FROM Usuarios WHERE Usuario = @pUsuario)
	BEGIN
		IF EXISTS (SELECT TOP 1 1 FROM Usuarios WHERE Usuario = @pUsuario AND Password = @pPassword )
		BEGIN 
			SELECT 'OK' AS RESULTADO
		END
		ELSE 
		BEGIN 
			SELECT 'DATOS INCORRECTOS' AS RESULTADO
		END
	END
	ELSE
	BEGIN 
		SELECT 'NO EXISTE' AS RESULTADO
		END

END