import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaEjemplo extends JFrame {
    private DefaultTableModel modelo;
    private JTable tabla;
    private JButton btnAgregar;
    private JTextField txtNombre;
    private JTextField txtEdad;

    public TablaEjemplo() {
        setTitle("Ejemplo de Tabla en Java");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear modelo de tabla con columnas
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");

        // Crear tabla con el modelo
        tabla = new JTable(modelo);

        // Crear botón y campos de texto
        btnAgregar = new JButton("Agregar");
        txtNombre = new JTextField(10);
        txtEdad = new JTextField(5);

        // Agregar componentes al contenedor
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Edad:"));
        panel.add(txtEdad);
        panel.add(btnAgregar);

        // Escuchar eventos del botón Agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarFila();
            }
        });

        // Agregar componentes al contenedor principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(new JScrollPane(tabla), BorderLayout.CENTER);
        container.add(panel, BorderLayout.SOUTH);
    }

    private void agregarFila() {
        String nombre = txtNombre.getText();
        String edad = txtEdad.getText();

        // Agregar datos a la tabla
        modelo.addRow(new Object[]{nombre, edad});

        // Limpiar campos de texto
        txtNombre.setText("");
        txtEdad.setText("" );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TablaEjemplo ventana = new TablaEjemplo();
                ventana.setVisible(true);
            }
        });
    }
}