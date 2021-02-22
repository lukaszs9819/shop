package com.shop;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class CashierWindow {

    private JFrame frame;
    private JTextField loggedAsField;
    String name = LoginWindow.user;
    private JTextField barcodeField;
    private JTextField TotalField;
    private JTextField toPayField;
    private JTextField paidField;
    private JTextField changeField;
    private JTextField amountField;
    static JPanel panel_1;
    LinkedList<Product> produkty = new LinkedList();
    private static final Logger log = Logger.getLogger(CashierWindow.class);



    int index=1;               //counter for clicking "Add" button, used in showProduct() method

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CashierWindow window = new CashierWindow();
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
    public CashierWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1002, 577);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Logged as:");
        lblNewLabel.setBounds(701, 25, 94, 16);
        frame.getContentPane().add(lblNewLabel);

        loggedAsField = new JTextField();
        loggedAsField.setText(name);
        loggedAsField.setEditable(false);
        loggedAsField.setBounds(807, 22, 151, 22);
        frame.getContentPane().add(loggedAsField);
        loggedAsField.setColumns(10);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(12, 65, 946, 452);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 946, 452);
        layeredPane.add(panel);
        panel.setLayout(null);

        barcodeField = new JTextField();
        barcodeField.setColumns(10);
        barcodeField.setBounds(702, 94, 201, 22);
        panel.add(barcodeField);

        JButton button = new JButton("Payment");

        button.setBounds(702, 313, 201, 37);
        panel.add(button);

        JLabel label = new JLabel("Enter BARCODE");
        label.setBounds(764, 65, 97, 16);
        panel.add(label);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(6, 54, 662, 329);
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout());

        panel_1 = new JPanel();
        panel_1.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel_1,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        panel_3.add(scrollPane);

        JLabel lblNewLabel_1 = new JLabel("Total:");
        lblNewLabel_1.setBounds(326, 405, 56, 16);
        panel.add(lblNewLabel_1);

        TotalField = new JTextField("0");
        TotalField.setEditable(false);
        TotalField.setBounds(453, 402, 116, 22);
        panel.add(TotalField);
        TotalField.setColumns(10);

        JButton button_1 = new JButton("Add");
        button_1.setBounds(753, 200, 97, 25);
        panel.add(button_1);


        JButton btnNewButton_1 = new JButton("Log out");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(1);
            }
        });
        btnNewButton_1.setBounds(826, 414, 97, 25);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("How many?");
        lblNewLabel_6.setBounds(775, 129, 86, 16);
        panel.add(lblNewLabel_6);

        amountField = new JTextField();
        amountField.setText("1");
        amountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                char c = arg0.getKeyChar();
                if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==46 || c==KeyEvent.VK_DELETE)) {
                    frame.getToolkit().beep();
                    arg0.consume();														//usuwa wszystko co nie jest wymienione w arg
                    log.warn("You can pass only numbers, backspace or dot!");
                }
            }
        });
        amountField.setBounds(702, 165, 201, 22);
        panel.add(amountField);
        amountField.setColumns(10);

        JLabel nameLabel1 = new JLabel("Name of Product");
        nameLabel1.setBounds(46, 25, 116, 16);
        panel.add(nameLabel1);

        JLabel amountLabel1 = new JLabel("Amount");
        amountLabel1.setBounds(210, 25, 56, 16);
        panel.add(amountLabel1);

        JLabel priceperoneLabel = new JLabel("Price per one:");
        priceperoneLabel.setBounds(326, 25, 91, 16);
        panel.add(priceperoneLabel);

        JLabel priceInSummaryLabel = new JLabel("Price:");
        priceInSummaryLabel.setBounds(474, 25, 56, 16);
        panel.add(priceInSummaryLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 946, 452);
        layeredPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Payment with a:");
        lblNewLabel_2.setBounds(304, 60, 127, 16);
        panel_2.add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash");
        rdbtnNewRadioButton.setSelected(true);
        rdbtnNewRadioButton.setBounds(484, 56, 127, 25);
        panel_2.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Credit Card");
        rdbtnNewRadioButton_1.setBounds(484, 85, 127, 25);
        panel_2.add(rdbtnNewRadioButton_1);

        ButtonGroup g =    new ButtonGroup();
        g.add(rdbtnNewRadioButton);
        g.add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_3 = new JLabel("To pay: ");
        lblNewLabel_3.setBounds(304, 155, 113, 16);
        panel_2.add(lblNewLabel_3);

        toPayField = new JTextField("0");
        toPayField.setEditable(false);
        toPayField.setBounds(484, 152, 116, 22);
        panel_2.add(toPayField);
        toPayField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Paid: ");
        lblNewLabel_4.setBounds(304, 204, 56, 16);
        panel_2.add(lblNewLabel_4);

        paidField = new JTextField("0");
        paidField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                char c = arg0.getKeyChar();
                if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==46 || c==KeyEvent.VK_DELETE)) {
                    frame.getToolkit().beep();
                    arg0.consume();														//usuwa wszystko co nie jest wymienione w arg
                    log.warn("You can pass only numbers, backspace or dot!");
                }
            }
        });
        paidField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                String paid = paidField.getText();
                if (paid.isEmpty()) {
                    changeField.setText(String.valueOf(0));
                }
                else {
                    float chnge = Float.valueOf(paid) - Float.valueOf(toPayField.getText());		//TODO: try catch!
                    changeField.setText(String.valueOf(chnge));
                }
            }
        });
        paidField.setBounds(484, 201, 116, 22);
        panel_2.add(paidField);
        paidField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Change:");
        lblNewLabel_5.setBounds(304, 265, 78, 16);
        panel_2.add(lblNewLabel_5);

        changeField = new JTextField("0");
        changeField.setEditable(false);
        changeField.setBounds(484, 262, 116, 22);
        panel_2.add(changeField);
        changeField.setColumns(10);

        JButton btnNewButton = new JButton("Transaction completed!");
        btnNewButton.setBounds(360, 350, 202, 25);
        panel_2.add(btnNewButton);

        JLabel lblNewLabel_7 = new JLabel("Paid value is not enough!");
        lblNewLabel_7.setForeground(Color.RED);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(304, 321, 296, 16);
        panel_2.add(lblNewLabel_7);
        lblNewLabel_7.setVisible(false);

        // "Payment" button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                panel_2.setVisible(true);
                panel.setVisible(false);
                toPayField.setText(TotalField.getText());
            }
        });

        // "Transaction Completed" button
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String chng = changeField.getText();
                float chng1 = Float.valueOf(chng);			//TODO: try catch
                if (chng1>=0) {
                    lblNewLabel_7.setVisible(false);
                    TotalField.setText("0");
                    barcodeField.setText("");
                    amountField.setText("");
                    paidField.setText("");
                    Iterator<Product> iter = produkty.iterator();
                    while (iter.hasNext()){
                        Product temp = iter.next();
                        Database.changeAmount(String.valueOf(temp.getBarcode()) ,temp.getAmount()-temp.getAmountMinus());
                        log.info("Sold Product\nBARCODE: " + temp.getBarcode() + "\nName: " + temp.getName() + "\nAmount: " + temp.getAmountMinus() + "\nTotal Price: " + temp.getPrice()*temp.getAmountMinus());
                    }
                    produkty.clear();
                    showProducts(1, produkty);

                    panel.setVisible(true);
                    panel_2.setVisible(false);
                }
                else {
                    lblNewLabel_7.setVisible(true);
                }
            }
        });

        //"Add" button
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String barcode = barcodeField.getText();
                String amount = amountField.getText();
                float amount1 = Float.valueOf(amount);//TODO: try catch
                Product product = Database.selectForSale(barcode, amount1);
                product.setAmountMinus(amount1);
                produkty.add(product);
                showProducts(index, produkty);
                index++;
            }
        });
        frame.setVisible(true);

    }

    public void showProducts(int indexer, LinkedList products)
    {
        // Clear panel
        panel_1.removeAll();
        Iterator iter = products.iterator();
        GridBagConstraints gbc = new GridBagConstraints();
        int count=0;
        float total = 0;
        gbc.insets = new Insets(1,20,10,80);		//góra lewo dół prawo
        while(iter.hasNext())
        {
            Product product_temp = (Product) iter.next();
            String barcode = String.valueOf(product_temp.getBarcode());
            String name = product_temp.getName();
            float price = product_temp.getPrice();
            gbc.gridx = 0;
            gbc.gridy = count;
            panel_1.add(new JLabel(name), gbc);
            gbc.gridx = 1;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(product_temp.getAmountMinus())), gbc);
            gbc.gridx = 2;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(price)), gbc);
            gbc.gridx = 3;
            gbc.gridy = count;
            panel_1.add(new JLabel(String.valueOf(price*product_temp.getAmountMinus())), gbc);
            count++;
            total += (price*product_temp.getAmountMinus());
        }

        TotalField.setText(String.valueOf(total));

        // Align components top-to-bottom
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = count;
        c.weighty = 1;
        panel_1.add(new JLabel(), c);
        panel_1.updateUI();
    }

}




