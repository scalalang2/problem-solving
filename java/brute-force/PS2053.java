import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int[] nums = new int[n];
        int[] strikes = new int[n];
        int[] balls = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(scanner.next());
            strikes[i] = Integer.parseInt(scanner.next());
            balls[i] = Integer.parseInt(scanner.next());
        }

        int answer = 0;
        for(int i = 123; i <= 987; i++) {
            int a = (i / 100);          // 첫째 자리수
            int b = (i / 10) % 10;      // 둘째 자리수
            int c = i % 10;             // 셋째 자리수

            if(a == 0 || b == 0 || c == 0) continue;
            if(a == b || a == c || b == c) continue;

            boolean pass = true;
            for(int k = 0; k < n; k++) {
                int a_1 = nums[k] / 100;
                int b_1 = (nums[k] / 10) % 10;
                int c_1 = nums[k] % 10;

                int strike = 0;
                int ball = 0;
                // 스트라이크의 개수가 동일해야 한다. = 자리수가 동일한 수를 모두 찾는다.
                if(a_1 == a) strike++;
                if(b_1 == b) strike++;
                if(c_1 == c) strike++;

                // 볼의 개수가 동일해야 한다. = 자리수는 동일하지 않되 동일한 수를 모두 찾는다.
                if(a == b_1 || a == c_1) ball++;
                if(b == a_1 || b == c_1) ball++;
                if(c == a_1 || c == b_1) ball++;

                if(strike != strikes[k] || ball != balls[k]) pass = false;
            }

            if(pass) answer +=1;
        }
        System.out.println(answer);
    }
}