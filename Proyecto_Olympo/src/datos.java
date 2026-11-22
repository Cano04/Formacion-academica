import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @joseangelcastillocenobio
 */
public class datos {
    private final String user;
    private final String password;
    private final String url;
    private final String driverClassName;
    private Connection conn = null;
    private Statement stmt;

    //Método para definir las variables de conexión a la base de datos
    public datos() {
            //usuario de mysql
            this.user = "root";
            //password de mysql
            this.password = "olaqace0307";
            //ruta de la base de datos
            this.url = "jdbc:mysql://localhost/olimpo?serverTimezone=UTC";
            //nombre del controlador de mysql según la versión
            this.driverClassName = "com.mysql.jdbc.Driver"; // driver
    }
//Método para establecer la conexión a la base de datos
    public void conectar() throws SQLException {
            try {
                    Class.forName(this.driverClassName).newInstance();
                    this.conn = DriverManager.getConnection(this.url, this.user,
                                    this.password);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException err) {
                    System.out.println("Error " + err.getMessage());
            }
    }
    //Método para realizar consultas a la base de datos
    public ResultSet obtenerDatos(String sql) throws SQLException {

            this.stmt = conn.createStatement();
            return this.stmt.executeQuery(sql);
    }
    //Método para realizar cualquier operación de actualización, inserción y eliminación de datos en la BD
    public void actualizar(String sql) throws SQLException {
            this.stmt = conn.createStatement();
            stmt.executeUpdate(sql);
    }
    //Método para cerrar la Base de Datos
    public void Off() throws SQLException {
            this.conn.close();

}
}