package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.Proceso;

/**
 * clase comun para todos los procesos contiene comportamientos y estados
 * @author alvar
 *
 */
public abstract class ABSprocesos {

	protected ArrayList<Proceso> procesos;
	protected ArrayList<String> listaMedias;
	
	
	/**
	 * comportamiento para mostrar las medias de los procesos
	 */
	protected void mostrarmedias() {
		
		System.out.println();
		System.out.println("Medias de los procesos:");
		System.out.println();
		Collections.sort(listaMedias);
		for (int cont=0;cont<listaMedias.size();cont++) {
			System.out.println(listaMedias.get(cont).toString());
		}
		
		
	}
	
	/**
	 * Comportaiento que crea un proceso a partir de un index de una array list
	 * @param cont
	 * @return
	 */
	public Proceso CrearProceso(int cont) {
			
			//necestito quitar el primero de la lista procesos_e y ponerlo al final
			String nombre=procesos.get(cont).getNombre();
			int entrada=procesos.get(cont).getT_Entrada();
			int duracion=procesos.get(cont).getDuracion();
			Proceso miproce= procesos.get(cont);
			
			return miproce;
		
	}
}
