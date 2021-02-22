package com.shop;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;

public class LoginWindow extends JFrame {

    private JFrame frame;
    private JTextField loginField;
    private JTextField passField;
    public static String user;
    private static final Logger log = Logger.getLogger(LoginWindow.class);
    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    LoginWindow window = new LoginWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });


    }
    /**
     * Create the application.
     */
    public LoginWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 785, 486);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 0, 767, 426);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        layeredPane.add(panel, "name_8277641259399");
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        layeredPane.add(panel_1, "name_8286026089900");
        panel_1.setLayout(null);

        switchingPanels(panel_1, layeredPane);					//See: potencjalny blad design window

        JLabel lblNewLabel = new JLabel("Welcome! We are very pleased to see you!");
        lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(55, 33, 644, 73);
        panel_1.add(lblNewLabel);

        JLabel login = new JLabel("login");
        login.setBounds(246, 132, 56, 16);
        panel.add(login);

        JLabel password = new JLabel("password");
        password.setBounds(246, 182, 84, 16);
        panel.add(password);

        JLabel corectnessLabel = new JLabel("login or password incorrect");
        corectnessLabel.setForeground(Color.RED);
        corectnessLabel.setBackground(Color.RED);
        corectnessLabel.setHorizontalAlignment(SwingConstants.CENTER);
        corectnessLabel.setBounds(260, 239, 206, 16);
        panel.add(corectnessLabel);
        corectnessLabel.setVisible(false);

        JButton btnNewButton_1 = new JButton("Login as an Employee");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel, layeredPane);
            }
        });
        btnNewButton_1.setBounds(198, 153, 311, 44);
        panel_1.add(btnNewButton_1);

        JButton btnLetMeSee = new JButton("Let me see what do you offer");
        btnLetMeSee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ClientWindow();
                frame.setVisible(false);
            }
        });
        btnLetMeSee.setBounds(198, 248, 311, 44);
        panel_1.add(btnLetMeSee);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Zaloguj");
        panel.add(btnNewButton);
        btnNewButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                String login= loginField.getText();
                String pass = passField.getText();
                user = login;
                int out = Database.logging(login,pass);
                if(out==1) {
                    corectnessLabel.setVisible(false);
                    new Warehouse();
                    frame.setVisible(false);
                    loginField.setText("");
                    passField.setText("");
                }
                else if(out == 0) {
                    corectnessLabel.setVisible(false);
                    new CashierWindow();
                    frame.setVisible(false);
                    loginField.setText("");
                    passField.setText("");

                }
                else {
                    log.warn("incorrect login or password, used login: "+loginField.getText());
                    loginField.setText("");
                    passField.setText("");
                    corectnessLabel.setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(299, 281, 134, 25);

        loginField = new JTextField();
        loginField.setBounds(363, 129, 116, 22);
        panel.add(loginField);
        loginField.setColumns(10);

        passField = new JPasswordField();
        passField.setBounds(363, 179, 116, 22);
        panel.add(passField);
        passField.setColumns(10);

        JButton goBackbtn = new JButton("Go back");
        goBackbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_1, layeredPane);
                loginField.setText("");
                passField.setText("");
                corectnessLabel.setVisible(false);
            }
        });
        goBackbtn.setBounds(608, 374, 97, 25);
        panel.add(goBackbtn);


    }

    public void switchingPanels (JPanel panel, JLayeredPane lpanel) {
        lpanel.removeAll();
        lpanel.add(panel);
        lpanel.repaint();
        lpanel.revalidate();
    }

}



