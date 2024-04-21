import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextArea text;

    public GUI(){
        JLabel label = new JLabel();
        label.setText("Enter Your CustomerID:");
        label.setForeground(Color.white);
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setBounds(10, 20, 250, 50);

        JLabel label2 = new JLabel();
        label2.setText("Enter Your Name:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("MV Boli", Font.BOLD, 20));
        label2.setBounds(10, 60, 200, 50);

        JLabel label3 = new JLabel();
        label3.setText("Enter Your Address:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.BOLD, 20));
        label3.setBounds(10, 100, 250, 50);

        JLabel label4 = new JLabel();
        label4.setText("Enter NProducts:");
        label4.setForeground(Color.white);
        label4.setFont(new Font("MV Boli", Font.BOLD, 20));
        label4.setBounds(10, 140, 300, 50);

        button = new JButton();
        button.setBounds(190, 380, 100, 40);
        button.setText("Submit");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.setForeground(Color.BLUE);

        textField = new JTextField();
        textField.setBounds(260, 30, 200, 30);
        textField.setFont(new Font("MV Boli", Font.BOLD, 20));

        textField2 = new JTextField();
        textField2.setBounds(260, 70, 200, 30);
        textField2.setFont(new Font("MV Boli", Font.BOLD, 20));

        textField3 = new JTextField();
        textField3.setBounds(260, 110, 200, 30);
        textField3.setFont(new Font("MV Boli", Font.BOLD, 20));

        textField4 = new JTextField();
        textField4.setBounds(260, 150, 200, 30);
        textField4.setFont(new Font("MV Boli", Font.BOLD, 20));

        this.setLocation(500, 200);
        this.setSize(500, 500);
        this.setTitle("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);

        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(textField);
        this.add(textField2);
        this.add(textField3);
        this.add(textField4);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            String id;
            String name;
            String price;
            this.dispose();
            JFrame newWindow = new JFrame();

            Customer customer = new Customer(Integer.parseInt(textField.getText()), textField2.getText(),
                    textField3.getText());

            Cart cart = new Cart(Integer.parseInt(textField.getText()), Integer.parseInt(textField4.getText()));

            for(int i = 0; i < Integer.parseInt(textField4.getText()); i++){
                name = JOptionPane.showInputDialog("Product Name (smartphone - T-shirt - OOP - else): ");
                if(name.equals("smartphone")){
                    ElectronicProduct electronicProduct = new ElectronicProduct(1, "smartphone", 599.9F,
                            "Samsung", 1);
                    cart.addProduct(electronicProduct);
                }else if(name.equals("T-shirt")){
                    ClothingProduct clothingProduct = new ClothingProduct(2, "T-shirt", 19.99F, "Medium",
                            "Cotton");
                    cart.addProduct(clothingProduct);
                }else if(name.equals("OOP")){
                    BookProduct bookProduct = new BookProduct(3, "OOP", 39.99F, "O’Reilly",
                            "X Publications");
                    cart.addProduct(bookProduct);
                }else{
                    name = JOptionPane.showInputDialog("Product Name: ");
                    id = JOptionPane.showInputDialog("Product ID: ");
                    price = JOptionPane.showInputDialog("Product Price: ");

                    Product p = new Product(Integer.parseInt(id), name, Float.parseFloat(price));
                    cart.addProduct(p);
                }

            }

            int answer = JOptionPane.showConfirmDialog(null,
                    "Do you want to place an order for the products in the cart? ", "Answer",
                    JOptionPane.YES_NO_OPTION);

            if(answer == 0){
                Order order = new Order(customer.getCustomerId(), 1, cart.calculatePrice());
                text = new JTextArea();
                text.setBounds(0, 0, 500, 500);
                text.setFont(new Font("MV Boli", Font.BOLD, 20));
                text.append("Here's your order's summary: \nOrder ID: "+order.getOrderId()+"\nCustomer ID: "
                        +order.getCustomerId()+"\nProducts:\n");
                for(Product p : cart.getProducts()){
                    text.append(p.getName()+" - $"+p.getPrice()+"\n");
                }
                text.append("Total Price: "+cart.calculatePrice());

                newWindow.add(text);
            }

            newWindow.setLocation(500, 200);
            newWindow.setSize(500, 500);
            newWindow.setTitle("Order");
            newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newWindow.setResizable(false);
            newWindow.setLayout(null);
            newWindow.getContentPane().setBackground(Color.BLACK);
            newWindow.setVisible(true);

        }
    }
}
