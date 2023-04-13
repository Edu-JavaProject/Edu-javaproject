package choongang.academy;

import choongang.student.StudentRepository;
import choongang.utility.Util;

import java.util.List;
import java.util.Scanner;

import static choongang.utility.Util.input;

public class AcademyView {

    private static AcademyRepository ar;
    private static StudentRepository sr;

    static {
        ar = new AcademyRepository();
        sr = new StudentRepository();
    }

    void managementMenu() {
        System.out.println("\n##### [중앙정보] 관리자 시스템 #####");
        System.out.println("☞ 1. 학생 조회");
        System.out.println("☞ 2. 강의 조회");
        System.out.println("☞ 3. 강의 개설");
        System.out.println("☞ 4. 회계 관리");
        System.out.println("☞ 0. 종료하기");
        System.out.println("=============================");
    }

    void viewProcess() {
        while (true) {
            managementMenu();
            String menuNum = input("▶▶ ");

            switch (menuNum) {
                case "1":
                    // 1. 학생 조회
                    break;
                case "2":
                    // 2. 강의 조회
                    searchLecList();
                   break;
                case "3":
                    // 3. 강의 개설
                    break;
                case "4":
                    // 4. 회계 관리
                    break;
                case "0":
                    String answer = input("# 관리자 페이지를 종료 [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# 프로그램을 종료합니다.");
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
    void searchLecList() {
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
                System.out.println("다시 입력해주세요\n");

        }
    }



}
