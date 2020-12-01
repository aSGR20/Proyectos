package TareaTiempoLimitado;

import java.io.Serializable;

/**
 * Clase Empleado
 *
 * Contiene informacion de cada empleado, es una clase abstracta
 *
 * @author Fernando
 * @version 1.0
 */
public class Empleado implements Serializable{

    private static final long serialVersionUID = -2873344211410398459L;

    //Constantes
    /**
     * Constante SALARIO_DEF
     */
    protected final static double SALARIO_DEF=600;

    //Atributos

    /**
     * Nombre del empleado
     */
    protected String nombre;
    /**
     * Apellido del empleado
     */
    protected String apellido;
    /**
     * Edad del empleado
     */
    protected int edad;
    /**
     * Salario del empleado
     */
    protected double salario;

    //Metodos publicos

    /**
     * Devuelve el nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de un empleado
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la edad de un empleado
     * @return edad del empleado
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad de un empleado
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el salarioBase
     * @return salarioBse
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Modifica el salarioBase de los empleados
     * @param salario
     */
    public  void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean plus (double sueldoPlus){
        boolean aumento=false;
        if (edad>40){
            salario+=sueldoPlus;
            aumento=true;
        }
        return aumento;
    }

    public boolean equals (Empleado a){
        if(a.getNombre().equals(nombre) && a.getApellido().equals(apellido)){
            return true;
        }else{
            return false;
        }
    }

    public int compareTo(Empleado a){

        int estado=-1;
        if(this.edad==a.getEdad()){
            //Los objetos son iguales
            estado=0;
        }else if(this.edad>a.getEdad()){
            //El objeto 1 es mayor que la pasada por parametro
            estado=1;
        }
        return estado;

    }

    /**
     * Método que imprime la información de interés del empleado
     */
    public String toString (){
        String mensaje="El empleado se llama "+nombre+" "+apellido+" con "+edad+" años " +
                "y un salario de "+salario;
        return mensaje;
    }
    
    public String getApellido() {
        return apellido;
    }

    //Constructores
    /**
     * Constructor por defecto
     */
    public Empleado(){
        this ("", "", 0, SALARIO_DEF);
    }

    /**
     * Constructor con 2 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     */
    public Empleado(String nombre, String apellido){
        this (nombre, apellido, 0, SALARIO_DEF);
    }


    /**
     * Constructor con 3 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     */
    public Empleado (String nombre, String apellido, int edad){
        this (nombre, apellido, edad, SALARIO_DEF);
    }
    
    /**
     * Constructor con 4 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     * @param salario salario del empleado
     */
    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.salario=salario;
    }
}