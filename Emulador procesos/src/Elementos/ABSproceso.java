package Elementos;

import java.text.DecimalFormat;

public class ABSproceso {
	
	
	protected String nombre;
	protected int T_Entrada;
	protected int Duracion;
	protected int T_final;
	protected int duracion_ini;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getT_Entrada() {
		return T_Entrada;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}
	
	public int getT_final() {
		return T_final;
	}

	public void setT_final(int tiempo) {
		T_final = tiempo;
	}

	public int getDuracion_ini() {
		return duracion_ini;
	}

	public void setDuracion_ini(int duracion_ini) {
		this.duracion_ini = duracion_ini;
	}

	public void setT_Entrada(int t_Entrada) {
		T_Entrada = t_Entrada;
	}
	
	public String calcmedia() {
		//(fin-inicio)/duración
		float resta=T_final-T_Entrada;
		float resultado= resta/duracion_ini;
		return ("media de: "+nombre+" es: "+ String.valueOf(resultado));
	}
	
	public String ToString() {
		if (Duracion!=0) {
		return "proceso: "+ nombre+" duracion restante "+Duracion+"\n";
		} else {
		return "proceso: "+ nombre+" duracion restante "+Duracion+" Proceso finalizado"+"\n";
		}
	}
	
	

}
