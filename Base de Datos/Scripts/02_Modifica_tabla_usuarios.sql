INSERT INTO Usuarios (Usuario, Nombre, Password, FechaActualizado)
SELECT 'admin', 'admin', 'admin', GETDATE()