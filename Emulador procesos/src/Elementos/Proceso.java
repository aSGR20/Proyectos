package Elementos;

public class Proceso extends ABSproceso{
	
	
	public Proceso(String minombre,int entrada,int duracion) {
		nombre=minombre;
		T_Entrada=entrada;
		Duracion=duracion;
		duracion_ini=Duracion;
		T_final=0;
	}
	
}
