/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alg_ordenamiento;

import busquedas.GeneradorDatos;
import java.util.Arrays;

/**
 *
 * @author Haide
 */
public class Rapido {
 
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Rapido() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }

    public void ordenarR(int[] datos, int izq, int der){
        this.tInicio = System.currentTimeMillis();
        quicksort(datos,izq,der);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public long gettInicio() {
        return tInicio;
    }

    public void settInicio(long tInicio) {
        this.tInicio = tInicio;
    }

    public long gettFinal() {
        return tFinal;
    }

    public void settFinal(long tFinal) {
        this.tFinal = tFinal;
    }

    public long gettTotal() {
        return tTotal;
    }

    public void settTotal(long tTotal) {
        this.tTotal = tTotal;
    }
    
    
    
    
    
    
   private static int particion(int arreglo[], int izquierda, int derecha) {
        // Elegimos el pivote, es el primero
        int pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            // Mientras cada elemento desde la izquierda esté en orden (sea menor que el
            // pivote) continúa avanzando el índice
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            // Mientras cada elemento desde la derecha esté en orden (sea mayor que el
            // pivote) continúa disminuyendo el índice
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
    /*
    Si la izquierda es mayor o igual que la derecha significa que no
    necesitamos hacer ningún intercambio
    de variables, pues los elementos ya están en orden (al menos en esta
    iteración)
    */
            if (izquierda >= derecha) {
                // Indicar "en dónde nos quedamos" para poder dividir el arreglo de nuevo
                // y ordenar los demás elementos
                return derecha;
            } else {//Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
      /*
      Si las variables quedaron "lejos" (es decir, la izquierda no superó ni
      alcanzó a la derecha)
      significa que se detuvieron porque encontraron un valor que no estaba
      en orden, así que lo intercambiamos
      */
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      /*
      Ya intercambiamos, pero seguimos avanzando los índices una vez más
      */
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }


    // Divide y vencerás
    private static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }


    private static int particion(String arreglo[], int izquierda, int derecha) {
        // Elegimos el pivote, es el primero
        String pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            // Mientras cada elemento desde la izquierda esté en orden (sea menor que el
            // pivote) continúa avanzando el índice
            while (arreglo[izquierda].compareTo(pivote) < 0) {
                izquierda++;
            }
            // Mientras cada elemento desde la derecha esté en orden (sea mayor que el
            // pivote) continúa disminuyendo el índice
            while (arreglo[derecha].compareTo(pivote) > 0) {
                derecha--;
            }
    /*
    Si la izquierda es mayor o igual que la derecha significa que no
    necesitamos hacer ningún intercambio
    de variables, pues los elementos ya están en orden (al menos en esta
    iteración)
    */
            if (izquierda >= derecha) {
                // Indicar "en dónde nos quedamos" para poder dividir el arreglo de nuevo
                // y ordenar los demás elementos
                return derecha;
            } else {//Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
      /*
      Si las variables quedaron "lejos" (es decir, la izquierda no superó ni
      alcanzó a la derecha)
      significa que se detuvieron porque encontraron un valor que no estaba
      en orden, así que lo intercambiamos
      */
                String temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      /*
      Ya intercambiamos, pero seguimos avanzando los índices una vez más
      */
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }

    // Divide y vencerás
    private static void quicksort(String arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }

    public static void main(String[] args){   
    
     Rapido b = new Rapido();
     Rapido b2 = new Rapido();
     Rapido b3 = new Rapido();
     
     
        int arr [] = GeneradorDatos.generarArregloInt(10,10);
        System.out.println("Array Medio Original:");
        System.out.println(Arrays.toString(arr));
        int arr2[] =arr.clone();
        int arr3[] = arr.clone();
        
        int aux2[]=GeneradorDatos.ordenarDesc(arr2);
        System.out.println("Array Peor Original:");
        System.out.println(Arrays.toString(aux2));
        
        int aux3[]=GeneradorDatos.ordenarAsc(arr3);
        System.out.println("Array Mejor Original:");
        System.out.println(Arrays.toString(aux3));


        System.out.println("Array Medio:");
        b.ordenarR(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
            
        System.out.println("Array Peor:");
        b2.ordenarR(aux2, 0, aux2.length-1);
        System.out.println(Arrays.toString(aux2));
        
        System.out.println("Array Mejor:");
        b3.ordenarR(aux3, 0, aux3.length-1);
        System.out.println(Arrays.toString(aux3));
        
     
        
    }
}
