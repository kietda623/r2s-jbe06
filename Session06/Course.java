package Session06;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", duration=" + duration +
                ", flag='" + flag + '\'' +
                '}';
    }

    public void input(ArrayList<Course> courses, Scanner sc) {
        System.out.print("Enter code: ");
        code = sc.nextLine();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter status: ");
        status = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Enter duration: ");
        duration = Short.parseShort(sc.nextLine());

        System.out.print("Enter flag: ");
        flag = sc.nextLine();
    }
}
