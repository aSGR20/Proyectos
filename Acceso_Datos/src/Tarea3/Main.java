package Tarea3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static File raiz = new File(".\\src\\Tarea3\\peliculas");
	public static File carpetaHDRip = new File (raiz + "\\HDRip");
	public static File carpetaMicroRip = new File (raiz + "\\MicroRip");
	public static File carpetaBDRip = new File (raiz + "\\BDRip");
	public static File carpetaUHD = new File (raiz + "\\UHD");
	public static ArrayList<String> lista = new ArrayList<String>();

	public static void main(String[] args) {
		creaciones();
		leerRaiz();	
		//escribirPeliculas();
	}
	
	/**
	 * Crea las carpetas y peliculas
	 * en el src del proyecto
	 */
	public static void creaciones() {				
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
	
	/**
	 * Lee las carpetas de la carpeta
	 * raíz llamada "peliculas" y guarda las "películas"
	 */
	public static void leerRaiz() {
		Peliculas datos;
		String[] carpetasRaiz = raiz.list();
		ArrayList<Peliculas>pelis = new ArrayList<Peliculas>();
		for (int i = 0; i < carpetasRaiz.length;i++) {
			if (carpetasRaiz[i].contains(".")) {
				
			}else {
				//Peliculas calidad = new Peliculas(carpetasRaiz[i]);
				
				if(carpetasRaiz[i].equals("HDRip")) {
					String[] peliculas = carpetaHDRip.list();
					for(int j = 0; j < peliculas.length; j++) {
						datos = new Peliculas(peliculas[j], carpetasRaiz[i]);
					}
				}else if(carpetasRaiz[i].equals("BDRip")) {
					String[] peliculas = carpetaBDRip.list();
					for(int j = 0; j < peliculas.length; j++) {
						datos = new Peliculas(peliculas[j], carpetasRaiz[i]);
					}
				}else if(carpetasRaiz[i].equals("MicroRip")) {
					String[] peliculas = carpetaMicroRip.list();
					for(int j = 0; j < peliculas.length; j++) {
						datos = new Peliculas(peliculas[j], carpetasRaiz[i]);
					}
				}else if(carpetasRaiz[i].equals("UHD")) {
					String[] peliculas = carpetaUHD.list();
					for(int j = 0; j < peliculas.length; j++) {
						datos = new Peliculas(peliculas[j], carpetasRaiz[i]);
					}
				}
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(raiz + ".csv"));
			String[] carpetasRaiz1 = raiz.list();
			bw.write("NOMBRE; FECHA; CALIDAD; TIPO"+"\n");
			for(int i = 0; i < carpetasRaiz1.length; i++) {
				//System.out.println(datos.serializar());
				bw.write("");
			}
		}catch(IOException io) {
			io.printStackTrace();
		}
	}

	/*public static void escribirPeliculas() {
		
	}*/
}
