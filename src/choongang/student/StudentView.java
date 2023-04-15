package choongang.student;

import choongang.academy.AcademyRepository;
import choongang.academy.AcademyView;
import choongang.academy.LectureManagement;
import choongang.utility.Util;

import java.util.List;
import java.util.stream.Collectors;

import static choongang.student.Gender.*;
import static choongang.utility.Util.*;
import static java.util.stream.Collectors.toList;

// 회원가입, 정보 입출력 처리
public class StudentView {

    private static StudentRepository repo; // 학생 저장소
    private static AcademyRepository aca;
    private AcademyView academyView = new AcademyView();
    public static Student onStudent = null;



    static {
        repo = new StudentRepository();
        aca = new AcademyRepository();

    }

    public void mainView()  {

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
        String inputId = null;
        String inputPassword = null;
        // 아이디 검증
        while (true) {
            inputId = input("* ID: ");
            onStudent = repo.findStudentById(inputId);
            System.out.println(onStudent);
            if (onStudent == null){
                System.out.println("아이디가 존재하지 않습니다.");
                continue;
            }

            // 이렇게하면 틀릴때 계속 아이디 부터 입력 시키는데 해결 방법이 있을까?
            inputPassword = input("* PASSWORD: ");

            if (!onStudent.getPassword().equals(inputPassword)) {
                System.out.println("비밀번호가 틀렸습니다.");
                continue;
            } // 자기 메소드 호출하는거로 확인해봐?
            break;
        }

        if (onStudent.getStudentId().equals("admin")){

            List<Student> studentList = StudentRepository.getStudentList();
            // 수강하는 강의 목록들 가져오기
            List<LectureManagement> allLecture = studentList.stream()
                    .flatMap(lec -> lec.getRequestClass().stream()).collect(toList());
            int sum = allLecture.stream().mapToInt(n -> n.getLectureMoney()).sum();
            onStudent.setMoney(sum);

            academyView.viewProcess();
        } else {
            userView(inputId);
        }
    }


    public void userView(String inputId) {
        while (true) {
            System.out.println("\n##### 중앙 정보 처리 학원 #####");
            System.out.println("* 1. 내 정보 보기");
            System.out.println("* 2. 비밀번호 변경");
            System.out.println("* 3. 수강 목록");
            System.out.println("* 4. 수강 신청");
//        if (!mr.isEmpty()) System.out.println("* 5. 회원 정보 삭제하기");
            System.out.println("* 5. 충전하기");
            System.out.println("* 9. 로그아웃");
            System.out.println("============================");
            String menuNum = input(">> ");
            switch (menuNum) {
                case "1":
                    myInfoView(inputId);
                    break;
                case "2":
                    changePassword();
                    break;
                case "3":
                    showMyLectures(inputId);
                    break;
                case "4":
                    addLecture(inputId);
                    break;
                case "5":
                    chargeMoney();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private void chargeMoney() {
        while (true) {
            System.out.println("충전할 금액을 입력해주세요(최대 50만원)");
            int inputCash = Integer.parseInt(input(">> "));
            if (inputCash<= 500000 ) {
                onStudent.setMoney(onStudent.getMoney()+inputCash);
                System.out.println("충전이 완료 되었습니다 현재 보유 금액 : " + onStudent.getMoney());
                break;
            } else {
                System.out.println("금액을 정확히 입력해주세요");
            }
        }
    }

    private void changePassword() {
        while (true) {
            System.out.println("# 비밀번호 재확인");
            String checkPassword = input(">> ");
            if (!onStudent.getPassword().equals(checkPassword)) {
                System.out.println("비밀번호가 다릅니다.");
                continue;
            }
            break;
        }
        System.out.println("# 변경할 비밀번호를 입력해주세요");
        String newPassword = input(">> ");
        onStudent.setPassword(newPassword);
        System.out.println("비밀번호가 변경되었습니다");

    }

    // 내 정보 확인 -> id, 이름, 이메일, 나이, 성별, 돈 보여주기
    private void myInfoView(String inputId) {
        System.out.println(onStudent.myInfo());
    }

    // 내가 수강중인 강의 목록 보여주기
    private void showMyLectures(String inputId) {
        Student studentById = repo.findStudentById(inputId);
        studentById.myLectures();
    }


    // 강의 신청
    private void addLecture(String inputId) {
        List<LectureManagement> lec = aca.getLec();
        for (int i = 0; i < lec.size(); i++) {
            System.out.printf("* %d. %s\n",i+1, lec.get(i).lecInform());
        }
        System.out.println("==== 수강 하실 강의를 선택해주세요 ====");
        int choiceLectureNum = Integer.parseInt(input(">> "));
        if (choiceLectureNum > lec.size()) {
            System.out.println("올바른 강의의 번호를 입력해주세요");
            return;
        }
        LectureManagement lm = lec.get(choiceLectureNum - 1);


        int i = onStudent.getRequestClass().indexOf(lm);
        if ( i != -1) {
            if (onStudent.getRequestClass().get(i).getLectureName().equals(lm.getLectureName())) {
                System.out.println("이미 신청하신 강의입니다.");
                return;
            }
        }

        if (onStudent.getMoney() - lm.getLectureMoney() < 0) {
            System.out.println("금액이 부족합니다. 금액을 충전해주세요");
            return;
        }

        onStudent.setMoney(onStudent.getMoney() - lm.getLectureMoney());
        repo.addLecture(inputId, lm);
        System.out.println("강의 신청이 완료 되었습니다.");

    }


    public void signUp()  {
        // 아이디, 이메일 등 중복 검사 부분 추가 해야됨
        // 성별 입력도 해야됨 - 뺄까?
        System.out.println("\n##### 회원 가입 #####");
        String id = null;
        while (true) {
            id = input("아이디 : ");
            List<Student> studentList = repo.getStudentList();
            List<String> studentIdList = studentList.stream()
                    .map(student -> student.getStudentId())
                    .collect(Collectors.toList());
            if (studentIdList.contains(id)) {
                System.out.println("이미 존재하는 ID입니다.");
                continue;
            }
            break;
        }
        String password = input("비밀번호 : ");
        String name = input("이름 : ");
        String email;
        while (true) {
            email = input("이메일 : ");
            List<Student> studentList = repo.getStudentList();
            List<String> studentIdList = studentList.stream()
                    .map(student -> student.getEmail())
                    .collect(Collectors.toList());
            if (studentIdList.contains(email)) {
                System.out.println("이미 존재하는 email입니다.");
                continue;
            }
            break;
        }
        String age = input("나이 : ");
        Gender gender;

        String inputGender = null;
        checkGender:while (true) {
            inputGender = input("성별(M/F) : ");
            switch (inputGender.toLowerCase().charAt(0)) {
                case 'm':
                case 'M':
                     gender = MALE;
                     break checkGender;
                case 'y':
                case 'Y':
                    gender = FEMALE;
                    break checkGender;
                default:
                    System.out.println("성별을 정확히 입력해주세요");
            }
        }


        Student newStudent = new Student(id, password, name, email, age,
                gender, 0);
        if (repo.registerStudent(newStudent)) {
            System.out.println("회원가입이 완료 되었습니다.");
            mainView();
        }
    }

    public void start()  {
        mainView();
    }
}
