/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

/**
 *
 * @author Haide
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    String[] nombre_nodos = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    Double[] coordenadasX = {20.0, 18.0, 22.0, 13.0, 3.0, 18.0, 30.0, 5.0, 14.0};
    Double[] coordenadasY = {3.0, 26.0, 27.0, 31.0, 32.0, 37.0, 35.0, 42.0, 52.0};
    List<String> lista_nombre_nodos = new ArrayList<>();
    List<Double> lista_coordenadasX = new ArrayList<>();
    List<Double> lista_coordenadasY = new ArrayList<>();

    String[] v_nodos = new String[lista_nombre_nodos.size()];
    double[][] coordenadas_XY;
    double[] ruta;
    
    public void principal() {

        Pasar_Arrays_a_Listas();
        Pasar_Listas_a_Arrays();

        // Calculos v_distancias entre nodos.  
        double n2 = Math.pow(coordenadas_XY.length, 2);
        double[] v_distancias = new double[(int) n2];
        v_distancias = getDistancia(coordenadas_XY);

        TSP_FuerzaBruta tspfb = new TSP_FuerzaBruta(lista_nombre_nodos, v_distancias);

        // Mostrar datos
        Mostrar_Listas();
        Mostrar_Tabla(v_distancias, "\nTabla distancias:");
        System.out.println("\nCalculando ruta...");
        System.out.println(tspfb.getRuta());
        System.out.println("\nDistancia recorrida:");
        System.out.println((double) tspfb.getDistanciaRecorrida() / 100000);

    }

    private void Pasar_Arrays_a_Listas() {
        lista_nombre_nodos.addAll(Arrays.asList(nombre_nodos));
        lista_coordenadasX.addAll(Arrays.asList(coordenadasX));
        lista_coordenadasY.addAll(Arrays.asList(coordenadasY));
    }

    private void Pasar_Listas_a_Arrays() {
        v_nodos = lista_nombre_nodos.toArray(v_nodos);
        coordenadas_XY = new double[lista_coordenadasX.size()][lista_coordenadasY.size()];
        for (int i = 0; i < coordenadas_XY.length; i++) {
            coordenadas_XY[0][i] = lista_coordenadasX.get(i);
            coordenadas_XY[1][i] = lista_coordenadasY.get(i);
        }
    }

    private void Mostrar_Listas() {
        System.out.println("\nNodos:\n" + lista_nombre_nodos);
        System.out.println("\nCoordenadas:");
        System.out.println("X: " + lista_coordenadasX);
        System.out.println("Y: " + lista_coordenadasY);
    }
public void Mostrar_Tabla(double[] v1, String msg) {
        System.out.println(msg);
        int n = (int) Math.sqrt(v1.length);
        double t1[][] = new double[n][n];
        int cont = 0;
        String aux = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t1[j][i] = v1[cont];
                aux += ((int) (t1[j][i] * 100000)) + "\t";
                cont++;
            }
            System.out.println(aux);
            aux = "";
        }
    }

    public double[] getDistancia(double[][] xy) {
        int cont = 0;
        double[] v1 = new double[xy[0].length * xy[0].length];
        for (int i = 0; i < xy[0].length; i++) {
            for (int j = 0; j < xy[0].length; j++) {
                v1[cont] = Math.sqrt(Math.pow((xy[0][i] - xy[0][j]), 2) + Math.pow((xy[1][i] - xy[1][j]), 2));
                cont++;
            }
        }
        return v1;
    }

}

