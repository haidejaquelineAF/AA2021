/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaltoCaballo;

import SaltCaballo.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Haide
 */
public class KnightsTour extends JPanel{
    private final static int base =12; //es de 8, pero la creamos de 12 para tener un margen de movimiento mejor
    //movimientos que realiza el caballo
    private final static int[][]movimientos={{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
    private static int [][] grid;//para el tablero de ajedrez
    private static int total;//total de casillas
    private static int[][]TableroFinal=new int[8][8];//matriz para mostrar en el JFrame
    
    public static void Resolver()throws Exception{
        grid=new int[base][base];
        total=(base-4)*(base-4);//el total es 8+*8=64
        
        
        //inicializar grid
        for(int r=0; r<base;r++)
            for(int c=0;c<base;c++)
                if(r<2 || r>base-3 ||c<2 || c>base-3)
                    grid[r][c]=-1;            
        
//        //posic inicial al azar
        int row=2+ (int)(Math.random()*(base-4));//filas
        int col=2+ (int)(Math.random()*(base-4));//columnas
        //posic def
//        int row=8;//filas
//        int col=8;//columnas
        grid[row][col]=1; //se le coloca 1 a esa posic(sería el primer mov del caballo)
        
        if(solve(row,col,2)){
            printResult();//si es verdadero, lo mostramos
        }else{
            System.out.println("Sin resultados");//si el metodo de solucionar da falso significa que no podemos solucionarlo
        }
        
    }
    
    private static boolean solve(int r, int c, int count){ //recibe entero de filas, entero de columnas y count pos en 
                                                                //entero que el caballo ha pisado
                                                                
        if(count>total){ //si esta posicion es mayor que el total retornamos true
            return true;//porque el caballo ya pisó todas las casillas
        }
            
        //si no creamos arrayList nbrs
        List<int[]> nbrs = neighbors(r,c);
            
        if(nbrs.isEmpty() && count != total){//si esta vacío y todavía no llegamos al total
            return false;//retornamos falso porque no tenemos movimientos posibles
        }
            
        //de lo contrario llamamos a Collections.sort para ordenar nuestro arreglo nbrs 
        Collections.sort(nbrs,new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                return a[2]-b[2];
            }
        });
            //y lo recorremos
        for(int[]nb: nbrs){
            r=nb[0];//el 0 es nuestro movimiento en filas
            c=nb[1];//el 1 es nuestro movimiento en columnas
            grid[r][c]=count;//al tablero en esa posicion le ponemos el contador en la casilla que esta pisando
            
            if(!orphanDetected(count,r,c)&&solve(r,c,count+1)){//si es verdadera sera falsa,si es falso retornara verdadero,
            //entonces si este ^metodo retorna falso, se volverá verdadero y llamamos al metodo de resolver  donde se encuentra
            //la recursividad y e¿al contador le agregamos 1, y para verificar con los nuevos datos pra seguir el mov del caballo
            //es decir vuelve a llamarse a sí mismo y va aingresar con los nuevos datos 
            //si esto no se puede mover para ningun lado retornará falso y si retorna falso la casilla (linea 80)  que 
            //habíamos cambiado la volvemos a poner como 0, y volvemos a probar con otro movimiento hasta que termine el for
                return true;
            }
            
            grid[r][c]=0;
        }
        //si el for termina y no pudimos hacer ningún movimiento retornarems falso porque no podemos movernos a ningun lado
        return false;
    }//fin del metodo solve
        
    private static List<int[]> neighbors(int r, int c){
        List<int[]>nbrs = new ArrayList<>();
            
        //recorrer los movimientos que realiza el caballo para cada movimiento
        for(int[] m: movimientos){
            int x=m[0];
            int y=m[1];
            if(grid[r+y][c+x]==0){//mirar si esta en la posicion 0 significa que la casilla puede ser pisada
                int num=countNeighbors(r+y,c+x);//la mandamos la posicion en la que estamos + la posicion a la que avanzamos
                nbrs.add(new int[]{r+y,c+x,num});//al arreglo de enteros le agregamos un nuevo arreglo que va a tener
                                                //la nueva fila, la nueva columna y el num de mov disponibles para esa posicion
            }
        }
            
        return nbrs;//retorna ese arrayList
    }//fin de neighbors
        
    private static int countNeighbors(int r, int c){
        int num=0;
            
        //recorrer los movimientos que puede realizar en esa nueva celda
        for(int[] m : movimientos){
            if(grid[r+m[1]][c+m[0]]==0)//si es igual a 0 es que se puede posicionar el caballo
                num++;//aumentando para saber cuantos movimientos puede realizar el caballo
        }
            
        return num;
    }//fin de CountNeighbors
        
    private static boolean orphanDetected(int cnt, int r, int c){//recibe un contador, el num de fila en la que esta y el num columna
           
        if(cnt<total-1){//si el contador es menor que el total -1
            List<int[]>nbrs=neighbors(r,c);//crea un arrayList con el método neighbors y lo recorre
                
            for(int[] nb: nbrs){
                if(countNeighbors(nb[0],nb[1])==0){//si en esas posiciones no tenemos vecinos o lugares de llegada
                    return true;//retorna true que sign que no tenemos lugares de llegada, por lo que no nos podemos mover
                }
            }
        }
            
        return false;
    }
        
    private static void printResult(){//recorrer(imprimir) el grid(tablero)
        for(int[] row:grid){
            for(int i : row){
                if(i==-1) continue;//si encuentra un -1 es el margen que estamos dejando, ese no lo queremos imprimir, 
                                        //entonces si lo encuentra, lo unico que hace es continuar
                System.out.printf("%2d ", i);//si no, imprime i que sería el num de la casilla en la que esta
                
            }
            System.out.println();
        }
    }
    
    public static void Tablero(){
        for(int i=2; i<10; i++){
            for(int j=2; j<10; j++){
                TableroFinal[i-2][j-2]=grid[i][j]; //llenar la matriz Tablero con los resoltados que obtuvimos
                
            }
        }
        //imprimir la matriz tableroFinal
//        for (int x=0; x < TableroFinal.length; x++) {
//            System.out.print(" ");
//            for (int y=0; y < TableroFinal[x].length; y++){
//                System.out.print (TableroFinal[x][y]);
//                if (y!=TableroFinal[x].length-1) System.out.print(" ");
//            }
//            System.out.println("");
//        }
//         System.out.println("0,0"+TableroFinal[0][0]);
    }
        
    public void paint(Graphics g){ //para el tablero
        super.paint(g);
        boolean blanco = true;
        int longX = getWidth()/8;
        int longY = getHeight()/8;
      
        for(int i=0; i<9;i++){
            for(int j=0; j<9; j++){
                if(blanco){
                    g.setColor(Color.WHITE);//llenamos de espacios blancos y negros
                    blanco=false;
                }else{
                    g.setColor(Color.BLACK);
                    blanco=true;
                }
                g.fillRect(i * longX, j * longY, longX, longY);
            }
        }
      
        g.setFont(new Font(g.getFont().getFontName(),6,22));
        g.setColor(Color.GRAY);
        for (int x=0; x < TableroFinal.length; x++) {
            for (int y=0; y < TableroFinal[x].length; y++){
                g.drawString(String.valueOf(TableroFinal[x][y]),(y)*longX+25,(x+1)*longY-25);//mandamos los resultados
            }
        }
     
    }
}


