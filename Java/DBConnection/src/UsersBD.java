import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersBD {

    public static ArrayList<Users> GetUsers() {
        Users users;
        Connection connection = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        ArrayList<Users> lista = new ArrayList<>();
        try{
            connection = SQLDatabaseConnection.Connect();
            if (connection != null){
                String sp = "{call dbo.spUsuariosConsultar}";
                callableStatement = connection.prepareCall(sp);
                //callableStatement.setString(1, Usuario);
                //callableStatement.setString(2, Password);
                resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    users = new Users();
                    users.setUsuario(resultSet.getString("Usuario"));
                    users.setNombre(resultSet.getString("Nombre"));
                    lista.add(users);
                }
                SQLDatabaseConnection.releaseConnection(connection);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
                
        return lista;
    }

    public static String AddUser(String user, String pass, String name) {
        String vRespuesta = "";
        Connection connection = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
     
        try{
            connection = SQLDatabaseConnection.Connect();
            if (connection != null){
                String sp = "{call dbo.spUsuariosAgregar(?,?,?)}";
                callableStatement = connection.prepareCall(sp);
                callableStatement.setString(1, user);
                callableStatement.setString(2, name);
                callableStatement.setString(3, pass);
                resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                   vRespuesta=resultSet.getString("Resultado");
                }
                SQLDatabaseConnection.releaseConnection(connection);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
                
        return vRespuesta;
    }

}
