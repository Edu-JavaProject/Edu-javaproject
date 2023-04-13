package choongang.financial;


import java.time.LocalDate;
import java.util.List;

import static choongang.utility.Util.*;


public class FinancialView {

    static FinacialRepository fr;

    static {
        fr = new FinacialRepository();
    }

    // 보여질 화면
    //1. 내역등록 2. 지출상세 3. 수입목록 4. 종료
    //내역 등록 -> 지출내역 등록 시, (날짜, 내역, 지출금액)
    //고정비용(월세, 관리비, 세금) 상수로 만들 것. 세금은 나가는 달이 정해져 있으므로 정하는 게 맞는지 볼 것


    public static void FinancialStart() {


        while (true) {
            System.out.println("##### 수입/지출 관리 ######");
            System.out.println("번호를 골라 주세요");
            System.out.println("☞1. 지출/수입 등록");
            System.out.println("☞2. 지출내역 조회");
            System.out.println("☞3. 수입내역 조회");
            System.out.println("☞4. 인건비 조회");
            System.out.println("☞5. 이전 페이지로");
            System.out.println("☞6. 프로그램 종료");
            System.out.println("=============================");
            String selNum = input("▶▶");

            switch (selNum) {
                case "1":
                    addList();
                    stop();
                    break;
                case "2":
                    showCostList();
                    stop();
                    break;
                case "3":
                    showIncomeList();
                    stop();
                    break;
                case "4":
                    showPayroll();
                    stop();
                    break;
                case "5":
                    return;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");

            }


        }

    }

    // 지출 수입 내역 수기로 작성을 위한 페이지 입니다.
    private static void addList() {
        System.out.println("###내역등록###");
        System.out.println("1. 비용 2. 수입 ");
        String selNum = input("번호를 입력해주세요 >>");
        switch (selNum) {
            //지출 내역 직접 작성해서 costlist에 추가합니다
            case "1":
                String costTitle = input("지출내역 :");
                int cost = Integer.parseInt(input("금액 : "));
                String datecost = input("날짜(yyyymmdd) : ");
                String costMemo = input("비고 : ");
                fr.addCost(costTitle, cost, stringToDate(datecost), costMemo);
                break;

            //수입내역 직접 작성해서 incomelist에 추가합니다.
            case "2":
                String incomeTitle = input("수입내역 :");
                int income = Integer.parseInt(input("금액 : "));
                String dateincome = (input("날짜(yyyymmdd) : "));
                String incomeMemo = input("비고 : ");
                fr.addIncome(incomeTitle, income, stringToDate(dateincome), incomeMemo);

                break;
        }
    }


    private static void showIncomeList() {
        System.out.println("수입내역을 조회합니다");
        System.out.print("|   강의명   |");
        System.out.print("   강의료   |");
        System.out.print("     날짜     |");
        System.out.print("   결제자명   |\n");
        fr.repositIncomeList();

    }

    private static void showCostList() {
        System.out.println("지출내역을 조회합니다");
        System.out.print("|  지출내역  |");
        System.out.print("     금액    |");
        System.out.print("     날짜    |");
        System.out.print("   비고   |\n");

        fr.repositCostList();

    }


    //강사를 프리랜서로 지정. 따라서 새로운
    private static void showPayroll() {
        System.out.println("인건비 조회 내역입니다");
        System.out.println("|  강사명  |    4월 강의료   |");
        System.out.println(" ");
        for (Payroll payroll : FinacialRepository.teacherPayroll()) {
            System.out.println(payroll);


        }

    }

    public static void stop() {
        System.out.print("엔터를 눌러 계속하기");
        input("");

    }


    /**
     * @param date String으로 입력받은 날짜
     * @return LocalDate로 변환하여 리터하고 입력할 수 있도록
     * 수입, 지출 항목에 적용
     */
    private static LocalDate stringToDate(String date) {

        if (date.length() != 8) {
            System.out.println("형식에 맞게 날짜를 입력해주세요 ");
        }
        int integerDate = Integer.parseInt(date);
        int year = integerDate / 10000;
        int month = (integerDate / 100) - year * 100;
        int day = integerDate % 100;
        LocalDate Date = LocalDate.of(year, month, day);

        return Date;

    }

}
