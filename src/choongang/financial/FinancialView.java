package choongang.financial;



import java.util.List;
import static choongang.utility.Util.*;


public class FinancialView {

    static FinacialRepository fr;
    static {
        fr =new FinacialRepository();
    }

    // 보여질 화면
    //1. 내역등록 2. 지출상세 3. 수입목록 4. 종료
    //내역 등록 -> 지출내역 등록 시, (날짜, 내역, 지출금액)
    //고정비용(월세, 관리비, 세금) 상수로 만들 것. 세금은 나가는 달이 정해져 있으므로 정하는 게 맞는지 볼 것


    public static void FinancialStart() {


        while (true) {
            System.out.println("수입/지출 관리");
            System.out.println("번호를 골라 주세요");
            System.out.println("1. 내역 등록 2. 지출 내역 3. 수입 내역 4. 이전페이지로 돌아가기 5. 인건비 6.종료");
            String selNum = input("번호를 입력하세요 :");

            switch (selNum) {
                case "1" :
                    addList();
                    stop();
                    break;
                case "2" :
                    showCostList();
                    stop();
                    break;
                case "3" :
                    showIncomeList();
                    stop();
                    break;
                case "4" :
                    //이전페이지로 돌아가기 만들기
                    break;
                case "5" :
                    showPayroll();
                    stop();
                    break;
                case "6" :
                    System.exit(0);
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");

            }


        }

    }
    public static void stop() {
        System.out.print("엔터를 눌러 계속하기");
        input("");

    }

    private static void showPayroll() {
        System.out.println("인건비 조회 내역입니다");
        fr.teacherPayroll();
    }

    private static void showIncomeList() {
        String incomeTitle = input("수입내역 :");
        String income = input("금액 : ");
        String incomeDate = input("날짜 : ");
        String incomeMemo = input("비고 : ");

    }

    private static void showCostList() {
        System.out.println("지출내역을 조회합니다");
        System.out.println(fr.repositCostList());

    }

    private static void addList() {
        System.out.println("내역등록");
        System.out.println("1. 비용 2. 수입 ");
        String selNum = input("번호를 입력해주세요 >>");
        switch(selNum) {
            case "1" :
                String costTitle = input("지출내역 :");
                String cost = input("금액 : ");
                String costDate = input("날짜 : ");
                String costMemo = input("비고 : ");
                fr.addCost(costTitle,cost,costDate,costMemo);


                break;
            case "2" :
                fr.addIncome();
                break;
        }
    }

}
