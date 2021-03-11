import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        int n = Integer.parseInt(sc.next());
        int dp[] = new int[101];
        dp[s.length] = 1;

        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        for(int i = s.length - 1; i >= 0; i--) {
            for(int j = 0; j < words.length; j++) {
                int textLen = words[j].length();
                char[] textArr = words[j].toCharArray();

                boolean match = true;
                if(i + textLen > s.length) continue;

                for(int k = 0; k < textLen; k++) {
                    if(textArr[k] != s[i + k]) match = false;
                }

                if(match && dp[i + textLen] == 1) {
                    dp[i] = 1;
                }
            }
        }

        System.out.println(dp[0]);
    }
}