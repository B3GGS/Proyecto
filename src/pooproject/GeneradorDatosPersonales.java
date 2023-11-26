/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class GeneradorDatosPersonales {
    private int edad,
                semestre,
                numeroCuenta = 23100000;

    public GeneradorDatosPersonales() {
    }

    public int getSemestre() {
        return semestre;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public GeneradorDatosPersonales(int edad, int semestre, int numeroCuenta) {
        this.edad = edad;
        this.semestre = semestre;
        this.numeroCuenta = numeroCuenta;
    }
    
    public void cargarEdad(List<String> nombres){
        Random rand = new Random();
        for(int i=0; i < nombres.size(); i++){
            for(String nombre:nombres){
                edad = rand.nextInt(10) + 18;
                nombres.set(i, nombres.get(i)+" "+edad);
                i++;
            }
        }
    }
    
    public void cargarSemestre(List<String> nombres){
        Random rand = new Random();
        for(int i=0; i < nombres.size(); i++){
            for(String nombre:nombres){
                semestre = (int) (Math.random() * 10) + 1;
                nombres.set(i, nombres.get(i)+" "+semestre);
                i++;
            }
        }
    }
    
    public void cargarNumeroCuenta(List<String> nombres){
        for(int i=0; i < nombres.size(); i++){
            for(String nombre:nombres){
                numeroCuenta++;
                nombres.set(i, nombres.get(i)+" "+numeroCuenta);
                i++;
            }
        }
    }
    
    
    
}
