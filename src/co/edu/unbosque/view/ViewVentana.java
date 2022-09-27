package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class ViewVentana {

	public ViewVentana() {

	}

	public int Leerdato(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int dato = Integer.parseInt(aux);
		return dato;
	}

	public void mostrarInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public String LeerdatoTexto(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		
		return aux;
}
}