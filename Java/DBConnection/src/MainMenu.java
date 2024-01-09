import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    JButton salir, consultarUsuarios;
    public MainMenu() {
        setLayout(null);
        salir=new JButton("Finalizar");
        salir.setBounds(300,250,100,30);
        add(salir);
        salir.addActionListener(this);
        
        consultarUsuarios=new JButton("Consultar Usuarios");
        consultarUsuarios.setBounds(10,10,200,30);
        add(consultarUsuarios);
        consultarUsuarios.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==salir) {
            System.exit(0);
        }
        if (e.getSource()==consultarUsuarios) {
            //JOptionPane.showMessageDialog(null, "Consulta de usuarios en construccion...", "Info", 0);
            GetUsers.main(null);
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