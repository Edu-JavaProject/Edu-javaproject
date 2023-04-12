package choongang.academy;

public class StudentManagement {
    private String name;
    private int phone;
    private int age;
    private String email;
    private String major;

    public StudentManagement() {
    }

    public StudentManagement(
            String name, int phone, int age, String email, String major) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
