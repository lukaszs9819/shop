package com.shop;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.util.Objects;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Warehouse extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JFrame frame;
    private JTextField loginField;
    private JPasswordField passField;
    private JPasswordField passFieldConf;
    private JTextField nameField;
    private JTextField barcodeField;
    private JTextField nameField2;
    private JTextField categoryField;
    private JTextField amountField;
    private JTextField surnameField;
    private JTextField priceField;
    private JTextField textField;
    private JTextField searchForField;
    static JPanel panel_000 = new JPanel();
    static LinkedList<PromoCode> promos;
    private JTextField updateBarcodeField;
    private JTextField newName;
    private JTextField updateAmountField;
    private JTextField updatePriceField;
    private JTextField updateCategoryField;
    private JTextField updateBarcode2;
    private static final Logger log = Logger.getLogger(Warehouse.class);
    private JTextField namePromoField;
    private JTextField howMuchPromoField;
    private JTextField providersField;

    /**
     * Launch the application.
     *
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Warehouse window = new Warehouse();
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
    public Warehouse() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 508);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        promos = new LinkedList();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(12, 13, 589, 435);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        layeredPane.add(panel, "name_38445870095900");
        panel.setLayout(null);
        panel.setVisible(false);

        loginField = new JTextField();
        loginField.setBounds(189, 122, 116, 22);
        panel.add(loginField);
        loginField.setColumns(10);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(36, 16, 56, 16);
        panel.add(nameLabel);

        JLabel lblNewLabel_1 = new JLabel("Login:");
        lblNewLabel_1.setBounds(36, 125, 56, 16);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("password");
        lblNewLabel_2.setBounds(36, 192, 75, 16);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Confirm password");
        lblNewLabel_3.setBounds(34, 236, 122, 16);
        panel.add(lblNewLabel_3);

        passField = new JPasswordField();
        passField.setBounds(189, 190, 116, 19);
        panel.add(passField);

        passFieldConf = new JPasswordField();
        passFieldConf.setBounds(189, 234, 116, 19);
        panel.add(passFieldConf);

        nameField = new JTextField();
        nameField.setBounds(189, 13, 116, 22);
        panel.add(nameField);
        nameField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(36, 324, 56, 16);
        panel.add(lblNewLabel_4);

        JRadioButton adminButton = new JRadioButton("Administrator");
        adminButton.setSelected(true);
        adminButton.setBounds(59, 315, 127, 25);
        panel.add(adminButton);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(0, 0, 10, 10);
        panel.add(panel_5);

        JRadioButton cashierButton = new JRadioButton("Cashier");
        cashierButton.setBounds(59, 349, 127, 25);
        panel.add(cashierButton);

        ButtonGroup g =    new ButtonGroup();
        g.add(adminButton);
        g.add(cashierButton);

        JButton addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(189, 349, 128, 25);
        panel.add(addEmployee);

        surnameField = new JTextField();
        surnameField.setColumns(10);
        surnameField.setBounds(189, 66, 116, 22);
        panel.add(surnameField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(36, 69, 75, 16);
        panel.add(surnameLabel);

        JLabel lblNewLabel_14 = new JLabel("Passwords are not the same!");
        lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_14.setForeground(new Color(255, 0, 51));
        lblNewLabel_14.setBounds(341, 236, 207, 16);
        panel.add(lblNewLabel_14);
        lblNewLabel_14.setVisible(true);

        JLabel fillInLabel = new JLabel("Fill in every field!");
        fillInLabel.setForeground(new Color(255, 51, 0));
        fillInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fillInLabel.setBounds(356, 353, 187, 16);
        panel.add(fillInLabel);
        fillInLabel.setVisible(false);

        JPanel panel_1 = new JPanel();
        layeredPane.add(panel_1, "name_38494086114200");
        panel_1.setLayout(null);

        barcodeField = new JTextField();
        barcodeField.setBounds(228, 47, 116, 22);
        panel_1.add(barcodeField);
        barcodeField.setColumns(10);

        JLabel Barcode = new JLabel("BARCODE");
        Barcode.setBounds(114, 50, 56, 16);
        panel_1.add(Barcode);

        nameField2 = new JTextField();
        nameField2.setBounds(228, 82, 116, 22);
        panel_1.add(nameField2);
        nameField2.setColumns(10);

        JLabel PrName = new JLabel("Name");
        PrName.setBounds(114, 79, 56, 16);
        panel_1.add(PrName);

        categoryField = new JTextField();
        categoryField.setBounds(228, 117, 116, 22);
        panel_1.add(categoryField);
        categoryField.setColumns(10);

        JLabel type = new JLabel("Category");
        type.setBounds(114, 120, 56, 16);
        panel_1.add(type);

        amountField = new JTextField();
        amountField.setBounds(228, 152, 116, 22);
        panel_1.add(amountField);
        amountField.setColumns(10);

        JLabel amount = new JLabel("Amount");
        amount.setBounds(114, 155, 56, 16);
        panel_1.add(amount);

        JLabel price = new JLabel("Price:");
        price.setBounds(114, 190, 56, 16);
        panel_1.add(price);

        priceField = new JTextField();
        priceField.setColumns(10);
        priceField.setBounds(228, 187, 116, 22);
        panel_1.add(priceField);

        JLabel lblNewLabel_15 = new JLabel("Fill in every field!");
        lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_15.setForeground(new Color(255, 51, 0));
        lblNewLabel_15.setBounds(156, 372, 226, 16);
        panel_1.add(lblNewLabel_15);
        lblNewLabel_15.setVisible(false);

        JButton addProduct = new JButton("Add product to database");
        addProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                String name = nameField2.getText();
                String barcode = barcodeField.getText();
                String category= categoryField.getText();
                String amount = amountField.getText();
                String price = priceField.getText();
                String providers = providersField.getText();
                if (name.equals("") || barcode.equals("") || category.equals("") || amount.equals("") || price.equals("") || providers.equals("")) {
                    lblNewLabel_15.setVisible(true);
                }
                else {
                    lblNewLabel_15.setVisible(false);
                    String output= barcode + ", '" + name + "', " + amount + ", '" + category + "', " + price + ", '"+ providers + "'";
                    log.info(output);
                    Database.addToDatabase("Products", output);
                    nameField2.setText("");
                    barcodeField.setText("");
                    categoryField.setText("");
                    amountField.setText("");
                    priceField.setText("");
                    providersField.setText("");
                }
            }
        });
        addProduct.setBounds(91, 307, 392, 25);
        panel_1.add(addProduct);

        providersField = new JTextField();
        providersField.setBounds(228, 224, 116, 22);
        panel_1.add(providersField);
        providersField.setColumns(10);

        JLabel lblNewLabel_18 = new JLabel("Provider:");
        lblNewLabel_18.setBounds(114, 227, 56, 16);
        panel_1.add(lblNewLabel_18);


        JPanel panel_2 = new JPanel();
        layeredPane.add(panel_2, "name_38495829752200");
        panel_2.setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("Select from:");
        lblNewLabel_5.setBounds(45, 13, 116, 16);
        panel_2.add(lblNewLabel_5);

        String comboTable[] = { "Products","Providers", "Users" };
        JComboBox comboBox = new JComboBox(comboTable);
        comboBox.setBounds(188, 10, 213, 22);
        panel_2.add(comboBox);

        JLabel lblNewLabel = new JLabel("Search for:");
        lblNewLabel.setBounds(45, 51, 94, 16);
        panel_2.add(lblNewLabel);

        searchForField = new JTextField();
        searchForField.setBounds(188, 48, 213, 22);
        panel_2.add(searchForField);
        searchForField.setColumns(10);

        JButton btnNewButton_7 = new JButton("Search");
        btnNewButton_7.setBounds(447, 47, 97, 25);
        panel_2.add(btnNewButton_7);

        JPanel panel_6 = new JPanel();
        panel_6.setBounds(12, 124, 565, 298);
        panel_2.add(panel_6);
        panel_6.setLayout(new GridLayout());

        JPanel panel_4 = new JPanel();
        panel_4.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel_4,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        panel_6.add(scrollPane);

        JLayeredPane layeredPane_1 = new JLayeredPane();
        layeredPane_1.setBounds(12, 88, 565, 34);
        panel_2.add(layeredPane_1);
        layeredPane_1.setLayout(new CardLayout(0, 0));

        JPanel panel_9 = new JPanel();
        layeredPane_1.add(panel_9, "name_27760408777200");
        panel_9.setLayout(null);

        JButton btnNewButton = new JButton("Name");
        btnNewButton.setBounds(0, 8, 97, 20);
        panel_9.add(btnNewButton);

        JButton btnBarcode = new JButton("BARCODE");
        btnBarcode.setBounds(99, 8, 97, 20);
        panel_9.add(btnBarcode);

        JButton btnPrice = new JButton("Price");
        btnPrice.setBounds(194, 8, 97, 20);
        panel_9.add(btnPrice);

        JButton btnAmount = new JButton("Amount");
        btnAmount.setBounds(292, 8, 97, 20);
        panel_9.add(btnAmount);

        JButton btnCategory = new JButton("Category");
        btnCategory.setBounds(390, 8, 97, 20);
        panel_9.add(btnCategory);

        JPanel panel_10 = new JPanel();
        layeredPane_1.add(panel_10, "name_27760427271900");
        panel_10.setLayout(null);

        JButton btnNewButton_3 = new JButton("Name");
        btnNewButton_3.setBounds(0, 8, 97, 20);
        panel_10.add(btnNewButton_3);

        JPanel panel_11 = new JPanel();
        layeredPane_1.add(panel_11, "name_27797652101300");
        panel_11.setLayout(null);

        JButton button = new JButton("Name");
        button.setBounds(2, 8, 97, 20);
        panel_11.add(button);

        JButton btnSurname = new JButton("Surname");
        btnSurname.setBounds(99, 8, 97, 20);
        panel_11.add(btnSurname);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(193, 8, 97, 20);
        panel_11.add(btnLogin);

        JButton btnAdmin = new JButton("Role");
        btnAdmin.setBounds(290, 8, 97, 20);
        panel_11.add(btnAdmin);



        JPanel panel_3 = new JPanel();
        layeredPane.add(panel_3, "name_38497345059300");
        panel_3.setLayout(null);

        JPanel panel_8 = new JPanel();
        panel_8.setBounds(12, 116, 565, 306);
        panel_3.add(panel_8);
        panel_8.setLayout(null);

        JPanel panel_7 = new JPanel();
        panel_7.setLayout(new GridBagLayout());

        JScrollPane scrollPane_1 = new JScrollPane(panel_7, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_1.setBounds(0, 0, 565, 306);
        panel_8.add(scrollPane_1);

        JLabel lblNewLabel_6 = new JLabel("Following products are going to run out soon:");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(98, 44, 376, 16);
        panel_3.add(lblNewLabel_6);

        JPanel panel_0 = new JPanel();
        layeredPane.add(panel_0, "name_38499294467400");
        panel_0.setLayout(null);

        JLabel lblNewLabel_7 = new JLabel("Enter BARCODE");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(91, 37, 122, 16);
        panel_0.add(lblNewLabel_7);

        updateBarcodeField = new JTextField();
        updateBarcodeField.setBounds(266, 34, 210, 22);
        panel_0.add(updateBarcodeField);
        updateBarcodeField.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Name");
        lblNewLabel_8.setBounds(91, 220, 56, 16);
        panel_0.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Amount");
        lblNewLabel_9.setBounds(91, 265, 56, 16);
        panel_0.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Price");
        lblNewLabel_10.setBounds(91, 315, 56, 16);
        panel_0.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Category");
        lblNewLabel_11.setBounds(91, 364, 56, 16);
        panel_0.add(lblNewLabel_11);

        newName = new JTextField();
        newName.setBounds(191, 217, 171, 22);
        panel_0.add(newName);
        newName.setColumns(10);

        updateAmountField = new JTextField();
        updateAmountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==46 || c==KeyEvent.VK_DELETE)) {
                    frame.getToolkit().beep();
                    e.consume();                                           //usuwa wszystko co nie jest wymienione w arg
                    log.warn("You can pass only numbers, backspace or dot!");
                }
            }
        });
        updateAmountField.setBounds(191, 262, 171, 22);
        panel_0.add(updateAmountField);
        updateAmountField.setColumns(10);

        updatePriceField = new JTextField();
        updatePriceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                char c = arg0.getKeyChar();
                if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==46 || c==KeyEvent.VK_DELETE)) {
                    frame.getToolkit().beep();
                    arg0.consume();                                           //usuwa wszystko co nie jest wymienione w arg
                    log.warn("You can pass only numbers, backspace or dot!");
                }
            }
        });
        updatePriceField.setBounds(191, 312, 171, 22);
        panel_0.add(updatePriceField);
        updatePriceField.setColumns(10);

        updateCategoryField = new JTextField();
        updateCategoryField.setBounds(191, 358, 171, 22);
        panel_0.add(updateCategoryField);
        updateCategoryField.setColumns(10);

        JLabel lblNewLabel_12 = new JLabel("BARCODE");
        lblNewLabel_12.setBounds(91, 174, 56, 16);
        panel_0.add(lblNewLabel_12);

        updateBarcode2 = new JTextField();
        updateBarcode2.setEditable(false);
        updateBarcode2.setBounds(191, 171, 171, 22);
        panel_0.add(updateBarcode2);
        updateBarcode2.setColumns(10);

        JButton btnNewButton_4 = new JButton("Find");
        btnNewButton_4.setBounds(227, 78, 97, 25);
        panel_0.add(btnNewButton_4);

        JLabel lblNewLabel_13 = new JLabel("PRODUCT WITH GIVEN BARCODE DOES NOT EXIST!");
        lblNewLabel_13.setBackground(new Color(255, 0, 0));
        lblNewLabel_13.setForeground(new Color(255, 69, 0));
        lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_13.setBounds(129, 123, 322, 16);
        panel_0.add(lblNewLabel_13);
        lblNewLabel_13.setVisible(false);

        JButton btnNewButton_5 = new JButton("Change");
        btnNewButton_5.setBounds(391, 216, 97, 25);
        panel_0.add(btnNewButton_5);
        btnNewButton_5.setVisible(false);

        JButton btnNewButton_8 = new JButton("Change");
        btnNewButton_8.setBounds(391, 261, 97, 25);
        panel_0.add(btnNewButton_8);
        btnNewButton_8.setVisible(false);

        JButton btnNewButton_9 = new JButton("Change");
        btnNewButton_9.setBounds(391, 311, 97, 25);
        panel_0.add(btnNewButton_9);
        btnNewButton_9.setVisible(false);

        JButton btnNewButton_10 = new JButton("Change");
        btnNewButton_10.setBounds(391, 355, 97, 25);
        panel_0.add(btnNewButton_10);
        btnNewButton_10.setVisible(false);

        JPanel panel_12 = new JPanel();
        layeredPane.add(panel_12, "name_37254725760100");
        panel_0.setVisible(true);

        switchingPanels(panel_12, layeredPane);

        JPanel panel_13 = new JPanel();
        layeredPane.add(panel_13, "name_53876782212100");
        panel_13.setLayout(null);

        JPanel panel_14 = new JPanel();
        panel_14.setLayout(new GridBagLayout());

        JScrollPane scrollPane_2 = new JScrollPane(panel_14, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_2.setBounds(0, 168, 589, 267);
        panel_13.add(scrollPane_2);

        JLabel addPromoNameLabel = new JLabel("Name");
        addPromoNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addPromoNameLabel.setBounds(145, 37, 101, 16);
        panel_13.add(addPromoNameLabel);

        namePromoField = new JTextField();
        namePromoField.setBounds(281, 34, 116, 22);
        panel_13.add(namePromoField);
        namePromoField.setColumns(10);

        JLabel lblNewLabel_16 = new JLabel("How much?");
        lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_16.setBounds(155, 66, 91, 16);
        panel_13.add(lblNewLabel_16);

        howMuchPromoField = new JTextField();
        howMuchPromoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==46 || c==KeyEvent.VK_DELETE)) {
                    frame.getToolkit().beep();
                    e.consume();                                           //usuwa wszystko co nie jest wymienione w arg
                    log.warn("You can pass only numbers, backspace or dot!");
                }
            }
        });
        howMuchPromoField.setBounds(281, 63, 116, 22);
        panel_13.add(howMuchPromoField);
        howMuchPromoField.setColumns(10);

        JLabel fillLabel = new JLabel("Fill in every field!");
        fillLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fillLabel.setForeground(new Color(255, 0, 0));
        fillLabel.setBounds(374, 130, 176, 16);
        panel_13.add(fillLabel);
        fillLabel.setVisible(false);

        //"Add" Button in Manage Promocodes
        JButton btnPromoAdd = new JButton("Add");
        btnPromoAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = namePromoField.getText();
                String discount = howMuchPromoField.getText();
                if (name.equals("") || discount.equals("")) {
                    fillLabel.setVisible(true);
                }
                else {
                    fillLabel.setVisible(false);
                    String string = "'" + name + "', " + discount;
                    Database.addToDatabase("Discount", string);
                    promos = Database.searchForPromos("code");
                    showPromos(panel_14, promos);
                }
            }
        });
        btnPromoAdd.setBounds(243, 126, 97, 25);
        panel_13.add(btnPromoAdd);

        JPanel panel_15 = new JPanel();
        layeredPane.add(panel_15, "name_44280493319700");
        panel_15.setLayout(null);

        JPanel panel_16 = new JPanel();
        panel_16.setLayout(new GridBagLayout());

        JScrollPane scrollPane_3 = new JScrollPane(panel_16, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_3.setBounds(12, 13, 565, 409);
        panel_15.add(scrollPane_3);

        //"Find" in Update Supplies panel
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LinkedList<Product> temp_list = Database.searchInDatabase("Products", "BARCODE", updateBarcodeField.getText());
                if (temp_list.isEmpty()) {
                    lblNewLabel_13.setVisible(true);
                }
                else {
                    lblNewLabel_13.setVisible(false);
                    updateBarcode2.setText(String.valueOf(temp_list.get(0).getBarcode()));
                    updateCategoryField.setText(temp_list.get(0).getCategory());
                    updateAmountField.setText(String.valueOf(temp_list.get(0).getAmount()));
                    updatePriceField.setText(String.valueOf(temp_list.get(0).getPrice()));
                    newName.setText(temp_list.get(0).getName());
                    btnNewButton_5.setVisible(true);
                    btnNewButton_8.setVisible(true);
                    btnNewButton_9.setVisible(true);
                    btnNewButton_10.setVisible(true);
                }
            }
        });

        //"Add Employee" Button
        addEmployee.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                fillInLabel.setVisible(false);
                lblNewLabel_14.setVisible(false);
                String name = nameField.getText();
                String surname = surnameField.getText();
                String login= loginField.getText();
                String pass = passField.getText();
                String passConf = passFieldConf.getText();
                if (pass.equals(passConf)==false) {
                    lblNewLabel_14.setVisible(true);
                }
                else {
                    if (name.equals("") || surname.equals("")|| login.equals("") || pass.equals("") || passConf.equals("")) {
                        fillInLabel.setVisible(true);
                    }
                    else {
                        fillInLabel.setVisible(false);
                        lblNewLabel_14.setVisible(false);
                        int admin = 0;
                        if(adminButton.isSelected())
                            admin=1;
                        if(cashierButton.isSelected())
                            admin=0;
                        String output= "'" + name + "', '" + surname + "', '" + login + "', '" + pass + "', " + admin;
                        log.info(output);
                        Database.addToDatabase("Users", output);
                        nameField.setText("");
                        surnameField.setText("");
                        loginField.setText("");
                        passField.setText("");
                        passFieldConf.setText("");

                    }
                }
            }
        });

        JButton NewAccount = new JButton("Create New Account");
        NewAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel, layeredPane);
            }
        });
        NewAccount.setBounds(648, 28, 165, 25);
        frame.getContentPane().add(NewAccount);

        JButton AddProduct = new JButton("Add Product");
        AddProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_1, layeredPane);
            }
        });
        AddProduct.setBounds(648, 82, 165, 25);
        frame.getContentPane().add(AddProduct);

        JButton btnNewButton_2 = new JButton("Search for product");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_2, layeredPane);
                layeredPane_1.setVisible(false);
            }
        });
        btnNewButton_2.setBounds(648, 130, 165, 25);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_6 = new JButton("Log Out");
        btnNewButton_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(1);
            }
        });
        btnNewButton_6.setBounds(686, 423, 97, 25);
        frame.getContentPane().add(btnNewButton_6);

        JButton btnShortage = new JButton("Shortage");
        btnShortage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_3, layeredPane);
                LinkedList<Product> sh_list = null;
                sh_list = Database.shortage();
                showProducts(panel_7, sh_list, "Products");
            }
        });
        btnShortage.setBounds(648, 179, 165, 25);
        frame.getContentPane().add(btnShortage);

        JButton btnNewButton_1 = new JButton("Update supplies");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_0, layeredPane);
            }
        });
        btnNewButton_1.setBounds(648, 230, 165, 25);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnPromo = new JButton("Manage Promocodes");
        btnPromo.setBounds(648, 276, 165, 25);
        frame.getContentPane().add(btnPromo);

        JButton btnNewButton_11 = new JButton("Orders of deliveries");
        btnNewButton_11.setBounds(648, 332, 165, 25);
        frame.getContentPane().add(btnNewButton_11);

        //"Manage Promocodes" Button
        btnPromo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchingPanels(panel_13, layeredPane);
                namePromoField.setText("");
                howMuchPromoField.setText("");
                String exactWord = " ";
                promos = Database.searchForPromos("code");
                showPromos(panel_14, promos);
            }
        });

        //"Change" No.1 in Update Supplies
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Database.updateField("Products", "Name", "BARCODE", updateBarcode2.getText(), newName.getText())) {
                    newName.setText("");
                }
                else {
                    log.warn("Changing Database has failed!");
                }
            }
        });

        //"Change" No.2 in Update Supplies
        btnNewButton_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Database.changeAmount(updateBarcode2.getText(), Float.valueOf(updateAmountField.getText()));
                updateAmountField.setText("");
            }
        });
        //"Change" No.3 in Update Supplies
        btnNewButton_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Database.updateField("Products", "Price", "BARCODE", updateBarcode2.getText(), updatePriceField.getText())) {
                    updatePriceField.setText("");
                }
                else {
                    log.warn("Changing Database has failed!");
                }
            }
        });

        //"Change" No.4 in Update Supplies
        btnNewButton_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Database.updateField("Products", "Category", "BARCODE", updateBarcode2.getText(), updateCategoryField.getText())) {
                    updateCategoryField.setText("");
                }
                else {
                    log.warn("Changing Database has failed!");
                }
            }
        });

        // "Search" button
        btnNewButton_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                switch (Objects.requireNonNull(searchBy)) {
                    case "Products": {
                        layeredPane_1.setVisible(true);
                        panel_9.setVisible(true);
                        panel_10.setVisible(false);
                        panel_11.setVisible(false);
                        LinkedList<Product>  list_prod = Database.searchInDatabase("Products", "Name", searchFor);

                        if(list_prod!=null) {
                            showProducts(panel_4, list_prod, "Products");
                        }
                        break;
                    }
                    case "Providers": {
                        layeredPane_1.setVisible(true);
                        panel_10.setVisible(true);
                        panel_11.setVisible(false);
                        panel_9.setVisible(false);
                        LinkedList<Providers> list_prov = Database.searchForProviders();
                        if(list_prov!=null)
                            showProducts(panel_4, list_prov, "Providers");
                        break;
                    }
                    case "Users": {
                        layeredPane_1.setVisible(true);
                        panel_11.setVisible(true);
                        panel_10.setVisible(false);
                        panel_9.setVisible(false);
                        String order = "surname";
                        LinkedList<Users> list_users = Database.selectUsers(order);
                        showProducts(panel_4, list_users, "Users");
                        break;
                    }
                }
            }
        });

        //"Name" Order By
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                LinkedList<Product> list_temp = Database.selectInOrder(searchBy, "Name");
                showProducts(panel_4, list_temp, "Products");
            }
        });

        //"BARCODE" Order by
        btnBarcode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                LinkedList<Product> list_temp = Database.selectInOrder(searchBy, "BARCODE");
                showProducts(panel_4, list_temp, "Products");
            }
        });

        //"Price" Order By
        btnPrice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                LinkedList<Product> list_temp = Database.selectInOrder(searchBy, "Price");
                showProducts(panel_4, list_temp, "Products");
            }
        });

        //"Amount" Order By
        btnAmount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                LinkedList<Product> list_temp = Database.selectInOrder(searchBy, "Amount");
                showProducts(panel_4, list_temp, "Products");
            }
        });

        //"Category" Order By
        btnCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String searchBy = (String) comboBox.getSelectedItem();
                String searchFor = searchForField.getText();
                LinkedList<Product> list_temp = Database.selectInOrder(searchBy, "Category");
                showProducts(panel_4, list_temp, "Products");
            }
        });

        //"Orders of Delivery" Button
        btnNewButton_11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                switchingPanels(panel_15, layeredPane);
                LinkedList orders = Database.searchForOrders();
                showOrders(panel_16, orders);
            }
        });

        frame.setVisible(true);
    }

    public void switchingPanels (JPanel panel, JLayeredPane lpanel) {
        lpanel.removeAll();
        lpanel.add(panel);
        lpanel.repaint();
        lpanel.revalidate();
    }

    public void showProducts (JPanel panel, LinkedList products, String table) {
        // Clear panel
        panel.removeAll();
        Iterator iter = products.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,1,30,80);      //góra lewo dół prawo
        int count=0;
        switch (table) {
            // Add labels which are describing table
            case "Products": {
                gbc.gridx = 0;
                gbc.gridy = count;
                panel.add(new JLabel("BARCODE"), gbc);
                gbc.gridx = 1;
                gbc.gridy = count;
                panel.add(new JLabel("Name"), gbc);
                gbc.gridx = 2;
                gbc.gridy = count;
                panel.add(new JLabel("Amount"), gbc);
                gbc.gridx = 3;
                gbc.gridy = count;
                panel.add(new JLabel("Price:"), gbc);
                gbc.gridx = 4;
                gbc.gridy = count;
                panel.add(new JLabel("Category:"), gbc);
                gbc.gridx = 5;
                gbc.gridy = count;
                panel.add(new JLabel("Provider:"), gbc);
                count++;

                gbc.insets = new Insets(10, 1, 10, 80);        //góra lewo dół prawo
                while (iter.hasNext()) {
                    Product product_temp = (Product) iter.next();
                    String barcode = String.valueOf(product_temp.getBarcode());
                    String name = product_temp.getName();
                    float price = product_temp.getPrice();
                    float amount = product_temp.getAmount();
                    String cat = product_temp.getCategory();
                    String prov = product_temp.getProvider();
                    gbc.gridx = 0;
                    gbc.gridy = count;
                    panel.add(new JLabel(barcode), gbc);
                    gbc.gridx = 1;
                    gbc.gridy = count;
                    panel.add(new JLabel(name), gbc);
                    gbc.gridx = 2;
                    gbc.gridy = count;
                    panel.add(new JLabel(String.valueOf(amount)), gbc);
                    gbc.gridx = 3;
                    gbc.gridy = count;
                    panel.add(new JLabel(String.valueOf(price)), gbc);
                    gbc.gridx = 4;
                    gbc.gridy = count;
                    panel.add(new JLabel(cat), gbc);
                    gbc.gridx = 5;
                    gbc.gridy = count;
                    panel.add(new JLabel(prov), gbc);
                    count++;
                }
                break;
            }
            case "Users": {
                gbc.gridx = 0;
                gbc.gridy = count;
                panel.add(new JLabel("ID:"), gbc);
                gbc.gridx = 1;
                gbc.gridy = count;
                panel.add(new JLabel("Name:"), gbc);
                gbc.gridx = 2;
                gbc.gridy = count;
                panel.add(new JLabel("Surname:"), gbc);
                gbc.gridx = 3;
                gbc.gridy = count;
                panel.add(new JLabel("Login:"), gbc);
                gbc.gridx = 4;
                gbc.gridy = count;
                panel.add(new JLabel("Is Admin?"), gbc);
                gbc.gridx = 5;
                gbc.gridy = count;
                panel.add(new JLabel(""), gbc);
                count++;

                gbc.insets = new Insets(10, 1, 10, 80);        //góra lewo dół prawo
                while (iter.hasNext()) {
                    Users product_temp = (Users) iter.next();
                    String id = String.valueOf(product_temp.getId());
                    String name = product_temp.getName();
                    String surname = product_temp.getSurname();
                    String login = product_temp.getLogin();
                    boolean admin = product_temp.isAdminRights();
                    gbc.gridx = 0;
                    gbc.gridy = count;
                    panel.add(new JLabel(id), gbc);
                    gbc.gridx = 1;
                    gbc.gridy = count;
                    panel.add(new JLabel(name), gbc);
                    gbc.gridx = 2;
                    gbc.gridy = count;
                    panel.add(new JLabel(surname), gbc);
                    gbc.gridx = 3;
                    gbc.gridy = count;
                    panel.add(new JLabel(login), gbc);
                    gbc.gridx = 4;
                    gbc.gridy = count;
                    panel.add(new JLabel(String.valueOf(admin)), gbc);
                    gbc.gridx = 5;
                    gbc.gridy = count;
                    JButton btn = new JButton("Change Password");
                    panel.add(btn, gbc);
                    btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //TODO: zmiana hasła
                        }
                    });
                    count++;
                }
                break;
            }
            case "Providers": {
                gbc.gridx = 0;
                gbc.gridy = count;
                panel.add(new JLabel("NIP:"), gbc);
                gbc.gridx = 1;
                gbc.gridy = count;
                panel.add(new JLabel("Name:"), gbc);
                gbc.gridx = 2;
                gbc.gridy = count;
                panel.add(new JLabel("Adress:"), gbc);
                count++;

                gbc.insets = new Insets(10, 1, 10, 80);        //góra lewo dół prawo
                while (iter.hasNext()) {
                    Providers product_temp = (Providers) iter.next();
                    String id = String.valueOf(product_temp.getNip()); //TODO: wyswietla sie w notacji wykladniczej xd
                    String name = product_temp.getName();
                    String surname = product_temp.getAdres();
                    gbc.gridx = 0;
                    gbc.gridy = count;
                    panel.add(new JLabel(id), gbc);
                    gbc.gridx = 1;
                    gbc.gridy = count;
                    panel.add(new JLabel(name), gbc);
                    gbc.gridx = 2;
                    gbc.gridy = count;
                    panel.add(new JLabel(surname), gbc);
                    count++;
                }
            }
            break;
        }
        // Align components top-to-bottom
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = count;
        c.weighty = 1;
        panel.add(new JLabel(), c);
        panel.updateUI();
    }

    public void showPromos(JPanel panel, LinkedList<PromoCode> list) {
        // Clear panel
        panel.removeAll();
        Iterator iter = list.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,1,30,80);      //góra lewo dół prawo
        int count=0;
        // Add labels which are describing table

        gbc.gridx = 0;
        gbc.gridy = count;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = count;
        panel.add(new JLabel("Discount:"), gbc);
        count++;

        gbc.insets = new Insets(10,1,10,80);      //góra lewo dół prawo
        while(iter.hasNext())
        {
            PromoCode product_temp = (PromoCode) iter.next();
            String code = product_temp.getCode();
            int discount = product_temp.getDiscount();
            gbc.gridx = 0;
            gbc.gridy = count;
            panel.add(new JLabel(code), gbc);
            gbc.gridx = 1;
            gbc.gridy = count;
            panel.add(new JLabel(String.valueOf(discount)), gbc);
            gbc.gridx = 2;
            gbc.gridy = count;
            JButton btn = new JButton("Remove");
            panel.add(btn, gbc);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String zz = product_temp.getCode();
                    Database.deleteFromTable("Discount", "Code", zz);
                    LinkedList<PromoCode> z1 = Database.searchForPromos("Code");
                    showPromos(panel, z1);
                }
            });
            count++;
        }

        // Align components top-to-bottom
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = count;
        c.weighty = 1;
        panel.add(new JLabel(), c);
        panel.updateUI();
    }

    private void showOrders (JPanel panel, LinkedList list) {
        // Clear panel
        panel.removeAll();
        Iterator iter = list.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,1,30,80);      //góra lewo dół prawo
        int count=0;
        // Add labels which are describing table

        gbc.gridx = 0;
        gbc.gridy = count;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = count;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 2;
        gbc.gridy = count;
        panel.add(new JLabel("Surname:"), gbc);
        gbc.gridx = 3;
        gbc.gridy = count;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 4;
        gbc.gridy = count;
        panel.add(new JLabel("Payment:"), gbc);
        count++;

        gbc.insets = new Insets(10,1,10,80);      //góra lewo dół prawo
        while(iter.hasNext())
        {
            Orders product_temp = (Orders) iter.next();
            int id = product_temp.getId();
            String code = product_temp.getCode();
            String str = product_temp.getAddres();
            String city = product_temp.getCity();
            String surname = product_temp.getSurname();
            String name = product_temp.getName();
            String discount = product_temp.getPayment();
            gbc.gridx = 0;
            gbc.gridy = count;
            panel.add(new JLabel(String.valueOf(id)), gbc);
            gbc.gridx = 1;
            gbc.gridy = count;
            panel.add(new JLabel(name), gbc);
            gbc.gridx = 2;
            gbc.gridy = count;
            panel.add(new JLabel(surname), gbc);
            gbc.gridx = 3;
            gbc.gridy = count;
            panel.add(new JLabel(str + " " + city +", " + code), gbc);
            gbc.gridx = 4;
            gbc.gridy = count;
            panel.add(new JLabel(discount), gbc);
            gbc.gridx = 5;
            gbc.gridy = count;
            JButton btn = new JButton("Realized");
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Database.deleteFromTable("Orders", "ID", String.valueOf(id));
                    panel.updateUI();
                }
            });
            count++;
        }

        // Align components top-to-bottom
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = count;
        c.weighty = 1;
        panel.add(new JLabel(), c);
        panel.updateUI();
    }
}


