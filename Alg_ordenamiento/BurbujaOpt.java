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
public class BurbujaOpt {
    
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public BurbujaOpt() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
    
    public void ordenarBO(int[] datos){
        this.tInicio = System.currentTimeMillis();
        Bubblesort(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public int []Bubblesort(int vector[]){	
        int aux; 
	int i,j;
        int[] arr = vector.clone();
	
        for(i = 0; i < arr.length; i++){	
            for(j = 0; j < i; j++){	
                if(vector[i] < vector [j]){	
                    aux = vector [j]; 
                    vector[j] = vector [i];
                    vector[i] = aux; 
		}                         
            }                 
	}    
        
        return arr;
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

    public static void main(String[] args){   
    
     BurbujaOpt b = new BurbujaOpt();
     BurbujaOpt b2 = new BurbujaOpt();
     BurbujaOpt b3 = new BurbujaOpt();
        int arr [] = GeneradorDatos.generarArregloInt(10,10);
        int aux2[]=GeneradorDatos.ordenarDesc(arr);
        int aux3[]=GeneradorDatos.ordenarAsc(arr);
        
        System.out.println("Array Medio Original:");
        System.out.println(Arrays.toString(arr));
        
        System.out.println("Array Peor Original:");
        System.out.println(Arrays.toString(aux2));
        
        System.out.println("Array Mejor Original:");
        System.out.println(Arrays.toString(aux3));


        System.out.println("Array Medio:");
        b.ordenarBO(arr);
        System.out.println(Arrays.toString(arr));
            
        System.out.println("Array Peor:");
        b2.ordenarBO(aux2);
        System.out.println(Arrays.toString(aux2));
        
        System.out.println("Array Mejor:");
        b3.ordenarBO(aux3);
        System.out.println(Arrays.toString(aux3));
        
    }
}
