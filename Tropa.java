package proyectotowerdefense;

/**
 *
 * @author R
 */
public abstract class Tropa extends InterfazGrafica{
    
    private int vida;
    private double danio;

    public Tropa(int vida, double danio) {
        this.vida = vida;
        this.danio = danio;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }

    // Método abstracto para determinar qué tropa vence a qué otra
    public abstract boolean venceA(Tropa tropa);
    
}
