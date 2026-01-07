import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        String name;
        int age;
        String address;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        do  {
            System.out.print("Enter your age: ");
            age = Integer.parseInt(scanner.nextLine());
        } while(age < 18);

        System.out.print("Enter your address: ");
        address = scanner.nextLine();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);

        scanner.close();
    }
}
