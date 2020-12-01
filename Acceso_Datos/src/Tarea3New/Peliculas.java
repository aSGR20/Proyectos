package Tarea3New;

import java.util.ArrayList;

public class Peliculas {
	ArrayList<String>coleccionPeliculas = new ArrayList<>();
	private String name;
	private String date;
	private String quality;
	private String format;
	public Peliculas(String name, String date, String quality, String format) {
		super();
		this.name = name;
		this.date = date;
		this.quality = quality;
		this.format = format;
	}
	public Peliculas(ArrayList lineaPeliculas, ArrayList carpetaPeliculas) {
		for(int i = 0; i < carpetaPeliculas.size(); i++) {
			String carpeta = (String) carpetaPeliculas.get(i);
			this.quality = carpeta;
			for(int k = 0; k < lineaPeliculas.size(); k++) {
				String linea = (String) lineaPeliculas.get(k);
				if (linea.contains("(")) {
					this.name = linea.substring(0, linea.indexOf("("));
					this.date = linea.substring(linea.indexOf("(")+1,linea.indexOf(")"));
					this.format = linea.substring(linea.indexOf(".")+1,linea.length());
				}else {
					this.name = linea.substring(0,linea.indexOf("."));
					this.date = "NA";
					this.format = linea.substring(linea.indexOf(".")+1,linea.length());
				}
				String result = this.name + "; " + this.date + " ; " + this.format + " ; " + this.quality + "\n";
				coleccionPeliculas.add(result);
			}
		}
	}
	public ArrayList<String> getPeliculas() {
		return coleccionPeliculas;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
