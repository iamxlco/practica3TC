/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3tc;

/**
 *
 * @author axel_
 */
public final class incisoC {
    
    private String cadena;
    private int contador;
    private boolean aceptacion; 
    private int estados[][];
    
    public incisoC(String cadena){
        this.cadena = cadena;
        this.contador = 0;
        this.aceptacion = false;
        
        estados = new int[][]{
    //Se declaran los estados de la siguiente manera
    //a: si es de aceptación, ta:transicion con a, tb:transición con b, tc: transición con c
         //qi, a, ta, tb, tc 
            {0, 0, 1, 2, 3},
            {1, 0, 4, 7, 9},
            {2, 0, 8, 5, 9},
            {3, 0, 8, 7, 6},
            {4, 0, 10, 10, 10},
            {5, 0, 10, 10, 10},
            {6, 0, 10, 10, 10},
            {7, 0, 11, 10, 11},
            {8, 0, 10, 11, 11},
            {9, 0, 11, 11, 10},
            {10, 1, 11, 11, 11},
            {11, 0, 11, 11, 11},
        };
        
        edoQ(0);   //Se ejecuta al primer estado del autómata
    }
    
    public void edoQ(int n){
        this.aceptacion = (estados[n][1]==1);
        if(!termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            this.contador++;
            switch (getActualChar()) {//Cambia de estado dependiendo de el caracter, el numero de estado lo toma de el array bidimensional
                case 'a':
                    edoQ(estados[n][2]);
                    break;
                case 'b':
                    edoQ(estados[n][3]);
                    break;
                case 'c':
                    edoQ(estados[n][4]);
                    break;
                default:
                    break;
            }
        }
        else{
            printAceptacion(); //Cuando termina dependiendo del valor de la aceptación imprime si es a ceptada o no
        }
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
