/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila_DinamicaV2;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Haide
 */
public class mochilaDinamicV2 {
    
   Vector<Articulo> almacen = new Vector<Articulo>();
  Vector<Articulo> mochila = new Vector<Articulo>();
  
  public mochilaDinamicV2(){
        
    }
    
     //K tamaño de la mochila, n es el numero de articulos(cambiar a beneficio)
public static int mochilaDinam(int k, int[] pesos, int[] beneficio, int n){        
//        
//       System.out.println("Pesos:");
//       for(int p=0; p<pesos.length; p++){System.out.print(" "+pesos[p]);}
//       System.out.println(""); 
//       System.out.println("Beneficios:");
//       for(int i=0; i<beneficio.length; i++){System.out.print(" "+beneficio[i]);}
//        System.out.println("");
        
        
       // int n = beneficio.length; //obtener el numero de articulos
       // int p = pesos.length; //obtener ek numero de pesos
        //int[] pesoW = new int[n+1];
        
//        for (int i = 1; i <= n; i++) { //Agregamos los pesos en la posicion de 1 al tamaño, ya que la primera debe ser 0.
//            pesoW[i] = pesos[i-1]; //En la posicion 1 almacena la posicion 0 del arreglo que entra.
//        }
        
//        System.out.println("Pesos dentro:");
//       for(int pe=0; pe<pesoW.length; pe++){System.out.print(" "+pesoW[pe]);}
//       
//       System.out.println("");

        //le decimos que tiene en matriz de n+1(3+1 para incluir el 0(FILAS)) y k+1 (que es el tamaño de la mochila + 1(COLUMNAS))
        //Articulo [][] elementMatrix = new Articulo [n + 1][k + 1]; //FILAS 0,A,B,C  COMLUMNAS el tamaño de la mochila
        
        if(n==0 || k == 0){return 0;}

        else if(pesos[n-1]>k){ //si el peso del item es > al tamaño de ls mochila no puede incluirse
            return mochilaDinam(k,pesos,beneficio,n-1);
        }
        else
            return maxBen(beneficio[n-1] + mochilaDinam(k-pesos[n-1],pesos,beneficio,n-1),
                    mochilaDinam(k,pesos,beneficio,n-1));
    }   
    
    public static int maxBen(int b1, int b2){
        int maxi =0;
        if(b1>b2) maxi=b1;
        else maxi=b2;
        
        System.out.println(" "+maxi);
        return maxi;// si el beneficio 1 es mayor al 2 manda el b1, de lo contrario manda beneficio 2.
       
    }
    
        public mochilaDinamicV2(ArrayList<Patron> aux){
        cargarDatos(aux);
    }
    
    public void cargarDatos(ArrayList<Patron> aux) {
      for(Patron acum:aux){
        for(int i=0;i<50;i++){
           // System.out.println("A:"+aux.get(i).getVectorC()[0]);
           // System.out.println("A_A:"+aux.get(i).getVectorC()[1]);
            almacen.add(new Articulo( aux.get(i).getVectorC()[0], aux.get(i).getVectorC()[1]));
        }
      }
   }
}
