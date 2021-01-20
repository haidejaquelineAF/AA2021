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
public class MergeSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public MergeSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenarMS(int[] datos, int l, int r){
        this.tInicio = System.currentTimeMillis();
        sort(datos,l,r);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    public long gettFinal() {
        return tFinal;
    }

    public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }

    public void merge(int arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Índice inicial del sub-vector arr[].
        int k = left;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void sort(int arr[], int left, int right){
        if(left < right){
        //Encuentra el punto medio del vector.
        int middle = (left + right) / 2;
      
        //Divide la primera y segunda mitad (llamada recursiva).
        sort(arr, left, middle);
        sort(arr, middle+1, right);

        //Une las mitades.
        merge(arr, left, middle, right);
        }
    }

public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }


public static void main(String[] args){   
    
     MergeSort b = new MergeSort();
     MergeSort b2 = new MergeSort();
     MergeSort b3 = new MergeSort();
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

//        System.out.println("Array original:");
//        for (int value : arr) {
//            System.out.print(value + " ");
//    
//        }
//        System.out.println();

        System.out.println("Array Medio:");
        b.ordenarMS(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
            
        System.out.println("Array Peor:");
        b2.ordenarMS(aux2, 0, aux2.length-1);
        System.out.println(Arrays.toString(aux2));
        
        System.out.println("Array Mejor:");
        b3.ordenarMS(aux3, 0, aux3.length-1);
        System.out.println(Arrays.toString(aux3));
        
    }
}
