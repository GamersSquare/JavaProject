import java.util.ArrayList;

public class Order {
    private int customerId;
    private int orderId;
    private ArrayList<Product> products;
    private float totalPrice;

    public Order(int customerId, int orderId, float totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = new ArrayList<>();
        this.totalPrice = Math.abs(totalPrice);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = Math.abs(orderId);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = Math.abs(totalPrice);
    }

    public void printOrderInfo(){
        System.out.println("Here's your order's summary: ");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products: ");
        for(Product p : products){
            System.out.println(p.getName() + " - $" + p.getPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }
}
