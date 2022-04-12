package logica;

import javax.swing.JOptionPane;
/**
 *
 * @author Mauricio Castro
 */

public class listaCircularSimple {
    private Nodo ptr;

    public listaCircularSimple() {
        this.ptr = null;
    }

    public Nodo getPtr() {
        return ptr;
    }

    public void setPtr(Nodo ptr) {
        this.ptr = ptr;
    }
    
    public boolean isVacia(){
        return this.getPtr()==null;
    }
    
    public Nodo buscarNodo(int dato){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            while(aux.getSgt() != this.getPtr()){
                if(aux.getDato()==dato){
                    return aux;
                }
                aux = aux.getSgt();
            }
            if(aux.getDato()==dato){
                return aux;
            }
        }
        return null;
    }
    
    public void insertarInicio(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            this.getPtr().setSgt(this.getPtr());
        }else{
            Nodo aux = this.getPtr();
            while(aux.getSgt() != this.getPtr()){
                aux = aux.getSgt();
            }
            nodo.setSgt(this.getPtr());
            aux.setSgt(nodo);
            this.setPtr(nodo);
        }
    }
    
    public void insertarFinal(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            this.getPtr().setSgt(this.getPtr());
        }else{
            Nodo aux = this.getPtr();
            while(aux.getSgt() != this.getPtr()){
                aux = aux.getSgt();
            }
            nodo.setSgt(this.getPtr());
            aux.setSgt(nodo);
        }
    }
    
    public void insertarDespues(Nodo nodo, int dato){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                nodo.setSgt(aux.getSgt());
                aux.setSgt(nodo);
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            }
        }
    }
    
    public void insertarAntes(Nodo nodo, int dato){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                Nodo aux2 = this.getPtr();
                while(aux2.getSgt()!=aux){
                    aux2 = aux2.getSgt();
                }
                nodo.setSgt(aux);
                aux2.setSgt(nodo);
                if(aux == this.getPtr()){
                    this.setPtr(nodo);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            }
        }
    }
    
    public boolean editarNodo(int datoNuevo, int datoBuscar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoBuscar);
            if(aux!=null){
                aux.setDato(datoNuevo);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarNodo(int datoBuscar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoBuscar);
            if(aux!=null){
                Nodo aux2 = this.getPtr();
                while(aux2.getSgt()!=aux){
                    aux2 = aux2.getSgt();
                }
                if(aux==this.getPtr()){
                    this.setPtr(aux.getSgt());
                    aux2.setSgt(aux.getSgt());
                    aux.setSgt(null);
                }else{
                    aux2.setSgt(aux.getSgt());
                    aux.setSgt(null);
                }
                return true;
            }
        }
        return false;
    }
    
    public void listar(){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            String datos = "";
            while(aux.getSgt() != this.getPtr()){
                datos += "["+aux.getDato()+"]->";
                aux = aux.getSgt();
            }
            datos += "["+aux.getDato()+"]->";
            JOptionPane.showMessageDialog(null, datos);
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia.");
        }
    }
    
    public void eliminarRepetidos(){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            Nodo aux2 = aux.getSgt();
            while(aux.getSgt()!=this.getPtr()){
                while(aux2!=this.getPtr()){
                    if(aux.getDato() == aux2.getDato()){
                        if(aux==this.getPtr()){
                            aux.setSgt(aux2.getSgt());
                        }else if(aux2.getSgt()==this.getPtr()){
                            Nodo aux3 = this.getPtr();
                            while(aux3.getSgt() != aux2){
                                aux3 = aux3.getSgt();
                            }
                            aux3.setSgt(aux2.getSgt());
                        }else{
                            Nodo aux3 = this.getPtr();
                            while(aux3.getSgt() != aux2){
                                aux3 = aux3.getSgt();
                            }
                            aux3.setSgt(aux2.getSgt());
                        }
                        aux2.setSgt(null);
                        aux2 = aux.getSgt();
                    }else{
                        aux2 = aux2.getSgt();
                    }
                }
                aux = aux.getSgt();
                aux2 = aux.getSgt();
            }
            JOptionPane.showMessageDialog(null, "Repetidos eliminados");
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
    
    
    
    
    
}
