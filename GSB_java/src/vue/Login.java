package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.metier.Utilisateur;
import com.metier.Visiteur;
import com.persistance.AccesData;

public class Login extends JPanel
{
    private JLabel lblLogin;
    private JTextField textLogin;
    private JLabel lblMdp;
    private JPasswordField passwordField;
    private JButton btnConnect;
    JFrame frame;
    /**
     * Create the panel.
     */
    public Login(JFrame myFrame)
    {
        setLayout(null);
        add(getLblLogin());
        add(getTextLogin());
        add(getLblMdp());
        add(getPasswordField());
        add(getBtnConnect());
        frame  = myFrame;

    }

    private JLabel getLblLogin() {
        if (lblLogin == null) {
            lblLogin = new JLabel("Visiteur");
            lblLogin.setBounds(44, 29, 86, 14);
        }
        return lblLogin;
    }
    private JTextField getTextLogin() {
        if (textLogin == null) {
            textLogin = new JTextField();
            textLogin.setBounds(218, 26, 86, 20);
            textLogin.setColumns(10);
        }
        return textLogin;
    }
    private JLabel getLblMdp() {
        if (lblMdp == null) {
            lblMdp = new JLabel("Mot de passe");
            lblMdp.setBounds(44, 95, 86, 14);
        }
        return lblMdp;
    }
    private JPasswordField getPasswordField() {
        if (passwordField == null) {
            passwordField = new JPasswordField();
            passwordField.setBounds(218, 92, 86, 20);
        }
        return passwordField;
    }
    private JButton getBtnConnect() {
        if (btnConnect == null) {
            btnConnect = new JButton("Connection");
            btnConnect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String login = textLogin.getText();
                    char[] pass = passwordField.getPassword();
                    Utilisateur util = null;
                    try
                    {
                    	util =(Utilisateur) AccesData.connection(login, pass);
                    }
                    catch (Exception e1)
                    {
                    	
                    }
                    if (util != null)
                    {
                        switch (util.getIdType())
                        {
                        case "c":
                            JOptionPane.showMessageDialog(null,
                                    "Les comptable n'ont pas accès à cette application",
                                    "Erreur de connection",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        case "d":
                            frame.dispose();
                            JFrame frame2 = new JFrame();
                            frame2.setVisible(true);
                            break;
                        case "r":
                            frame.dispose();
                            JFrame frame3 = new JFrame();
                            frame3.setVisible(true);
                            break;
                        case "s":
                            frame.dispose();
                            JFrame secretaire = new Secretaire();
                            secretaire.setVisible(true);
                            break;
                        case "v":
                            JOptionPane.showMessageDialog(null,
                                    "Les visiteurs n'ont pas accès à cette application",
                                    "Erreur de connection",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Les informations saisies sont incorrect\nVeuillez ressaisir vos informations de connection",
                                "Erreur de connection",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            btnConnect.setBounds(44, 151, 106, 39);
        }
        return btnConnect;
    }
}
