import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Actualizar extends JFrame implements ActionListener{
    
    FondoPanel fondo = new FondoPanel();

    private JLabel lbportada, lbdatos, lbusuario, lbnombre, lbapellido, lbtelefono, lbcorreo, lbcontra, lbconfirmar, lbbuscar;
    private JTextField txtusuario, txtnombre, txtapellido, txttelefono, txtcorreo, txtbuscar;
    private JPasswordField txtcontra, txtconfirmar;
    private JButton btactualizar, btatras, btbuscar;

    public String nombre, apellido, telefono, usuario, correo, contra, confirmar;

    String buscar = "";
    boolean numero;
    int id;

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

    public Actualizar(){

        this.setContentPane(fondo);
        setLayout(null);
        setTitle("System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));;
        setIconImage(new ImageIcon(getClass().getResource("imagenes/t.png")).getImage());

        lbportada = new JLabel("Actualizar", SwingConstants.CENTER);
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

        lbbuscar = new JLabel("Ingrese ID:");
        lbbuscar.setBounds(350,105,80,23);
        lbbuscar.setFont(new Font("Andale Mono", 1, 14));
        lbbuscar.setForeground(new Color(255,255,255));
        lbbuscar.setOpaque(false);
        add(lbbuscar);

        txtbuscar = new JTextField();
        txtbuscar.setBounds(435,105,80,23); 
        txtbuscar.setFont(new Font("Andale Mono", 1, 14));
        txtbuscar.setForeground(new Color(0,0,0));
        add(txtbuscar);

        btbuscar = new JButton("Buscar");
        btbuscar.setBounds(530,105,100,23);
        btbuscar.setBackground(new Color(0,0,0));
        btbuscar.setForeground(new Color(2, 196, 56));
        btbuscar.setFont(new Font("Andale Mono", 1, 14));
        btbuscar.addActionListener(this);
        add(btbuscar);
        

        lbnombre = new JLabel("Nombre:");
        lbnombre.setBounds(290, 155, 150, 30);
        lbnombre.setFont(new Font("Bodoni MT Black", 1, 20));
        lbnombre.setForeground(new Color(255, 255, 255));
        lbnombre.setOpaque(false);
        lbnombre.setVisible(false);
        add(lbnombre);

        txtnombre = new JTextField();
        txtnombre.setBounds(380, 185, 190, 25);
        txtnombre.setFont(new Font("Arial", 1, 15));
        txtnombre.setForeground(new Color(255, 255, 255));
        txtnombre.setOpaque(false);
        txtnombre.setVisible(false);
        add(txtnombre);

        lbapellido = new JLabel("Apellido:");
        lbapellido.setBounds(290, 215, 150, 30);
        lbapellido.setFont(new Font("Bodoni MT Black", 1, 20));
        lbapellido.setForeground(new Color(255, 255, 255));
        lbapellido.setOpaque(false);
        lbapellido.setVisible(false);
        add(lbapellido);

        txtapellido = new JTextField();
        txtapellido.setBounds(380, 250, 190, 25);
        txtapellido.setFont(new Font("Arial", 1, 16));
        txtapellido.setForeground(new Color(255, 255, 255));
        txtapellido.setOpaque(false);
        txtapellido.setVisible(false);
        add(txtapellido);

        lbtelefono = new JLabel("Telefono:");
        lbtelefono.setBounds(290, 340, 150, 30);
        lbtelefono.setFont(new Font("Bodoni MT Black", 1, 20));
        lbtelefono.setForeground(new Color(255, 255, 255));
        lbtelefono.setOpaque(false);
        lbtelefono.setVisible(false);
        add(lbtelefono);

        txttelefono = new JTextField();
        txttelefono.setBounds(380, 370, 190, 25);
        txttelefono.setFont(new Font("Arial", 1, 16));
        txttelefono.setForeground(new Color(255, 255, 255));
        txttelefono.setOpaque(false);
        txttelefono.setVisible(false);
        add(txttelefono);

        lbcorreo = new JLabel("Correo:");
        lbcorreo.setBounds(290, 400, 150, 30);
        lbcorreo.setFont(new Font("Bodoni MT Black", 1, 20));
        lbcorreo.setForeground(new Color(255, 255, 255));
        lbcorreo.setOpaque(false);
        lbcorreo.setVisible(false);
        add(lbcorreo);

        txtcorreo = new JTextField();
        txtcorreo.setBounds(380, 425, 190, 25);
        txtcorreo.setFont(new Font("Arial", 1, 16));
        txtcorreo.setForeground(new Color(255, 255, 255));
        txtcorreo.setOpaque(false);
        txtcorreo.setVisible(false);
        add(txtcorreo);

        lbcontra = new JLabel("Contraseña:");
        lbcontra.setBounds(250, 460, 200, 25);
        lbcontra.setFont(new Font("Bodoni MT Black", 1, 20));
        lbcontra.setForeground(new Color(255, 255, 255));
        lbcontra.setOpaque(false);
        lbcontra.setVisible(false);
        add(lbcontra);

        txtcontra = new JPasswordField();
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(380, 490, 190, 25);
        txtcontra.setFont(new Font("Arial", 1, 16));
        txtcontra.setForeground(new Color(255, 255, 255));
        txtcontra.setOpaque(false);
        txtcontra.setVisible(false);
        add(txtcontra);

        lbconfirmar = new JLabel("Confirmar Contraseña:");
        lbconfirmar.setBounds(135, 530, 250, 25);
        lbconfirmar.setFont(new Font("Bodoni MT Black", 1, 20));
        lbconfirmar.setForeground(new Color(255, 255, 255));
        lbconfirmar.setOpaque(false);
        lbconfirmar.setVisible(false);
        add(lbconfirmar);

        txtconfirmar = new JPasswordField();
        txtconfirmar.setEchoChar('*');
        txtconfirmar.setBounds(380, 555, 190, 25);
        txtconfirmar.setFont(new Font("Arial", 1, 16));
        txtconfirmar.setForeground(new Color(255, 255, 255));
        txtconfirmar.setOpaque(false);
        txtconfirmar.setVisible(false);
        add(txtconfirmar);

        lbusuario = new JLabel("Usuario:");
        lbusuario.setBounds(290, 280, 150, 30);
        lbusuario.setFont(new Font("Bodoni MT Black", 1, 20));
        lbusuario.setForeground(new Color(255, 255, 255));
        lbusuario.setOpaque(false);
        lbusuario.setVisible(false);
        add(lbusuario);

        txtusuario = new JTextField();
        txtusuario.setBounds(380, 315, 190, 25);
        txtusuario.setFont(new Font("Arial", 1, 16));
        txtusuario.setForeground(new Color(255, 255, 255));
        txtusuario.setOpaque(false);
        txtusuario.setVisible(false);
        add(txtusuario);

        btactualizar = new JButton("Actualizar");
        btactualizar.setBounds(685, 620, 190, 30);
        btactualizar.setBackground(new Color(0, 0, 0));
        btactualizar.setForeground(new Color(2, 196, 56));
        btactualizar.setFont(new Font("Bodoni MT Black", 1, 25));
        btactualizar.setOpaque(true);
        btactualizar.addActionListener(this);
        btactualizar.setVisible(false);
        add(btactualizar);

        btatras = new JButton("Atras");
        btatras.setBounds(490, 620, 190, 30);
        btatras.setBackground(new Color(0, 0, 0));
        btatras.setForeground(new Color(228, 19, 19));
        btatras.setFont(new Font("Bodoni MT Black", 1, 25));
        btatras.addActionListener(this);
        add(btatras);
        
    }

    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() == btactualizar){
            nombre = txtnombre.getText().trim();
            apellido = txtapellido.getText();
            telefono = txttelefono.getText();
            correo = txtcorreo.getText();
            contra = new String(txtcontra.getPassword());
            confirmar = new String(txtconfirmar.getPassword());
            usuario = txtusuario.getText();  

                if(opc == 1){
                    if(nombre.equals("") && apellido.equals("") && telefono.equals("") && correo.equals("") && contra.equals("") && confirmar.equals("") && usuario.equals("")){
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                            opc = 1;
                        }
                        else{
                            opc = 2;
                        }
                }
                
                if(opc == 2){
                        if(nombre.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Nombre) en blanco");
                        }
                        if(apellido.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Apellido) en blanco");
                        }
                        if(telefono.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Telefono) en blanco");
                        }
                        if(correo.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Correo) en blanco");
                        }
                        if(contra.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Contraseña) en blanco");
                        }
                        if(confirmar.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Confirmar) en blanco");
                        }
                        if(usuario.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Usuario) en blanco");
                        }
                        else{
                            opc = 3;
                        }
                        }
                        

                if(opc == 3){
                        if(contra.equals(confirmar)){
                            if(contra.equals("") && confirmar.equals("")){
                                opc = 3;
                            }else{
                                opc = 4;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Campo (Contraseña) y el campo (Confirmar contraseña) deben coincidir");
                        }
                        }

                if(opc == 4){
                    if(nombre.equals("") || apellido.equals("") || telefono.equals("") || correo.equals("") || contra.equals("") || confirmar.equals("") || usuario.equals("")){
                        
                    }else{
                        opc = 5;
                    }

                }
                        
                if(opc == 5){
                    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
                        PreparedStatement pst = cn.prepareStatement("update usuarios set usuario = ?, nombre = ?, apellido = ?, telefono = ?, correo = ?, contraseña = ? where ID = '" + id + "' ");
                        pst.setString(1, usuario);
                        pst.setString(2, nombre); 
                        pst.setString(3, apellido);
                        pst.setString(4, telefono);
                        pst.setString(5, correo);
                        pst.setString(6, contra);
                        pst.executeUpdate();

                        txtnombre.setText("");
                        txtapellido.setText("");
                        txttelefono.setText("");
                        txtcorreo.setText("");
                        txtcontra.setText("");
                        txtconfirmar.setText("");
                        txtusuario.setText("");

                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");

                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0, 0, 750, 400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }catch(Exception evt){

                    }         
                }  
        }

        if(e.getSource() == btatras){
            Tabla ventanatabla = new Tabla();
            ventanatabla.setBounds(0, 0, 750, 400);
            ventanatabla.setVisible(true);
            ventanatabla.setResizable(false);
            ventanatabla.setLocationRelativeTo(null);
            this.setVisible(false);
        }

        if(e.getSource() == btbuscar){

            lbnombre.setVisible(false);
            txtnombre.setVisible(false);
            lbapellido.setVisible(false);
            txtapellido.setVisible(false);
            lbtelefono.setVisible(false);
            txttelefono.setVisible(false);
            lbcorreo.setVisible(false);
            txtcorreo.setVisible(false);
            lbcontra.setVisible(false);
            txtcontra.setVisible(false);
            lbconfirmar.setVisible(false);
            txtconfirmar.setVisible(false);
            lbusuario.setVisible(false);
            txtusuario.setVisible(false);
            btactualizar.setVisible(false);

            buscar = txtbuscar.getText().trim();
            numero = buscar.matches("[+-]?\\d*(\\.\\d+)?");
            if(numero == true){
                try{
                    
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios where ID = ?");
                    pst.setString(1, buscar);

                    ResultSet rs = pst.executeQuery();

                    if(rs.next()){
                        lbnombre.setVisible(true);
                        txtnombre.setVisible(true);
                        lbapellido.setVisible(true);
                        txtapellido.setVisible(true);
                        lbtelefono.setVisible(true);
                        txttelefono.setVisible(true);
                        lbcorreo.setVisible(true);
                        txtcorreo.setVisible(true);
                        lbcontra.setVisible(true);
                        txtcontra.setVisible(true);
                        lbconfirmar.setVisible(true);
                        txtconfirmar.setVisible(true);
                        lbusuario.setVisible(true);
                        txtusuario.setVisible(true);
                        btactualizar.setVisible(true);

                        txtusuario.setText(rs.getString("usuario"));
                        txtnombre.setText(rs.getString("nombre"));
                        txtapellido.setText(rs.getString("apellido"));
                        txttelefono.setText(rs.getString("telefono"));
                        txtcorreo.setText(rs.getString("correo"));
                        txtcontra.setText(rs.getString("contraseña"));
                        txtconfirmar.setText(rs.getString("contraseña"));
                        

                        id = Integer.parseInt(buscar);

                    }else{
                        if(txtbuscar.getText().length()==0){
                            JOptionPane.showMessageDialog(null, "Debe ingresar el ID");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        
                    }

                }catch(Exception evt){
                    JOptionPane.showMessageDialog(null, "Error.");
                }

            }else if(numero == false || txtbuscar.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Error al introducir el ID \nIngrese el ID de forma correcta");
            }
                   
        }
    }                       
            

        
    public static void main(String args[]){
        Actualizar ventanaactualizar = new Actualizar();
        ventanaactualizar.setBounds(0,0,900,700);
        ventanaactualizar.setVisible(true);
        ventanaactualizar.setResizable(false);
        ventanaactualizar.setLocationRelativeTo(null);
    }

}