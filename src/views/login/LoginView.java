package views.login;

import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import views.MainView;

public class LoginView implements ActionListener {

    MainView mainView;
    JFrame frame = new JFrame();
    JTextField emailIdField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel titleLabel = new JLabel("Autókölcsönző admin felület");
    JLabel emailIdLabel = new JLabel("Email: ");
    JLabel passwordLabel = new JLabel("Jelszó: ");
    JLabel messageLabel = new JLabel();
    JButton loginButton = new JButton("Bejelentkezés");
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginView(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        titleLabel.setBounds(75, 50, 400, 25);
        titleLabel.setFont(new Font(null, Font.BOLD, 18));

        emailIdLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(null);

        emailIdField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 125, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        frame.add(titleLabel);
        frame.add(emailIdLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(emailIdField);
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setTitle("Admin panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String email = emailIdField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (loginInfo.containsKey(email)) {
                if (loginInfo.get(email).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Sikeres bejelentkezés");
                    frame.dispose();
                    mainView = new MainView(email);
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Helytelen jelszó");
                    ;
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Nincs ilyen felhasználó");
                ;
            }
        }
    }
}