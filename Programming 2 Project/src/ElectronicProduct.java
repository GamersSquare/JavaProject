public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(int id, String name, float price, String brand, int warrantyPeriod){
        super(id, name, price);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }
}
