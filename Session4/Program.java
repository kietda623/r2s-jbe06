package Session4;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement pm = new ProductManagement();

        while (true) {
            System.out.println("=== Product Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Display Product List");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Product ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Product Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        System.out.print("Quantity in Stock: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        Product product = new Product(id, name, price, quantity);
                        pm.addProduct(product);
                        break;

                    case 2:
                        System.out.print("Enter Product ID to retrieve: ");
                        int searchId = Integer.parseInt(sc.nextLine());

                        Product found = pm.getProductByID(searchId);
                        found.displayProductInfo();
                        break;

                    case 3:
                        System.out.print("Enter Product ID to update: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new quantity: ");
                        int newQuantity = Integer.parseInt(sc.nextLine());

                        pm.updateProductQuantity(updateId, newQuantity);
                        break;

                    case 4:
                        for (int i = 0; i <; i++)

                    case 5:
                        System.out.println("Exiting the program...");
                        return;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (ProductNotFoundException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
