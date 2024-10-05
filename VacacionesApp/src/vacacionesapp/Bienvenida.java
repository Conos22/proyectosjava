package vacacionesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida extends JFrame {
    private JTextField nombreTextField;
    private JButton continuarButton;
    private JLabel logoLabel,piePaginaLabel;
    public Bienvenida() {
        setTitle("FFACSA");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        //LOGO
         ImageIcon appIcon = new ImageIcon("src/vacacionesapp/resources/logopeque.png");
        setIconImage(appIcon.getImage());  // Para el ícono de la ventana (favicon)
         ImageIcon logoIcon = new ImageIcon("src/vacacionesapp/resources/logo.png");
        logoLabel = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(logoLabel, gbc);


        // Texto "BIENVENIDO"
        JLabel bienvenidaLabel = new JLabel("BIENVENIDO");
        bienvenidaLabel.setForeground(Color.WHITE);  // Color de texto blanco
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Tamaño grande
        bienvenidaLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(bienvenidaLabel, gbc);

        // Etiqueta Nombre
        JLabel nombreLabel = new JLabel("Ingrese su nombre:");
        nombreLabel.setForeground(Color.WHITE); // Texto en blanco
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(nombreLabel, gbc);

        // Cuadro de texto Nombre
        nombreTextField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(nombreTextField, gbc);
// Pie de página
        piePaginaLabel = new JLabel("FFACSA | NOE DAVID ALEXANDER CONOS RIVAS | PROGRAMACIÓN 2 | Sección A");
        piePaginaLabel.setForeground(Color.LIGHT_GRAY);
        piePaginaLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Más pequeño
        piePaginaLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(piePaginaLabel, gbc);
        // Botón Continuar
        continuarButton = new JButton("Continuar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        continuarButton.setPreferredSize(new Dimension(200, 40));
        add(continuarButton, gbc);

        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                } else {
                    TerminosCondiciones terminos = new TerminosCondiciones(nombreTextField.getText());
                    terminos.setVisible(true);
                    setVisible(false);
                }
            }
        });
    }
}
