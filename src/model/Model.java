package model;

import java.sql.*;

import utils.DBSingleton;

public class Model {

	Connection conexion = null;
	Statement s = null;
	ResultSet rs = null;
	
	public Model() throws ClassNotFoundException, SQLException {
		conexion = DBSingleton.getInstance();
		s = conexion.createStatement(); 
		
	}
	
	public void exportCSV() {
		
	}
	
	
	
}
