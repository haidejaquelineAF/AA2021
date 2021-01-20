/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fbnacci;

/**
 *
 * @author Haide
 */
public class Fibonacci_2V {
     public long tInicio;
    public long tFinal;
    public long tTotal;

    
    
   

    public Fibonacci_2V() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenarN(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacci(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public void ordenarR(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacciRecursivo(datos);
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
    public static int fibonacci(int posicion){
        //int[] arreglo = new int[posicion+1];
        int siguiente = 1, actual=0, temporal=0;
        for(int x = 1; x<=posicion;x++){
            //System.out.print(actual + ", ");
            temporal=actual;
            actual=siguiente;
            siguiente=siguiente+temporal;
            //arreglo[x]=actual;
            //System.out.println(arreglo[x]);
            
        }
        //System.out.println("El que va en la posicion es "+actual);
        return actual;
    }
    
    
    public static int fibonacciRecursivo(int posicion){
        if(posicion <2)
            return posicion;
        
        return fibonacciRecursivo(posicion - 1) + fibonacciRecursivo(posicion-2);
    }
    
    public static int[] mostrarFibRec(int posicion){
        int[] arreglo = new int[posicion+1];
        for(int i=0; i<=posicion; i++){
            //System.out.println(fibonacciRecursivo(i));
            arreglo[i]=fibonacciRecursivo(i);
        }
        
        return arreglo;
    }
    
    public static void main (String[] args){
        Fibonacci_2V b = new Fibonacci_2V();
        b.ordenarN(10);
        mostrarFibRec(10);
    }
}
