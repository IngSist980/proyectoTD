package proyectotowerdefense;

import javax.swing.SwingUtilities;

/**
 *
 * @author Ryan Morales.    
 */
public class Main {
    public static void main(String[] args) {
        InterfazGrafica interfazGrafica = new InterfazGrafica();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGrafica();
            }
        });
    }
    }
    
    

