import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] page = new int[101][101];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    page[y + j][x + k] = 1;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (page[i][j] == 1){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}