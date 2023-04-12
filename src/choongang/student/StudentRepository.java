package choongang.student;

import java.util.HashMap;
import java.util.Map;

// 학생 들 저장소
// 회원가입, 마이페이지, 정보 수정
public class StudentRepository {

    private static Map<String, Student> studentList; // 학생 목록

    static {
        studentList = new HashMap<>();
    }

    /**
     * @param id : 입력받은 id
     * @return : id에 해당하는 student 객체 반환
     */
    public Student findStudentById(String id) {
        return studentList.get(id);
    }


    /**
     * 회원가입 기능
     */
    public boolean registerStudent(Student newStudent) {
        String studentId = newStudent.getStudentId();
        if (isDuplicateId(studentId)) return false;

        studentList.put(studentId, newStudent);
        return true;
    }

    /**
     * id, email 중복 확인 기능
     */
    public boolean isDuplicateId(String id) {
        return findStudentById(id) != null;
    }

}
