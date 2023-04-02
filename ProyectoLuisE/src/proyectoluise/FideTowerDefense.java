/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoluise;

/**
 *
 * @author Luis
 */
class FideTowerDefense {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
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
        }
    }
}