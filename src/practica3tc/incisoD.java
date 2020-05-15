/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3tc;

import java.util.Scanner;

/**
 *
 * @author axel_
 */
public final class incisoD {
    
    Scanner scan = new Scanner(System.in);
    
    private String cadena;
    private int contador;
    private boolean aceptacion; 
    private int estados[][], opc;
    private String alfabeto[], qs[];
    
    public incisoD(){
        this.contador = 0;
        this.aceptacion = false;
        this.opc = 0;
        
        estados = new int[][]{
    //Se declaran los estados de la siguiente manera
    //a: si es de aceptación, ta:transicion con $0.25, tb:transición con $1.00, tc: transición con select
         //qi, a, ta, tb, tc 
            {0, 0, 1, 4, 0},
            {1, 0, 2, 5, 1},
            {2, 0, 3, 6, 2},
            {3, 0, 4, 7, 3},
            {4, 0, 5, 8, 4},
            {5, 1, 5, 5, 0},
            {6, 1, 6, 6, 0},
            {7, 1, 7, 7, 0},
            {8, 1, 8, 8, 0}
        };
        
        qs = new String[]{
            "$0.00",
            "$0.25",
            "$0.50",
            "$0.75",
            "$1.00",
            "$1.25",
            "$1.50",
            "$1.75",
            "$2.00"
        };
        
        alfabeto = new String[]{
            "$0.25",
            "$1.00",
            "Comprar"
        };
        
        edoQ(0);   //Se ejecuta al primer estado del autómata
    }
    
    public void edoQ(int n){
        this.contador = n;
        this.aceptacion = (estados[n][1]==1);
        
        printMenu();
        if(this.opc != 4)
            edoQ(estados[n][this.opc+1]);
    }
    
    public void printMenu(){
        System.out.println("\nMÁQUINA EXPENDEDORA"
                + "\nSaldo actual: " + this.qs[contador]);
        System.out.println(this.aceptacion ? " Saldo suficiente" : " Saldo insuficiente");
        for(int i = 0;i<alfabeto.length;i++){
            System.out.println((i+1)+".- " + alfabeto[i]);
        }
        System.out.println("4.- Salir");
        
        System.out.print("Opción: ");
        this.opc = Integer.parseInt(scan.nextLine().charAt(0)+"");
    }
}
