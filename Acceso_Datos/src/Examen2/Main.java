package Examen2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private Scanner teclado;
	
	public static void main(String[] args) {
		int idCategoria = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿De que categoría desea ver la información?");
		try {
			idCategoria = teclado.nextInt();
		}catch(InputMismatchException ea) {
			System.out.println("Eso no es un número, adiós");
		}
		System.out.println("¿Cómo desea llamar al fichero? (No hace falta .txt al final)");
		String fileName = ".\\src\\Examen2\\"+teclado.next()+".txt";
		almacenarProductosEnFichero(idCategoria, fileName);
		ficheroATablas(fileName);
	}
	
	/**
	 * Crea un fichero con el nombre que usted le escriba en la misma carpeta que los .java<br>
	 * Tambien escribe en el correspondiente fichero la categoria seleccionada, los proveedores y los productos
	 * @param idCategoria
	 * @param fileName
	 */
	public static void almacenarProductosEnFichero(int idCategoria, String fileName){
		Conexion con = new Conexion("bd_neptuno");
		Categorias categoria = new Categorias();
		Proveedores proveedor = new Proveedores();
		Productos producto = new Productos();
		String linea;
		/*
		 * Comienzo a crear/escribir la categoría en el fichero
		 */
		categoria.setId(idCategoria);
		String consultaGetCategorias = "SELECT * FROM `categorias` WHERE `id` = "+categoria.getId()+";";
		try {
			ResultSet rs = con.selecciona(consultaGetCategorias);
			while(rs.next()) {
				categoria.setCategoria(rs.getString(2));
				categoria.setDescripcion(rs.getString(3));
			}
		}catch(SQLException sqle) {
			System.out.println("ERROR - No se ha podido cargar la lista");
		}
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("CATEGORÍA");
			linea = categoria.getId()+";"+categoria.getCategoria()+";"+categoria.getDescripcion();
			salida.println(linea);
			salida.println();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Comienzo a escribir los proveedores en el fichero
		 */
		String consultaGetIdProveedor = "SELECT DISTINCT `proveedor_id` FROM `productos` WHERE `categoria_id` = "+categoria.getId()+";";
		ArrayList<Object>proveedoresObj = new ArrayList<>();
		
		try {
			ResultSet rs = con.selecciona(consultaGetIdProveedor);
			while(rs.next()) {
				proveedoresObj.add(rs.getInt(1));
			}
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("PROVEEDORES");
			for(int i = 0; i < proveedoresObj.size(); i++) {
				String consultaGetProveedores = "SELECT `id`, `empresa`, `contacto` FROM proveedores WHERE `id` = "+proveedoresObj.get(i)+"";
				ResultSet rs2 = con.selecciona(consultaGetProveedores);
				while(rs2.next()) {
					proveedor.setId(rs2.getInt(1));
					proveedor.setEmpresa(rs2.getString(2));
					proveedor.setContacto(rs2.getString(3));
					linea = proveedor.getId()+";"+proveedor.getEmpresa()+";"+proveedor.getContacto();
					salida.println(linea);
				}
			}
			salida.println();
			salida.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Comienzo a escribir los productos en el fichero
		 */
		String consultaGetProductos = "SELECT `id`, `producto`, `proveedor_id`, `categoria_id`, `cantidad_por_unidad`, "
				+ "`precio_unidad`, `unidades_existencia`, `unidades_pedido`, `nivel_nuevo_pedido`, `suspendido` FROM "
				+ "`productos` WHERE `categoria_id` = "+categoria.getId()+"";
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("PRODUCTOS");
			ResultSet rs = con.selecciona(consultaGetProductos);
			while(rs.next()) {
				producto.setId(rs.getInt(1));
				producto.setProducto(rs.getString(2));
				producto.setProveedorId(rs.getInt(3));
				producto.setCategoriaId(rs.getInt(4));
				producto.setCantidadPorUnidad(rs.getString(5));
				producto.setPrecioUnidad(rs.getDouble(6));
				producto.setUnidadesExistencia(rs.getInt(7));
				producto.setUnidadesPedido(rs.getInt(8));
				producto.setNivelNuevoPedido(rs.getInt(9));
				producto.setSuspendido(rs.getInt(10));
				linea = producto.getId()+";"+producto.getProducto()+";"+producto.getProveedorId()+";"+producto.getCategoriaId()
				+";"+producto.getCantidadPorUnidad()+";"+producto.getPrecioUnidad()+";"+producto.getUnidadesExistencia()+";"+producto.getUnidadesPedido()
				+";"+producto.getNivelNuevoPedido()+";"+producto.getSuspendido()+";";
				salida.println(linea);
			}
			salida.println();
			salida.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		con.cerrar();
	}
	
	/**
	 * Lee el fichero creado (o sobreescrito) anteriormente y lo mete en diferentes tablas
	 * @param fileName
	 */
	public static void ficheroATablas(String fileName){
		String linea;
		Object[]datos;
		Conexion con = new Conexion("bd_neptuno");
		/*
		 * Mete el contenido en la tabla "categorias_new"
		 */
		try {
			FileReader fichero = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fichero);
			linea = br.readLine();
			while(linea != null) {
				if(linea.equals("CATEGORÍA")) {
					linea = br.readLine();
					datos = linea.toString().split(";");
					String consultaCategoriasNew = "INSERT INTO categorias_new (`id`, `categoria`, `descripcion`) VALUES (?, ?, ?)";
					try {
						PreparedStatement pst = con.getCon().prepareStatement(consultaCategoriasNew);
						pst.setString(1, (String) datos[0]);
						pst.setString(2, (String) datos[1]);
						pst.setString(3, (String) datos[2]);
						pst.executeUpdate();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Mete el contenido en la tabla "proveedores_new"
		 */
		try {
			FileReader fichero = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fichero);
			linea = br.readLine();
			while(linea != null) {
				if(linea.equals("PROVEEDORES")) {
					linea = br.readLine();
					datos = linea.toString().split(";");
					String consultaProveedoresNew = "INSERT INTO proveedores_new (`id`, `producto`, `proveedor_id`, `categoria_id`, `cantidad_por_unidad`,"
							+ "precio_unidad`, `unidades_existencia`, `unidades_pedido`, `nivel_nuevo_pedido`, `suspendido` FROM, "
							+ "`productos` WHERE `categoria_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
					try {
						PreparedStatement pst = con.getCon().prepareStatement(consultaProveedoresNew);
						pst.setString(1, (String) datos[0]);
						pst.setString(2, (String) datos[1]);
						pst.setString(3, (String) datos[2]);
						pst.setString(4, (String) datos[3]);
						pst.setString(5, (String) datos[4]);
						pst.setString(6, (String) datos[5]);
						pst.setString(7, (String) datos[6]);
						pst.setString(8, (String) datos[7]);
						pst.setString(9, (String) datos[8]);
						pst.setString(10, (String) datos[9]);
						pst.executeUpdate();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		con.cerrar();
	}

}
