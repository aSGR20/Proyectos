package Tarea2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Centro {
	String code;
	String denominacion;
	String nombre;
	String dependencia;
	String domicilio;
	String localidad;
	String municipio;
	String provincia;
	String cod_postal;
	String telefono;
	String ensenyanza;
	
	public Centro(String linea) {
		String[] partes = linea.split(";");
		this.code = "C�digo: " + partes[0];
		if(partes[1].equals("Instituto de Educaci�n Secundaria")) {
			this.denominacion = "Denominaci�n: " + "IES";
		}else if(partes[1].equals("Centro de Convenio")) {
			this.denominacion = "Denominaci�n: " + "CC";
		}else if(partes[1].equals("Ense�anza Concertada")) {
			this.denominacion = "Denominaci�n: " + "EC";
		}else{
			this.denominacion = "NA";
		}
		this.nombre = "Nombre: " + partes[2];
		this.dependencia = "Dependencia: " + partes[3];
		this.domicilio = "Domicilio: " + partes[4];
		this.localidad = "Localidad: " + partes[5];
		this.municipio = "Municipio: " + partes[5];
		this.provincia = "Provincia: " + partes[6];
		this.cod_postal = "C�d.Postal: " + partes[7];
		this.telefono = "Tel�fono: " + partes[8];
		this.ensenyanza = "Ense�anzas: " + partes[9];
		
		try {
			FileOutputStream fos = new FileOutputStream(".\\src\\Tarea2\\lista.dat");
			DataOutputStream salida = new DataOutputStream(fos);
			try {
				salida.writeUTF(code);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
