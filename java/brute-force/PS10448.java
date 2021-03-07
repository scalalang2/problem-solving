import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        // 삼각수를 찾아서 계산한다.
        int k = 1;
        int num = k;
        nums.add(num);
        while(num <= 1000) {
            k++;
            num = num + k;
            if(num <= 1000) {
                nums.add(num);
            }
        }

        int T = Integer.parseInt(scanner.next());
        for(int i = 0; i < T; i++) {
            int targetNum = Integer.parseInt(scanner.next());
            int sum = 0;
            boolean canBeSummed = false;

            outloop:
            for(int x = 0; x < nums.size()-2; x++) {
                for(int y = 0; y < nums.size()-1; y++) {
                    for(int j = 0; j < nums.size(); j++) {
                        sum = nums.get(x) + nums.get(y) + nums.get(j);
                        // System.out.println(nums.get(x) + ", " + nums.get(y) + ", " + nums.get(j));
                        // System.out.println(targetNum + "," + sum);
                        if(sum == targetNum) canBeSummed = true;
                    }
                }
            }

            if(canBeSummed) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}