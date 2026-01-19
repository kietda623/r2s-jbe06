package Session06;
import java.util.ArrayList;
import java.util.Arrays;

public final class Validator {
    public Validator() {}

    public static boolean validateCode(String code) {
         return code != null && code.matches(Constants.COURSE_CODE_REGEX);
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        return courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
    }

    public static boolean validateStatus(boolean status) {
        return true;
    }

    public static boolean validateFlag(String flag) {
        if (flag == null) {
            return false;
        }
        String normalizeFlag = flag.trim();
        return Arrays.stream(Constants.ALLOWED_FLAGS)
                .anyMatch(a->a.equalsIgnoreCase(normalizeFlag));
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}
