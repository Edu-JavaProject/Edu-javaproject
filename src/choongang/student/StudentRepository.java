package choongang.student;

import choongang.academy.AcademyRepository;
import choongang.academy.LectureManagement;

import java.util.*;
import java.util.stream.Collectors;

import static choongang.student.Gender.*;
import static java.util.stream.Collectors.*;

// 학생 들 저장소
// 회원가입, 마이페이지, 정보 수정
public class StudentRepository {

    //    private static Map<String, Student> studentList; // 학생 목록
    private static List<Student> studentList;
    private static AcademyRepository ar;

    static {
        ar = new AcademyRepository();

        studentList = new ArrayList<>(
                List.of(
                        // 관리자 계정
                        new Student("admin", "admin", "관리자", "admin@gmail.com", "00", MALE, 0),

                        // 일반 회원
                        new Student("hong", "1234", "홍길동", "abc@gmail.com", "22", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(5), ar.getLec().get(7), ar.getLec().get(4)))),
                        new Student("superman", "1234", "슈퍼맨", "super@gmail.com", "44", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(1), ar.getLec().get(2), ar.getLec().get(3)))),
                        new Student("origin", "1234", "원본", "onebon@gmail.com", "33", FEMALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(8), ar.getLec().get(9), ar.getLec().get(7)))),
                        new Student("parking", "1234", "주차왕", "park@gmail.com", "20", FEMALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(10), ar.getLec().get(5), ar.getLec().get(7), ar.getLec().get(8)))),
                        new Student("kimssi", "1234", "김씨", "kim@gmail.com", "44", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(5), ar.getLec().get(10), ar.getLec().get(9)))),
                        new Student("hong", "1234", "홍길동", "abc@gmail.com", "22", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(5), ar.getLec().get(7), ar.getLec().get(4)))),
                        new Student("daly", "1111", "달리", "bbc@bbc.com", "23", FEMALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(3), ar.getLec().get(5), ar.getLec().get(10)))),
                        new Student("jane_lee", "abc123", "제인", "jane@gmail.com", "30", FEMALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(0), ar.getLec().get(5), ar.getLec().get(9)))),
                        new Student("mike", "godmike", "마이크", "mikegod@gmail.com", "27", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(1), ar.getLec().get(2), ar.getLec().get(10)))),
                        new Student("enom33", "class", "이놈", "nom3@gmail.com", "25", MALE, 1000000,
                                new ArrayList<>(List.of(ar.getLec().get(1) )))
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

    public static List<Student> getStudentList() {
        return studentList;
    }
}
