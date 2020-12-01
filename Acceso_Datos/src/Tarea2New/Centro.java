package Tarea2New;

import java.util.ArrayList;

public class Centro {
	ArrayList<String> coleccionCentros = new ArrayList<>();
	String code;
	String denominacion;
	String nombre;
	String dependencia;
	String domicilio;
	String localidad;
	String municipio;
	String provincia;
	String codpostal;
	String telfn;
	String ensenyanza;

	public Centro(ArrayList lineaEntera) {
		for(int i = 0; i < lineaEntera.size();i++) {
			String linea = (String) lineaEntera.get(i);
			String[] partes = linea.split(";");
			this.code = "Código: " + partes[0];
			if(partes[1].equals("Instituto de Educación Secundaria")) {
				this.denominacion = "Denominación: " + "IES";
			}else if(partes[1].equals("Centro de Convenio")) {
				this.denominacion = "Denominación: " + "CC";
			}else if(partes[1].equals("Enseñanza Concertada")) {
				this.denominacion = "Denominación: " + "EC";
			}else{
				this.denominacion = "NA";
			}
			this.nombre = "Nombre: " + partes[2];
			this.dependencia = "Dependencia: " + partes[3];
			this.domicilio = "Domicilio: " + partes[4];
			this.localidad = "Localidad: " + partes[5];
			this.municipio = "Municipio: " + partes[5];
			this.provincia = "Provincia: " + partes[6];
			this.codpostal = "Cód.Postal: " + partes[7];
			this.telfn = "Teléfono: " + partes[8];
			this.ensenyanza = "Enseñanzas: " + partes[9];
			String inf = this.code + "\t\t" + this.denominacion + "\n" + this.nombre + "\t" + this.dependencia + "\n" + this.domicilio + "\t" + this.localidad + "\n"
					 + this.municipio + "\t" + this.provincia + "\n" + this.codpostal + "\t" + this.telfn + "\n" + this.ensenyanza + "\n";
			coleccionCentros.add(inf);
		}
	}
	
	public ArrayList<String> getCentros() {
		return coleccionCentros;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCodpostal() {
		return codpostal;
	}
	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}
	public String getTelfn() {
		return telfn;
	}
	public void setTelfn(String telfn) {
		this.telfn = telfn;
	}
	public String getEnsenyanza() {
		return ensenyanza;
	}
	public void setEnsenyanza(String ensenyanza) {
		this.ensenyanza = ensenyanza;
	}
}
