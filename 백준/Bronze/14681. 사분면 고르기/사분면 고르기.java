import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        int A,B;
    	A = sc.nextInt();
    	B = sc.nextInt();
    	if (A>0) {
    		if(B>0) {
    			System.out.println("1");	
    		}else {
    			System.out.println("4");
    		}
    	}
    	else if (A<0) {
    		if(B>0) {
    			System.out.println("2");	
    		}else {
    			System.out.println("3");
    		}
    	}   	    
    }
}