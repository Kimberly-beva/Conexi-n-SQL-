import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    JButton exit, getUsers, addUser;
    
    public MainMenu() {


        setLayout(null);

        exit = new JButton("Finalizar");
        exit.setBounds(300,250,100,30);
        add(exit);
        exit.addActionListener(this);
        
        getUsers = new JButton("Consultar Usuarios");
        getUsers.setBounds(10,10,200,30);
        add(getUsers);
        getUsers.addActionListener(this);

        addUser = new JButton("Agregar usuario");
        addUser.setBounds(10,60,200,30);
        add(addUser);
        addUser.addActionListener(this);


        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Sesion finalizada", "Info", 0);
                Login.main(null);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit) {
            System.exit(0);
        }
        if (e.getSource()==getUsers) {
            //JOptionPane.showMessageDialog(null, "Consulta de usuarios en construccion...", "Info", 0);
            GetUsers.main(null);
            this.setVisible(false);
        }

        if (e.getSource()==addUser) {
            dispose();
            //JOptionPane.showMessageDialog(null, "Agregar usuario en construccion...", "Info", 0);
            AddUser.main(null);
            this.setVisible(false);
        }

    }
    
    public static void main(String[] ar) {
        MainMenu mainMenu=new MainMenu();
        mainMenu.setLocationRelativeTo(null);
        mainMenu.pack();
        //mainMenu.setBounds(0,0,450,350);
        mainMenu.setSize(450, 350);
        mainMenu.setTitle("Menu Principal");
        mainMenu.setVisible(true);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}