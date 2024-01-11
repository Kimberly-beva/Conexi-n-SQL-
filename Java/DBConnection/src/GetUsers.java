import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.event.*;

public class GetUsers extends JFrame implements ActionListener{

    static JFrame frame;
    static JTable tblUsuarios;

    public GetUsers(){
        //frame = new JFrame();
        this.setTitle("Consulta de Usuarios");
        DefaultTableModel usuarios = new DefaultTableModel();
        ArrayList<Users> datosUsuarios;
        String[] fila = new String[2];
        usuarios.addColumn("Usuario");
        usuarios.addColumn("Nombre");

        datosUsuarios = UsersBD.GetUsers();
            for(int f = 0; f < datosUsuarios.size(); f++){
                fila[0] = datosUsuarios.get(f).getUsuario();
                fila[1] = datosUsuarios.get(f).getNombre();
                usuarios.addRow(fila);
            }
        tblUsuarios = new JTable();

        tblUsuarios.setModel(usuarios);

        tblUsuarios.setBounds(30,40,200,300);

        JScrollPane sp = new JScrollPane(tblUsuarios);
        /*
        frame.add(sp);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(500, 200);
        frame.setVisible(true);
        */
        this.add(sp);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.main(null);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] ar) {
        GetUsers GetUsers = new GetUsers();
        GetUsers.setLocationRelativeTo(null);
        GetUsers.pack();
        GetUsers.setSize(500, 200);
        GetUsers.setVisible(true);

    }

}
