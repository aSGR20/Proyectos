package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.Proceso;
/**
 * Clase que simulara RR, con un quantuum que se le pasara en el contructor<br>
 * Puede contener errores
 * @author alvar
 *
 */
public class RR extends ABSprocesos{
	
	
	int quantum;
	
	/**
	 * constructor de RR, es necesrio pasarle una array list de procesos y un int que actuara como quantum
	 * @param lista
	 * @param miquantum
	 */
	public RR(ArrayList<Proceso> lista, int miquantum) {
		procesos=lista;
		quantum=miquantum;
		listaMedias= new ArrayList();
		
	}
	
	/**
	 * proceso que ejecuta algoritmo rr <br>
	 */
	public void run() {
		int tiempo=1;
		Proceso miproce;
		boolean fin=false;
		boolean cambio=false;
		
		while (fin==false) {
				cambio=false;
				while (cambio==false) {
				if (!procesos.isEmpty()) {
					
					if (procesos.get(0).getT_Entrada()<tiempo ) {
						for (int contq=0;contq<quantum;contq++) {
							if (procesos.get(0).getDuracion()!=0) {
								//haz cosas
								procesos.get(0).setDuracion(procesos.get(0).getDuracion()-1);
								System.out.println("tiempo sistema:  "+ tiempo+"     "+procesos.get(0).ToString());
								if (procesos.get(0).getDuracion()==0) {
									procesos.get(0).setT_final(tiempo);
								}
								tiempo++;
								
								if (contq==1) {
										if (procesos.get(0).getDuracion()!=procesos.get(0).getDuracion_ini()) {
										miproce=CrearProceso(0);
										procesos.remove(0);
										procesos.add(miproce);
										cambio=true;
										}
								}
								
							}
						}
					}
					
				} else {
					cambio=true;
				}
				
				
				eliminarfinalizado();
				
			}
				if (procesos.isEmpty()) {
					fin=true;
					System.out.println("RR Q="+quantum+" finalizado");
					mostrarmedias();
				}
		}
				
			
	
		
		
		
	}
	
	
	
		
	/**
	 * proceso que elimina los que han terminado
	 */
	public void eliminarfinalizado() {
		try {
			if (!(procesos.isEmpty())) {
				for (int cont=0;cont<procesos.size();cont++) {
					if (procesos.get(cont).getDuracion()==0) {
						
						listaMedias.add(procesos.get(cont).calcmedia());
						procesos.remove(cont);
					}
				}
			}
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("RR Q="+quantum+" finalizado");
        }

	}
	
	
}
