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
public class main_MergeS {
     public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 10000;
        int[] aux;
        int[] aux_c1;
        int[] aux_c2;
        int[] aux2;
        int[] aux3;
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];
        double[] tiempos3 = new double[n];
        MergeSort b = new MergeSort();
        MergeSort b2 = new MergeSort();
        MergeSort b3 = new MergeSort();
        
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        for (int j = 0; j < n; j++){
            aux = GeneradorDatos.generarArregloInt(j,1000);
            aux_c1=aux.clone();
            aux_c2=aux.clone();
            aux2 = GeneradorDatos.ordenarDesc(aux_c1);
            aux3 = GeneradorDatos.ordenarAsc(aux_c2);
            b.ordenarMS(aux,0,aux.length-1);
            b2.ordenarMS(aux2,0,aux2.length-1);
            b3.ordenarMS(aux3,0,aux3.length-1);
            System.out.println(Arrays.toString(aux));
            System.out.println(Arrays.toString(aux2));
            System.out.println(Arrays.toString(aux3));
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();
            tiempos3[j] = (int) b3.gettTotal();
            //System.out.println("j= "+j+" :"+tiempos[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("Medio",tiempos);
        g1.agregarSerie("Peor",tiempos2);
        g1.agregarSerie("Mejor",tiempos3);
        g1.crearGrafica();
        g1.muestraGrafica();
       
       
    }
}
