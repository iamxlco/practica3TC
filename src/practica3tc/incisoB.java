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
public final class incisoB {
    
    Automata auto;
    
    public incisoB(String cadena){
        this.auto = new Automata(cadena);
        q0();   //Se ejecuta al primer estado del autómata
    }
    
    public void q0(){
        auto.setAceptacion(true);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){  //Cambia de estado dependiendo de el caracter
                auto.aumentarContador();
                q2();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q1();
            }
        }
        else{
            printAceptacion(); //Dependiendo del valor de la aceptación imprime si es a ceptada o no
        }
    }
    
    public void q1(){
        auto.setAceptacion(true);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){
                auto.aumentarContador();
                q2();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q5();
            }
        }
        else{
            printAceptacion();
        }
    }
    
    public void q2(){
        auto.setAceptacion(false);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){
                auto.aumentarContador();
                q3();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q4();
            }
        }
        else{
            printAceptacion();
        }
    }
    
    public void q3(){
        auto.setAceptacion(true);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){
                auto.aumentarContador();
                q2();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q1();
            }
        }
        else{
            printAceptacion();
        }
    }
    
    public void q4(){
        auto.setAceptacion(false);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){
                auto.aumentarContador();
                q3();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q5();
            }
        }
        else{
            printAceptacion();
        }
    }
    
    public void q5(){
        auto.setAceptacion(false);
        if(!auto.termina()){ //Verifica que la cadena aún no haya sido recorrida por completo
            if(auto.getActualChar()=='0'){
                auto.aumentarContador();
                q5();
            }
            else if (auto.getActualChar()=='1'){
                auto.aumentarContador();
                q5();
            }
        }
        else{
            printAceptacion();
        }
    }
    
    public void printAceptacion(){
        System.out.println(auto.esAceptado() ? "Cadena aceptada" : "Cadena rechazada");
    }
}
