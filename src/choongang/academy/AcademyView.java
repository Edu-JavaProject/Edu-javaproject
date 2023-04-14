package choongang.academy;

import choongang.financial.FinacialRepository;
import choongang.financial.FinancialView;
import choongang.student.Student;
import choongang.student.StudentRepository;
import choongang.student.StudentView;
import choongang.utility.Util;

import java.util.List;
import java.util.Scanner;

import static choongang.utility.Util.input;

public class AcademyView {

    private static AcademyRepository ar;
    private static FinancialView fv;
    private static StudentView sv;

    static {
        ar = new AcademyRepository();
        fv = new FinancialView();
        sv = new StudentView();
    }

    public void managementMenu() {
        System.out.println("\n:¨·.·¨:\n" +
                " `·. \uD83D\uDC97\uD83D\uDC9B\uD83D\uDC99무지개 관리자 시스템 ##### ★°*ﾟ");
        System.out.println("☞ 1. 학생 조회");
        System.out.println("☞ 2. 강의 조회");
        System.out.println("☞ 3. 강의 관리");
        System.out.println("☞ 4. 회계 관리");
        System.out.println("☞ 9. 종료하기");
        System.out.println("=====================================");
    }

    public void viewProcess() {
        while (true) {
            managementMenu();
            String menuNum = input("▶▶ ");

            switch (menuNum) {
                case "1":
                    // 1. 학생 조회
                    ar.showStudent();
                    break;
                case "2":
                    // 2. 강의 조회
                    searchLecList();
                    break;
                case "3":
                    // 3. 강의 관리
                    manageLecture();
                    break;
                case "4":
                    // 4. 회계 관리
                    fv.FinancialStart();
                    break;
                case "9":
                    String answer = input("# 관리자 페이지 종료 [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# (´･_･)프로그램을 종료합니다.");
                        sv.start();
                    } else {
                        continue;
                    }
                    break;
                default:
                    System.out.println("\n# 메뉴 번호를 다시 입력하세요");
            }
        }
    }
// =========================================================================

    // 2. 강의조회
    public void searchLecList() {
        System.out.println("\n##### [중앙정보] 강의 조회 #####");
        System.out.println("☞ 1. 강의 전체 조회");
        System.out.println("☞ 2. 강의 검색하기");
        System.out.println("☞ 9. 이전페이지로");
        System.out.println("=============================");

        String menuNum = input("▶▶ ");
        switch (menuNum) {
            case "1":
                //1. 강의 전체 조회
                ar.getLectureList();
                break;
            case "2":
                //2. 강의 검색하기
                String keyword = input(" ＃ 강의명 or 강사명을 입력해주세요!\n▶▶ ");
                ar.searchList(keyword);
                break;
            case "0":
                return;
            default:
                System.out.println("(´･_･)다시 입력해주세요\n");

        }
    }

    // =========================================================
    // 3. 강의 관리
    public void manageLecture() {
        System.out.println("\n##### [중앙정보] 강의 관리 #####");
        System.out.println("☞ 1. 신규 강의 개설");
        System.out.println("☞ 2. 기존 강의 삭제");
//        System.out.println("☞ 3. 강의 내용 수정");
        System.out.println("☞ 9. 이전페이지로");
        System.out.println("=============================");

        String menuNum = input("▶▶ ");
        switch (menuNum) {
            case "1":
                //1. 신규 강의 개설
                addNewLec();
                break;
            case "2":
                //2. 기존 강의 삭제
                delLecture();
                break;
//            case "3":
//                //3. 강의 내용 수정
//                String keyword = input(" ＃ 강의명 or 강사명을 입력해주세요!\n▶▶ ");
//                ar.searchList(keyword);
//                break;
            case "9":
                return;
            default:
                System.out.println("(´･_･)다시 입력해주세요\n");

        }
    }

    // 3-1. 신규 강의 개설
    public void addNewLec() {
        System.out.println("\n##### [중앙정보] 강의 개설 #####");
        String lecName = input("☞ 강의명 : ");
        String teacherName = input("☞ 강사명 : ");
        int lectureDate = Integer.parseInt(input("☞ 개강일(8자리) : "));
        int lectureFee = Integer.parseInt(input("☞ 수강료 : "));
        int countStudent = Integer.parseInt(input("☞ 수강정원 : "));

        LectureManagement newLecture =
                new LectureManagement(lecName, teacherName, lectureDate, lectureFee, countStudent);
        ar.addNewLecture(newLecture);
        System.out.println(" # 신규 강의가 개설되었습니다.");
        System.out.println("-------------------------------------------");
        ar.getLectureList();
    }

    // 3-2. 기존 강의 삭제
    public void delLecture() {
        String targetLecKeyword = input(" ＃ 삭제할 강의명의 키워드를 입력하세요. \n▶▶ ");
        List<LectureManagement> searchLecKeyword = ar.searchByLecName(targetLecKeyword);
//        System.out.println("searchLecKeyword = " + searchLecKeyword);

        if (searchLecKeyword != null) {
//            if (searchLecKeyword.equals(targetLecKeyword)) {
            if (searchLecKeyword.size() == 1) {
                String menuNum = input(String.format("\n [ %s ] 강의를 정말 삭제할까요? [y/n] : ",
                        searchLecKeyword.get(0).getLectureName()));

                switch (menuNum.toLowerCase().charAt(0)) {
                    case 'y':
                    case 'ㅛ':
                        ar.deleteLecture(targetLecKeyword);
                        System.out.println(" # 강의가 삭제되었습니다!");
                        break;
                    default:
                        System.out.println(" # 이전 페이지로...");
                }
         /*   } else if (searchLecKeyword.equals(targetLecKeyword)) {
                System.out.println(" ＃ 해당 키워드의 강의는 없습니다. 다시 입력해주세요.");
                delLecture();*/
            } else {
                System.out.println(" ＃ 검색 키워드와 중복된 강의가 있습니다. \n    삭제할 강의를 번호로 선택해주세요!");
                for (int i = 0; i < searchLecKeyword.size(); i++) {
                    System.out.printf("* %d. %s\n", i + 1, searchLecKeyword.get(i).lecInform());
                }
                int targetNum = Integer.parseInt(input("▶▶ "));
                LectureManagement lm = searchLecKeyword.get(targetNum - 1);

                ar.deleteLecture(targetLecKeyword);
            }
        }
        else if (searchLecKeyword.equals(targetLecKeyword)) {
            System.out.println(" ＃ 해당 키워드의 강의는 없습니다. 다시 입력해주세요.");
            delLecture();
        }
    }
}









