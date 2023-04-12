package choongang.academy;

import java.util.List;

public class AcademyRepository {
    private static StudentManagement[] studentList;
    private static LectureManagement[] lectureList;

    static {
        List<StudentManagement> studentList = List.of(new StudentManagement[]{
                new searchStuList("JAVA 입문", "홍길동",
                        20230403, 210810, 20),
                new searchStuList("C언어 입문", "고길동",
                        20230408, 320000, 30),
                new searchStuList("인공지능 이해, 챗봇만들기", "김길동",
                        20230415, 600000, 25),
                new searchStuList("드론 프로그래밍", "최길동",
                        20230429, 390000, 28)
        });

        List<LectureManagement> lectureList = List.of(new LectureManagement[]{
                new searchLecList("JAVA 입문", "홍길동",
                        20230403, 210810, 20),
                new searchLecList("C언어 입문", "고길동",
                        20230408, 320000, 30),
                new searchLecList("인공지능 이해, 챗봇만들기", "김길동",
                        20230415, 600000, 25),
                new searchLecList("드론 프로그래밍", "최길동",
                        20230429, 390000, 28)
        });
    }

    // 학생조회

    public void showStudents() {
        System.out.printf("======= 현재 학생정보 (총 %d명) ========"
                , studentList.length);
        for (LectureManagement lectureManagement : lectureList) {

        }

    }
    // 강의 조회
    public String[] getLectureList() {
        String[] lecList = new String[lectureList.length];
        return lecList;
    }
    // 새 강의 개설

}
