package view;

import java.sql.SQLException;

import model.EnfermeroModel;
import model.MedicoModel;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		try {
			
			MedicoModel medico = new MedicoModel();
			medico.showResult();
			
			EnfermeroModel enfermero = new EnfermeroModel();
			enfermero.showResult();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
