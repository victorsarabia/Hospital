package utils;
import java.sql.*;

public class DBSingleton {
	/**
     * Conexión única de BD
     */
    private static Connection conn = null;
    /**
     * Driver de conexión a BD
     */
    private String driver;
    /**
     * URL de conexión a BD
     */
    private String url;
    /**
     * Usuario de BD
     */
    private String usuario;
    /**
     * Clave de BD
     */
    private String password;
	 
    /**
     * Constructor
     * Inicializa parámetros de conexión y crea la conexión
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private DBSingleton() throws ClassNotFoundException, SQLException {
	 
		String url = "jdbc:mariadb://localhost:3306/hospital";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "root";
		String password = "";
  
		Class.forName(driver);
		conn = DriverManager.getConnection(url, usuario, password);			
    }
	 
    /**
     * Obtiene la conexión, si no existe la crea.
     * 
     * @return Conexión creada
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public static Connection getInstance() throws ClassNotFoundException, SQLException {	  
		if (conn == null){
			new DBSingleton();
		}
	  
		return conn;
	}
}
