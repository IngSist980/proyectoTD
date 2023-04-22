package proyectoluise;

/**
 *
 * @author Ryan Morales. 
 */
class Cola {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    
    public Cola() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }
    
    public void agregar(Tropa tropa) {
        Nodo nuevoNodo = new Nodo(tropa);
        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.siguiente = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        }
    }
    
    public Tropa sacar() {
        if (this.primerNodo == null) {
            return null;
        } else {
            Tropa tropa = this.primerNodo.tropa;
            this.primerNodo = this.primerNodo.siguiente;
            if (this.primerNodo == null) {
                this.ultimoNodo = null;
            }
            return tropa;
        }
    }
    
    private class Nodo {
        public Tropa tropa;
        public Nodo siguiente;
        
        public Nodo(Tropa tropa) {
            this.tropa = tropa;
            this.siguiente = null;
        }
    }
}
