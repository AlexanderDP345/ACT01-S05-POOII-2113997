import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.showPanel();
    }
}

class LoginPanel extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberPasswordCheckbox;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton forgetPasswordButton;

    LoginPanel() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(15);
        rememberPasswordCheckbox = new JCheckBox("Remember Password");
        forgetPasswordButton = new JButton("Forget Password");
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(rememberPasswordCheckbox, gbc);
        gbc.gridx = 2;
        panel.add(forgetPasswordButton, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        panel.add(loginButton, gbc);
        gbc.gridy = 4;
        panel.add(signUpButton, gbc);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

            if (hasRegisteredAccounts()) {

                JOptionPane.showMessageDialog(this, "Account found. Welcome!");
            } else {
                JOptionPane.showMessageDialog(this, "No registered accounts.");
            }
        } else if (e.getSource() == signUpButton) {
            CreateAccountPanel createAccountPanel = new CreateAccountPanel(this);
            createAccountPanel.showPanel();
        }
    }

    public void showPanel() {
        setVisible(true);
    }

    public void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
        rememberPasswordCheckbox.setSelected(false);
    }

    private boolean hasRegisteredAccounts() {

        return false;
    }
}

class CreateAccountPanel extends JFrame implements ActionListener {
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JTextField emailField;
    private JButton createAccountButton;
    private LoginPanel loginPanel;

    CreateAccountPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;

        setTitle("Create Account");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        newUsernameField = new JTextField(20);
        newPasswordField = new JPasswordField(15);
        emailField = new JTextField(20); 

        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("New Username:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(newUsernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("New Password:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(newPasswordField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(emailField, gbc);
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(createAccountButton, gbc);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String newUsername = newUsernameField.getText();
        String newPassword = new String(newPasswordField.getPassword());
        String email = emailField.getText();

        if (newUsername.length() > 20 || newPassword.length() > 15 || !email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Please enter valid information.");
            return;
        }
        boolean accountCreated = createNewAccount(newUsername, newPassword, email);
        if (accountCreated) {
            JOptionPane.showMessageDialog(this, "Account created successfully");

            setVisible(false);
            loginPanel.setVisible(true);

            loginPanel.resetFields();


            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create account. Please try again later.");
        }
    }

    public void showPanel() {
        setVisible(true);
    }

    private boolean createNewAccount(String username, String password, String email) {
        System.out.println("Creating new account...");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);

        return true;
    }
}
