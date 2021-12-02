import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Eliminar extends JFrame implements ActionListener{

    FondoPanel fondo = new FondoPanel();
    private JLabel lbtitulo, lbinfo;
    private JTextField txtid;
    private JButton btnid, btnatras;

    String buscar = "";
    boolean numero;

    int id;
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


    public Eliminar(){

        this.setContentPane(fondo);
        setLayout(null);
        setTitle("System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/t.png")).getImage());

        lbtitulo = new JLabel("Eliminar", SwingConstants.CENTER);
        lbtitulo.setBounds(25,10,300,23);
        lbtitulo.setFont(new Font("Bodoni MT Black", 1, 25));
        lbtitulo.setForeground(new Color(255,239,0));
        lbtitulo.setOpaque(false);
        add(lbtitulo);

        lbinfo = new JLabel("Ingresa el ID del usuario a eliminar:");
        lbinfo.setBounds(40,60,500,23);
        lbinfo.setFont(new Font("Bodoni MT Black", 1, 18));
        lbinfo.setForeground(new Color(255,239,0));
        lbinfo.setOpaque(false);
        add(lbinfo);

        txtid = new JTextField();
        txtid.setBounds(40,100,80,23); 
        txtid.setFont(new Font("Bodoni MT Black", 1, 14));
        txtid.setForeground(new Color(0,0,0));
        add(txtid);

        btnid = new JButton("Eliminar");
        btnid.setBounds(140,100,130,23);
        btnid.setBackground(new Color(0, 0, 0)); 
        btnid.setForeground(new Color(2, 196, 56));
        btnid.setFont(new Font("Bodoni MT Black", 1, 15));
        btnid.addActionListener(this);
        add(btnid);

        btnatras = new JButton("Atras");
        btnatras.setBounds(280,100,100,23);
        btnatras.setBackground(new Color(0,0,0));
        btnatras.setForeground(new Color(228, 19, 19));
        btnatras.setFont(new Font("Bodoni MT Black", 1, 15));
        btnatras.addActionListener(this);
        add(btnatras);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnid){

            buscar = txtid.getText().trim();
            numero = buscar.matches("[+-]?\\d*(\\.\\d+)?");
        
            if(numero == true){
                try{
                    id = Integer.parseInt(buscar);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbu", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios where ID = ?");
                    pst.setString(1, buscar);

                    ResultSet rs = pst.executeQuery();

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"El usuario fue eliminado con exito");
                        PreparedStatement psn = cn.prepareStatement("delete from usuarios where ID = ?");
                        psn.setString(1, buscar);
                        psn.executeUpdate();
                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0,0,750,400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"No se a encontrado esa ID");
                    }

                }catch(Exception evt){
                    JOptionPane.showMessageDialog(null, "Ingrese el ID por favor");
                }
                    
                    
            }else if(numero == true && txtid.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Ingreso de ID incorrecto");
            }
        }

        if(e.getSource() == btnatras){
            Tabla ventanatabla = new Tabla();
            ventanatabla.setBounds(0, 0, 750, 400);
            ventanatabla.setVisible(true);
            ventanatabla.setResizable(false);
            ventanatabla.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main(String args[]){
        Eliminar ventanaeliminar = new Eliminar();
        ventanaeliminar.setBounds(0,0,500,200);
        ventanaeliminar.setVisible(true);
        ventanaeliminar.setResizable(false);
        ventanaeliminar.setLocationRelativeTo(null);
    }

}
