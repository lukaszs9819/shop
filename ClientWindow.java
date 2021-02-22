package com.shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;
import javax.xml.crypto.Data;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ClientWindow {

    private JFrame frame;
    private JTextField totalField;
    private JTextField promoCodeField;
    LinkedList<Product> produkty, prod_right;
    LinkedList<Float> amountList;
    private JPanel panel_1;
    private static final Logger log = Logger.getLogger(ClientWindow.class);
    private JTextField surnameDelivery;
    private JTextField addressDelivery;
    private JTextField nameDelivery;
    private JTextField cityDelivery;
    private JTextField zipDelivery;
    private JTextField searchForField;
    private static int discount;
    private static float total = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientWindow window = new ClientWindow();
                    window.frame.setVisible(true);
                    log.info("Client Window has been opened successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Client Window has not opened, shuting down");
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public ClientWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1003, 588);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        amountList = new LinkedList();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 989, 551);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 13, 967, 525);
        layeredPane.add(panel_3);
        panel_3.setLayout(null);
        panel_3.setVisible(true);

        JLabel label_2 = new JLabel("Cart");
        label_2.setBounds(793, 18, 56, 16);
        panel_3.add(label_2);

        JButton button = new JButton("Order");
        button.setBounds(793, 474, 97, 25);
        panel_3.add(button);


        JLabel label = new JLabel("Pick your products");
        label.setBounds(60, 18, 213, 16);
        panel_3.add(label);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 85, 632, 392);
        panel_3.add(scrollPane);

        //wywolanie metody zwracajacej liste
        produkty = new LinkedList();
        prod_right = new LinkedList();
        produkty = Database.selectInOrder("Products", "Name");
        showProducts(produkty, panel);

        JLabel lblNewLabel = new JLabel("The Cart is empty! Please pick at least 1 product to proceed");
        lblNewLabel.setBackground(new Color(204, 0, 0));
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(565, 512, 390, 16);
        panel_3.add(lblNewLabel);
        lblNewLabel.setVisible(false);

        panel_1 = new JPanel();
        panel_1.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent arg0) {
                if (prod_right.isEmpty() == false) {
                    lblNewLabel.setVisible(false);
                }
            }
        });
        panel_1.setLayout(new GridBagLayout());

        JScrollPane scrollPane_1 = new JScrollPane(panel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_1.setBounds(652, 85, 303, 365);
        panel_3.add(scrollPane_1);

        searchForField = new JTextField();
        searchForField.setBounds(345, 33, 180, 22);
        panel_3.add(searchForField);
        searchForField.setColumns(10);

        JLabel searchForLabel = new JLabel("Search for:");
        searchForLabel.setBounds(250, 36, 83, 16);
        panel_3.add(searchForLabel);

        JButton searchFrontButton = new JButton("Search");
        searchFrontButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                String searchFor = searchForField.getText();
                produkty.clear();
                produkty = Database.searchInDatabase("Products", "name", searchFor);
                showProducts(produkty, panel);
            }
        });
        searchFrontButton.setBounds(535, 32, 97, 25);
        panel_3.add(searchFrontButton);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 13, 967, 525);
        layeredPane.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setVisible(false);

        JPanel panel_4 = new JPanel();
        panel_4.setLayout(new GridBagLayout());

        JScrollPane scrollPane_2 = new JScrollPane(panel_4, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_2.setBounds(0, 13, 573, 389);
        panel_2.add(scrollPane_2);

        JLabel lblNewLabel_10 = new JLabel("Total");
        lblNewLabel_10.setBounds(327, 422, 56, 16);
        panel_2.add(lblNewLabel_10);

        totalField = new JTextField();
        totalField.setEditable(false);
        totalField.setBounds(442, 419, 116, 22);
        panel_2.add(totalField);
        totalField.setColumns(10);

        promoCodeField = new JTextField();
        promoCodeField.setBounds(751, 113, 116, 22);
        panel_2.add(promoCodeField);
        promoCodeField.setColumns(10);

        JLabel lblNewLabel_11 = new JLabel("Promo Code");
        lblNewLabel_11.setBounds(634, 116, 76, 16);
        panel_2.add(lblNewLabel_11);

        JButton addButton = new JButton("Add");
        addButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                LinkedList<PromoCode> temp = Database.searchForPromos("code");

                if (temp != null) {
                    for (PromoCode temp1 : temp) {
                        if (promoCodeField.getText().equals(temp1.getCode())) {
                            discount = temp1.getDiscount();
                            totalField.setText(String.valueOf(total * (100 - discount) / 100));
                        }
                    }
                }
            }
        });
        addButton.setBounds(761, 148, 97, 25);
        panel_2.add(addButton);

        JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.setBounds(692, 326, 156, 25);
        panel_2.add(ConfirmButton);

        JButton goBackButton = new JButton("Go back");
        goBackButton.setBounds(858, 487, 97, 25);
        panel_2.add(goBackButton);

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Deliver Products");
        rdbtnNewRadioButton_4.setBounds(692, 213, 127, 25);
        panel_2.add(rdbtnNewRadioButton_4);
        rdbtnNewRadioButton_4.setSelected(true);

        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("I will handle myself");
        rdbtnNewRadioButton_5.setBounds(692, 243, 189, 25);
        panel_2.add(rdbtnNewRadioButton_5);

        ButtonGroup g0 = new ButtonGroup();
        g0.add(rdbtnNewRadioButton_4);
        g0.add(rdbtnNewRadioButton_5);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(10, 13, 967, 525);
        layeredPane.add(panel_5, "name_20904425192400");
        panel_5.setLayout(null);

        JLayeredPane layeredPane_1 = new JLayeredPane();
        layeredPane_1.setBounds(0, 51, 977, 487);
        panel_5.add(layeredPane_1);
        layeredPane_1.setLayout(new CardLayout(0, 0));

        JPanel panel_7 = new JPanel();
        panel_7.setLayout(null);
        layeredPane_1.add(panel_7, "name_23917709552400");

        JLabel label_9 = new JLabel("Fill in delivery form");
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_9.setBounds(192, 36, 150, 22);
        panel_7.add(label_9);

        JLabel label_10 = new JLabel("Name");
        label_10.setBounds(161, 85, 33, 16);
        panel_7.add(label_10);

        JLabel label_11 = new JLabel("Surname");
        label_11.setBounds(161, 131, 52, 16);
        panel_7.add(label_11);

        JLabel label_12 = new JLabel("Address");
        label_12.setBounds(161, 179, 46, 16);
        panel_7.add(label_12);

        JLabel label_13 = new JLabel("ZIP Code");
        label_13.setBounds(161, 225, 51, 16);
        panel_7.add(label_13);

        JLabel label_14 = new JLabel("City");
        label_14.setBounds(161, 277, 21, 16);
        panel_7.add(label_14);

        surnameDelivery = new JTextField();
        surnameDelivery.setColumns(10);
        surnameDelivery.setBounds(256, 128, 116, 22);
        panel_7.add(surnameDelivery);

        addressDelivery = new JTextField();
        addressDelivery.setColumns(10);
        addressDelivery.setBounds(256, 176, 116, 22);
        panel_7.add(addressDelivery);

        nameDelivery = new JTextField();
        nameDelivery.setColumns(10);
        nameDelivery.setBounds(256, 82, 116, 22);
        panel_7.add(nameDelivery);

        cityDelivery = new JTextField();
        cityDelivery.setColumns(10);
        cityDelivery.setBounds(256, 274, 116, 22);
        panel_7.add(cityDelivery);

        zipDelivery = new JTextField();
        zipDelivery.setColumns(10);
        zipDelivery.setBounds(256, 222, 116, 22);
        panel_7.add(zipDelivery);

        JRadioButton nowRButton = new JRadioButton("Now");
        nowRButton.setBounds(601, 81, 127, 25);
        panel_7.add(nowRButton);
        nowRButton.setSelected(true);

        JRadioButton onDeliveryRButton = new JRadioButton("On delivery");
        onDeliveryRButton.setBounds(732, 81, 127, 25);
        panel_7.add(onDeliveryRButton);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(nowRButton);
        g1.add(onDeliveryRButton);

        JRadioButton rdbtnIHaveRead = new JRadioButton("I have read the regulations and accept the terms");
        rdbtnIHaveRead.setBounds(601, 175, 328, 25);
        panel_7.add(rdbtnIHaveRead);

        JLabel lblNewLabel_1 = new JLabel("Payment Method");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(670, 41, 158, 16);
        panel_7.add(lblNewLabel_1);

        JRadioButton cashRButton = new JRadioButton("Cash");
        cashRButton.setSelected(true);
        cashRButton.setBounds(601, 122, 127, 25);
        panel_7.add(cashRButton);
        cashRButton.setVisible(false);

        JRadioButton ccRButton = new JRadioButton("Credit Card");
        ccRButton.setBounds(732, 122, 127, 25);
        panel_7.add(ccRButton);
        ccRButton.setVisible(false);

        ButtonGroup g2 = new ButtonGroup();
        g2.add(cashRButton);
        g2.add(ccRButton);

        //"On delivery" RadioButton
        onDeliveryRButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ccRButton.setVisible(true);
                cashRButton.setVisible(true);
                cashRButton.setEnabled(true);
                ccRButton.setEnabled(true);
            }
        });

        //"Now" RadioButton
        nowRButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                cashRButton.setVisible(false);
                ccRButton.setVisible(false);
                cashRButton.setEnabled(false);
                ccRButton.setEnabled(false);
            }
        });

        JButton btnConfirmPay = new JButton("Confirm & Pay");
        btnConfirmPay.setBounds(446, 378, 173, 25);
        panel_7.add(btnConfirmPay);

        JLabel lblNewLabel_3 = new JLabel("Fill in every field!");
        lblNewLabel_3.setForeground(new Color(255, 0, 0));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(238, 328, 104, 16);
        panel_7.add(lblNewLabel_3);
        lblNewLabel_3.setVisible(false);

        JLabel lblNewLabel_4 = new JLabel("Selecting this button is a must to proceed!");
        lblNewLabel_4.setForeground(new Color(255, 0, 0));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(601, 225, 287, 16);
        panel_7.add(lblNewLabel_4);
        lblNewLabel_4.setVisible(false);

        JPanel panel_6 = new JPanel();
        layeredPane_1.add(panel_6, "name_23917719011700");
        panel_6.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Thank you and have a good day!");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(87, 39, 801, 236);
        panel_6.add(lblNewLabel_2);

        JButton btnHidden = new JButton("HiddenButton");
        btnHidden.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent arg0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                showCart(panel_1, prod_right, amountList);
                panel_3.setVisible(true);
                panel_6.setVisible(false);
                panel_5.setVisible(false);
                btnHidden.setVisible(true);
                showProducts(produkty, panel);
            }
        });
        btnHidden.setEnabled(false);
        btnHidden.setBounds(421, 371, 194, 25);
        btnHidden.setVisible(true);
        panel_6.add(btnHidden);

        JPanel panel_8 = new JPanel();
        layeredPane_1.add(panel_8, "name_4342083705299");
        panel_8.setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("Payment being processed, please wait...");
        lblNewLabel_5.setFont(new Font("Goudy Old Style", Font.PLAIN, 26));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(225, 95, 601, 85);
        panel_8.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Payment processed successfuly :)");
        lblNewLabel_6.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 28));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(225, 240, 601, 85);
        panel_8.add(lblNewLabel_6);
        lblNewLabel_6.setVisible(false);

        JButton btnHidden2 = new JButton("HiddenButton");
        btnHidden2.setEnabled(false);
        btnHidden2.setBounds(785, 373, 17, 7);
        btnHidden2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent arg0) {
                btnHidden2.setVisible(false);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                lblNewLabel_6.setVisible(true);
                lblNewLabel_5.setVisible(false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                switchingPanels(panel_6, layeredPane_1);
                btnHidden.setVisible(false);
                btnHidden2.setVisible(true);
            }
        });
        panel_8.add(btnHidden2);
        btnHidden.setVisible(false);

        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel_2.setVisible(false);
                panel_3.setVisible(true);
            }
        });

        //"Confirm" Button
        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                searchForField.setText("");
                promoCodeField.setText("");
                if (rdbtnNewRadioButton_4.isSelected()) {
                    panel_2.setVisible(false);
                    panel_5.setVisible(true);
                    switchingPanels(panel_7, layeredPane_1);
                } else {
                    panel_2.setVisible(false);
                    panel_5.setVisible(true);
                    switchingPanels(panel_6, layeredPane_1);
                    Iterator<Product> itt = prod_right.iterator();
                    while (itt.hasNext()) {
                        Product temp = itt.next();
                        log.info("Sold Product\nBARCODE: " + temp.getBarcode() + "\nName: " + temp.getName() + "\nAmount: " + temp.getAmountMinus() + "\nTotal Price: " + temp.getPrice() * temp.getAmountMinus());
                        Database.changeAmount(String.valueOf(temp.getBarcode()), temp.getAmount() - temp.getAmountMinus());
                    }
                    prod_right.clear();
                    btnHidden.setVisible(false);
                    amountList.clear();
                    produkty.clear();
                    produkty = Database.selectInOrder("Products", "Name");
                }
                total=0;
            }
        });

        //"Order" button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!prod_right.isEmpty()) {
                    panel_3.setVisible(false);
                    panel_2.setVisible(true);
                    finalCart(panel_4, prod_right, amountList);
                } else {
                    lblNewLabel.setVisible(true);
                    log.info("The Cart is empty! Please pick at least 1 product to proceed");
                }
            }
        });

        //"Confirm & Pay" Button
        btnConfirmPay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = nameDelivery.getText();
                String surname = surnameDelivery.getText();
                String addr = addressDelivery.getText();
                String zip = zipDelivery.getText();
                String city = cityDelivery.getText();
                if (name.equals("") || surname.equals("") || addr.equals("") || zip.equals("") || city.equals("")) {
                    lblNewLabel_3.setVisible(true);
                }
                else {
                    lblNewLabel_3.setVisible(false);
                    if (rdbtnIHaveRead.isSelected() == false) {
                        lblNewLabel_4.setVisible(true);
                    }
                    else {
                        nameDelivery.setText("");
                        surnameDelivery.setText("");
                        addressDelivery.setText("");
                        zipDelivery.setText("");
                        cityDelivery.setText("");
                        lblNewLabel_4.setVisible(false);
                        if (nowRButton.isSelected()) {
                            switchingPanels(panel_8, layeredPane_1);
                            btnHidden2.setVisible(false);
                            String insert = "'" + name + "', '" + surname +"', '"+ addr + "', '" + zip + "', '" + city +"', 'Already paid'";
                            Database.addToDatabase("orders",insert);
                            Iterator itt = prod_right.iterator();
                            while (itt.hasNext()) {
                                Product temp = (Product) itt.next();
                                log.info("Sold Product\nBARCODE: " + temp.getBarcode() + "\nName: " + temp.getName() + "\nAmount: " + temp.getAmountMinus() + "\nTotal Price: " + temp.getPrice() * temp.getAmountMinus());
                                Database.changeAmount(String.valueOf(temp.getBarcode()), temp.getAmount() - temp.getAmountMinus());
                            }
                        } else {
                            if (cashRButton.isSelected()) {
                                switchingPanels(panel_6, layeredPane_1);
                                btnHidden.setVisible(false);
                                String insert = "'" + name + "', '" + surname +"', '"+ addr + "', '" + zip + "', '" + city +"', 'Not paid, will pay with card'";
                                Database.addToDatabase("orders",insert);
                                Iterator itt = prod_right.iterator();
                                while (itt.hasNext()) {
                                    Product temp = (Product) itt.next();
                                    log.info("Sold Product\nBARCODE: " + temp.getBarcode() + "\nName: " + temp.getName() + "\nAmount: " + temp.getAmountMinus() + "\nTotal Price: " + temp.getPrice() * temp.getAmountMinus());
                                    Database.changeAmount(String.valueOf(temp.getBarcode()), temp.getAmount() - temp.getAmountMinus());
                                }
                            } else {
                                switchingPanels(panel_8, layeredPane_1);
                                btnHidden2.setVisible(false);
                                String insert = "'" + name + "', '" + surname +"', '"+ addr + "', '" + zip + "', '" + city +"', 'Not paid, will pay with cash'";
                                Database.addToDatabase("orders",insert);
                                Iterator itt = prod_right.iterator();
                                while (itt.hasNext()) {
                                    Product temp = (Product) itt.next();
                                    log.info("Sold Product\nBARCODE: " + temp.getBarcode() + "\nName: " + temp.getName() + "\nAmount: " + temp.getAmountMinus() + "\nTotal Price: " + temp.getPrice() * temp.getAmountMinus());
                                    Database.changeAmount(String.valueOf(temp.getBarcode()), temp.getAmount() - temp.getAmountMinus());
                                }
                            }
                        }
                    }
                }
                prod_right.clear();
                amountList.clear();
                produkty.clear();
                produkty = Database.selectInOrder("Products", "Name");
            }
        });

        frame.setVisible(true);
    }

    protected void switchingPanels(JPanel panel, JLayeredPane lpanel) {
        lpanel.removeAll();
        lpanel.add(panel);
        lpanel.repaint();
        lpanel.revalidate();
    }

    public void showProducts(LinkedList products, JPanel panel) {
        panel.removeAll();
        Iterator iter = products.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 40, 80);     //góra lewo dół prawo
        int count = 0;
        // Add labels which are describing table
        //zakomentowane bo cos "design" okno ma wonty, a kod przeciez dobry
        gbc.gridx = 0;
        gbc.gridy = count;
        panel.add(new JLabel("No."), gbc);
        gbc.gridx = 1;
        gbc.gridy = count;
        panel.add(new JLabel("Name"), gbc);
        gbc.gridx = 2;
        gbc.gridy = count;
        panel.add(new JLabel("Category"), gbc);
        gbc.gridx = 3;
        gbc.gridy = count;
        panel.add(new JLabel("Price:"), gbc);
        count++;

        gbc.insets = new Insets(1, 10, 10, 80);      //góra lewo dół prawo
        while (iter.hasNext()) {
            Product product_temp = (Product) iter.next();
            String barcode = String.valueOf(product_temp.getBarcode());
            String name = product_temp.getName();
            float price = product_temp.getPrice();
            String cat = product_temp.getCategory();
            gbc.gridx = 0;
            gbc.gridy = count;
            panel.add(new JLabel(String.valueOf(count)), gbc);
            gbc.gridx = 1;
            gbc.gridy = count;
            panel.add(new JLabel(name), gbc);
            gbc.gridx = 2;
            gbc.gridy = count;
            panel.add(new JLabel(cat), gbc);
            gbc.gridx = 3;
            gbc.gridy = count;
            panel.add(new JLabel(String.valueOf(price)), gbc);
            gbc.gridx = 4;
            gbc.gridy = count;
            JButton plus = new JButton("+");
            panel.add(plus, gbc);
            plus.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (doesItAlreadyExist(prod_right, product_temp, true) == 1) {
                        showCart(panel_1, prod_right, amountList);
                    } else {
                        prod_right.add(product_temp);
                        amountList.add((float) 1);
                        product_temp.setAmountMinus(1);
                        showCart(panel_1, prod_right, amountList);
                    }
                }
            });
            gbc.gridx = 5;
            gbc.gridy = count;
            JButton minus = new JButton("-");
            panel.add(minus, gbc);
            minus.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (doesItAlreadyExist(prod_right, product_temp, false) == 1) {
                        showCart(panel_1, prod_right, amountList);
                    }
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

    public void showCart(JPanel panel, LinkedList products, LinkedList amountList) {
        panel.removeAll();
        Iterator iter = products.iterator();
        GridBagConstraints gbc1 = new GridBagConstraints();
        int count = 0;

        gbc1.insets = new Insets(1, 1, 10, 30);      //góra lewo dół prawo
        while (iter.hasNext()) {
            Product product_temp = (Product) iter.next();
            String name = product_temp.getName();
            float price = product_temp.getPrice();
            float amount = (float) amountList.get(count);
            gbc1.gridx = 1;
            gbc1.gridy = count;
            panel.add(new JLabel(name), gbc1);
            gbc1.gridx = 2;
            gbc1.gridy = count;
            panel.add(new JLabel(String.valueOf(price)), gbc1);
            gbc1.gridx = 3;
            gbc1.gridy = count;
            panel.add(new JLabel(String.valueOf(amount) + "x"), gbc1);
            gbc1.gridx = 4;
            gbc1.gridy = count;
            JButton plus = new JButton("+");
            panel.add(plus, gbc1);
            plus.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (doesItAlreadyExist(prod_right, product_temp, true) == 1) {
                        showCart(panel_1, prod_right, amountList);
                    }
                }
            });
            gbc1.gridx = 5;
            gbc1.gridy = count;
            JButton minus = new JButton("-");
            panel.add(minus, gbc1);
            minus.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (doesItAlreadyExist(prod_right, product_temp, false) == 1) {
                        showCart(panel_1, prod_right, amountList);
                    } else {
                        prod_right.add(product_temp);
                        amountList.add((float) 1);
                        product_temp.setAmountMinus(1);
                        showCart(panel_1, prod_right, amountList);
                    }
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

    public void finalCart(JPanel panel_1, LinkedList products, LinkedList amountList) {
        // Clear panel
        panel_1.removeAll();
        Iterator iter = products.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 30, 80);
        int count = 0;


        gbc.gridx = 0;
        gbc.gridy = count;
        panel_1.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = count;
        panel_1.add(new JLabel("Price per 1:"), gbc);
        gbc.gridx = 2;
        gbc.gridy = count;
        panel_1.add(new JLabel("Amount:"), gbc);
        gbc.gridx = 3;
        gbc.gridy = count;
        panel_1.add(new JLabel("Price for chosen amount:"), gbc);
        count++;

        gbc.insets = new Insets(1, 20, 10, 80);      //góra lewo dół prawo
        while (iter.hasNext()) {
            Product product_temp = (Product) iter.next();
            String barcode = String.valueOf(product_temp.getBarcode());
            String name = product_temp.getName();
            float price = product_temp.getPrice();
            float amount = (float) amountList.get(count - 1);
            gbc.gridx = 0;
            gbc.gridy = count;
            panel_1.add(new JLabel(name), gbc);
            gbc.gridx = 1;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(price)), gbc);
            gbc.gridx = 2;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(amount)), gbc);
            gbc.gridx = 3;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(price * amount)), gbc);
            count++;
            total += (price * amount);
            log.info("Dodano: \n" + "Name: " + name + " How many: " + amount + " total cost: " + (price * amount));
        }

        totalField.setText(String.valueOf(total));

        // Align components top-to-bottom
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = count;
        c.weighty = 1;
        panel_1.add(new JLabel(), c);
        panel_1.updateUI();
    }

    public int doesItAlreadyExist(LinkedList list, Product product, boolean action) {
        Iterator iter = list.iterator();
        int count = 0;
        if (action) {
            while (iter.hasNext()) {
                Product product_temp = (Product) iter.next();
                if (product_temp.getBarcode() == product.getBarcode()) {
                    float temp = amountList.get(count);
                    temp++;
                    amountList.set(count, temp);
                    product_temp.setAmountMinus(temp);
                    return 1;
                } else {
                    count++;
                }
            }
            return 0;
        } else {
            while (iter.hasNext()) {
                Product product_temp = (Product) iter.next();
                if (product_temp.getBarcode() == product.getBarcode()) {
                    float temp = amountList.get(count);
                    if (temp == 1) {
                        list.remove(product_temp);
                        amountList.remove(count);
                        product_temp.setAmountMinus(temp);
                    } else {
                        temp--;
                        amountList.set(count, temp);
                        product_temp.setAmountMinus(temp);
                    }
                    return 1;
                } else {
                    count++;
                }
            }
            return 0;
        }
    }
}




