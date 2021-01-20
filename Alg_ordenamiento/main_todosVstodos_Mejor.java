/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alg_ordenamiento;

import aa20201.data.Grafica;
import busquedas.GeneradorDatos;
import java.util.Arrays;

/**
 *
 * @author Haide
 */
public class main_todosVstodos_Mejor {
    
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 5000;
        int[] arr;
        int[] arr_c1;
        int[] arr_c2;
        int[] arr_c3;
        int[] arr_c4;
        int[] arr_c5;
        
        int[] aux1;
        int[] aux2;
        int[] aux3;
        int[] aux4;
        int[] aux5;
        
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];
        double[] tiempos3 = new double[n];
        double[] tiempos4 = new double[n];
        double[] tiempos5 = new double[n];
        
        MergeSort b = new MergeSort();
        InsertShort b2 = new InsertShort();
        Burbuja b3 = new Burbuja();
        BurbujaOpt b4 = new BurbujaOpt();
        Rapido b5= new Rapido();
        
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        for (int j = 0; j < n; j++){
            arr = GeneradorDatos.generarArregloInt(j,1000);//Aleatorio
            arr_c1=arr.clone();
            arr_c2=arr.clone();
            arr_c3=arr.clone();
            arr_c4=arr.clone();
            arr_c5=arr.clone();
            
            aux1 = GeneradorDatos.ordenarAsc(arr_c1);//Mejor caso
            aux2 = GeneradorDatos.ordenarAsc(arr_c2);//Mejor caso
            aux3 = GeneradorDatos.ordenarAsc(arr_c3);//Mejor caso
            aux4 = GeneradorDatos.ordenarAsc(arr_c4);//Mejor caso
            aux5 = GeneradorDatos.ordenarAsc(arr_c5);//Mejor caso
            b.ordenarMS(aux1,0,aux1.length-1);
            b2.ordenarISN(aux2);
            b3.ordenarB(aux3);
            b4.ordenarBO(aux4);
            b5.ordenarR(aux5, 0, aux5.length-1);
            System.out.println(Arrays.toString(aux1));
            System.out.println(Arrays.toString(aux2));
            System.out.println(Arrays.toString(aux3));
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();
            tiempos3[j] = (int) b3.gettTotal();
            tiempos4[j] = (int) b4.gettTotal();
            tiempos5[j] = (int) b5.gettTotal();
            //System.out.println("j= "+j+" :"+tiempos[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("MergeS",tiempos);
        g1.agregarSerie("InsertS",tiempos2);
        g1.agregarSerie("Burbuja",tiempos3);
        g1.agregarSerie("BurbujaOpt",tiempos4);
        g1.agregarSerie("Rapido",tiempos5);
        g1.crearGrafica();
        g1.muestraGrafica();
       
       
    }
    
}
