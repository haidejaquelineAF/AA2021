/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alg_ordenamiento;

/**
 *
 * @author haide
 */
public class otros {
     
   
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public otros() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int[] datos){
        this.tInicio = System.currentTimeMillis();
        ordenarDatosDesc(datos);
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

    private void ordenarDatos(int[] datos) { // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)
      int i, j, aux; // 3
        for (i = 0; i < datos.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < datos.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (datos[j + 1] < datos[j]) { // 4  13
                    aux = datos[j + 1]; // 3
                    datos[j + 1] = datos[j]; // 4
                    datos[j] = aux; // 2
                }
            }
        }
    } 
public int[] insertionSort(int numbers[]){//4 + 10n + 10n^2
 
 int i = 0; //2 
 int j, key; //2 
  
for(j=0; j<numbers.length; j++) { //10(n)
    key = numbers[j]; //2
    i = j-1; //2

    while(i>=0 && numbers[i]>key) { //10(n)(n)
        numbers[i+1]=numbers[i];//4
        i--;//1
    }
    numbers[i+1] = key;//3
}

return numbers; 

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


    private void ordenarDatosDesc(int[] arreglo) {
        //iteramos sobre los elementos del arreglo
        int i,j, max;//3
        for ( i = 0 ; i < arreglo.length - 1 ; i++) {//3(n)
             max = i; //1
 
            //buscamos el mayor número
            for ( j = i + 1 ; j < arreglo.length ; j++) { //4(n)
                if (arreglo[j] > arreglo[max]) { //3
                    max = j;    //encontramos el mayor número //1
                }
            }
 
            if (i != max) { //1
                //permutamos los valores
                int aux = arreglo[i]; //2
                arreglo[i] = arreglo[max]; //3
                arreglo[max] = aux; //2
            }
        }
    }
    
}
