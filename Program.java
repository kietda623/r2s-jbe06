import java.util.Scanner;

public class Program {

    Student[] students = new Student[100];
    int count = 0;
    Scanner scanner = new Scanner(System.in);

    boolean isDuplicateId(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    static void addStudent() {
        if (count >= students.length) {
            System.out.println("Full");
            return;
        }

        Student student = new Student();

        // id
        do {
            System.out.print("Enter id: ");
            student.id = scanner.nextLine();
        } while (isDuplicateId(student.id));

        // name
        do {
            System.out.print("Enter name: ");
            student.name = scanner.nextLine();

            if (student.name.isEmpty()) {
                System.out.println("Name cannot be empty!");
            }
        } while (student.name.isEmpty());

        // age
        do {
            System.out.print("Enter age (>=18): ");
            student.age = Integer.parseInt(scanner.nextLine());
        } while (student.age < 18);

        // address
        System.out.print("Enter address: ");
        student.address = scanner.nextLine();

        // gender
        do {
            System.out.print("Enter gender(male/female): ");
            student.gender = scanner.nextLine();
        } while (!student.gender.equals("male") && !student.gender.equals("female"));

        System.out.print("Enter email: ");
        student.email = scanner.nextLine();

        students[count++] = student;
    }

    void displayAll() {
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println(
                    "ID: " + s.id +
                            ", Name: " + s.name +
                            ", Age: " + s.age +
                            ", Address: " + s.address +
                            ", Gender: " + s.gender +
                            ", Email: " + s.email
            );
        }
    }

    void findById() {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                Student s = students[i];
                System.out.println(
                        "ID: " + s.id +
                                ", Name: " + s.name +
                                ", Age: " + s.age +
                                ", Address: " + s.address +
                                ", Gender: " + s.gender +
                                ", Email: " + s.email
                );
                return;
            }
        }
        System.out.println("Student not found!");
    }

    void updateInfo() {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                Student s = students[i];

                System.out.print("Enter new name: ");
                s.name = scanner.nextLine();

                do {
                    System.out.print("Enter new age (>=18): ");
                    s.age = Integer.parseInt(scanner.nextLine());
                } while (s.age < 18);

                System.out.print("Enter new address: ");
                s.address = scanner.nextLine();

                System.out.print("Enter new gender: ");
                s.gender = scanner.nextLine();

                System.out.print("Enter new email: ");
                s.email = scanner.nextLine();

                System.out.println("Update successful!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        String choice;
        Scanner scanner = new Scanner(System.in);
        do {
                System.out.println("1. Add");
                System.out.println("2. Display");
                System.out.println("3. Find by id");
                System.out.println("4. Update");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                choice = scanner.nextLine();
        } while(!choice.equals("0"));

        switch (choice) {
            case "1":
                addStudent();
                break;
        }
    }
}
