package choongang.academy;

import choongang.financial.FinacialRepository;
import choongang.financial.FinancialView;
import choongang.student.Student;
import choongang.student.StudentRepository;
import choongang.utility.Util;

import java.util.List;
import java.util.Scanner;

import static choongang.utility.Util.input;

public class AcademyView {

    private static AcademyRepository ar;
    private static FinancialView fv;

    static {
        ar = new AcademyRepository();
        fv = new FinancialView();
    }

    public void managementMenu() {
        System.out.println("\n:¨·.·¨:\n" +
                " `·. \uD83D\uDC97무지개 관리자 시스템 ##### ★°*ﾟ");
        System.out.println("☞ 1. 학생 조회");
        System.out.println("☞ 2. 강의 조회");
        System.out.println("☞ 3. 강의 개설");
        System.out.println("☞ 4. 회계 관리");
        System.out.println("☞ 0. 종료하기");
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
                    // 3. 강의 개설
                    addNewLec();
                    break;
                case "4":
                    // 4. 회계 관리
                    fv.FinancialStart();
                    break;
                case "0":
                    String answer = input("# 관리자 페이지 종료 [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# (´･_･)프로그램을 종료합니다.");
                        System.exit(0);
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
        System.out.println("☞ 0. 이전페이지로");
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
    // 3. 강의 개설
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
}





