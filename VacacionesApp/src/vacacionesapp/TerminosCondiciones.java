package vacacionesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminosCondiciones extends JFrame {
    private JButton aceptarButton, rechazarButton;
    private JCheckBox aceptarCheckBox;
    private String nombreUsuario;
    private JLabel logoLabel;

    public TerminosCondiciones(String nombre) {
        this.nombreUsuario = nombre;
        setTitle("FFACSA");
        setSize(600, 500);  // Ajuste de tamaño
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana
        setLayout(new GridBagLayout());  // Seguir usando GridBagLayout
        getContentPane().setBackground(Color.DARK_GRAY);  // Fondo gris oscuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Asegura que los componentes se expandan horizontalmente
        gbc.insets = new Insets(10, 10, 10, 10);  // Añadir espacio entre los componentes

        // Logo
        ImageIcon appIcon = new ImageIcon("src/vacacionesapp/resources/logopeque.png");
        setIconImage(appIcon.getImage());  // Ícono de la ventana
        ImageIcon logoIcon = new ImageIcon("src/vacacionesapp/resources/logo.png");
        logoLabel = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // El logo ocupará el ancho de dos columnas
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar el logo
        add(logoLabel, gbc);

        // Título "Términos y Condiciones"
        JLabel tituloLabel = new JLabel("Términos y Condiciones");
        tituloLabel.setForeground(Color.WHITE);  // Texto en blanco
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));  // Fuente en negrita
        gbc.gridy = 1;  // Segunda fila
        gbc.gridwidth = 2;  // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar título
        add(tituloLabel, gbc);

        // Texto Términos y Condiciones en un JTextArea con JScrollPane
        JTextArea terminosArea = new JTextArea(
            "Al aceptar estos términos, te vuelves parte del programa de prueba del examen parcial. \n"
            + "Este programa no tiene garantía y es solo para fines académicos. \n"
            + "El participante entiende que su información solo se utilizará para la simulación.\n"
            + "Por participar, aceptas que FFACSA no se hace responsable por errores o fallos en el sistema.\n"
            + "Te comprometes a seguir las reglas del examen y respetar los plazos establecidos.\n"
            + "Recuerda que este programa es solo para fines educativos y no se utilizará con otro propósito."
        );
        terminosArea.setEditable(false);  // No editable
        terminosArea.setLineWrap(true);   // Ajusta el texto a la línea
        terminosArea.setWrapStyleWord(true);  // Ajuste de palabras
        JScrollPane scrollPane = new JScrollPane(terminosArea);  // Añadir JScrollPane para scroll

        // Ajustes del área de texto con scroll
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipady = 100;  // Altura del área de texto
        gbc.ipadx = 200;  // Ancho del área de texto
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar el área de términos
        add(scrollPane, gbc);

        // Check "Yo (nombre) acepto los términos y condiciones"
        aceptarCheckBox = new JCheckBox("Yo, " + nombreUsuario + ", acepto los términos y condiciones.");
        aceptarCheckBox.setBackground(Color.DARK_GRAY);  // Fondo gris oscuro
        aceptarCheckBox.setForeground(Color.WHITE);  // Texto en blanco
        gbc.gridy = 3;  // Posición para la casilla de aceptación
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar la casilla
        add(aceptarCheckBox, gbc);

        // Panel para botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesPanel.setBackground(Color.DARK_GRAY);  // Fondo oscuro para los botones

        // Botones "Aceptar" y "Rechazar"
        aceptarButton = new JButton("Aceptar");
        aceptarButton.setEnabled(false);  // Deshabilitado inicialmente
        rechazarButton = new JButton("Rechazar");

        // Añadir botones al panel
        botonesPanel.add(aceptarButton);
        botonesPanel.add(rechazarButton);

        // Añadir el panel de botones
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar el panel de botones
        add(botonesPanel, gbc);

        // Listener para habilitar el botón "Aceptar"
        aceptarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarButton.setEnabled(aceptarCheckBox.isSelected());
            }
        });

        // Acción del botón "Aceptar"
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaPrincipal pantalla = new PantallaPrincipal(nombreUsuario);
                pantalla.setVisible(true);
                setVisible(false);
            }
        });

        // Acción del botón "Rechazar"
        rechazarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Debe aceptar los términos para continuar");
            }
        });
    }
}
