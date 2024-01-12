import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class AddUser extends JFrame implements ActionListener{

    static JLabel lblUser = new JLabel("Usuario: ");
    static JLabel lblName = new JLabel("Nombre: ");
    static JLabel lblPassword = new JLabel("Password: ");
    static JLabel lblPassConfirm = new JLabel("Confirmar Password: ");
    static JTextField txtUser = new JTextField(); 
    static JTextField txtName = new JTextField();
    static JPasswordField txtPassword = new JPasswordField() ;
    static JPasswordField txtPassConfirm = new JPasswordField();
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
        txtName.setBounds(150,40,300,30);
        txtPassword.setBounds(150,70,300,30);
        txtPassConfirm.setBounds(150,100,300,30);

        btnCancel.setBounds(10,150, 200, 30);
        btnSave.setBounds(270,150, 200, 30);

        btnCancel.addActionListener(this);
        btnSave.addActionListener(this);

        add(lblUser);
        add(lblName);
        add(lblPassword);
        add(lblPassConfirm);

        add(txtUser);
        add(txtName);
        add(txtPassword);
        add(txtPassConfirm);

        add(btnCancel);
        add(btnSave);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            
                MainMenu mainMenu = new MainMenu();
                dispose();
                mainMenu.main(null);
            }
        });



    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnCancel) {
            MainMenu mainMenu = new MainMenu();
            dispose();
            mainMenu.main(null);

        }

        if(e.getSource()==btnSave){
            if(txtUser.getText().toString().length()>0 && 
                txtName.getText().toString().length()>0 &&
                txtPassword.getText().toString().length()>0 &&
                txtPassConfirm.getText().toString().length()>0){
                    String pass = Arrays.toString(txtPassword.getPassword());
                    String spass = Arrays.toString(txtPassConfirm.getPassword());
                    String respuesta;

                    if(pass.equals(spass)){
                        respuesta = UsersBD.AddUser(txtUser.getText().toString(), pass, txtName.getText().toString());
                        if(respuesta .equals("OK")){
                            clean();
                            JOptionPane.showMessageDialog(null, "Usuario agregado de manera correcta", "Info", 0);

                        }
                       //JOptionPane.showMessageDialog(null, "Aqui se deberia de guardar en BD", "Info", 0);

                    } else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Info", 0);
                    }
                
            } else{
                JOptionPane.showMessageDialog(null, "Favor de rellenar los datos de forma correcta", "Info", 0);
            } 
        }
    }


    public static void main(String[] ar) {
        clean();
        AddUser AddUser = new AddUser();
        AddUser.setLocationRelativeTo(null);
        AddUser.pack();
        AddUser.setSize(500, 230);
        AddUser.setVisible(true);

    }

    public static void clean(){
        txtName.setText("");
        txtPassConfirm.setText((""));
        txtPassword.setText("");
        txtUser.setText("");
    }

}
