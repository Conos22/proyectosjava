package vacacionesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private JComboBox<String> departamentoComboBox;
    private JComboBox<String> antiguedadComboBox;
    private JTextField nombreField, apellidosField;
    private JButton calcularButton, cambiarColorButton, mostrarInfoButton, regresarButton;
    private JLabel resultadoLabel, logoLabel, piePaginaLabel;
    private String nombreUsuario;

    public PantallaPrincipal(String nombre) {
        this.nombreUsuario = nombre;
        setTitle("FFACSA");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.DARK_GRAY);

        // Establecer el ícono de la ventana
        ImageIcon appIcon = new ImageIcon("src/vacacionesapp/resources/logopeque.png");
        setIconImage(appIcon.getImage());  // Para el ícono de la ventana (favicon)

        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Barra superior (logo + botones estilo menú superior)
        JPanel barraSuperiorPanel = new JPanel();
        barraSuperiorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        barraSuperiorPanel.setBackground(Color.DARK_GRAY);

        // Logo
        ImageIcon logoIcon = new ImageIcon("src/vacacionesapp/resources/logo.png");
        logoLabel = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(logoLabel, gbc);
        barraSuperiorPanel.add(logoLabel);

        // Botón Mostrar Información
        mostrarInfoButton = new JButton("Autor");
        barraSuperiorPanel.add(mostrarInfoButton);

        // Botón Cambiar Color de Fondo
        cambiarColorButton = new JButton("Color Fondo");
        barraSuperiorPanel.add(cambiarColorButton);

        // Botón Regresar a Bienvenida
        regresarButton = new JButton("Bienvenida");
        barraSuperiorPanel.add(regresarButton);

        // Añadir barra superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        add(barraSuperiorPanel, gbc);

        // Campos de nombre y apellidos
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(nombreField, gbc);

        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(apellidosLabel, gbc);

        apellidosField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(apellidosField, gbc);

        // Departamento
        JLabel departamentoLabel = new JLabel("Seleccione su departamento:");
        departamentoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(departamentoLabel, gbc);

        departamentoComboBox = new JComboBox<>(new String[]{"Atención al cliente", "Logística", "Gerencia"});
        departamentoComboBox.setPreferredSize(new Dimension(100, 20)); // Más pequeño
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(departamentoComboBox, gbc);

        // Antigüedad
        JLabel antiguedadLabel = new JLabel("Seleccione su antigüedad:");
        antiguedadLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(antiguedadLabel, gbc);

        antiguedadComboBox = new JComboBox<>(new String[]{"1 año", "2 a 6 años", "+7 años"});
        antiguedadComboBox.setPreferredSize(new Dimension(100, 20)); // Más pequeño
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(antiguedadComboBox, gbc);

        // Botón Calcular
        calcularButton = new JButton("Calcular Vacaciones");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(calcularButton, gbc);

        // Resultado
        resultadoLabel = new JLabel("Días de vacaciones: ");
        resultadoLabel.setForeground(Color.WHITE);
        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(resultadoLabel, gbc);

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

        // Acción del botón Calcular
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDiasVacaciones();
            }
        });

        // Acción del botón Cambiar Color de Fondo
        cambiarColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMenuDeColores(); // Mostramos el menú con las opciones de color
            }
        });

        // Acción del botón Mostrar Información
        mostrarInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion();
            }
        });

        // Acción del botón Regresar a Bienvenida
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarABienvenida();
            }
        });
    }

    private void calcularDiasVacaciones() {
        String departamento = (String) departamentoComboBox.getSelectedItem();
        String antiguedad = (String) antiguedadComboBox.getSelectedItem();
        int diasVacaciones = 0;

        if (departamento.equals("Atención al cliente")) {
            if (antiguedad.equals("1 año")) {
                diasVacaciones = 6;
            } else if (antiguedad.equals("2 a 6 años")) {
                diasVacaciones = 14;
            } else if (antiguedad.equals("+7 años")) {
                diasVacaciones = 20;
            }
        } else if (departamento.equals("Logística")) {
            if (antiguedad.equals("1 año")) {
                diasVacaciones = 7;
            } else if (antiguedad.equals("2 a 6 años")) {
                diasVacaciones = 15;
            } else if (antiguedad.equals("+7 años")) {
                diasVacaciones = 22;
            }
        } else if (departamento.equals("Gerencia")) {
            if (antiguedad.equals("1 año")) {
                diasVacaciones = 10;
            } else if (antiguedad.equals("2 a 6 años")) {
                diasVacaciones = 20;
            } else if (antiguedad.equals("+7 años")) {
                diasVacaciones = 30;
            }
        }

        String nombreCompleto = nombreField.getText() + " " + apellidosField.getText();
        resultadoLabel.setText(nombreCompleto + ", Días de vacaciones: " + diasVacaciones);
    }

    private void mostrarMenuDeColores() {
        // Crear un menú emergente con las opciones de color
        JPopupMenu menuColores = new JPopupMenu();

        // Opción de color Amarillo Huevo
        JMenuItem amarilloItem = new JMenuItem("Amarillo");
        amarilloItem.addActionListener(e -> getContentPane().setBackground(new Color(255, 255, 102)));
        menuColores.add(amarilloItem);

        // Opción de color Rojo Pasión
        JMenuItem rojoItem = new JMenuItem("Rojo");//Trabaja con RGB por eso son 3 coordenadas(R,G,B)
        rojoItem.addActionListener(e -> getContentPane().setBackground(new Color(255, 51, 51))); 
        menuColores.add(rojoItem);

        // Opción de color Base (Gris Oscuro)
        JMenuItem baseItem = new JMenuItem("Color Base");
        baseItem.addActionListener(e -> getContentPane().setBackground(Color.DARK_GRAY));
        menuColores.add(baseItem);

        // Mostrar el menú de colores debajo del botón
        menuColores.show(cambiarColorButton, cambiarColorButton.getWidth() / 2, cambiarColorButton.getHeight() / 2);
    }

    private void mostrarInformacion() {
        JOptionPane.showMessageDialog(this, "Autor: Noe David Alexander Conos Rivas\nGrado: Cuarto Semestre\nCurso: Programación 2\nSección: A", "Información del Autor", JOptionPane.INFORMATION_MESSAGE);
    }

    private void regresarABienvenida() {
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setVisible(true);
        dispose(); // Cerrar la pantalla actual
    }

    public static void main(String[] args) {
        PantallaPrincipal pantalla = new PantallaPrincipal("Usuario");
        pantalla.setVisible(true);
    }
}
