/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class GenerarNumInscripcion {
    
    //Modificar para que acepte materias reprobadas
    public List<Double> obtenerEscolaridad(List<Integer> materiasInscritas){
        List<Double> escolaridadAlumnos = new ArrayList<>();

        for(Integer materiasOrdinario:materiasInscritas){
            double escolaridad = (materiasOrdinario/materiasOrdinario)*100;
            escolaridadAlumnos.add(escolaridad);
        }
        return escolaridadAlumnos;
    }
    //Modificar para materias reprobadas
    public List<Double> obtenerVelocidad(List<Integer> creditosIngreso){
        List<Double> velocidadAlumnos = new ArrayList<>();
        for(Integer creditos:creditosIngreso){
            double velocidad = (creditos/creditos)*100;
            velocidadAlumnos.add(velocidad);
        }
        return velocidadAlumnos;
    }
    
    public List<Double> obtenerNumInscripcion(List<Double> promediosGenerales,List<Double> escolaridad,List<Double> velocidad){
        List<Double> numerosInscripcion = new ArrayList<>();
        for (int i = 0; i < promediosGenerales.size(); i++) {
                double numInscripcion = promediosGenerales.get(i) * escolaridad.get(i) * velocidad.get(i);
                numerosInscripcion.add(numInscripcion);
        }
        return numerosInscripcion;
    }
}
