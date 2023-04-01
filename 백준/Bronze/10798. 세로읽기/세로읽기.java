import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character[][] arr = new Character[5][15];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(arr[i], ' ');
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i]!=' ') sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }
}
