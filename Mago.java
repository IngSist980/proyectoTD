package proyectotowerdefense;

/**
 *
 * @author Ryan Morales. 
 */
public class Mago extends Tropa{
    
    public Mago() {
        super(10, 1.5);
    }

    @Override
    public boolean venceA(Tropa tropa) {
        return tropa instanceof Caballero;
    }
    
}
