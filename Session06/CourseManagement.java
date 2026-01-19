package Session06;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.ArrayList;

public class CourseManagement {
    private final ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        new CourseManagement().run();
    }

    private void run() {
        while (true) {
            showMenu();
            int choice = ScannerUtil.readMenuChoice();
            switch (choice) {
                case Constants.MENU_CREATE -> createCourse();
                case Constants.MENU_SEARCH -> searchCourses();
                case Constants.MENU_DISPLAY_BY_FLAG -> displayByFlag();
                case Constants.MENU_QUIT -> {
                    System.out.println("Quit!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    private void showMenu() {
        System.out.println("====COURSE MANAGEMENT====");
        System.out.println("1. Create a course");
        System.out.println("2. Search courses by attribute");
        System.out.println("3. Display courses by flag");
        System.out.println("0. Quit");
    }

    private void createCourse() {
        String code = readValidCode();
        String name = ScannerUtil.readNonEmpty("Enter name: ");
        boolean status = ScannerUtil.readBoolean("Enter status: ");
        short duration = ScannerUtil.readPositiveShort("Enter duration(>0): ");
        String flag = readValidFlag();

        courses.add(new Course(code, name, status, duration, flag));
        System.out.println("Course created!");
    }

    private String readValidCode() {
        while (true) {
            String code = ScannerUtil.readNonEmpty("Enter course code (RAxxx): ")
                    .toLowerCase(Locale.ROOT);

            if (!Validator.validateCode(code)) {
                System.out.println("Code must start RAxxx");
                continue;
            }

            if (!Validator.isDuplicatedCode(code, courses)) {
                System.out.println("Code exists");
                continue;
            }

            return code;
        }
    }

    private String readValidFlag() {
        while (true) {
            String flag = ScannerUtil.readNonEmpty("Enter flag (optional/prerequisite/NA): ");

            if (Validator.validateFlag(flag))   return flag.equalsIgnoreCase("n/a") ? "N/A":flag.toLowerCase(Locale.ROOT);
            System.out.println("Invalid flag.");
        }
    }


}
