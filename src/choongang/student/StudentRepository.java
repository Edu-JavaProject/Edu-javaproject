package choongang.student;

import choongang.academy.LectureManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

// 학생 들 저장소
// 회원가입, 마이페이지, 정보 수정
public class StudentRepository {

    //    private static Map<String, Student> studentList; // 학생 목록
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>(
                List.of(
                        new Student("hong", "1234", "홍길동", "abc@aaa.com", "25", Gender.MALE, 100000),
                        new Student("dooly", "1234", "둘리", "abc@aaa.com", "25", Gender.FEMALE, 1000000)
                )
        );
    }

    /**
     * @param id : 입력받은 id
     * @return : id에 해당하는 student 객체 반환
     */
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) return student;
        }
        return null;
    }


    /**
     * 회원가입 기능
     */
    public boolean registerStudent(Student newStudent) {
        String studentId = newStudent.getStudentId();
        if (isDuplicateId(studentId)) return false;

        studentList.add(newStudent);
        return true;
    }

    /**
     * id, email 중복 확인 기능
     */
    public boolean isDuplicateId(String id) {
        return findStudentById(id) != null;
    }


    // 선택한 강의를 신청 강의 목록에 해주는 기능
    public void addLecture(String inputId, LectureManagement lecture) {
        Student studentById = findStudentById(inputId);
        studentById.requestClass.add(lecture);
    }
}
