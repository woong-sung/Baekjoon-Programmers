import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NB = sc.nextLine().split(" ");
        String N = NB[0];
        Integer B = Integer.parseInt(NB[1]);
        double[] arr = new double[N.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.pow(B, i);
        }
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(N.length() - 1 - i);
            if (c >= 'A') {
                sum += (c - '7') * arr[i];
            } else {
                sum += (c - '0') * arr[i];
            }
        }
        System.out.println(sum);
    }
}