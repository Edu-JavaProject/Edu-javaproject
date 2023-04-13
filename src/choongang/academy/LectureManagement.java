package choongang.academy;

import java.util.Objects;

public class LectureManagement {
    private String lectureName;  // 강의명
    private String teacherName;  // 강사명
    private int lectureDate;    // 수강기간
    private int lectureFee;   // 수강료
    private int countStudent;   // 수강인원

    public LectureManagement() {
    }

    public LectureManagement(String lectureName, String teacherName,
                             int lectureDate, int lectureFee, int countStudent) {
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.lectureDate = lectureDate;
        this.lectureFee = lectureFee;
        this.countStudent = countStudent;
    }
    public LectureManagement(String lectureName, String teacherName,
                             int lectureDate, int lectureFee) {
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.lectureDate = lectureDate;
        this.lectureFee = lectureFee;
    }


    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(int lectureDate) {
        this.lectureDate = lectureDate;
    }

    public int getLectureMoney() {
        return lectureFee;
    }

    public void setLectureMoney(int lectureMoney) {
        this.lectureFee = lectureMoney;
    }

    public int getCountStudent() {
        return countStudent;
    }

    public void setCountStudent(int countStudent) {
        this.countStudent = countStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureManagement that = (LectureManagement) o;
        return lectureDate == that.lectureDate && lectureFee == that.lectureFee && countStudent == that.countStudent && Objects.equals(lectureName, that.lectureName) && Objects.equals(teacherName, that.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureName, teacherName, lectureDate, lectureFee, countStudent);
    }

    @Override
    public String toString() {
        return "· 강의현황 [ " +
                "강의명='" + lectureName + '\'' +
                ", 강사명='" + teacherName + '\'' +
                ", 개강일=" + lectureDate +
                ", 수강료=" + lectureFee + "원" +
                ", 수강정원=" + countStudent + "명" +
                " ]";
    }

    public String lecInform() {
        return String.format("# %s | %s | %d | %d원 | %d명 "
                , this.lectureName, this.teacherName, this.lectureDate
                , this.lectureFee, this.countStudent
        );
    }
}

