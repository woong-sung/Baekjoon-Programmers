import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Node>[] list;
    static String ans1="",ans2="",ans3 = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char mid = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            list[mid-'A'].add(new Node(mid, left, right));
        }
        front(list[0].get(0));
        System.out.println(ans1);
        mid(list[0].get(0));
        System.out.println(ans2);
        back(list[0].get(0));
        System.out.println(ans3);
    }
    public static void front(Node node){
        ans1 += node.cur;
        if (node.leftChild=='.' && node.rightChild=='.') return;
        if (node.leftChild != '.') {
            front(list[node.leftChild - 'A'].get(0));
        }
        if (node.rightChild != '.') {
            front(list[node.rightChild - 'A'].get(0));
        }
    }

    public static void mid(Node node) {
        if (node.leftChild=='.' && node.rightChild=='.') {
            ans2 += node.cur;
            return;
        }
        if (node.leftChild != '.') {
            mid(list[node.leftChild - 'A'].get(0));
        }
        ans2 += node.cur;
        if (node.rightChild != '.') {
            mid(list[node.rightChild - 'A'].get(0));
        }
    }

    public static void back(Node node){
        if (node.leftChild=='.' && node.rightChild=='.') {
            ans3 += node.cur;
            return;
        }
        if (node.leftChild != '.') {
            back(list[node.leftChild - 'A'].get(0));
        }
        if (node.rightChild != '.') {
            back(list[node.rightChild - 'A'].get(0));
        } else {
            ans3 += node.cur;
            return;
        }
        ans3 += node.cur;
    }
    static class Node{
        char cur;
        char leftChild;
        char rightChild;
        public Node(char c, char l, char r){
            this.cur = c;
            this.leftChild = l;
            this.rightChild = r;
        }
    }
}
