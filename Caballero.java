package proyectotowerdefense;

/**
 *
 * @author Ryan Morales. 
 */
public class Caballero extends Tropa{
    
    public Caballero() {
        super(15, 2);
    }

    @Override
    public boolean venceA(Tropa tropa) {
        return tropa instanceof Arquero;
    }
    
}
