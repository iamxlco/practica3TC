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
public final class incisoB {
    
    Scanner scan = new Scanner(System.in);
    
    private String cadena;
    private int contador;
    private boolean aceptacion; 
    private int estados[][];
    
    public incisoB(){
        String cadena = readChain();
        
        while(!cadena.equals("z")){
            this.cadena = cadena;
            this.contador = 0;
            this.aceptacion = false;

            estados = new int[][]{
        //Se declaran los estados de la siguiente manera
        //a: si es de aceptación, ta:transicion con 0, tb:transición con 1
             //qi, a, ta, tb
                {0, 1, 2, 1},
                {1, 1, 2, 5},
                {2, 0, 3, 4},
                {3, 1, 2, 1},
                {4, 0, 3, 5},
                {5, 0, 5, 5}
            };

            edoQ(0);   //Se ejecuta al primer estado del autómata
            
            cadena = readChain();
        }
        
        
        
    }
    
    public void edoQ(int n){
        this.aceptacion = (estados[n][1]==1); //Aquí obtiene la aceptación del estado en el que se encuentra, lo iguala con int para obtener booleano
        if(!termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            this.contador++;
            char actual = getActualChar();
            switch (actual) {//Cambia de estado dependiendo de el caracter, el numero de estado lo toma de el array bidimensional
                case '0':
                    edoQ(estados[n][2]);
                    break;
                case '1':
                    edoQ(estados[n][3]);
                    break;
                default:
                    break;
            }
        }
        else{
            printAceptacion(); //Cuando termina dependiendo del valor de la aceptación imprime si es a ceptada o no
        }
    }
    
    public String readChain(){
        System.out.println("Para salir escriba z");
        System.out.print("Inserte la cadena: ");
        return scan.nextLine();
    }
    
    public boolean termina(){
        return this.cadena.length() == this.contador;
    }
    
    public char getActualChar(){
        return this.cadena.charAt(this.contador-1);
    }
    
    public void printAceptacion(){
        System.out.println(this.aceptacion ? "Cadena aceptada" : "Cadena rechazada");
    }
}
