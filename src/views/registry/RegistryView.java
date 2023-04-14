package views.registry;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import views.InputPanel;
import views.PassPanel;
import views.TitlePanel;

public class RegistryView extends VBox {

    TitlePanel titlePanel;
    InputPanel nameInput;
    InputPanel emailInput;
    InputPanel phoneInput;
    PassPanel passInput;
    PassPanel passAgainInput;
    Button registryButton;

    public RegistryView() {

        this.initComponent();
        this.setComponent();
        this.addComponent();
        this.setPanel();
        this.onClickButton();
    }

    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.nameInput = new InputPanel();
        this.emailInput = new InputPanel();
        this.phoneInput = new InputPanel();
        this.passInput = new PassPanel();
        this.passAgainInput = new PassPanel();
        this.registryButton = new Button();
    }

    private void setComponent() {
        this.titlePanel.setText(" Regisztáció ");
        this.nameInput.setText("Név :");
        this.emailInput.setText("Email :");
        this.phoneInput.setText("Telefonszám :");
        this.passInput.setText("Jelszó :");
        this.passAgainInput.setText("Jelszó megerősítése :");
        this.registryButton.setText("Regisztráció");
    }

    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.phoneInput);
        this.getChildren().add(this.passInput);
        this.getChildren().add(this.passAgainInput);
        this.getChildren().add(this.registryButton);
    }

    private void setPanel() {
        this.setAlignment(Pos.CENTER);
    }

    private void onClickButton() {
        registryButton.setOnAction(e -> {
            String name = nameInput.getText();
            String email = emailInput.getText();
            String phone = phoneInput.getText();
            String password = passInput.getText();
            String passAgain = passAgainInput.getText();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Név megadása kotelezo");
            }
            if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email megadása kotelezo");
            }
            if (phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Telefonszám megadása kotelezo");
            }
            if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Jelszó megadása kotelezo");
            }
            if (passAgain.equals("")) {
                JOptionPane.showMessageDialog(null, "Jelszó ismétlése kotelezo");
            }
        });

        System.out.println("work");
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {

    // if (e.getSource() == registryButton) {
    // String name = nameInput.getText();
    // String email = emailInput.getText();
    // String phone = phoneInput.getText();
    // String password = passInput.getText();
    // String passAgain = passAgainInput.getText();

    // if (name.equals("")) {
    // JOptionPane.showMessageDialog(null, "Név megadása kotelezo");
    // }
    // if (email.equals("")) {
    // JOptionPane.showMessageDialog(null, "Email megadása kotelezo");
    // }
    // if (phone.equals("")) {
    // JOptionPane.showMessageDialog(null, "Telefonszám megadása kotelezo");
    // }
    // if (password.equals("")) {
    // JOptionPane.showMessageDialog(null, "Jelszó megadása kotelezo");
    // }
    // if (passAgain.equals("")) {
    // JOptionPane.showMessageDialog(null, "Jelszó ismétlése kotelezo");
    // }
    // }
    // }
}