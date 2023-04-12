package choongang.student;

import choongang.utility.Util;

import static choongang.student.Gender.*;
import static choongang.utility.Util.*;

// 회원가입, 정보 입출력 처리
public class StudentView {

    private static StudentRepository repo;

    static {
        repo = new StudentRepository();
    }

    public void mainView() {

        while (true) {
            System.out.println("\n##### 중앙 정보 처리 학원 #####");
            System.out.println("* 1. 로그인");
            System.out.println("* 2. 회원가입");
            System.out.println("* 9. 프로그램 종료");
            String menuNum = input(">> ");
            switch (menuNum) {
                case "1":
                    login();
                    break;
                case "2":
                    signUp();
                    break;
                case "9":
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못 입력 하셨습니다.");
            }
        }
    }

    public void login() {
        System.out.println("로그인 해주세요");
        // 아이디 검증
        while (true) {
            String inputId = input("* ID: ");
            Student student = repo.findStudentById(inputId);
            if (student == null){
                System.out.println("아이디가 존재하지 않습니다.");
                continue;
            }

            // 이렇게하면 틀릴때 계속 아이디 부터 입력 시키는데 해결 방법이 있을까?
            String inputPassword = input("* PASSWORD: ");

            if (!student.getPassword().equals(inputPassword)) {
                System.out.println("비밀번호가 틀렸습니다.");
                continue;
            } // 자기 메소드 호출하는거로 확인해봐?
            break;
        }
        userView();
    }
//    public void checkPassword(String password) {
//
//        if (!student.getPassword().equals(password)) {
//            System.out.println("비밀번호가 틀렸습니다.");
//            continue;
//        } // 자기 메소드 호출하는거로 확인해봐?
//
//    }

    public void userView() {
        System.out.println("\n##### 중앙 정보 처리 학원 #####");
        System.out.println("* 1. 마이페이지");
        System.out.println("* 2. 정보 수정");
        System.out.println("* 3. 수강 목록");
        System.out.println("* 4. 수강 신청");
//        if (!mr.isEmpty()) System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 9. 프로그램 끝내기");
        System.out.println("============================");
    }

    public void signUp() {
        // 아이디, 이메일 등 중복 검사 부분 추가 해야됨
        System.out.println("\n##### 회원 가입 #####");
        String id = input("아이디 : ");
        String password = input("비밀번호 : ");
        String name = input("이름 : ");
        String email = input("이메일 : ");
        String age = input("나이 : ");
        String gender = input("성별 : ");

        Student newStudent = new Student(id, password, name, email, age,
                gender.equals(MALE) ? MALE : FEMALE, 100000);
        if (repo.registerStudent(newStudent)) {
            System.out.println("회원가입이 완료 되었습니다.");
            mainView();
        }
    }

    public void start() {
        mainView();
    }
}
