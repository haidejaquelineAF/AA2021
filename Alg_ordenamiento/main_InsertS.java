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
public class main_InsertS {
        public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 10000;
        int[] aux;
        int[] aux2;
        int[] aux3;
        double[] tiempos = new double[n];
        double[] tiempos2 = new double[n];
        double[] tiempos3 = new double[n];
        InsertShort b = new InsertShort();
        InsertShort b2 = new InsertShort();
        InsertShort b3 = new InsertShort();
       
        for (int j = 0; j < n; j++){
            aux = GeneradorDatos.generarArregloInt(j,1000);
            aux2 = GeneradorDatos.ordenarDesc(aux);
            aux3 = GeneradorDatos.ordenarAsc(aux);
            b.ordenarISN(aux);
            b2.ordenarISN(aux2);
            b3.ordenarISN(aux3);
            System.out.println(Arrays.toString(aux));
            System.out.println(Arrays.toString(aux2));
            System.out.println(Arrays.toString(aux3));
            tiempos[j] = (int) b.gettTotal();
            tiempos2[j] = (int) b2.gettTotal();
            tiempos3[j] = (int) b3.gettTotal();
            
            //System.out.println("Pj= "+j+" :"+tiempos[j]);
            //System.out.println("Mj= "+j+" :"+tiempos2[j]);
        }  
        //System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("Medio",tiempos);
        g1.agregarSerie("Peor",tiempos2);
        g1.agregarSerie("Mejor",tiempos3);
        g1.crearGrafica();
        g1.muestraGrafica();
       
       
    }
    
}
