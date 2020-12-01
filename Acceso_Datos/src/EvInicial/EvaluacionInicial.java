package EvInicial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

public class EvaluacionInicial {
	
	public EvaluacionInicial() {
		
	}
	
	public static void main(String[] args) {
		ArrayList fichero1 = new ArrayList<String>();
		ArrayList fichero2 = new ArrayList<String>();
		ArrayList fichero1ordenado = new ArrayList<String>();
		ArrayList fichero2ordenado = new ArrayList<String>();
		ArrayList fichero2atras = new ArrayList<String>();
		String ruta1 = ".\\src\\EvInicial\\fichero1.txt";
		String ruta2 = ".\\src\\EvInicial\\fichero2.txt";
		String rutaFichero = ".\\src\\EvInicial\\";
		File fich1 = new File(ruta1);
		File fich2 = new File(ruta2);
		
		if (fich1.exists() && fich2.exists()) {
			try {
				FileReader fr1 = new FileReader(fich1);
                BufferedReader br1 = new BufferedReader(fr1);
                FileReader fr2 = new FileReader(ruta2);
                BufferedReader br2 = new BufferedReader(fr2);
                String linea1;
                String linea2;
                linea1 = br1.readLine();
                linea2 = br2.readLine();
                while(linea1!=null){
                    fichero1.add(linea1);
                    linea1 = br1.readLine();
                }
                br1.close();
                while(linea2!=null){
                    fichero2.add(linea2);
                    linea2 = br2.readLine();
                }
                br2.close();
			}catch(IOException io) {
				System.out.println("Error al leer");
			}
		}else {
			System.out.println("los ficheros no existen");
		}
		for(int i=0;i<fichero1.size();i++) {
			if(i%2==0) {
				//System.out.println(fichero1.get(i));
				fichero1ordenado.add(fichero1.get(i));
			}
		}
		
		ListIterator iter = fichero2.listIterator(fichero2.size());
		while(iter.hasPrevious()) {
			fichero2atras.add(iter.previous());
			//System.out.println(iter);
		}
		
		for(int i=0;i<fichero2.size();i++) {
			if(i%2!=0) {
				fichero2ordenado.add(fichero2atras.get(i));
			}
		}
		for(int k=0;k<fichero1ordenado.size();k++) {
			//System.out.println(fichero1ordenado.get(k));
		}
		for(int k=0;k<fichero2ordenado.size();k++) {
			//System.out.println(fichero2ordenado.get(k));
		}
		FileWriter fw;
		try {
			fw = new FileWriter(rutaFichero+"frase.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			for(int i=0;i<fichero1ordenado.size();i++) {
				/*System.out.println(fichero1ordenado.get(i));
				System.out.println(fichero2ordenado.get(i));*/
				Object lineaFichero1;
				lineaFichero1=fichero1ordenado.get(i);
				salida.print(lineaFichero1+" ");
				Object lineaFichero2;
				lineaFichero2=fichero2ordenado.get(i);
				salida.print(lineaFichero2+" ");
			}
			System.out.println("Fichero creado correctamente");
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
