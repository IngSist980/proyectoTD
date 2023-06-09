package proyectoluise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Random;

/**
 *
 * @author Luis
 */
class FideTowerDefense {
    static BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Castillo castilloJugador = new Castillo();
        Castillo castilloCPU = new Castillo();
        SoundPlayer s = new SoundPlayer();

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

        System.out.println("Puntos de vida del castillo del jugador: "
                + castilloJugador.puntosDeVida);
        System.out.println("Puntos de vida del castillo de la CPU: " 
                + castilloCPU.puntosDeVida);

        oleada++;
    }

    if (castilloJugador.destruido) {
        System.out.println
        ("¡El castillo del jugador ha sido destruido! La CPU gana.");
    } else {
        System.out.println
        ("¡El castillo de la CPU ha sido destruido! El jugador gana.");
    }
}

static void generarTropasCPU(Tropa[] tropasCPU) {
    String[] tipos = {"Mago", "Caballero", "Arquero"};
    int limiteTropas = (int) Math.ceil((tropasCPU.length * 75.0) / 100.0);

    for (int i = 0; i < tropasCPU.length; i++) {
        int randomIndex = (int) (Math.random() * tipos.length);
        tropasCPU[i] = new Tropa(tipos[randomIndex]);
    }

    int[] contadorTipos = {0, 0, 0};
    for (int i = 0; i < tropasCPU.length; i++) {
        for (int j = 0; j < tipos.length; j++) {
            if (tropasCPU[i].tipo.equals(tipos[j])) {
                contadorTipos[j]++;
            }
        }
    }

    for (int i = 0; i < contadorTipos.length; i++) {
        if (contadorTipos[i] > limiteTropas) {
            int count = contadorTipos[i] - limiteTropas;
            for (int j = 0; j < tropasCPU.length && count > 0; j++) {
                if (tropasCPU[j].tipo.equals(tipos[i])) {
                    int randomIndex = (int) (Math.random() * tipos.length);
                    tropasCPU[j] = new Tropa(tipos[randomIndex]);
                    count--;
                }
            }
        }
    }
}
}
    

