package Tarea4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	public static String linea;
	public static String[]datos;
	public static void main(String[] args) {
		try {
			guardarLinea();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void guardarLinea() throws FileNotFoundException, IOException {
		linea = null;
		try(BufferedReader br = new BufferedReader(new FileReader(".\\src\\Tarea4\\fichero.txt"))){
			while(br.ready()) {
				linea = br.readLine();
				datos = linea.split(";");
				try {
					meterBBDD(datos);
				}catch(ArrayIndexOutOfBoundsException ex) {
					System.out.println();
				}
				
			}
		}
		finally {
		}
	}
	
	public static void meterBBDD(String[]datos) {
		if(datos[0].equals("Profesor")) {
			Conexion con=new Conexion("ermaster");
	        String query = "INSERT INTO profesor (NIF_P, Nombre, Especialidad, Telefono) VALUES (?, ?, ?, ?);";
	        try{
	            PreparedStatement pst = con.getCon().prepareStatement(query);
	            pst.setString(1, datos[1].toString());
	            pst.setString(2, datos[2].toString());
	            pst.setString(3, datos[3].toString());
	            pst.setInt(4, Integer.parseInt(datos[4].toString()));
	            pst.executeUpdate();
	        } catch (SQLException ex){
	        	ex.printStackTrace();
	        }
	        con.cerrar();
		}
		if(datos[0].equals("Asignatura")) {
			Conexion con=new Conexion("ermaster");
	        String query = "INSERT INTO asignatura (CodAsignatura, Nombre) VALUES (?, ?);";
	        try{
	            PreparedStatement pst = con.getCon().prepareStatement(query);
	            pst.setString(1, datos[1].toString());
	            pst.setString(2, datos[2].toString());
	                pst.executeUpdate();
	        } catch (SQLException ex){
	        	ex.printStackTrace();
	        }
	        con.cerrar();
		}
	}
}
