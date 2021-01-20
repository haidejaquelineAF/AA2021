/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaltoCaballo;

import javax.swing.JFrame;

/**
 *
 * @author Haide
 */
public class Main extends JFrame{
     private KnightsTour c1;
    
    public Main()throws Exception{
        this.setTitle("Caballo");
        this.setBounds(0,0,536,550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        c1=new KnightsTour();
        this.add(c1);
        this.setVisible(true);
        Thread.sleep(1000);
        c1.Resolver();
        c1.Tablero();
        
    }
        public static void main(String[]args) throws Exception{
             Main m1= new Main();
        }
        
}
