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
        System.out.println("☞ 1. 학생 조회하기");
        System.out.println("☞ 2. 강의 전체조회");
        System.out.println("☞ 3. 강의 검색하기");
        System.out.println("☞ 4. 강의 개설하기");
        System.out.println("☞ 5. 강의 개설하기");
        System.out.println("☞ 0. 종료하기");
        System.out.println("=============================");
    }

    void viewProcess() {
        while (true) {
            managementMenu();
            String menuNum = input("▶▶ ");

            switch (menuNum) {
                case "1":

                    break;
                case "2":
                    ar.getLectureList();
                   break;
                case "3":
                    String keyword = input("# 검색어: ");
                    List<String> searchLecture
                            = List.of(ar.searchLecList(keyword));
                    if (searchLecture.size() > 0) {
                        System.out.printf("\n======== [%s] 검색 결과 =========\n", keyword);
                        for (String inform : searchLecture) {
                            System.out.println(inform);
                        }
                    } else {
                        System.out.println("\n# 검색 결과가 없습니다.");
                    }
                    break;
                case "4":
                    break;
                case "0":
                    String answer = input("# 관리자 페이지를 종료하시나요? [y/n] : ");
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




}
