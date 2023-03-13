import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean asc = false;
        boolean des = false;
        int pre = sc.nextInt();
        for (int i = 1; i < 8; i++) {
            int cur = sc.nextInt();
            if (pre > cur){
                des = true;
            }else{
                asc = true;
            }
            pre = cur;
        }
        if (asc && !des) System.out.println("ascending");
        else if (!asc && des) System.out.println("descending");
        else if (asc && des) System.out.println("mixed");
    }
}
