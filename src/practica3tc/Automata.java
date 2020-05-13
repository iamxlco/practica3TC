package practica3tc;


public class Automata {
    
    private String cadena;
    private int contador;
    private boolean aceptacion;
    
    
    public Automata(String cadena){
        this.cadena = cadena;
        this.contador = 0;
        this.aceptacion = false;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean esAceptado() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }
    
    public void aumentarContador(){
        this.contador++;
    }
    
    public char getActualChar(){
        return this.cadena.charAt(this.contador);
    }
    
    public boolean termina(){
        return this.cadena.length() == this.contador;
    }
}
