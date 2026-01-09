import java.util.Scanner;

public class TrainingManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees = new Trainee[100];
    private byte count;

    public TrainingManagement(){
        scanner = new Scanner(System.in);
        traineeForm = new TraineeForm(scanner);
    }

    private boolean isDuplicateId(String id){
        for (int i  = 0; i < count; i++){
            if (listOfTrainees[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addTrainee(){
        Trainee t;
        do {
            t = traineeForm.getTrainee();
            if (isDuplicateId(t.getId())) {
                System.out.println("ID already exists.");
            }
        } while (isDuplicateId(t.getId()));

        listOfTrainees[count++] = t;
        System.out.println();
    }

    public void displayAllTrainees(){
        if (count == 0) {
            System.out.println("NO TRAINEES");
            return;
        }

        for (int i = 0; i < count; i++){
            System.out.println(listOfTrainees[i]);
        }
        System.out.println();
    }

    public void findTraineeById(){
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        for (int i = 0;i < count;i++){
            if (listOfTrainees[i].getId().equals(id)) {
                Trainee t = listOfTrainees[i];
                System.out.println(
                        "ID: " + t.getId() +
                                ", Name: " + t.getName() +
                                ", Age: " + t.getAge() +
                                ", Gender: " + t.getGender()
                );
            }
            System.out.println("Trainee not found!");
        }
    }

    public void updateTrainee(){
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equals(id)) {
                Trainee t = listOfTrainees[i];

                System.out.print("Enter new name: ");
                t.setName(scanner.nextLine());

                do {
                    System.out.print("Enter new age: ");
                    t.setAge(Byte.parseByte(scanner.nextLine()));
                } while (t.getAge() < 18);

                System.out.print("Enter new gender(male/female): ");
                t.setGender(scanner.nextLine());

                System.out.println();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        TrainingManagement tm = new TrainingManagement();
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
                    tm.addTrainee();
                    break;
                case "2":
                    tm.displayAllTrainees();
                    break;
                case "3":
                    tm.findTraineeById();
                    break;
                case "4":
                    tm.updateTrainee();
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
