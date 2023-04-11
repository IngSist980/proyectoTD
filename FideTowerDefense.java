package proyectoluise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Clase principal del juego Fide Tower Defense.
 * Permite al jugador elegir tropas para defender su castillo y pelear contra las tropas generadas aleatoriamente por la CPU.
 * El objetivo es destruir el castillo enemigo antes de que el propio castillo sea destruido.
 */
public class FideTowerDefense {
    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private SoundPlayer soundPlayer;

    /**
     * Constructor de la clase Fide.
     * Crea un objeto SoundPlayer para reproducir efectos de sonido.
     */
    public FideTowerDefense() {
        soundPlayer = new SoundPlayer();
    }

    /**
     * Método principal del juego.
     * Crea los castillos del jugador y de la CPU, y ejecuta las oleadas del juego hasta que uno de los castillos sea destruido.
     *
     * @throws IOException si hay un problema con la entrada de datos.
     */
    public void run() throws IOException {
        Castillo castilloJugador = new Castillo();
        Castillo castilloCPU = new Castillo();

        int oleada = 1;

        while (!castilloJugador.destruido && !castilloCPU.destruido) {
            System.out.println("Oleada: " + oleada);
            int tropasMaximas = oleada + 4;

            Tropa[] tropasJugador = new Tropa[tropasMaximas];
            Tropa[] tropasCPU = new Tropa[tropasMaximas - 1];

            System.out.println("Elige tus tropas (Mago, Caballero, Arquero):");
            for (int i = 0; i < tropasMaximas; i++) {
                System.out.print("Tropa " + (i + 1) + ": ");
                String tipo = reader.readLine();
                tropasJugador[i] = new Tropa(tipo);
            }

            generarTropasCPU(tropasCPU);

            System.out.println("Las primeras 3 tropas de la CPU son:");
            for (int i = 0; i < 3; i++) {
                System.out.println("Tropa " + (i + 1) + ": " + tropasCPU[i].tipo);
            }

            for (int i = 0; i < tropasMaximas; i++) {
                for (int j = 0; j < tropasMaximas - 1; j++) {
                    if (tropasJugador[i] != null && tropasCPU[j] != null) {
                        if (tropasJugador[i].ganarEnCombate(tropasCPU[j])) {
                            tropasCPU[j] = null;
                        } else {
                            tropasJugador[i] = null;
                        }
                    }
                }
            }
            for (int i = 0; i < tropasMaximas; i++) {
                if (tropasJugador[i] != null) {
                    castilloCPU.recibirDanio(tropasJugador[i].puntosDeDanio);
                }
                if (i < tropasMaximas - 1 && tropasCPU[i] != null) {
                    castilloJugador.recibirDanio(tropasCPU[i].puntosDeDanio);
                }
            }
        }
    }
}

          