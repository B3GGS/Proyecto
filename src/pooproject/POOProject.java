/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pooproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ACER
 */
public class POOProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> nombresAlumnos = generarNombres();
        generarDatosPersonales(nombresAlumnos);
        generarDirecciones(nombresAlumnos);
        registrosAcademicos(nombresAlumnos);
        guardarDatos(nombresAlumnos);
        
    }
    
    // Método que guarda en el archivo CSV los datos personales.
    public static void guardarDatos( List<String> datos ){
        
        //Escribe en un TXT los elementos de la lista separados por comas.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DatosPersonales.txt"))) {
            for (int i = 0; i < datos.size(); i++) {
                String elemento = datos.get(i);
                elemento = elemento.replaceAll(" ", ","); // Reemplazar espacios por comas
                writer.write(elemento);

                if (i != datos.size() - 1) {
                    writer.newLine(); // Agregar salto de línea si no es el último elemento
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Convierte el TXT en CSV
        try (BufferedReader reader = new BufferedReader(new FileReader("DatosPersonales.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("DatosPersonales.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Módulo Generador de Nombres
    public static List<String> generarNombres(){
        String rutaArchivoNombres = "nombres.txt";
        String rutaArchivoApellidos = "apellidos.txt"; 

        GeneradorNombres manejador = new GeneradorNombres();
        manejador.cargarNombres(rutaArchivoNombres);
        manejador.cargarApellidos(rutaArchivoApellidos);

        List<String> listaNombres = manejador.obtenerNombres();
        List<String> listaApellidos = manejador.obtenerApellidos();
        
        List<String> nombresCompletos = manejador.generarNombresCompletos(); 
        
        return nombresCompletos;
    }
    
    //Módulo Generador de Datos Personales
    public static void generarDatosPersonales(List<String> nombres){
        GeneradorDatosPersonales manejador = new GeneradorDatosPersonales();
        manejador.cargarEdad(nombres);
        manejador.cargarNumeroCuenta(nombres);
        manejador.cargarSemestre(nombres);
    }
    
    //Modulo Generador de Direcciones
    public static void generarDirecciones(List<String> nombres){
        String rutaArchivoDireccion = "Direcciones.csv";
        
        Direcciones manejador = new Direcciones();

    }
    
    //Modulo de Registros Academicos
    public static void registrosAcademicos(List<String> nombres){
        RegistrosAcademicos manejador = new RegistrosAcademicos();
        
        //Materias
        manejador.obtenerMaterias();
        List<List<String>> materiasPorSemestre = manejador.materiasPorSemestre();
        List<String> numerosCuenta = manejador.obtenerNumerosCuenta(nombres);
        List<String> semestre = manejador.obtenerSemestre(nombres);
        List<List<String>> materiasInscritas = manejador.obtenerMateriasInscritas(semestre,materiasPorSemestre);
        List<String> materiasAlumnos = manejador.materiasInscritasAlumno(numerosCuenta, materiasInscritas);
        List<Integer> cantidadMaterias = manejador.cantidadMaterias(semestre);

        //Creditos
        List<Integer> creditosSemestre = manejador.creditosPorSemestre(materiasPorSemestre);
        List<Integer> creditosIngreso = manejador.creditosIngreso(semestre,creditosSemestre);
        
        //Promedio
        List<List<String>> materiasCursadasAlumno = manejador.materiasTotalesAlumno(semestre, materiasPorSemestre);
        manejador.asignacionCalificaciones(materiasCursadasAlumno);
        List<List<Double>> promedioSemestral = manejador.calcularPromediosSemestrales(materiasCursadasAlumno);
        List<Double> promediosGenerales = manejador.promedioGeneral(promedioSemestral);
        
        //Numero de Inscripción
        GenerarNumInscripcion controladora = new GenerarNumInscripcion();
        List<Double> escolaridad = controladora.obtenerEscolaridad(cantidadMaterias);
        List<Double> velocidad = controladora.obtenerVelocidad(creditosIngreso);
        List<Double> numerosInscripcion = controladora.obtenerNumInscripcion(promediosGenerales, escolaridad, velocidad);
        int i = 1;
        for(Double dato:numerosInscripcion){
            System.out.println("Alumno["+i+"]: "+dato);
            i++;
        }
    }
    
}
    
    
    
    
   
