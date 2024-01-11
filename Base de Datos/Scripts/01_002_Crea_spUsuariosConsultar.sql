IF EXISTS(SELECT TOP 1 1 FROM SYSOBJECTS WHERE NAME = 'spUsuariosConsultar')
BEGIN
DROP PROCEDURE [dbo].[spUsuariosConsultar]
END
GO
-- =============================================
-- Author:		Kimberly Beltran
-- Create date:	09/01/2024
-- Description:	Crear spUsuariosConsultar
-- =============================================

CREATE PROCEDURE [dbo].[spUsuariosConsultar]
AS 
BEGIN
    SELECT Usuario, Nombre
	FROM Usuarios
END