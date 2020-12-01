package Tarea2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private Centro centro;
	static int contador;

	public static void main(String[] args) {
		try {
			leerFichero();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lee el fichero y la clase Centro
	 * la cual se encarga de pasarlo a un fichero 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void leerFichero() throws FileNotFoundException, IOException {
		//ArrayList<String> linea = new ArrayList<>();
		String linea = null;
		try(BufferedReader br = new BufferedReader(new FileReader(".\\src\\Tarea2\\listado_centros.txt"))){
			while(br.ready()) {
				//linea.add(br.readLine());
				linea = br.readLine();
				Centro centro = new Centro(linea);
			}
		}
	}
}
