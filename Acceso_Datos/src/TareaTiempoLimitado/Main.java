package TareaTiempoLimitado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FICHERO_ENTRADA = ".\\src\\TareaTiempoLimitado\\empleados.dat";
    private static final String FICHERO_SALIDA_BIN = ".\\src\\TareaTiempoLimitado\\empleados.dat";
    private static final String FICHERO_SALIDA_TXT = ".\\src\\TareaTiempoLimitado\\empleados.txt";


    public static void main(String[] args) {
        List<Empleado> lista = new ArrayList<>();

        // Prueba sencilla. Creamos una lista de 6 empleados
        /*lista.add(new Empleado("Pepe", "Perez", 22, 1100));
        lista.add(new Empleado("Luisa", "Tapia", 34, 1060));
        lista.add(new Empleado("Juan", "Fernández", 28, 1240));
        lista.add(new Empleado("Antonio", "García", 23, 1400));
        lista.add(new Empleado("Elena", "Otero", 44, 2100));
        lista.add(new Empleado("María", "García", 45, 2000));*/

        // Prueba intensiva. Creamos una lista de 200 empleados
        for (int i=0; i<200; i++) {
        	lista.add(new Empleado("Empleado_" + i, "ApellidoElQueSea", 30, 1200));
        }
        
        guardarEmpleados(lista);
        	
        imprimirFicheroEmpleados(true);
        imprimirFicheroEmpleados(false);  
    }

    /**
     * Guarda una lista de empleados en el fichero binario "empleados.dat". <br>
     * Si no está creado, lo creará y guardará los empleados.<br>
     * Si ya está creado, añadirá los nuevos empleados a los que ya hubiera.<br>
     * @param lista lista de empleados
     * @throws IOException
     */
    static void guardarEmpleados(List<Empleado> lista) {
    	ObjectOutputStream escritor = null;

    	try {
        	// Controlo el uso de ObjectOutputStream si el fichero ya existe
            if (new File(FICHERO_SALIDA_BIN).exists()) {
                escritor = new MiObjectOutputStream(new FileOutputStream(FICHERO_SALIDA_BIN, true));
            }
            else {
            	escritor = new ObjectOutputStream(new FileOutputStream(FICHERO_SALIDA_BIN));
            }

            // A guardar empleados
            for (Empleado empleado : lista) {
                escritor.writeObject(empleado);
            }    
		} catch (EOFException e) {
		} catch (IOException e) { 
			System.out.println("Hubo un problema a la hora de guardar los empleados");
			e.printStackTrace();
		} finally {
			try {
				if (escritor!= null) escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

    /**
     * Vuelca los empleados por pantalla o a un fichero de texto "empleados.txt".<br>
     * En el caso de fichero, si no está creado, lo creará. <br>
     * Si ya está creado, añadirá los nuevos empleados a los que ya hubiera.<br>
     * @param mostrarEnPantalla <ul><li>True: por pantalla.</li><li>False: fichero de texto</li></ul>
     */
    static void imprimirFicheroEmpleados(boolean mostrarEnPantalla) {
    	ObjectInputStream lector = null;
    	BufferedWriter escritor = null;
    	
    	try {
        	lector =  new ObjectInputStream(new FileInputStream(FICHERO_ENTRADA));
        	
            if (mostrarEnPantalla) {
                while(true) {
                    Empleado empleado = (Empleado) lector.readObject();
                    System.out.println(empleado);
                }
            }
            else {
                escritor = new BufferedWriter(new FileWriter(FICHERO_SALIDA_TXT, true));
                while(true) {
                	Empleado empleado = (Empleado) lector.readObject();
                	escritor.write(empleado.toString() + "\n");
                }
            }
        } catch (ClassNotFoundException e) {
		} catch (EOFException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (lector!= null) lector.close();
				if (escritor!= null) escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

}
