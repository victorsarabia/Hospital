package model;

import java.sql.SQLException;

public class MedicoModel extends Model {

	public MedicoModel() throws ClassNotFoundException, SQLException {
		super();
		initResultSet();
	}

	private void initResultSet() throws SQLException {
		rs = s.executeQuery("select * from medicos limit 20");
	}
	
	public void showResult() throws SQLException {
		while (rs.next()){
			System.out.println (rs.getString("dni") + " " + rs.getString(2)+ " " + rs.getString(3)); 
		}
	}
	
	public void find() {
	}
}
