import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class GetUsers {

    static JFrame frame;
    static JTable tblUsuarios;

    public static void fillTable(){
        frame = new JFrame();
        frame.setTitle("Usuarios");
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
        frame.add(sp);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    public static void main(String[] ar) {
        fillTable();
    }

}
