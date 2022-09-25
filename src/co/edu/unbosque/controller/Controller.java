package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.Bm;

public class Controller {

	private Bm bm = new Bm();
	int data = -1;
	public Scanner sc = new Scanner(System.in);

	public Controller() {

		while (data != 4) {


				System.out.println("que tarea desea realizar \n" + "1) Contar similitudes \n"
						+ "2) Ver si hay coincidencias \n" + "3) Ambas acciones \n" + "4) salir");
				data = sc.nextInt();

				switch (data) {

				case 1:

					Contar();

					break;
				case 2:

					break;
				case 3:

					break;

				case 4:

					System.out.println("fin");

					break;

				default:
					System.out.println("Número no reconocido");
					break;
				}

				System.out.println("\n");

			}
		}


	public void Contar() {
		
		String text = "hola mundo";
		String pattern = "mundo";

		System.out.print(bm.search(text, pattern));
		
	}

}
