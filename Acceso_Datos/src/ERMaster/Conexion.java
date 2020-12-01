package ERMaster;

import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Conexion {
    private Connection con;
    private Statement st;
    
    public Conexion(String base){
        try{
            Class contr = Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Controlador Cargado");
        }catch(ClassNotFoundException cnfe){
            System.out.println("com.mysql.jdbc.Driver");
        }
        //Hacer referencia a url de nuestra base de datos
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/"+base, "root","");
            st = con.createStatement();
            System.out.println("Conexion realizada");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "No se creo la conexion");
        }
    }
    
    public void cerrar(){
        try{
            con.close();
        }catch(SQLException sqle){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
    
    public void actualizar(String consulta){
        try{
            st.executeUpdate(consulta);
            System.out.println(consulta);
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet selecciona(String consulta) throws SQLException{
        return st.executeQuery(consulta);
    }

    public Connection getCon() {
        return con;
    }
}
