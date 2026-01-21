public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    public Trainee(String id, String name, String gender, byte age) {
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("male") &&
                !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be male or female");
        }
        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age < 6) {
            throw new IllegalArgumentException("Age must be >= 6");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Name=" + name +
                ", Gender=" + gender + ", Age=" + age;
    }
}
