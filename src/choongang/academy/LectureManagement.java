package choongang.academy;

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
}
