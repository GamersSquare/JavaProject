import java.util.ArrayList;

public class Cart {
    private int customerId;
    private int nProducts;
    private ArrayList<Product> products;

    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setNProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public int getNProducts() {
        return nProducts;
    }

    public void addProduct(Product product) {
        if (products.size() < nProducts) {
            products.add(product);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Cart is full. Cannot add more products.");
        }
    }

    public void removeProduct(String productName) {
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                products.remove(p);
                System.out.println(productName + " removed from cart.");
                break;
            }
        }
        System.out.println(productName + " not found in cart.");
    }

    public float calculatePrice() {
        float total_price = 0;
        for (Product p : products) {
            total_price += p.getPrice();
        }
        return total_price;
    }

    public void placeOrder() {
        float total_price = calculatePrice();
        if (total_price > 0) {
            System.out.println("Order placed for customer " + customerId + " with total price: " + total_price);
        } else {
            System.out.println("Cart is empty. Cannot place order.");
        }
    }
}
