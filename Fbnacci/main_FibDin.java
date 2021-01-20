/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fbnacci;

import aa20201.data.Grafica;
import busquedas.GeneradorDatos;

/**
 *
 * @author Haide
 */
public class main_FibDin {
    
    
    public static void main(String[] args){

        int n = 40;
        int[] arr;
        int[] arr2;
        int[] aux;
        int[] aux2;
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];
        double[] tiempos3 = new double[n];
        double[] tiempos4 = new double[n];
        Fibonacci_Dinamico b = new Fibonacci_Dinamico();
        Fibonacci_Dinamico b2 = new Fibonacci_Dinamico();
        Fibonacci_2V c = new Fibonacci_2V();
        Fibonacci_2V c2 = new Fibonacci_2V();
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        
        for (int j = 0; j < n; j++){
            arr = GeneradorDatos.generarArregloInt(j,1000);
            arr2=arr.clone();
            b.ordenarDI(j+1);
            b2.ordenarDR(j+1);
            c.ordenarN(j+1);
            c2.ordenarR(j);
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();
            tiempos3[j] = (int) c.gettTotal();
            tiempos4[j] = (int) c2.gettTotal();
            System.out.println("j= "+j+" :"+tiempos2[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("fibIter",tiempos3);
        g1.agregarSerie("fibRec",tiempos4);
        g1.agregarSerie("fibDinaIter",tiempos);
        g1.agregarSerie("fibDinaRec",tiempos2);
        g1.crearGrafica();
        g1.muestraGrafica();
        
       
    }
    
}
