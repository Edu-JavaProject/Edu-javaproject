package choongang.student;

import choongang.academy.LectureManagement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static choongang.student.Gender.*;

// 학생 객체
public class Student {

    private String studentId;
    private String password;
    private String name; // 학생 이름
    private String email; // 이메일
    private String age; // 나이
    Gender gender; // 성별
    private int money; // 보유중인 돈

    // 강의 관련 내용 미사용 - 4.11.
    List<LectureManagement> requestClass; // 강의 신청 목록
    List<LectureManagement> acceptClass; // 수락 된 강의 목록
    // 강의 신청 -> 학원쪽에서 수락
    // 수강료 납부 여부 -> 납부 완료 or 납부 하십시오


    public Student() {
    }

    public Student(String studentId, String password, String name, String email, String age, Gender gender, int money) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.requestClass = new ArrayList<>();
        this.acceptClass = new ArrayList<>();
    }

    public Student(String studentId, String password, String name, String email, String age, Gender gender, int money, List<LectureManagement> requestClass) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.requestClass = requestClass;
//        this.acceptClass = acceptClass;
    }
    @Override
    public String toString() {
        return "[" +
                "ID: '" + studentId + '\'' +
                ", password: '" + password + '\'' +
                ", 이름: '" + name + '\'' +
                ", 이메일: '" + email + '\'' +
                ", 나이: '" + age + '\'' +
                ", 성별 " + gender +
                ", 머니: " + money +
                ']';
    }

    public void myLectures() {
        // String을 리턴해서 다 붙여? 말어?
        System.out.println("#" + name + "님의 수강목록");
        List<LectureManagement> LectureList = getRequestClass();
        for (LectureManagement l : LectureList) {
            System.out.println("- 강의명: " +l.getLectureName() + " - 강사명: " + l.getTeacherName());
        }
    }

    public String myInfo() {
        DecimalFormat df = new DecimalFormat("##,###");

        return "\n# 아이디: " + studentId + "\n# 이름: " + name + "\n# 이메일: " + email
                + "\n# 나이: " + age + "\n# 성별: " + (gender == MALE ? "남" : "여") + "\n# 잔액: " + df.format(money) +"원";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, email);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<LectureManagement> getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(List<LectureManagement> requestClass) {
        this.requestClass = requestClass;
    }

    public List<LectureManagement> getAcceptClass() {
        return acceptClass;
    }

    public void setAcceptClass(List<LectureManagement> acceptClass) {
        this.acceptClass = acceptClass;
    }
}
