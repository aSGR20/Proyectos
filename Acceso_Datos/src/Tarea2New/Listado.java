package Tarea2New;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Listado {
	Centro centro;
	public ArrayList<String> linea = new ArrayList<>();
	private String ruta = ".\\src\\Tarea2New\\listado_centros.txt";
	
	/**
	 * Lee las lineas y las metete en un ArrayList
	 * @throws IOException
	 */
	public void leerLineas() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		while(br.ready()) {
			linea.add(br.readLine());
		}
		br.close();
	}
	
	/**
	 * Divide cada una de las lineas del anterior ArrayList
	 */
	public void dividirLinea() {
			centro = new Centro(linea);
	}
	
	/**
	 * Crea el fichero binario y añade cada apartado
	 */
	public void creacionFichero() {
		try {
			FileOutputStream fos = new FileOutputStream(".\\src\\Tarea2New\\lista.dat");
			DataOutputStream salida = new DataOutputStream(fos);
			try {
				for(int i = 0; i < centro.getCentros().size(); i++) {
					salida.writeUTF(centro.getCentros().get(i));
					salida.writeUTF("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
