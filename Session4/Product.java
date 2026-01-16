package Session4;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityStock;

    public Product(int productID, String name, double price, int quantityStock) {
        if (price < 0 || quantityStock < 0) {
            throw new IllegalArgumentException("Price and Quantity must be non-negative!");
        }
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative!");

        }        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        if (quantityStock < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        this.quantityStock = quantityStock;
    }

    public void displayProductInfo(){
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Quantity Stock: " + quantityStock);
    }
}
