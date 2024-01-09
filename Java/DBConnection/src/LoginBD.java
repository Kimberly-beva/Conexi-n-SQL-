import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
public class LoginBD {

    public static String Login(String Usuario, String Password) {
        Connection connection = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        String vRespuesta = "";
        try{
            connection = SQLDatabaseConnection.Connect();
            if (connection != null){
                String sp = "{call dbo.spSesionIniciar(?,?)}";
                callableStatement = connection.prepareCall(sp);
                callableStatement.setString(1, Usuario);
                callableStatement.setString(2, Password);
                resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    if (resultSet.getString("Resultado").equals("OK")){
                        vRespuesta = "OK";
                    }
                    else if (resultSet.getString("Resultado").equals("NO EXISTE")){
                        vRespuesta = "Usuario no existe en la base de datos";
                    }
                    else if (resultSet.getString("Resultado").equals("DATOS INCORRECTOS")){
                        vRespuesta = "El usuario y contraseña no coinciden, favor de verificar los datos ingresados";
                    }
                    else{
                        vRespuesta = "ERROR";
                    }
                }
                SQLDatabaseConnection.releaseConnection(connection);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
                
        return vRespuesta;
    }
}
