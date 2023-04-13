package choongang.financial;


import choongang.academy.AcademyRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static choongang.utility.Util.*;
import static java.util.stream.Collectors.toList;

public class FinacialRepository {

    private static List<Cost> costList = new ArrayList<>(
            List.of(
                    new Cost("월세", 2000000, LocalDate.of(2023, 4, 1), "없음", new ArrayList<>()),
                    new Cost("관리비", 1000000, LocalDate.of(2023, 4, 1), "없음", new ArrayList<>()),
                    new Cost("렌탈비용", 500000, LocalDate.of(2023, 4, 15), "없음", new ArrayList<>()),
                    new Cost("세무사비용", 200000, LocalDate.of(2023, 4, 15), "없음", new ArrayList<>())
            )
    );
    private static List<Income> incomeList = new ArrayList<>(
            List.of(
                    new Income("JAVA 입문", 210810, LocalDate.of(2023, 4, 10), "김나나")
            )
    );

    private static List<Payroll> payrollListOftMonth;

    private static LocalDate startDate;
    private static LocalDate endDate;

    static {
        startDate = LocalDate.of(2023, 4, 1);
        endDate = LocalDate.of(2023, 5, 1);
    }

    public FinacialRepository() {
    }

    public void addCost(String costTitle, int cost, LocalDate costDate, String costMemo) {

        Cost c1 = new Cost(costTitle, cost, costDate, costMemo, new ArrayList<>());
        costList.add(c1);
//        System.out.print(costList);
        repositCostList();

//cost로 값이 줄어드는 것 구현해야 하는지?
//        autoSave();

    }


    public void addIncome(String lectureName, int tuitionFee, LocalDate incomeDate, String incomeMemo) {
        Income income = new Income(lectureName, tuitionFee, incomeDate, incomeMemo);
        incomeList.add(income);
        repositIncomeList();


//
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
    public static void repositIncomeList() {

        AcademyRepository.lecturListForPayroll()
                .stream().filter(d -> {
                    int year = d.getLectureDate() / 10000;
                    int month = (d.getLectureDate() / 100) - year * 100;
                    int day = d.getLectureDate() % 100;
                    LocalDate Date = LocalDate.of(year, month, day);
                    return Date.isAfter(startDate) && Date.isBefore(endDate);
                })
                .map(count -> count.getCountStudent())
                .collect(toList());

        for (Income income : incomeList) {
            System.out.println(income.info());
        }
        int initIncome = 20000000;
        int sum = incomeList.stream().mapToInt(n -> n.tuitionFee).sum();
        initIncome += sum;
//        String.format("%,d",initIncome);\

        System.out.println("====================================================");
        System.out.printf("수입 총액 : %,d\n", initIncome);


        //강의등록시 수입총합
//        return incomeList;


    }

    /**
     * @return : 이번달 수업을 진행할 강사와 이번달 지급될 pay list
     */


    public static List<Payroll> teacherPayroll() {

        List<Teacher> teacherList = AcademyRepository.lecturListForPayroll()
                .stream().filter(d -> {
                    int year = d.getLectureDate() / 10000;
                    int month = (d.getLectureDate() / 100) - year * 100;
                    int day = d.getLectureDate() % 100;
                    LocalDate Date = LocalDate.of(year, month, day);
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


    public void autoSave() {
        File file = new File("D:/CostList");
        if (!file.exists()) file.mkdir();

        try (ObjectOutputStream oos
                     = new ObjectOutputStream(
                new FileOutputStream("D:/CostList/list.sav"))) {
            oos.writeObject(costList);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }

    public static void loadFile() {

//        repositCostList();

        File file = new File("D:/CostList/list.sav");
        if (file.exists()) {
            try (ObjectInputStream ois =
                         new ObjectInputStream(new FileInputStream(file))) {
                costList = (List<Cost>) ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
