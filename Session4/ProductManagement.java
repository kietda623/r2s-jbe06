package Session4;

public class ProductManagement {
    private final Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) throws IllegalArgumentException{
        if (productCount >= products.length) {
            System.out.println("Product list is full");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Duplicate ID");
            }
        }
        products[productCount++] = product;
        System.out.println("Product added successfully!");
    }

    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                return products[i];
            }
        }
        throw new ProductNotFoundException("productID not found");
    }

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative!");
        }

        Product product = getProductByID(productID);
        product.setQuantityStock(newQuantity);
        System.out.println("Updated new quantity!");
    }
}
