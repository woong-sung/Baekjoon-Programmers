import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        double h = 0;   // 학점 총합
        double j = 0;   // 학점*과목평점 총합
        for (int i = 0; i < 20; i++) {
            String[] s = sc.nextLine().split(" ");
            double gp = Double.parseDouble(s[1]);   // 학점
            if (s[2].equals("P")) continue;
            double grade = map.get(s[2]);   // 과목 평점
            h += gp;
            j += (gp * grade);
        }
        System.out.printf("%.6f",j/h);
    }
}
