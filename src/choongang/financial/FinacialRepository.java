package choongang.financial;


import choongang.academy.AcademyRepository;
import choongang.academy.LectureManagement;
import choongang.student.Student;
import choongang.student.StudentRepository;
import choongang.student.StudentView;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FinacialRepository {


    private static AcademyRepository ar;

    private static List<Cost> costList = new ArrayList<>(
            List.of(
                    new Cost("월세", 2000000, LocalDate.of(2023, 4, 1), "없음", new ArrayList<>()),
                    new Cost("관리비", 1000000, LocalDate.of(2023, 4, 1), "없음", new ArrayList<>()),
                    new Cost("렌탈비용", 500000, LocalDate.of(2023, 4, 15), "없음", new ArrayList<>()),
                    new Cost("세무사비용", 200000, LocalDate.of(2023, 4, 15), "없음", new ArrayList<>())
            )
    );

    private static List<Payroll> payrollListOftMonth;

    private static LocalDate startDate;
    private static LocalDate endDate;

    static {
        startDate = LocalDate.of(2023, 4, 1);
        endDate = LocalDate.of(2023, 5, 1);
        ar = new AcademyRepository();
    }

    public FinacialRepository() {

    }

    public void addCost(String costTitle, int cost, LocalDate costDate, String costMemo) {

        Cost c1 = new Cost(costTitle, cost, costDate, costMemo, new ArrayList<>());
        costList.add(c1);
        repositCostList();

    }


    public int addIncome(String lectureName, int tuitionFee, LocalDate incomeDate, String incomeMemo) {
        int addSum = tuitionFee;
        int sddMon = repositIncomeList() + addSum;
        StudentView.onStudent.setMoney(sddMon);
        return sddMon;

    }

    public void repositCostList() {
        for (Cost cost : costList) {
            System.out.println(cost.info());
        }
        int costSum = costList.stream().mapToInt(cost -> cost.getCost()).sum();
        System.out.println("====================================================");
        System.out.printf("비용 총액 : %,d\n", costSum);

    }

    //강의료 수입 - 4월 강의 진행하는 강사 명단
    public static int repositIncomeList() {
//        int initIncome = 20000000;
        int sum = StudentView.onStudent.getMoney();
        StudentView.onStudent.setMoney(sum);
        return sum;
    }

    /**
     * @return : 이번달 수업을 진행할 강사와 이번달 지급될 pay list
     */
    public static List<Payroll> teacherPayroll() {

        List<Teacher> teacherList = ar.lecturListForPayroll()
                .stream().filter(d -> {
                    LocalDate Date = intToDate(d.getLectureDate());
                    return Date.isAfter(startDate) && Date.isBefore(endDate);
                })
                .map(n -> new Teacher(n))
                .collect(toList());

        List<Payroll> payrollListOftMonth = new ArrayList<>(
                List.of(
                        new Payroll(new Teacher(String.valueOf(teacherList.get(0))).getTeacherName(), 2500000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(1))).getTeacherName(), 3000000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(2))).getTeacherName(), 2000000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(3))).getTeacherName(), 200000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(4))).getTeacherName(), 1500000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(5))).getTeacherName(), 200000),
                        new Payroll(new Teacher(String.valueOf(teacherList.get(6))).getTeacherName(), 150000)

                )
        );

        return payrollListOftMonth;


    }

    private static LocalDate intToDate(int date) {

        int integerDate = date;
        int year = integerDate / 10000;
        int month = (integerDate / 100) - year * 100;
        int day = integerDate % 100;
        LocalDate Date = LocalDate.of(year, month, day);

        return Date;

    }


}
