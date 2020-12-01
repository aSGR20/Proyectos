package Examen1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.PreparedStatement;

public class Main {
	private static File fichero = new File(".\\src\\Examen1\\Alumnos.txt");

	public static void main(String[] args) {
		crearTablaSuperusuarios(fichero);
	}
	
	/**
	 * Crea la tabla Superusuarios y añade <br>
	 * todas las lineas del fichero Alumnos a la BBDD
	 * @param fichero
	 */
	public static void crearTablaSuperusuarios(File fichero) {
		//Creación de variables
		Conexion con = new Conexion("bd_neptuno");
		String linea, user, nombre, apell;
		Object[] div;
		
		//Creación de la BBDD si no existe
		String query1 = "CREATE TABLE IF NOT EXISTS `Superusuarios`(`IdUser` int(20) NOT NULL AUTO_INCREMENT, `Nombre` varchar(25) NOT NULL, `Apellidos` varchar(30) NOT NULL, `User` varchar(6), PRIMARY KEY (`IdUser`));";
		con.actualizar(query1);
		//Abro el archivo y añado cada linea separada por ", " a la tabla superusuarios
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			while((linea=br.readLine())!=null) {
				div = linea.split(", ");
				
				apell = div[0].toString();
				nombre = div[1].toString();
				user = "2DAM" + Character.toString(nombre.charAt(0)) + Character.toString(apell.charAt(0));
				
				String query2 = "INSERT INTO Superusuarios(Nombre, Apellidos, User) VALUES (?, ?, ?);";
				PreparedStatement pst = con.getCon().prepareStatement(query2);
				pst.setString(1, nombre);
				pst.setString(2, apell);
				pst.setString(3, user);
				pst.executeUpdate();
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		con.cerrar();
	}
}
