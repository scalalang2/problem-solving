import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int ans = 0;

        for(int i = 0; i < n; i++) {
            String text = sc.nextLine();
            char[] chars = text.toCharArray();
            
            Stack<Character> stack = new Stack();
            for(int j = 0; j < chars.length; j++) {
                if(stack.isEmpty() || stack.peek() != chars[j]) {
                    stack.push(chars[j]);
                } else {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) ans++;
        }

        System.out.println(ans);
    }
}