package model;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
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

	public void exportCSV(String ruta) throws SQLException {
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		int num_columns = resultSetMetaData.getColumnCount();

		Path path = Paths.get(ruta);
		try (BufferedWriter br = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)) {
			String cabeceras = "";
			for (int i = 1; i <= num_columns; i++) {
				cabeceras += "\"" + resultSetMetaData.getColumnName(i) + "\"";
				if (i!=num_columns) {
					cabeceras += ",";
				}
			}
			br.write(cabeceras);
			br.newLine();
			while (rs.next()) {
				String line = "";
				for (int i = 1; i <= num_columns; i++) {
					line += "\"" + (rs.getString(i)!=null?rs.getString(i):"") + "\"";
					if (i!=num_columns) {
						line += ",";
					}
				}
				br.write(line);
				br.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
