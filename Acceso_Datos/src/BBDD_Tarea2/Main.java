package BBDD_Tarea2;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Main {
	static String tabla1 = "CREATE TABLE Region (CodRegion VARCHAR(8), Nombre VARCHAR(20),PRIMARY KEY (CodRegion));";
	static String tabla2 = "CREATE TABLE Provincia (CodProvincia VARCHAR(16), Nombre VARCHAR(20), CodRegion VARCHAR(8), PRIMARY KEY(CodProvincia), FOREIGN KEY (CodRegion) REFERENCES Region(CodRegion));";
	static String tabla3 = "CREATE TABLE Localidad (CodLocalidad VARCHAR(20), Nombre VARCHAR(26), CodProvincia VARCHAR(16), PRIMARY KEY (CodLocalidad), FOREIGN KEY (CodProvincia) REFERENCES Provincia(CodProvincia));";
	static String tabla4 = "CREATE TABLE Empleado (ID INT(10), DNI VARCHAR(10) NOT NULL, Nombre VARCHAR(15), FechaNac DATE, Telefono VARCHAR(12), Salario INT(6), CodLocalidad VARCHAR(20), PRIMARY KEY (ID), FOREIGN KEY (CodLocalidad) REFERENCES Localidad(CodLocalidad));";

	public static void main(String[] args) {
		crearTabla1();
		crearTabla2();
	}
	
	static void crearTabla1() {
		Conexion con = new Conexion("prueba2");
		String query = tabla1;
		try {
			PreparedStatement pst = con.getCon().prepareStatement(tabla1);
			pst.executeUpdate();
		} catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la consulta");
        }
        con.cerrar();
	}
	
	static void crearTabla2() {
		Conexion con = new Conexion("prueba2");
		String query = tabla1;
		try {
			PreparedStatement pst = con.getCon().prepareStatement(tabla2);
			pst.executeUpdate();
		} catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la consulta");
        }
        con.cerrar();
	}

}
