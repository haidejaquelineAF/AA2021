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
public class Fibonacci_Dinamico {
    
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Fibonacci_Dinamico() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;  
    }
    
    public void ordenarDI(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacciNRD(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public void ordenarDR(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacciRD(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    
    //recursivo dinamico
    private int fibonacciRD(int n){
        int [] conocido=new int [45];
        if(conocido[n]!=0){
            return conocido[n];
        }
        int t=n;
        if(n<0){
            return 0;
        }
        if(n>1){
            t=fibonacciRD(n-1)+fibonacciRD(n-2);
        }
        return conocido[n]=t;
    }
    
    
    
    //iterativo dinamico
    private int fibonacciNRD(int n){
        int [] arreglo=new int [45];
        arreglo[0]=1;
        arreglo[1]=1;
        for(int i=2;i<n+1;i++){
             arreglo[i]=arreglo[i-1] + arreglo[i-2];
        }
        return arreglo[n-1];
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
    
    
    
    
}
