package Tarea3New;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Creacion {
	public static File raiz = new File(".\\src\\Tarea3New\\peliculas");
	public static File carpetaHDRip = new File (raiz + "\\HDRip");
	public static File carpetaMicroRip = new File (raiz + "\\MicroRip");
	public static File carpetaBDRip = new File (raiz + "\\BDRip");
	public static File carpetaUHD = new File (raiz + "\\UHD");
	public static ArrayList<String> lista = new ArrayList<String>();
	
	public void crear() {				
		//Comprueba que haya sido creada y en caso de que no procede a
		//crear las correspondientes carpetas y "peliculas"
		boolean creadoRaiz = raiz.mkdir();
		if (creadoRaiz) {
			//Mensaje de que ha sido creada la carpeta raíz correctamente
			System.out.println("Carpeta raíz creada correctamente");
			//Crea las diferentes carpetas
				carpetaHDRip.mkdir();
				System.out.println("Carpeta HDRip creada correctamente");
				
				carpetaMicroRip.mkdir();
				System.out.println("Carpeta MicroRip creada correctamente");
				
				carpetaBDRip.mkdir();
				System.out.println("Carpeta BDRip creada correctamente");
				
				carpetaUHD.mkdir();
				System.out.println("Carpeta UHD creada correctamente");
				
			//Bucle el cual mete 5 "peliculas" en cada carpeta
			for(int i = 0; i<=5; i++) {
				String nombrePeli = "Pelicula " + i;
				int numFecha = 2000 + i;
				String  fecha = "("+numFecha+")";
				File pelisHDRip = new File(carpetaHDRip + "\\" + nombrePeli + " " + fecha + ".mkv");
				File pelisMicroRip = new File(carpetaMicroRip + "\\" + nombrePeli + " " + fecha + ".mp4");
				File pelisBDRip = new File(carpetaBDRip + "\\" + nombrePeli + " " + fecha + ".mp4");
				File pelisUHD = new File(carpetaUHD + "\\" + nombrePeli + " " + fecha + ".mkv");
				try {
					pelisHDRip.createNewFile();
					pelisMicroRip.createNewFile();
					pelisBDRip.createNewFile();
					pelisUHD.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Peliculas creadas correctamente en las correspondientes carpetas");
		}else if (raiz.isDirectory()) {
			System.out.println("La carpeta ya ha sido creada");
		}else {
			System.out.println("No se ha podido crear la carpeta raíz de películas");
		}
	}
}
