import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Tabla extends JFrame implements ActionListener {

    FondoPanel fondo = new FondoPanel();

    private JLabel lbtitulo;
    private JButton btnuevo, btactualizar, bteliminar, btcerrar;

    String[] columnas = { "ID", "usuario", "nombre", "Apellido", "telefono", "correo", };
    String nombre, apellido, telefono, correo, usuario;
    int ID;

    private JTable tabla;
    private JScrollPane scroll;
    private DefaultTableModel modelo = new DefaultTableModel(null, columnas);

    class FondoPanel extends JPanel {
        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("imagenes/32.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);

        }

    }

    public Tabla() {

        this.setContentPane(fondo);
        setLayout(null);
        setTitle("System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/t.png")).getImage());

        lbtitulo = new JLabel("Usuarios registrados", SwingConstants.CENTER);
        lbtitulo.setBounds(180, 10, 350, 25);
        lbtitulo.setFont(new Font("Bodoni MT Black", 1, 25));
        lbtitulo.setForeground(new Color(255, 239, 0));
        lbtitulo.setOpaque(false);
        add(lbtitulo);

        btnuevo = new JButton("Nuevo");
        btnuevo.setBounds(40, 255, 105, 30);
        btnuevo.setBackground(new Color(0, 0, 0));
        btnuevo.setForeground(new Color(2, 196, 56));
        btnuevo.setFont(new Font("Bodoni MT Black", 1, 20));
        btnuevo.addActionListener(this);
        add(btnuevo);

        btactualizar = new JButton("Actualizar");
        btactualizar.setBounds(190, 255, 140, 30);
        btactualizar.setBackground(new Color(0, 0, 0));
        btactualizar.setForeground(new Color(2, 196, 56));
        btactualizar.setFont(new Font("Bodoni MT Black", 1, 20));
        btactualizar.addActionListener(this);
        add(btactualizar);

        bteliminar = new JButton("Eliminar");
        bteliminar.setBounds(370, 255, 150, 30);
        bteliminar.setBackground(new Color(0, 0, 0));
        bteliminar.setForeground(new Color(2, 196, 56));
        bteliminar.setFont(new Font("Bodoni MT Black", 1, 20));
        bteliminar.addActionListener(this);
        add(bteliminar);

        btcerrar = new JButton("Cerrar");
        btcerrar.setBounds(560, 255, 120, 30);
        btcerrar.setBackground(new Color(0, 0, 0));
        btcerrar.setForeground(new Color(228, 19, 19));
        btcerrar.setFont(new Font("Bodoni MT Black", 1, 20));
        btcerrar.addActionListener(this);
        add(btcerrar);

        tabla = new JTable(modelo);
        tabla.setEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(23, 60, 700, 180);
        add(scroll);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
            Statement st = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from usuarios");
            while (rs.next()) {
                ID = rs.getInt("ID");
                usuario = rs.getString("usuario");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                telefono = rs.getString("telefono");
                correo = rs.getString("correo");
                modelo.addRow(new Object[] { ID, usuario, nombre, apellido, telefono, correo, });
            }
        } catch (Exception evt) {

        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnuevo) {
            Nuevo ventananuevo = new Nuevo();
            ventananuevo.setBounds(90, 90, 900, 700);
            ventananuevo.setVisible(true);
            ventananuevo.setResizable(false);
            ventananuevo.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if (e.getSource() == btactualizar) {
            Actualizar ventanaactualizar = new Actualizar();
            ventanaactualizar.setBounds(0,0,900,700);
            ventanaactualizar.setVisible(true);
            ventanaactualizar.setResizable(false);
            ventanaactualizar.setLocationRelativeTo(null);
            this.setVisible(false);

        }
        if (e.getSource() == bteliminar) {
            Eliminar ventanaeliminar = new Eliminar();
            ventanaeliminar.setBounds(0,0,500,200);
            ventanaeliminar.setVisible(true);
            ventanaeliminar.setResizable(false);
            ventanaeliminar.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if (e.getSource() == btcerrar) {
            login ventanalogin = new login();
            ventanalogin.setBounds(90, 90, 900, 500);
            ventanalogin.setVisible(true);
            ventanalogin.setResizable(false);
            ventanalogin.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main(String args[]) {
        Tabla ventanatabla = new Tabla();
        ventanatabla.setBounds(0, 0, 750, 400);
        ventanatabla.setVisible(true);
        ventanatabla.setResizable(false);
        ventanatabla.setLocationRelativeTo(null);
    }
}