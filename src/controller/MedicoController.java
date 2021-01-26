package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MedicoController extends Controller implements ActionListener {

	JTextField txtRespuesta;
	
	public MedicoController(JTextField txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object fuente = e.getSource();
		String comando = e.getActionCommand();
		
		//if (fuente == btnMedico) {
		if (comando.equals("exportMedico")) {
			//System.out.println("Exportado médicos");
			txtRespuesta.setText("Médicos");
		} else if (comando.equals("exportEnfermero")) {
			//System.out.println("Exportado enfermero");
			txtRespuesta.setText("Enfermeros");
		}
	}

}
