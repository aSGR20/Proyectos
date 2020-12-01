package ERMaster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Main extends javax.swing.JFrame{

	private int posicion;
	private JFrame frame;
	private JTextField textMatricula;
	private JTextField textNombre;
	private JTextField textFechEntrada;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		setLocationRelativeTo(null);
		setTitle("Alumnos");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alumnos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTitulo.setBounds(241, 11, 84, 22);
		panel.add(lblTitulo);
		
		JLabel lblNumMatricula = new JLabel("Matr\u00EDcula");
		lblNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumMatricula.setBounds(26, 70, 53, 14);
		panel.add(lblNumMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(26, 86, 198, 20);
		panel.add(textMatricula);
		textMatricula.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(287, 86, 198, 20);
		panel.add(textNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(287, 70, 53, 14);
		panel.add(lblNombre);
		
		textFechEntrada = new JTextField();
		textFechEntrada.setColumns(10);
		textFechEntrada.setBounds(26, 193, 198, 20);
		panel.add(textFechEntrada);
		
		JLabel lblFechEntrada = new JLabel("Fecha de Entrada");
		lblFechEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechEntrada.setBounds(26, 168, 96, 14);
		panel.add(lblFechEntrada);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(287, 193, 198, 20);
		panel.add(textTelefono);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(287, 168, 53, 14);
		panel.add(lblTelefono);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoAlumno();
			}
		});
		btnNuevo.setBounds(492, 119, 89, 23);
		panel.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarAlumno();
			}
		});
		btnGuardar.setBounds(492, 153, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = 0;
				cargarAlumno(pos);
			}
		});
		btnPrimero.setBounds(26, 244, 89, 23);
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = 1;
				cargarAlumno(pos);
			}
		});
		btnAnterior.setBounds(153, 244, 89, 23);
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = 2;
				cargarAlumno(pos);
			}
		});
		btnSiguiente.setBounds(271, 244, 89, 23);
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = 4;
				cargarAlumno(pos);
			}
		});
		btnUltimo.setBounds(396, 244, 89, 23);
		panel.add(btnUltimo);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setBounds(100, 100, 607, 317);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void nuevoAlumno() {
		textMatricula.setText("");
		textNombre.setText("");
		textFechEntrada.setText("");
		textTelefono.setText("");
	}
	
	public void guardarAlumno() {
		Conexion con = new Conexion("ermaster");
		String query = "INSERT INTO `alumno` (`NumMatricula`, `Nombre`, `FechaNacimiento`, `Telefono`) VALUE (?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.getCon().prepareStatement(query);
			pst.setString(1, textMatricula.getText());
			pst.setString(2, textNombre.getText());
			pst.setString(3, textFechEntrada.getText());
			pst.setString(4, textTelefono.getText());
			pst.executeUpdate();
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

	public void cargarAlumno(int n) {
		Conexion con = new Conexion("ermaster");
		if(n == 0) {
			posicion = 1;
			String query = "SELECT * FROM alumno ORDER BY NumMatricula ASC LIMIT 1;";
			try {
				ResultSet rs = con.selecciona(query);
				while(rs.next()) {
					textMatricula.setText(rs.getString(1));
					textNombre.setText(rs.getString(2));
					textFechEntrada.setText(rs.getString(3));
					textTelefono.setText(rs.getString(4));
				}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
		}
		if(n == 1) {
			if(posicion>0){
				posicion--;
				String query = "SELECT * FROM alumno ORDER BY NumMatricula ASC LIMIT "+posicion+";";
			try {
				ResultSet rs = con.selecciona(query);
				while(rs.next()) {
					textMatricula.setText(rs.getString(1));
					textNombre.setText(rs.getString(2));
					textFechEntrada.setText(rs.getString(3));
					textTelefono.setText(rs.getString(4));
				}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
			}
		}
		if(n == 2) {
			if(posicion>0){
				posicion++;
				String query = "SELECT * FROM alumno ORDER BY NumMatricula ASC LIMIT "+posicion+";";
			try {
				ResultSet rs = con.selecciona(query);
				while(rs.next()) {
					textMatricula.setText(rs.getString(1));
					textNombre.setText(rs.getString(2));
					textFechEntrada.setText(rs.getString(3));
					textTelefono.setText(rs.getString(4));
				}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
			}
		}
		if(n == 4) {
			String query = "SELECT COUNT(*) FROM alumno;";
			try {
				ResultSet rs = con.selecciona(query);
				while(rs.next()) {
					posicion = rs.getInt("count(*)");
				}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
			
			String query2 = "SELECT * FROM alumno ORDER BY NumMatricula ASC LIMIT "+posicion+";";
			try {
				ResultSet rs = con.selecciona(query2);
				while(rs.next()) {
					textMatricula.setText(rs.getString(1));
					textNombre.setText(rs.getString(2));
					textFechEntrada.setText(rs.getString(3));
					textTelefono.setText(rs.getString(4));
				}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error en la consulta");
			}
		}
	}
}
