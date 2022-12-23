import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = 0;
        int x = 0;
        int largest = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = scanner.nextInt();
                if (num > largest) {
                    largest = num;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(largest);
        System.out.println((y + 1) + " " + (x + 1));
    }
}