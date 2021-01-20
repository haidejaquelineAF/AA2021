/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CambioMoneda;

/**
 *
 * @author Haide
 */
public class main_CambioMon {
    public static void main(String[] args) {
     
     int[]tipMonedas=new int[]{1,100,5,20,500,10,50};
     int cantidad = 1288;
     
     System.out.println ("Cambio de la cantidad de : "+cantidad );
        
     CambioMoneda01 c = new CambioMoneda01(cantidad, tipMonedas);
     
     for(int i=0; i<tipMonedas.length;i++){
         System.out.println("Billetes de "+tipMonedas[i]+": "+c.getCambio()[i]);
     }
        
    }
}
