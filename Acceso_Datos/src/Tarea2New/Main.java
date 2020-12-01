package Tarea2New;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Listado centro = new Listado();
		centro.leerLineas();
		centro.dividirLinea();
		centro.creacionFichero();
	}
}
