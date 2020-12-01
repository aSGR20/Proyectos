package Tarea3New;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lectura {
	Peliculas pelicula;
	File raiz = new File(".\\src\\Tarea3New\\peliculas");
	String[]lista = raiz.list();
	ArrayList<String>lineaPeliculas = new ArrayList<>();
	ArrayList<String>carpetaPeliculas = new ArrayList<>();
	
	public void leer() {
		if(lista == null || lista.length == 0) {
			System.out.println("No hay carpetas");
		}else {
			for(int i = 0; i < lista.length; i++) {
				//System.out.println(lista[i]);
				carpetaPeliculas.add(lista[i]);
				File carpeta = new File(".\\src\\Tarea3New\\peliculas\\" + lista[i]);
				String[]listado = carpeta.list();
				for(int k = 0; k < listado.length; k++) {
					lineaPeliculas.add(listado[k]);
				}
			}
		}
	}
	
	public void escribir() throws IOException {
		pelicula = new Peliculas(lineaPeliculas, carpetaPeliculas);
		FileWriter fichero = new FileWriter(".\\src\\Tarea3New\\peliculas.txt");
			for(int i = 0; i < pelicula.getPeliculas().size(); i++) {
				fichero.write(pelicula.getPeliculas().get(i));
		}
			fichero.close();
	}
}
