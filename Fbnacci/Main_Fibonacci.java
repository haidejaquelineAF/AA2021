/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fbnacci;

import static Fbnacci.Fibonacci_2V.fibonacci;
import static Fbnacci.Fibonacci_2V.fibonacciRecursivo;
import static Fbnacci.Fibonacci_2V.mostrarFibRec;
import aa20201.data.Grafica;
import busquedas.GeneradorDatos;
import java.util.Arrays;


/**
 *
 * @author Haide
 */
public class Main_Fibonacci {
    public static void main(String[] args){
//        fibonacci(20);
//        
//        long elQueVaEnLa20 = fibonacciRecursivo(20);
//       System.out.println("El que va en la posición 20 es "+elQueVaEnLa20);
//       mostrarFibRec(20);
        int n = 40;
        int[] arr;
        int[] arr2;
        int[] aux;
        int[] aux2;
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];
        Fibonacci_2V b = new Fibonacci_2V();
        Fibonacci_2V b2 = new Fibonacci_2V();
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        
        for (int j = 0; j < n; j++){
            arr = GeneradorDatos.generarArregloInt(j,1000);
            arr2=arr.clone();
            b.ordenarN(j);
            b2.ordenarR(j);
            
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();
            System.out.println("j= "+j+" :"+tiempos2[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("fibonacciIter",tiempos);
        g1.agregarSerie("fibonacciRec",tiempos2);
        g1.crearGrafica();
        g1.muestraGrafica();
        
       
    }
}
