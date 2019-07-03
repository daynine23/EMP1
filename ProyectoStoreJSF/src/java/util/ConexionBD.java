
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConexionBD {
    
    public static Connection getConnection(){
        Connection cnn = null;
        /*String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store?useSSL=false";
        String usu = "root";
        String pas = "";*/
        try {
            //cargar el driver JDBC
            //Class.forName(driver);
            //Conexion a la BD
            //cnn = (Connection) DriverManager.getConnection(url, usu, pas);
            //System.out.println("Conexion OK");
            
            //USAMDP DATASOURCE - POOL DE CONEXIONES
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/StoreDS");
            cnn = ds.getConnection();
            
        }   catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return cnn;
    }
    
    public static void close(Connection cnn) {
        try{
            if(cnn != null)
                cnn.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void close(Statement stm) {
        try{
            if(stm != null)
                stm.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void close(ResultSet rs) {
        try{
            if(rs != null)
                rs.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
