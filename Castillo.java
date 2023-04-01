package proyectotowerdefense;

/**
 *
 * @author Ryan Morales. 
 */
public class Castillo {
    
    private int vida;

    public Castillo(int vida) {
        this.vida = vida;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
    }

    public boolean estaEnPie() {
        return vida > 0;
    }
    
}
