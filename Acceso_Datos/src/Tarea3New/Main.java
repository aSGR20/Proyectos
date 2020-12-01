package Tarea3New;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//Creacion fichero = new Creacion();
		//fichero.crear();
		Lectura pelicula = new Lectura();
		pelicula.leer();
		try {
			pelicula.escribir();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
