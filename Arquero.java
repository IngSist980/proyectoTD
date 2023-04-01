package proyectotowerdefense;

/**
 *
 * @author Ryan Morales. 
 */
public class Arquero extends Tropa{
    
    public Arquero() {
        super(12, 1);
    }

    @Override
    public boolean venceA(Tropa tropa) {
        return tropa instanceof Mago;
    }
    
    
}
