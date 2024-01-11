import javax.swing.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener{

    static JLabel lblUser = new JLabel("Usuario: ");
    static JLabel lblName = new JLabel("Nombre: ");
    static JLabel lblPassword = new JLabel("Password: ");
    static JLabel lblPassConfirm = new JLabel("Confirmar Password: ");
    static JTextField txtUser = new JTextField(); 
    static JTextField txtName;
    static JPasswordField txtPassword;
    static JPasswordField txtPassConfirm;
    static JButton btnCancel = new JButton("Cancelar");
    static JButton btnSave = new JButton("Guardar");

    public AddUser(){
        setTitle("Agregar Usuario");
        setLayout(null);
        
        lblUser.setBounds(10,10,300,30);
        lblName.setBounds(10,40,300,30);
        lblPassword.setBounds(10,70,300,30);
        lblPassConfirm.setBounds(10,100,300,30);

        txtUser.setBounds(150,10,300,30);

        btnCancel.setBounds(10,150, 200, 30);
        btnSave.setBounds(270,150, 200, 30);

        add(lblUser);
        add(lblName);
        add(lblPassword);
        add(lblPassConfirm);

        add(txtUser);

        add(btnCancel);
        add(btnSave);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] ar) {
        AddUser AddUser = new AddUser();
        AddUser.setLocationRelativeTo(null);
        AddUser.pack();
        AddUser.setSize(500, 230);
        AddUser.setVisible(true);

    }

}
