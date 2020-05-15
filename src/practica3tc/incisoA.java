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
public final class incisoA {
    
    Scanner scan = new Scanner(System.in);
    
    private String cadena;
    private int contador;
    private boolean aceptacion; 
    private int estados[][];
    
    public incisoA(){
        String cadena = readChain();
        
        while(!cadena.equals("z")){
            this.cadena = cadena;
            this.contador = 0;
            this.aceptacion = false;

            estados = new int[][]{
        //Se declaran los estados de la siguiente manera
        //a: si es de aceptación, ta:transicion con dígito, 
        //tb:transición con signo, tc: transición con e, td: transición con punto
               //qi,a,ta,tb,tc,td
                {0, 0, 2, 1, 8, 3},
                {1, 0, 2, 8, 8, 3},
                {2, 1, 2, 8, 5, 3},
                {3, 0, 4, 8, 8, 8},
                {4, 1, 4, 8, 5, 8},
                {5, 0, 7, 6, 8, 8},
                {6, 0, 7, 8, 8, 8},
                {7, 1, 7, 8, 8, 8},
                {8, 0, 8, 8, 8, 8}
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
            if(esDigito()){
                edoQ(estados[n][2]);
            }else if(esSigno()){
                edoQ(estados[n][3]);
            }else if(esE()){
                edoQ(estados[n][4]);
            }else if(actual=='.'){
                edoQ(estados[n][5]);
            }else{
                edoQ(estados[8][0]);
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
    
    public boolean esDigito(){
        return '0'<=getActualChar() && getActualChar()<='9';
    }
    
    public boolean esSigno(){
        return getActualChar() == '+' || getActualChar() == '-';
    }
    
    public boolean esE(){
        return getActualChar() == 'E' || getActualChar() == 'e';
    }
    
    public char getActualChar(){
        return this.cadena.charAt(this.contador-1);
    }
    
    public void printAceptacion(){
        System.out.println(this.aceptacion ? "\n****Cadena ACEPTADA****\n" : "\n****Cadena RECHAZADA****\n");
    }
}
