package proyectotowerdefense;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public InterfazGrafica() {
        setTitle("Fide - Tower Defense");
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

        btnIniciarCombate = new JButton("Iniciar combate");
        btnIniciarCombate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar aquí la lógica de preparación del combate y la CPU eligiendo tropas
                iniciarCombate();
            }

            private void iniciarCombate() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        contentPane.add(lblTropas, BorderLayout.SOUTH);
    }

    private void agregarTropa(Tropa tropa) {
        // Implementar aquí la lógica de agregar tropa al panelTrop


        
}
    
    
    
}
  
         

    

