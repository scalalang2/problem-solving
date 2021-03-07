import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int completeSum = 100;
        int[] length = new int[9];

        for(int i = 0; i < 9; i++) {
            length[i] = Integer.parseInt(scanner.next());
        }

        Arrays.sort(length);

        int a = 0, b = 0, sum;

        outloop:
        for(int i = 0; i < 8; i++) {
            a = i;
            for(int j = i+1; j < 9; j++) {
                b = j;
                sum = 0;
                for(int k = 0; k < 9; k++) {
                    if(!(k == a || k == b)) {
                        sum += length[k];
                    }
                }

                if(sum == completeSum) {
                    break outloop;
                }
            }
        }

        for(int i = 0 ; i < 9; i++) {
            if(!(i == a || i == b)) {
                System.out.println(length[i]);
            }
        }
    }
}