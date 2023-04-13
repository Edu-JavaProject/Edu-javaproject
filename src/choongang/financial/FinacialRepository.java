package choongang.financial;




import choongang.academy.AcademyRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static choongang.utility.Util.*;

public class FinacialRepository {

    private static List<Cost> costList = new ArrayList<>(
            List.of(
                    new Cost("월세", "2,000,000", "4월1일","없음", new ArrayList<>()),
                    new Cost("관리비", "1,000,000", "4월1일","없음", new ArrayList<>()),
                    new Cost("렌탈비용", "500,000", "4월10일","없음", new ArrayList<>())

            )
    );
    private static List<Income> incomeList = new ArrayList<>(
            List.of(
                    new Income("JAVA 입문",210810,"4월1일", "김나나")
            )
    );



    public FinacialRepository() {
    }

    public void addCost(String costTitle, String cost, String costDate, String costMemo) {

        Cost c1 = new Cost(costTitle, cost, costDate,costMemo, new ArrayList<>() );
        costList.add(c1);
        System.out.print(costList);

//        autoSave();

    }



    public void addIncome(String lectureName, int tuitionFee, String incomeDate, String incomeMemo) {
        Income income = new Income(lectureName, tuitionFee,incomeDate,incomeMemo);
        incomeList.add(income);
        System.out.println(incomeList);
    }




    public static List<Cost> repositCostList() {

        return costList;

    }
    public static List<Income> repositIncomeList() {
        return incomeList;
    }

    public List<Teacher> teacherPayroll() {
        List<Teacher> teacherList = AcademyRepository.lecturListForPayroll()
                .stream().filter(d -> d.getLectureDate() > 20230400 && d.getLectureDate() < 20230501
                )
                .map(n -> new Teacher(n))
                .collect(Collectors.toList());
        return teacherList;



    }



    public void autoSave() {
        File file = new File("D:/CostList");
        if(!file.exists()) file.mkdir();

        try (ObjectOutputStream oos
                     = new ObjectOutputStream(
                new FileOutputStream("D:/CostList/list.sav"))) {
            oos.writeObject(costList);
        }catch(FileNotFoundException e) {

        }catch(IOException e) {

        }

    }

    public static void loadFile() {

        repositCostList();

        File file = new File("D:/CostList/list.sav");
        if(file.exists()) {
            try(ObjectInputStream ois =
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
