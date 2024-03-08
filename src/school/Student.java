package school;

public class Student extends Person {
    protected String major;


    public Student(int id, String name, String email, String major) {
        super(id, name, email);
        this.major = major;
    }

    @Override
    public String toString() {
        return "STUDENT: " + name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
