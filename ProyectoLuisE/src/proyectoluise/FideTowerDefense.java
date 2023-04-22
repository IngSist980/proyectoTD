package proyectoluise;



/**
 *
 * @author Luis
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FideTowerDefense {
    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Castillo castilloJugador = new Castillo();
        Castillo castilloCPU = new Castillo();
        SoundPlayer s = new SoundPlayer();
        s.reproducirEfectoDeSonido("mario.wav");

        int oleada = 1;

        while (!castilloJugador.destruido && !castilloCPU.destruido) {
            System.out.println("Oleada: " + oleada);
            int tropasMaximas = oleada + 4;

            Cola tropasJugador = new Cola();
            Cola tropasCPU = new Cola();

            System.out.println("Elige tus tropas (Mago, Caballero, Arquero):");
            for (int i = 0; i < tropasMaximas; i++) {
                System.out.print("Tropa " + (i + 1) + ": ");
                String tipo = reader.readLine();
                tropasJugador.agregar(new Tropa(tipo));
            }

            generarTropasCPU(tropasCPU, tropasMaximas - 1);

            System.out.println("Las primeras 3 tropas de la CPU son:");
            Cola copiaTropasCPU = copiarCola(tropasCPU);
            for (int i = 0; i < 3; i++) {
                Tropa t = copiaTropasCPU.sacar();
                System.out.println("Tropa " + (i + 1) + ": " + t.tipo);
            }

            for (int i = 0; i < tropasMaximas; i++) {
                Tropa jugadorTropa = tropasJugador.sacar();
                if (jugadorTropa == null) break;
                for (int j = 0; j < tropasMaximas - 1; j++) {
                    Tropa cpuTropa = tropasCPU.sacar();
                    if (cpuTropa == null) break;

                    if (jugadorTropa.ganarEnCombate(cpuTropa)) {
                        // No se añade la tropa de la CPU a la cola
                    } else {
                        tropasCPU.agregar(cpuTropa);
                    }
                }
            }

            Tropa t;
            while ((t = tropasJugador.sacar()) != null) {
                castilloCPU.recibirDanio(t.puntosDeDanio);
            }
            while ((t = tropasCPU.sacar()) != null) {
                castilloJugador.recibirDanio(t.puntosDeDanio);
            }

            System.out.println("Puntos de vida del castillo del jugador: "
                    + castilloJugador.puntosDeVida);
            System.out.println("Puntos de vida del castillo de la CPU: "
                    + castilloCPU.puntosDeVida);
            s.reproducirEfectoDeSonido("fin_oleada.wav");

            oleada++;
        }
        

        if (castilloJugador.destruido) {
            System.out.println
                    ("¡El castillo del jugador ha sido destruido! La CPU gana.");
            s.reproducirEfectoDeSonido("derrota.wav");
        } else {
            System.out.println
                    ("¡El castillo de la CPU ha sido destruido! El jugador gana.");
            s.reproducirEfectoDeSonido("victoria.wav");
        }
    }
    static void generarTropasCPU(Cola tropasCPU, int tropasMaximas) {
        String[] tipos = {"Mago", "Caballero", "Arquero"};
        int limiteTropas = (int) Math.ceil((tropasMaximas * 75.0) / 100.0);

        for (int i = 0; i < tropasMaximas; i++) {
            int randomIndex = (int) (Math.random() * tipos.length);
            tropasCPU.agregar(new Tropa(tipos[randomIndex]));
        }

        int[] contadorTipos = {0, 0, 0};
        Cola copiaTropasCPU = copiarCola(tropasCPU);
        for (int i = 0; i < tropasMaximas; i++) {
            Tropa t = copiaTropasCPU.sacar();
            if (t == null) break;
            for (int j = 0; j < tipos.length; j++) {
                if (t.tipo.equals(tipos[j])) {
                    contadorTipos[j]++;
                }
            }
        }

        for (int i = 0; i < contadorTipos.length; i++) {
    if (contadorTipos[i] > limiteTropas) {
        int count = contadorTipos[i] - limiteTropas;
        Cola nuevaCola = new Cola();
        Tropa t;
        while ((t = tropasCPU.sacar()) != null) {
            if (t.tipo.equals(tipos[i]) && count > 0) {
                int randomIndex = (int) (Math.random() * tipos.length);
                nuevaCola.agregar(new Tropa(tipos[randomIndex]));
                count--;
            } else {
                nuevaCola.agregar(t);
            }
        }
        tropasCPU = nuevaCola;
    }
}

    }

    static Cola copiarCola(Cola colaOriginal) {
        Cola copia = new Cola();
        Cola colaTemp = new Cola();
        Tropa t;
        while ((t = colaOriginal.sacar()) != null) {
            copia.agregar(t);
            colaTemp.agregar(t);
        }
        while ((t = colaTemp.sacar()) != null) {
            colaOriginal.agregar(t);
        }
        return copia;
    }
}


