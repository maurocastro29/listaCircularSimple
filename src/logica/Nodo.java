package logica;

public class Nodo {
    private int dato;
    private Nodo sgt;
    
    public Nodo( int dato) {
        this.dato = dato;
        this.sgt = null;
    }
    
    public int getDato() {
        return dato;
    }
    
    public void setDato(int dato) {
        this.dato = dato;
    }
    
    public Nodo getSgt() {
        return sgt;
    }
    
    public void setSgt(Nodo sgt) {
        this.sgt = sgt;
    }   
    
}