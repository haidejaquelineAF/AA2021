/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import java.util.Random;

/**
 *
 * @author Haide
 */
public class GeneradorDatos {
    
    // "aleatorio"
    public static int[] generarArregloInt(int x, int dim, int bound){
        int[] arreglo = new int[dim];
        Random ran = new Random();
       
        for(int y=0; y < dim; y++){
            arreglo[y] = ran.nextInt(bound);
        }
        int pos = ran.nextInt(dim);
        arreglo[pos] = x;
       return arreglo;
    }
    
    // peor de los casos / unico elemento
    public static int[] generarArregloIntPeorCaso(int x, int dim, int bound){
        int[] arreglo = new int[dim];
              
        for(int y=0; y < dim; y++){
            int j = generarNumeroAleatorioControlado(x, bound);
            arreglo[y] = j;
        }
        arreglo[arreglo.length-1] = x;
       return arreglo;
    }
   
    // genera numeros aleatorio en base a un valor x que no queremos que genere
    public static int generarNumeroAleatorioControlado (int x, int bound){
        Random ran = new Random();
        int aux = ran.nextInt(bound);
        while(aux==x){
         aux = ran.nextInt(bound);
        }
        return aux;
    }

    
    public static int[] generarArregloIntMejorCaso(int x, int dim, int bound){
        int[] arreglo = new int[dim];
              
        for(int y=0; y < dim; y++){
            int j = generarNumeroAleatorioControlado(x, bound);
            arreglo[y] = j;
        }
        arreglo[0] = x;
       return arreglo;
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /////////CASO MEDIO (Aleatorio)
    public static int[] generarArregloInt(int n, int bound){
        int[] arreglo = new int[n];
        Random ran = new Random();
     
        for(int y=0; y < n; y++){
            arreglo[y] = ran.nextInt(bound);
        }
        
       return arreglo;
    }
        
        
        
    //////////////MEJOR CASO
    public static int[] ordenarAsc(int[] arreglo) {
        int[]arr=arreglo.clone();
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int min = i;
 
            //buscamos el número más chico
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[j] < arr[min]) {
                    min = j;    //encontramos el número más pequeño
                }
            }
 
            if (i != min) {
                //permutamos los valores
                int aux = arr[i];
                arr[i] = arr[min];
                arr[min] = aux;
            }
        }
        
        return arr;
    }
         
    
    
    ////////////////////PEOR CASO
    public static int[] ordenarDesc(int[] arreglo) {
        
        int [] arr=arreglo.clone();
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int max = i;
 
            //buscamos el mayor número
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[j] > arr[max]) {
                    max = j;    //encontramos el mayor número
                }
            }
 
            if (i != max) {
                //permutamos los valores
                int aux = arr[i];
                arr[i] = arr[max];
                arr[max] = aux;
            }
        }
        
        return arr;
        
     }
}
