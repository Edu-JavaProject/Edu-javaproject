package choongang.financial;

import choongang.academy.AcademyRepository;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class date {
    public static void main(String[] args) {


//    LocalDate localDate;
//
//   int date = 20231211;
//      int year = date/10000;
//      int month = (date/100)-year*100;
//      int day =date%100;


        LocalDate startDate = LocalDate.of(2023, 4, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 1);
        List<Teacher> teacherList = AcademyRepository.lecturListForPayroll()
                .stream().filter(d -> {
                    int year = d.getLectureDate() / 10000;
                    int month = (d.getLectureDate() / 100) - year * 100;
                    int day = d.getLectureDate() % 100;
                    LocalDate Date = LocalDate.of(year, month, day);
                    return Date.isAfter(startDate)&&Date.isBefore(endDate);

                })
                .map(n -> new Teacher(n))
                .collect(toList());
                for (Teacher teacher : teacherList) {
            System.out.println("teacher = " + teacher);
        }


}

}
