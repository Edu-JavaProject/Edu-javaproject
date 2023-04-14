package choongang.financial;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Cost {

    String costTitle; //비용 내역
    int cost; //비용
    LocalDate costDate; //지출일자
    String costMemo; //비고
    List<Cost> costList;


    public Cost(String costTitle, String cost, LocalDate costDate, String costMemo) {
    }

    public Cost(String costTitle, int cost, LocalDate costDate, String costMemo, List<Cost> costList) {
        this.costTitle = costTitle;
        this.cost = cost;
        this.costDate = costDate;
        this.costMemo = costMemo;
        this.costList = costList;
    }

    public String getCostTitle() {
        return costTitle;
    }

    public void setCostTitle(String costTitle) {
        this.costTitle = costTitle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getCostDate() {
        return costDate;
    }

    public void setCostDate(LocalDate costDate) {
        this.costDate = costDate;
    }

    public String getCostMemo() {
        return costMemo;
    }

    public void setCostMemo(String costMemo) {
        this.costMemo = costMemo;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

    @Override
    public String toString() {
        return "\nCost{" +
                "costTitle='" + costTitle + '\'' +
                ", cost='" + cost + '\'' +
                ", costDate='" + costDate + '\'' +
                ", costMemo='" + costMemo + '\'' +
                '}';
    }
    public String info() {

        return String.format("%8s    %,-8d    %s    %s",costTitle(),cost,costDate,costMemo);

    }

    public String costTitle() {
        //문자열 글자수 얻기 length()
        int length = this.costTitle.length();
        String prettier;
        if(length > 7 ) {
            //문자열 슬라이스 substring() 사용
            prettier = this.costTitle.substring(0,7) + "...";
        }else {
            prettier = this.costTitle;
        }
        return String.format("%s",prettier);
    }
}
