import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner;

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getId() {
        System.out.print("Enter ID: ");
        return scanner.nextLine();
    }

    public Trainee getTrainee() {
        Trainee t = null;

        while (true) {
            try {
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter gender (male/female): ");
                String gender = scanner.nextLine();

                System.out.print("Enter age: ");
                byte age = Byte.parseByte(scanner.nextLine());

                t = new Trainee(id, name, gender, age);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please re-enter trainee information.\n");
            }
        }
        return t;
    }
}
