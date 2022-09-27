package co.edu.unbosque.controller;

import co.edu.unbosque.view.ViewVentana;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Bm;

public class Controller {

	String txt2;
	List<Integer> resultado = new ArrayList<Integer>();// Array de los resultados
	private ViewVentana vista;
	private Bm bm = new Bm();
	int data = -1;
	public Scanner sc = new Scanner(System.in);

	public Controller() throws IOException {

		vista = new ViewVentana();
		File doc = new File("Txt1.txt");
		BufferedReader obj = new BufferedReader(new FileReader(doc));

		String menu1 = " ";

		menu1 = "Que algoritmo desea utilizar \n" + "1) Bm \n" + "2) KMP \n";

		int opcion = vista.Leerdato(menu1);
		if (opcion > 0 && opcion <= 1) {
			String txt;
			while ((txt = obj.readLine()) != null) {
				txt2 = txt;

				vista.mostrarInformacion("*EL TXT ES EL SIGUIENTE* \n"
						+ " ----------------------------------------------- " + "\n" + txt);

			}

			String menu2 = " ";

			menu2 = "Digite la palabra que quiere buscar";
			String busqueda = vista.LeerdatoTexto(menu2);
			bm.search(txt2, busqueda);
			vista.mostrarInformacion("La cantidad de similitudes son: " + bm.getContador() +"\n"+ " La ubicacion de las similitudes son: \n" + bm.search(txt2, busqueda));
			
			
			
//			String texto = "<html><b>Jorgesys</b> ,es su turno, con la ficha <b>1</b></html>";
//			JLabel label = new JLabel(texto);
//			label.setFont(new Font("TimesRoman", Font.PLAIN, 16));
//			JOptionPane.showMessageDialog(null, label);  
			
			resultado = bm.search(txt2, busqueda);
		

			for(int i = 0; i < resultado.get(0) + busqueda.length()-1; i++) {
				
				
			}	
				
			
			
			
			
			
			
			// bm.search(txt, busqueda);

		} else if (opcion > 1 && opcion <= 2) {
			String txt;
			while ((txt = obj.readLine()) != null)
				vista.mostrarInformacion(txt);
			while (data != 4) {
				String menu = " ";

				menu = "que tarea desea realizar con KMP \n" + "1) Contar similitudes \n"
						+ "2) Ver si hay coincidencias \n" + "3) Ambas acciones \n" + "4) salir";
				// data = sc.nextInt();
				data = vista.Leerdato(menu);
				// int opcion = vista.Leerdato(menu);
				switch (data) {

				case 1:

					Contar();

					break;
				case 2:

					break;
				case 3:

					break;

				case 4:

					vista.mostrarInformacion("fin");

					break;

				default:
					System.out.println("Número no reconocido");
					break;
				}

				System.out.println("\n");
			}
		}
	}

	public void Contar() {

		String text = "hola mundo";
		String pattern = "mundo";

		System.out.print(bm.search(text, pattern));

	}

}
