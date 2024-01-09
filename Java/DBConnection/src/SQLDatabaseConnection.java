import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    public static Connection Connect() {
        
        Connection Conn = null;

        //Conexion Omar
        String connectionUrl =
                "jdbc:sqlserver://192.168.10.50;"
                + "database=SAYTO_WMS;"
                + "user=sa;"
                + "password=DataWare23;"
                + "encrypt=false";
        
        //Conexion Kimy
        /*String connectionUrl =
                "jdbc:sqlserver://192.168.100.23\\SQL22;"
                + "database=Proyecto;"
                + "user=sa;"
                + "password=jajaxdxd13;"
                + "encrypt=true;"
                + "TrustServerCertificate=True;";*/

        //ResultSet resultSet = null;

        try  {

            Conn = DriverManager.getConnection(connectionUrl);
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Conn;
    }

    public static Connection releaseConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
