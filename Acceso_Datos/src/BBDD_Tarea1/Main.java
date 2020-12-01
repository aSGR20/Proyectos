package BBDD_Tarea1;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		consulta();
	}
	
	static void consulta() {
		Conexion con = new Conexion("bbva");
		String query = "select * from users";
		try {
			ResultSet rs = con.selecciona(query);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la consulta");
        }
        con.cerrar();
	}

}
