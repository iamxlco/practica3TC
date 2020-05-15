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
public final class incisoD {
    
    private String cadena;
    private int contador;
    private boolean aceptacion; 
    private int estados[][];
    private String alfabeto[];
    
    public incisoD(){
        this.cadena = cadena;
        this.contador = 0;
        this.aceptacion = false;
        
        estados = new int[][]{
    //Se declaran los estados de la siguiente manera
    //a: si es de aceptación, ta:transicion con $0.25, tb:transición con $1.00, tc: transición con select
         //qi, a, ta, tb, tc 
            {0, 0, 1, 5, 0},
            {1, 0, 2, 6, 1},
            {2, 0, 3, 7, 2},
            {3, 0, 5, 8, 3},
            {4, 0, 6, 8, 4},
            {5, 1, 5, 5, 0},
            {6, 1, 6, 6, 0},
            {7, 1, 7, 7, 0},
            {8, 1, 8, 8, 0}
        };
        
        alfabeto = new String[]{
            "$0.25",
            "$1.00",
            "select"
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
    
    public void printMenu(){
        System.out.println("MÁQUINA EXPENDEDORA");
        for(int i = 0;i<alfabeto.length;i++){
            System.out.println((i+1)+".- " + alfabeto[i]);
        }
        System.out.println("4.- Salir");
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
