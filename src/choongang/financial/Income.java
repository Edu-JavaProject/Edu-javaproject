package choongang.financial;

import java.time.LocalDate;

public class Income {

    String lectureName; //강의명
    int tuitionFee; //수강료

   LocalDate incomeDate; //결제날짜
    String incomeMemo; //비고,결제자명

    public Income() {
    }

    public Income(String lectureName, int tuitionFee, LocalDate incomeDate, String incomeMemo) {
        this.lectureName = lectureName;
        this.tuitionFee = tuitionFee;
        this.incomeDate = incomeDate;
        this.incomeMemo = incomeMemo;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeMemo() {
        return incomeMemo;
    }

    public void setIncomeMemo(String incomeMemo) {
        this.incomeMemo = incomeMemo;
    }

    @Override
    public String toString() {
        return "\nIncome{" +
                "강의명='" + lectureName + '\'' +
                ", 강의료=" + tuitionFee +
                ", 날짜='" + incomeDate + '\'' +
                ", 입금명='" + incomeMemo + '\'' +
                '}';
    }
    public String info() {
        return String.format("%-10s    %,-5d    %-12s  %5s",lectureName,tuitionFee,incomeDate,incomeMemo);
    }



}
