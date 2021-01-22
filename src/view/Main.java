package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBSingleton;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {			
			
			conexion = DBSingleton.getInstance();
			
			s = conexion.createStatement(); 
			rs = s.executeQuery("select * from medicos limit 20");
			
			while (rs.next()){
				System.out.println (rs.getString("dni") + " " + rs.getString(2)+ " " + rs.getString(3)); 
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {			
			if (s != null)
				s.close();
			
			if (rs != null)
				rs.close();
			
			if (conexion != null)
				conexion.close();
		}
	}

}
