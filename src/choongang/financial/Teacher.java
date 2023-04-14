package choongang.financial;

import choongang.academy.LectureManagement;

public class Teacher {
    private String teacherName;


    public Teacher(LectureManagement lectureManagement) {

        this.teacherName = lectureManagement.getTeacherName();
    }
    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                '}';
    }
}
