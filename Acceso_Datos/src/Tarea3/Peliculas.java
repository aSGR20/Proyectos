package Tarea3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Peliculas {
	private String name;
	private String date;
	private String quality;
	private String format;
	
	public Peliculas(String datos, String carpeta) {
		int indParentesisAbre = datos.indexOf("(");
		if (indParentesisAbre != -1) {
			this.name = datos.substring(0, datos.indexOf("("));
			this.date = datos.substring(datos.indexOf("(")+1,datos.indexOf(")"));
			this.format = datos.substring(datos.indexOf(".")+1,datos.length());
			this.quality = carpeta;
		}else {
			this.name = datos.substring(0,datos.indexOf("."));
			this.date = "NA";
			this.format = datos.substring(datos.indexOf(".")+1,datos.length());
			this.quality = carpeta;
		}
	}
	
	public String serializar(){
		String linea;
		linea = this.name + ";" + this.date + ";" + this.format + ";" + this.quality;
		return linea;
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
