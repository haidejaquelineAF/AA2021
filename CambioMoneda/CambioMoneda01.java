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
public class CambioMoneda01 {
    private int[][] CambioMon; //tabla para guardar la min cantidad de monedas
    private int cantidad;//cantidad
    private int[] Cambio;//guarda los cambios de moneda, es decir, si por ejemplo, las monedas son 2,20,10 para cambiar 52
                        // guarda 1,2,1 es decir 1 moneda de 2, 2 "monedas" de 20, y 1 moneda de 10.
    private int[] vMonedas;//monedas

    CambioMoneda01(int cantidad, int[]  monedas){
        this.cantidad = cantidad; 
        this.vMonedas = monedas;
        CambioMon = calcMonedas(cantidad, monedas);
        Cambio = minMonedas(cantidad, monedas, CambioMon);
    }
     
    //cantidad es el valor que se desea cambiar, []monedas son el valor de las monedas ej, 12,{1,6,10}
    private int[][] calcMonedas(int cantidad, int[]  monedas){
        int[][] tCambio = new int[monedas.length + 1][cantidad + 1]; //retomando ese ejemplo, sería matrizcambio[4][13] 
                                                                    //para la pos 0
        for (int i = 0; i < monedas.length; i++){ //i filas, j columnas
            tCambio[i][0] = 0; /// i=0,0 = 0, 
            //System.out.println(""+matrizCambio[i][0]);
        }
        for (int j = 1; j <= cantidad; j++){
            tCambio[0][j] = 99;
           // System.out.println(""+matrizCambio[0][j]);
           // matrizToString(matrizCambio);
        } 
        //num min de monedas
        for (int i = 1; i <= monedas.length; i++){
            for (int j = 1; j <= cantidad; j++) {
                if (j < monedas[i - 1]) {//si es mayor a la moneda(1,6,10)para cuando i es 1, entonces es cuando la moneda vale 1
                                 //si es mayor a la moneda entonces la descartamos y pasamos a considerar monedas de menor valor
                    tCambio[i][j] = tCambio[i - 1][j];
                } else {
                    int minimo = 0; //guardar el min
                    minimo = minimo(tCambio[i - 1][j] , tCambio[i][j- monedas[i - 1]] + 1);//para tomar la moneda y completar 
                                                                                           //con la cantidad restante 
                    tCambio[i][j] = minimo;

                }
            }
        }
         return tCambio;
    }//Fin de calcMonedas
    
    private int[] minMonedas(int cant, int[] monedas, int[][]cambio ){
        int i,j;
        int[] seleccion = new int[monedas.length];//para regresar la cantidad de cada tipo de monedas
        
        
        for(i = 0; i< monedas.length; i++){             
            seleccion[i]=0;   //inicializamos      
        }        
        i= monedas.length;    //ej 3    
        j= cant;        //ej cantidad 12 
        
        
        //para comprobar que cada casilla su valor a cambiado respecto a la fila superior
        while(j>0){ //lo hacemos hasta que alcance la casilla t[0,0] en la que ya no queda ninguna cantidad pendiente.
            if(i>1 && cambio[i][j]==cambio[i-1][j]){//si no ha variado,es que no se ha empleado ninguna moneda del tipo de fila i
                i--;
            }
            else{
                //si ha variado, anotamos que se ha utilizado una moneda de este tipo
                seleccion[i-1]++;
                j = j - monedas[i-1]; //nos movemos a la casilla t[i, j-moneda[i]], para ver qué monedas se han utilizado 
                                        //para dar la cantidad restante
            }
        }

        return seleccion;
    }//fin de minMonedas

    //hacer la comparacion para devolver la menor cantidad de monedas
    private int minimo(int a, int b){
        int maxi =0;
        if(a<b) maxi=a;
        else maxi=b;
        
        //System.out.println(" "+maxi);
        return maxi;// si el beneficio 1 es mayor al 2 manda el b1, de lo contrario manda beneficio 2.
    }
    
    
    //Getter y setter

    public int[][] getCambioMon() {
        return CambioMon;
    }

    public void setCambioMon(int[][] CambioMon) {
        this.CambioMon = CambioMon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int[] getCambio() {
        return Cambio;
    }

    public void setCambio(int[] Cambio) {
        this.Cambio = Cambio;
    }

    public int[] getvMonedas() {
        return vMonedas;
    }

    public void setvMonedas(int[] vMonedas) {
        this.vMonedas = vMonedas;
    }
    
    
}
