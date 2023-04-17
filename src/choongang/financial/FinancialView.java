package choongang.financial;




import choongang.student.StudentView;

import java.time.LocalDate;
import java.util.List;

import static choongang.utility.Util.*;


public class FinancialView {
    static StudentView stview;
    static FinacialRepository fr;

    static {
        fr = new FinacialRepository();
        stview =new StudentView();
    }

    // 보여질 화면
    //1. 내역등록 2. 지출상세 3. 수입목록 4. 종료
    //내역 등록 -> 지출내역 등록 시, (날짜, 내역, 지출금액)
    //고정비용(월세, 관리비, 세금) 상수로 만들 것. 세금은 나가는 달이 정해져 있으므로 정하는 게 맞는지 볼 것


    public void FinancialStart() {

        while (true) {
            System.out.println("\nʚ ═════･୨\uD83C\uDF08 회계관리 페이지 \uD83C\uDF08୧･═════ ɞ");
            System.out.println("☞ 1. 지출/수입 등록");
            System.out.println("☞ 2. 지출내역 조회");
            System.out.println("☞ 3. 수입내역 조회");
            System.out.println("☞ 4. 인건비 조회");
            System.out.println("☞ 5. 이전 페이지로");
            System.out.println("☞ 9. 로그아웃");
            System.out.println("==================================");
            String selNum = input("▶▶ ");

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
                case "9":
                    stview.login();
                    break;
                default:
                    System.out.println("\uD83D\uDEA8 번호를 다시 입력해주세요");

            }


        }

    }

    // 지출 수입 내역 수기로 작성을 위한 페이지 입니다.
    private static void addList() {

        while (true) {
            System.out.println("\n####### \uD83C\uDF40 지출/수입 등록 \uD83C\uDF40 #######");
            System.out.println("1. 비용 2. 수입 3.이전 페이지로 돌아가기 ");
            String selNum = input("\uD83C\uDF20 번호를 입력해주세요 >>");
            switch (selNum) {
                //지출 내역 직접 작성해서 costlist에 추가합니다
                case "1":
                    String costTitle = input("* 지출내역 :");

                    try {
                        int cost = Integer.parseInt(input("* 금액 : "));
                        String datecost = input("* 날짜(yyyymmdd) : ");
                        String costMemo = input("* 비고 : ");
                        fr.addCost(costTitle, cost, stringToDate(datecost), costMemo);
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("* 숫자를 입력해주세요");
                        break;
                    }


                //수입내역 직접 작성해서 totalIncome을 구합니다.
                case "2":

                    String incomeTitle = input("* 수입내역 :");
                    try {
                        int income = Integer.parseInt(input("* 금액 : "));
                        String dateincome = (input("* 날짜(yyyymmdd) : "));
                        String incomeMemo = input("* 비고 : ");
                        int addSum = 10000000 + fr.addIncome(incomeTitle, income, stringToDate(dateincome), incomeMemo);
                        System.out.printf("* 이번달 총 수입 : %,d\n", addSum);
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("* 숫자를 입력해주세요 ");
                        break;
                    }

                case "3":
                    return;
                default:
                    System.out.println("* 해당하는 숫자를 입력해주세요");
            }

        }
    }


    private static void showIncomeList() {
        System.out.println("\uD83C\uDF20 수입내역을 조회합니다");
        System.out.print(" # 이번달 총 수입 ");
        int income = 10000000+fr.repositIncomeList();
        System.out.printf("%,d원\n",income);

    }

    private static void showCostList() {
        System.out.println("\uD83C\uDF20  지출내역을 조회합니다");
        System.out.print("|  지출내역  |");
        System.out.print("     금액    |");
        System.out.print("     날짜    |");
        System.out.print("   비고   |\n");

        fr.repositCostList();

    }


    //강사를 프리랜서로 지정. 따라서 새로운
    private static void showPayroll() {
        System.out.println("\uD83C\uDF20  인건비 조회 내역입니다");
        System.out.println("|  강사명  |    4월 강의료   |");
        System.out.println(" ");
        for (Payroll payroll : FinacialRepository.teacherPayroll()) {
            System.out.println(payroll);


        }

    }

    public static void stop() {
        System.out.print("\n엔터를 눌러 계속하기");
        input("");

    }


    /**
     * @param date String으로 입력받은 날짜
     * @return LocalDate로 변환하여 리터하고 입력할 수 있도록
     * 수입, 지출 항목에 적용
     */
    private static LocalDate stringToDate(String date) {

        if (date.length() != 8) {
            System.out.println("\uD83D\uDEA8 형식에 맞게 날짜를 입력해주세요 ");
        }
        int integerDate = Integer.parseInt(date);
        int year = integerDate / 10000;
        int month = (integerDate / 100) - year * 100;
        int day = integerDate % 100;
        LocalDate Date = LocalDate.of(year, month, day);

        return Date;

    }

}
