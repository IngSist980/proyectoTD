package proyectotowerdefense;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazGrafica extends JFrame {

    private JButton btnMago;
    private JButton btnCaballero;
    private JButton btnArquero;
    private JButton btnIniciarCombate;
    private JLabel lblOleada;
    private JLabel lblTropas;
    private JPanel panelTropas;
    private int tropasDisponibles = 0;
    private int oleada = 0;

    // Arrays para las tropas del jugador y la CPU
    private Tropa[] tropasJugador = new Tropa[10];
    private Tropa[] tropasCPU = new Tropa[10];
    private int numTropasJugador = 0;
    private int numTropasCPU = 0;

    public InterfazGrafica() {
        setTitle("Tower Defense-Grupo #4");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        lblOleada = new JLabel("Oleada: " + oleada);
        lblTropas = new JLabel("Tropas disponibles: " + tropasDisponibles);
        panelTropas = new JPanel(new FlowLayout());

        btnMago = new JButton("Mago");
        btnMago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tropasDisponibles > 0) {
                    agregarTropa(new Mago());
                    tropasDisponibles--;
                    lblTropas.setText("Tropas disponibles: " + tropasDisponibles);
                }
            }
        });

        btnCaballero = new JButton("Caballero");
        btnCaballero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tropasDisponibles > 0) {
                    agregarTropa(new Caballero());
                    tropasDisponibles--;
                    lblTropas.setText("Tropas disponibles: " + tropasDisponibles);
                }
            }
        });

        btnArquero = new JButton("Arquero");
        btnArquero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tropasDisponibles > 0) {
                    agregarTropa(new Arquero());
                    tropasDisponibles--;
                    lblTropas.setText("Tropas disponibles: " + tropasDisponibles);
                }
            }
        });

        btnIniciarCombate = new JButton("Iniciar Combate");
        btnIniciarCombate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  iniciarCombate();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnMago);
        panelBotones.add(btnCaballero);
        panelBotones.add(btnArquero);
        panelBotones.add(btnIniciarCombate);

        contentPane.add(panelBotones, BorderLayout.NORTH);
        contentPane.add(panelTropas, BorderLayout.CENTER);
        contentPane.add(lblOleada, BorderLayout.WEST);
    }

    private void agregarTropa(Tropa tropa) {
        TropaGUI tropaGUI = new TropaGUI(tropa); //crea un objeto TropaGUI para la tropa
      //  panelTropas
                
                }


   
        

}


