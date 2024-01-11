import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    public static void main(String[] args) {
        String vRespuesta;
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
            "Username:", username,
            "Password:", password
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            if (username.getText().toString().length()>0){
                if (password.getText().toString().length()>0){
                    vRespuesta = LoginBD.Login(username.getText(), password.getText());
                    if (vRespuesta.equals("OK")){
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.main(null);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, vRespuesta, "Info", 0);
                        Login.main(null);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Favor de rellenar los datos", "Info", 0);
                Login.main(args);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hasta luego", "Info", 0);
        }
    }
}
