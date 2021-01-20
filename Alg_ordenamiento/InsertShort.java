/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alg_ordenamiento;

import java.util.Arrays;

/**
 *
 * @author Haide
 */
public class InsertShort {
       
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public InsertShort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenarIS(int[] datos, int n){
        this.tInicio = System.currentTimeMillis();
        insertionSortRecursive(datos, n);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
     public void ordenarISN(int[] datos){
        this.tInicio = System.currentTimeMillis();
        insertionSort(datos);
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

 
public static void insertionSortRecursive(int arr[], int n){
 
    if(n <= 1)
        return;
    
    insertionSortRecursive(arr, n-1);
    
    int last=arr[n-1];
    int j=n-2;
    
    
    while(j>=0 && arr[j]>last)
    {
        arr[j+1]=arr[j];
        j--;
    }
    arr[j+1]=last;
 
 

}

public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }  

public void printArray(int arr[], int n){
    for(int i=0; i<n; i++){
        System.out.print(arr[i]+" ");
    }
    

}


public static void mergesort(int A[],int izq, int der){
    if (izq < der){ //1
            int m=(izq+der)/2;//4
            mergesort(A,izq, m);
            mergesort(A,m+1, der);                                                                                
            merge(A,izq, m, der);                                                                                 
    }
}
public static void merge(int A[],int izq, int m, int der){
   int i, j, k; //3
   int [] B = new int[A.length]; //4
   for (i=izq; i<=der; i++)      //7n                                     
        B[i]=A[i];//3

   i=izq; //1
   j=m+1; //2
   k=izq;//1
     
   while (i<=m && j<=der) //19n                                  
          if (B[i]<=B[j])// 9 , son4+5= 9
              A[k++]=B[i++];//5
          else //5 del de abajo
              A[k++]=B[j++];//5
        
   while (i<=m)         //7n
         A[k++]=B[i++]; //5
}


public static void main(String[] args){
    int arr[] = {12, 11, 13,5,6};
    
    insertionSortRecursive(arr, arr.length);
    
    System.out.print(Arrays.toString(arr));
    
}



  
}
