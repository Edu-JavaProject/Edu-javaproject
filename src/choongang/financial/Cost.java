package choongang.financial;

import java.util.List;

public class Cost {

    String costTitle; //비용 내역
    String cost; //비용
    String costDate; //지출일자
    String costMemo; //비고
    List<Cost> costList;

    public Cost(String costTitle, String cost, String costDate, String costMemo) {
    }

    public Cost(String costTitle, String cost, String costDate, String costMemo, List<Cost> costList) {
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostDate() {
        return costDate;
    }

    public void setCostDate(String costDate) {
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
}
