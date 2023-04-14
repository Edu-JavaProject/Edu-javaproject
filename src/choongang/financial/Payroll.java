package choongang.financial;

public class Payroll {

    String name; //강사이름
    String year; //연차
    int payroll;//강사월급


    public Payroll() {
    }

    public Payroll(String name, String year, int payroll) {
        this.name = name;
        this.year = year;
        this.payroll = payroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", payroll=" + payroll +
                '}';
    }
}
