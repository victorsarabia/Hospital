package model;

import java.sql.SQLException;

public class CitaModel extends Model {

	public CitaModel() throws ClassNotFoundException, SQLException {
		super();
		initResultSet();
	}
	
	private void initResultSet() throws SQLException {
		rs = s.executeQuery("select * from citas limit 20");
	}

}
