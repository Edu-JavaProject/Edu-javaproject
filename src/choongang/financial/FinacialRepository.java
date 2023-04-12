package choongang.financial;




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



    public FinacialRepository() {
    }

    public void addCost(String costTitle, String cost, String costDate, String costMemo) {

        Cost c1 = new Cost(costTitle, cost, costDate,costMemo, new ArrayList<>() );
        costList.add(c1);
        System.out.print(costList);

//        autoSave();

    }



    public void addIncome() {

    }



    public static List<Cost> repositCostList() {
        List<Cost> costList = new ArrayList<>(
                List.of(
                        new Cost("월세", "2,000,000", "4월1일","없음", new ArrayList<>()),
                        new Cost("관리비", "1,000,000", "4월1일","없음", new ArrayList<>()),
                        new Cost("렌탈비용", "500,000", "4월10일","없음", new ArrayList<>())

                )
        );
        List<Cost> list = costList.stream().
                map(c -> new Cost(c.costTitle, c.cost, c.costDate, c.costMemo)).
                collect(Collectors.toList());

        return list;

    }

    public void teacherPayroll() {



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
