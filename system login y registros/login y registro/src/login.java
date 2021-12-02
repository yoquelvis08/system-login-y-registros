import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class login extends JFrame implements ActionListener {

    FondoPanel fondo = new FondoPanel();

    private JLabel Jlusuario, Jlcontraseña;
    private JTextField txtusuario;
    private JPasswordField txtcontraseña;
    private JButton btnLogin, btnRegister;
    String usuario = "";
    String contra = "";

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

    public login() {

        this.setContentPane(fondo);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("System");
        getContentPane().setBackground(new Color(74, 68, 74));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/t.png")).getImage());

        // USUARIO DE LOGIN//
        Jlusuario = new JLabel("USUARIO", SwingConstants.CENTER);
        Jlusuario.setBounds(360, 100, 150, 30);
        Jlusuario.setFont(new Font("Bodoni MT Black", 3, 25));
        Jlusuario.setForeground(new Color(242, 219, 16));
        add(Jlusuario);

        // Boton de login//
        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(370, 285, 106, 29);
        btnLogin.setFont(new Font("Bodoni MT Black", 1, 20));
        btnLogin.setForeground(new Color(2, 196, 56));
        btnLogin.setBackground(new Color(27, 27, 27));
        btnLogin.addActionListener(this);
        btnLogin.setOpaque(true);
        add(btnLogin);

        // boton de registro////
        btnRegister = new JButton("REGISTRARSE");
        btnRegister.setBounds(328, 325, 205, 30);
        btnRegister.setFont(new Font("Bodoni MT Black", 1, 20));
        btnRegister.setForeground(new Color(255, 255, 255));
        btnRegister.setBackground(new Color(27, 27, 27));
        btnRegister.addActionListener(this);
        btnRegister.setOpaque(true);
        add(btnRegister);

        // CONTRASEÑA DE LOGIN//
        Jlcontraseña = new JLabel("CONTRASEÑA", SwingConstants.CENTER);
        Jlcontraseña.setBounds(290, 200, 300, 30);
        Jlcontraseña.setFont(new Font("Bodoni MT Black", 3, 25));
        Jlcontraseña.setForeground(new Color(242, 219, 16));
        add(Jlcontraseña);

        // JPASSWORD txtcontraseña//
        txtcontraseña = new JPasswordField();
        txtcontraseña.setBounds(285, 235, 300, 29);
        txtcontraseña.setFont(new Font("Arial Black", 3, 16));
        txtcontraseña.setForeground(new Color(255, 255, 255));
        txtcontraseña.setBackground(new Color(27, 27, 27));
        txtcontraseña.setOpaque(false);
        add(txtcontraseña);

        // JTextField txtusuario//
        txtusuario = new JTextField();
        txtusuario.setBounds(285, 135, 300, 30);
        txtusuario.setFont(new Font("Arial Black", 3, 16));
        txtusuario.setForeground(new Color(255, 255, 255));
        txtusuario.setBackground(new Color(27, 27, 27));
        txtusuario.setOpaque(false);
        add(txtusuario);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {

            usuario = txtusuario.getText();
            contra = new String(txtcontraseña.getPassword());

            if (usuario.equals("") || contra.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese su usuario y contraseña. " + "\n"
                        + "Si no tienen una cuenta, puede crear una pulsando el boton de REGISTRARSE.");
            } else {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
                    PreparedStatement pst = cn
                            .prepareStatement("select usuario, contraseña from usuarios where usuario = '"
                                    + usuario + "' and contraseña = '" + contra + "'");

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0, 0, 750, 400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta");
                        txtusuario.setText("");
                        txtcontraseña.setText("");
                    }
                } catch (Exception evt) {

                }
            }
        }

        if (e.getSource() == btnRegister) {
            Registro ventanaregistro = new Registro();
            ventanaregistro.setBounds(90, 90, 900, 700);
            ventanaregistro.setVisible(true);
            ventanaregistro.setResizable(false);
            ventanaregistro.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        login ventanalogin = new login();
        ventanalogin.setBounds(90, 90, 900, 500);
        ventanalogin.setVisible(true);
        ventanalogin.setResizable(false);
        ventanalogin.setLocationRelativeTo(null);

    }

}