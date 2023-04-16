package choongang.academy;


import choongang.student.Student;
import choongang.student.StudentRepository;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import static choongang.utility.Util.input;

public class AcademyRepository {


    public static List<LectureManagement> lectureList;
    private static StudentRepository sr;
    private static Student st;
    private static AcademyView av;


    static {
        lectureList = new ArrayList<>(
                List.of(
                        new searchLecList("JAVA 입문", "김기범",
                                20230403, 210810, 0),
                        new searchLecList("C언어 입문", "전현무",
                                20230408, 320000, 0),
                        new searchLecList("Android APP", "장보고",
                                20230408, 320000, 0),
                        new searchLecList("인공지능 이해, 챗봇만들기", "박나래",
                                20230415, 600000, 0),
                        new searchLecList("CUDA GPU 프로그래밍", "최화사",
                                20230415, 900000, 0),
                        new searchLecList("드론 프로그래밍", "한혜진",
                                20230429, 390000, 0),
                        new searchLecList("정보처리기사 실기 대비반", "무지개",
                                20230429, 120000, 0),
                        new searchLecList("R기반 빅데이터 분석, 시각화", "이장우",
                                20230503, 210000, 0),
                        new searchLecList("증강/가상현실 프로그래밍", "하연태",
                                20230503, 600000, 0),
                        new searchLecList("SW기업 입사 코딩테스트 대비반", "홍순규",
                                20230512, 500000, 0),
                        new searchLecList("코딩테스트와 개발실무를 모두 잡는 알고리즘", "김희민",
                                20230517, 240000, 0)
                ));
        sr = new StudentRepository();
        st = new Student();
        av = new AcademyView();

    }

    /**
     * 학생조회
     */
    public void showStudent() {
        System.out.printf("========= 우리학원 학생현황 (총 %d명) ========\n"
                , sr.getStudentList().size()-1);
        List<Student> studentList = sr.getStudentList();
        for (Student student : studentList) {
            if ( student.getStudentId().equals("admin")) continue;
            System.out.println("학생정보 " + student);
        }
    }

    /**
     * 강의 전체조회
     */
    public void getLectureList() {
        System.out.printf("========== 개설된 강의현황 (총 %d개) =========\n"
                , lectureList.size());

        System.out.println("※ 강의명  |  강사명  |  개강일  |  수강료  | 수강인원 ※");

        List<String> allLecList = StudentRepository.getStudentList().stream()
                .flatMap(st -> st.getRequestClass()
                        .stream().map(n -> n.getLectureName())).collect(Collectors.toList());

        for (LectureManagement lm : lectureList) {
            long count = allLecList.stream().filter(target -> target.equals(lm.getLectureName())).count();
            lm.setCountStudent((int) count);
            System.out.println(lm.lecInform());
        }
    }

    /**
     * 강의 선택조회
     */
    public void searchList(String keyword) {
        lectureList.stream()
                .filter(d -> d.getLectureName().contains(keyword) ||
                        d.getTeacherName().contains(keyword))
                .collect(Collectors.toList())
                .forEach(d -> System.out.println(d));
    }

    /**
     * 강의 개설하기
     * 개설한 강의는 강의배열에 추가
     */
    public void addNewLecture(LectureManagement newLecture) {
        lectureList.add(newLecture);
    }

    /**
     * 강의 삭제하기
     */
    public void deleteLecture(String targetLecKeyword) {
        for (int i = 0; i < lectureList.size(); i++) {
            if (lectureList.get(i).getLectureName().contains(targetLecKeyword)) {
                lectureList.remove(i);
            }
        }
    }

    /**
     * 강의 키워드 검색하기
     */
    public static List<LectureManagement> searchByLecName(String targetLecKeyword) {
        return lectureList.stream()
                .filter(d -> d.getLectureName().contains(targetLecKeyword))
                .collect(Collectors.toList());
    }

    /**
     * 강의 내용 수정하기
     */
    public void modifyLecName(LectureManagement lm) {
        while (true) {
            System.out.println("\n\uD83C\uDF20 변경할 강사이름");
            String checkTeacher = input("▶▶ ");
            if (lm.getTeacherName().equals(checkTeacher)) {
                lm.setTeacherName(checkTeacher);
                System.out.println("\uD83D\uDEA8 기존의 강사명과 같습니다. 다시 입력해주세요.");
                continue;
            } else {
                lm.setTeacherName(checkTeacher);
                System.out.println("\n\uD83C\uDF20 강사가 변경되었습니다!");
                break;
            }
        }
    }


    /**
     * 수강신청 강의 리스트
     */
    public void requestLecList() {
        List<LectureManagement> requestClass = st.getRequestClass();
        System.out.println("requestClass = " + requestClass);
    }

    /**
     * 외부 패키지 사용할 강의리스트
     */
    public List<LectureManagement> getLec() {
        return lectureList;
    }

    public static List<LectureManagement> lecturListForPayroll() {
        return lectureList;
    }

}

