package choongang.financial;

public class Payroll {

    String name; //강사이름

    int payroll;//강사월급


    public Payroll() {
    }

    public Payroll(String name,  int payroll) {
        this.name = name;
        this.payroll = payroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    @Override
    public String toString() {
        return  "   "+name + "        "+ String.format("%,d",payroll) +"  " ;
    }
}
