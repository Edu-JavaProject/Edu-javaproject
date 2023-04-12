package choongang.utility;

import java.util.Scanner;

public class Util {

    private static Scanner sc = new Scanner(System.in);

    public static String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public static void makeLine() {
        System.out.println("==============================");
    }


}
