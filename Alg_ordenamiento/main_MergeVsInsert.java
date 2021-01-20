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
public class main_MergeVsInsert {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 10000;
        int[] arr;
        int[] arr_c1;
        int[] arr_c2;
    
        
        int[] aux1;
        int[] aux2;

        
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];

        MergeSort b = new MergeSort();
        InsertShort b2 = new InsertShort();

        
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        for (int j = 0; j < n; j++){
            arr = GeneradorDatos.generarArregloInt(j,1000);//Aleatorio (Medio)
            arr_c1=arr.clone();
            arr_c2=arr.clone();

            aux1 = GeneradorDatos.ordenarAsc(arr_c1);//Mejor caso
            aux2 = GeneradorDatos.ordenarAsc(arr_c2);//Mejor caso
            
//            aux1 = GeneradorDatos.ordenarDesc(arr_c1);//peor caso
//            aux2 = GeneradorDatos.ordenarDesc(arr_c2);//peor caso
            
            b.ordenarMS(aux1,0,aux1.length-1);
            b2.ordenarIS(aux2,aux2.length);

            //System.out.println(Arrays.toString(arr_c1));
            //System.out.println(Arrays.toString(arr_c2));
            //System.out.println(Arrays.toString(arr_c3));
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();

            System.out.println("j= "+j+" :"+tiempos[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("MergeS",tiempos);
        g1.agregarSerie("InsertS",tiempos2);

        g1.crearGrafica();
        g1.muestraGrafica();
       
       
    }
    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        
//        int n = 1000;
//        int[] aux;
//        int[] arr_c1;
//        int[] aux_c1;
//
//     
//     
//        
//        double[] tiempos = new double[n];
//        double[] tiempos2 = new double[n];
//        
//        
//        MergeSort a = new MergeSort();
//        InsertShort b = new InsertShort();
//
//        
//        
//        
//       
//        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
//        for (int j = 0; j < n; j++){
//            aux = GeneradorDatos.generarArregloInt(j,1000);//Aleatorio
//            arr_c1=aux.clone(); //Medio-Insert
//            aux_c1=aux.clone(); //Medio-Merge
//           
////            aux2 = GeneradorDatos.ordenarDesc(arr_c1);//Peor-Insert
////            //aux2 = GeneradorDatos.ordenarAsc(aux);//Mejor-Insert
////            aux3 = GeneradorDatos.ordenarDesc(aux_c1);//Peor-Merge
////           // aux3 = GeneradorDatos.ordenarAsc(aux_c2); //Mejor-Merge
//            
//            
//            b.ordenarIS(arr_c1,arr_c1.length);
////            b2.ordenarIS(aux2,aux2.length);
////            b3.ordenarIS(aux3,aux3.length);
////            
//            a.ordenarMS(aux_c1,0,aux_c1.length-1);
////            a2.ordenarMS(aux2,0,aux2.length-1);
////            a3.ordenarMS(aux3,0,aux3.length-1);
//            
//            System.out.println(Arrays.toString(arr_c1));
//            System.out.println(Arrays.toString(aux_c1));
//            tiempos[j] = (int) b.gettTotal();
//            tiempos2[j] = (int) a.gettTotal();
//        }  
//        System.out.println();
//        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
//        g1.agregarSerie("MergeS",tiempos);
//        g1.agregarSerie("InsertS",tiempos2);
//        g1.crearGrafica();
//        g1.muestraGrafica();
//       
//       
//    }
    
}
