import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Registro extends JFrame implements ActionListener {

    FondoPanel fondo = new FondoPanel();

    private JLabel lbportada, lbdatos, lbusuario, lbnombre, lbapellido, lbtelefono, lbcorreo, lbcontra, lbconfirmar;
    private JTextField txtusuario, txtnombre, txtapellido, txttelefono, txtcorreo;
    private JPasswordField txtcontra, txtconfirmar;
    private JButton btregistrar, btatras;

    public String nombre, apellido, telefono, usuario, correo, contra, confirmar;

    int opc = 1;

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

    public Registro() {

        this.setContentPane(fondo);

        setLayout(null);
        setTitle("System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/t.png")).getImage());
        
        lbportada = new JLabel("Registro", SwingConstants.CENTER);
        lbportada.setBounds(190, 3, 500, 100);
        lbportada.setFont(new Font("Goudy Stout", 1, 35));
        lbportada.setForeground(new Color(255, 239, 0));
        lbportada.setOpaque(false);
        add(lbportada);

        lbdatos = new JLabel("Ingrese sus datos:");
        lbdatos.setBounds(10, 100, 300, 35);
        lbdatos.setFont(new Font("Bodoni MT Black", 1, 28));
        lbdatos.setForeground(new Color(255, 239, 0));
        lbdatos.setOpaque(false);
        add(lbdatos);

        lbnombre = new JLabel("Nombre:");
        lbnombre.setBounds(290, 155, 150, 30);
        lbnombre.setFont(new Font("Bodoni MT Black", 1, 20));
        lbnombre.setForeground(new Color(255, 255, 255));
        lbnombre.setOpaque(false);
        add(lbnombre);

        txtnombre = new JTextField();
        txtnombre.setBounds(380, 185, 190, 25);
        txtnombre.setFont(new Font("Arial", 1, 15));
        txtnombre.setForeground(new Color(255, 255, 255));
        txtnombre.setOpaque(false);
        add(txtnombre);

        lbapellido = new JLabel("Apellido:");
        lbapellido.setBounds(290, 215, 150, 30);
        lbapellido.setFont(new Font("Bodoni MT Black", 1, 20));
        lbapellido.setForeground(new Color(255, 255, 255));
        lbapellido.setOpaque(false);
        add(lbapellido);

        txtapellido = new JTextField();
        txtapellido.setBounds(380, 250, 190, 25);
        txtapellido.setFont(new Font("Arial", 1, 16));
        txtapellido.setForeground(new Color(255, 255, 255));
        txtapellido.setOpaque(false);
        add(txtapellido);
        
        lbusuario = new JLabel("Usuario:");
        lbusuario.setBounds(290, 280, 150, 30);
        lbusuario.setFont(new Font("Bodoni MT Black", 1, 20));
        lbusuario.setForeground(new Color(255, 255, 255));
        lbusuario.setOpaque(false);
        add(lbusuario);

        txtusuario = new JTextField();
        txtusuario.setBounds(380, 315, 190, 25);
        txtusuario.setFont(new Font("Arial", 1, 16));
        txtusuario.setForeground(new Color(255, 255, 255));
        txtusuario.setOpaque(false);
        add(txtusuario);

        lbtelefono = new JLabel("Telefono:");
        lbtelefono.setBounds(290, 340, 150, 30);
        lbtelefono.setFont(new Font("Bodoni MT Black", 1, 20));
        lbtelefono.setForeground(new Color(255, 255, 255));
        lbtelefono.setOpaque(false);
        add(lbtelefono);

        txttelefono = new JTextField();
        txttelefono.setBounds(380, 370, 190, 25);
        txttelefono.setFont(new Font("Arial", 1, 16));
        txttelefono.setForeground(new Color(255, 255, 255));
        txttelefono.setOpaque(false);
        add(txttelefono);

        

        lbcorreo = new JLabel("Correo:");
        lbcorreo.setBounds(290, 400, 150, 30);
        lbcorreo.setFont(new Font("Bodoni MT Black", 1, 20));
        lbcorreo.setForeground(new Color(255, 255, 255));
        lbcorreo.setOpaque(false);
        add(lbcorreo);

        txtcorreo = new JTextField();
        txtcorreo.setBounds(380, 425, 190, 25);
        txtcorreo.setFont(new Font("Arial", 1, 16));
        txtcorreo.setForeground(new Color(255, 255, 255));
        txtcorreo.setOpaque(false);
        add(txtcorreo);

        lbcontra = new JLabel("Contraseña:");
        lbcontra.setBounds(250, 460, 200, 25);
        lbcontra.setFont(new Font("Bodoni MT Black", 1, 20));
        lbcontra.setForeground(new Color(255, 255, 255));
        lbcontra.setOpaque(false);
        add(lbcontra);

        txtcontra = new JPasswordField();
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(380, 490, 190, 25);
        txtcontra.setFont(new Font("Arial", 1, 16));
        txtcontra.setForeground(new Color(255, 255, 255));
        txtcontra.setOpaque(false);
        add(txtcontra);

        lbconfirmar = new JLabel("Confirmar Contraseña:");
        lbconfirmar.setBounds(135, 530, 250, 25);
        lbconfirmar.setFont(new Font("Bodoni MT Black", 1, 20));
        lbconfirmar.setForeground(new Color(255, 255, 255));
        lbconfirmar.setOpaque(false);
        add(lbconfirmar);

        txtconfirmar = new JPasswordField();
        txtconfirmar.setEchoChar('*');
        txtconfirmar.setBounds(380, 555, 190, 25);
        txtconfirmar.setFont(new Font("Arial", 1, 16));
        txtconfirmar.setForeground(new Color(255, 255, 255));
        txtconfirmar.setOpaque(false);
        add(txtconfirmar);

        btregistrar = new JButton("Registrar");
        btregistrar.setBounds(685, 620, 190, 30);
        btregistrar.setBackground(new Color(0, 0, 0));
        btregistrar.setForeground(new Color(2, 196, 56));
        btregistrar.setFont(new Font("Bodoni MT Black", 1, 25));
        btregistrar.setOpaque(true);
        btregistrar.addActionListener(this);
        add(btregistrar);

        btatras = new JButton("Atras");
        btatras.setBounds(490, 620, 190, 30);
        btatras.setBackground(new Color(0, 0, 0));
        btatras.setForeground(new Color(228, 19, 19));
        btatras.setFont(new Font("Bodoni MT Black", 1, 25));
        btatras.addActionListener(this);
        add(btatras);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btregistrar) {

            if (e.getSource() == btregistrar) {
                nombre = txtnombre.getText();
                apellido = txtapellido.getText();
                telefono = txttelefono.getText();
                correo = txtcorreo.getText();
                contra = new String(txtcontra.getPassword());
                confirmar = new String(txtconfirmar.getPassword());
                usuario = txtusuario.getText();

                if (opc == 1) {
                    if (nombre.equals("") && apellido.equals("") && telefono.equals("") && correo.equals("")
                            && contra.equals("") && confirmar.equals("") && usuario.equals("")) {
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                        opc = 1;
                    } else {
                        opc = 2;
                    }
                }

                if (opc == 2) {
                    if (nombre.equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo (Nombre) en blanco");
                    }
                    if (apellido.equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo (Apellido) en blanco");
                    }
                    if (telefono.equals("")) {
                        JOptionPane.showMessageDialog(null, "El espacio de telefono esta en ");
                    }
                    if (correo.equals("")) {
                        JOptionPane.showMessageDialog(null, "El espacio de correo esta en blanco \npor favor rellenar");
                    }

                    if (contra.equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo (Contraseña) en blanco");
                    }
                    if (confirmar.equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo (Confirmar) en blanco");
                    }
                    if (usuario.equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo (Usuario) en blanco");
                    } else {
                        opc = 3;
                    }
                }

                if (opc == 3) {
                    if (contra.equals(confirmar)) {
                        if (contra.equals("") && confirmar.equals("")) {
                            opc = 3;
                        } else {
                            opc = 4;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Campo (Contraseña) y el campo (Confirmar) deben coincidir");
                    }
                }

                if (opc == 4) {
                    if (nombre.equals("") || apellido.equals("") || telefono.equals("") || correo.equals("")
                            || contra.equals("") || confirmar.equals("") || usuario.equals("")) {

                    } else {
                        opc = 5;
                    }

                }

                if (opc == 5) {
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
                        PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
                        pst.setString(1, "0");
                        pst.setString(2, usuario);
                        pst.setString(3, nombre);
                        pst.setString(4, apellido);
                        pst.setString(5, telefono);
                        pst.setString(6, correo);
                        pst.setString(7, contra);
                        pst.executeUpdate();

                        txtnombre.setText("");
                        txtapellido.setText("");
                        txttelefono.setText("");
                        txtcorreo.setText("");
                        txtcontra.setText("");
                        txtconfirmar.setText("");
                        txtusuario.setText("");

                        JOptionPane.showMessageDialog(null, "El usuario se a registrado correctamente");

                        login ventanalogin = new login();
                        ventanalogin.setBounds(90, 90, 900, 500);
                        ventanalogin.setVisible(true);
                        ventanalogin.setResizable(false);
                        ventanalogin.setLocationRelativeTo(null);
                        this.setVisible(false);
                    } catch (Exception evt) {

                    }
                }
            }

        }

        if (e.getSource() == btatras) {
            login ventanalogin = new login();
            ventanalogin.setBounds(90, 90, 900, 500);
            ventanalogin.setVisible(true);
            ventanalogin.setResizable(false);
            ventanalogin.setLocationRelativeTo(null);
            this.setVisible(false);
        }

    }

    public static void main(String args[]) {
        Registro ventanaregistro = new Registro();
        ventanaregistro.setBounds(90, 90, 900, 700);
        ventanaregistro.setVisible(true);
        ventanaregistro.setResizable(false);
        ventanaregistro.setLocationRelativeTo(null);
    }

}