import java.util.Scanner;

public class Program {
    static Student[] students = new Student[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    static boolean isDuplicateId(String id) {
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
            Student st = new Student();

            // id
            do {
                System.out.print("Enter id: ");
                st.id = scanner.nextLine();
            } while (isDuplicateId(st.id));

            // name
            do {
                System.out.print("Enter name: ");
                st.name = scanner.nextLine();

                if (st.name.isEmpty()) {
                    System.out.println("Name cannot be empty!");
                }
            } while (st.name.isEmpty());

            // age
            do {
                System.out.print("Enter age: ");
                st.age = Integer.parseInt(scanner.nextLine());
            } while (st.age < 18);

            // address
            System.out.print("Enter address: ");
            st.address = scanner.nextLine();

            // gender
            do {
                System.out.print("Enter gender(male/female): ");
                st.gender = scanner.nextLine();
            } while (!st.gender.equals("male") && !st.gender.equals("female"));

            System.out.print("Enter email: ");
            st.email = scanner.nextLine();

            students[count++] = st;
    }
    static void displayAll() {
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println(
                    "ID: " + s.id + "\n" +
                            "Name: " + s.name + "\n" +
                            "Age: " + s.age + "\n" +
                            "Address: " + s.address + "\n" +
                            "Gender: " + s.gender + "\n" +
                            "Email: " + s.email
            );
        }
    }
    static void findById() {
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

    static void updateInfo() {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                Student s = students[i];

                System.out.print("Enter new name: ");
                s.name = scanner.nextLine();

                do {
                    System.out.print("Enter new age: ");
                    s.age = Integer.parseInt(scanner.nextLine());
                } while (s.age < 18);

                System.out.print("Enter new address: ");
                s.address = scanner.nextLine();

                System.out.print("Enter new gender(male/female): ");
                s.gender = scanner.nextLine();

                System.out.print("Enter new email: ");
                s.email = scanner.nextLine();

                System.out.println();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Find by id");
            System.out.println("4. Update");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    displayAll();
                    break;
                case "3":
                    findById();
                    break;
                case "4":
                    updateInfo();
                    break;
                case "0":
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!choice.equals("0"));

    }
}
