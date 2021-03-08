import java.io.*;
import java.util.*;

class ProblemSolver {
    private int row = 0;
    private int[][] stickers;
    private int[][] dp;

    public ProblemSolver(int row) {
        this.row = row;
        this.stickers = new int[2][row];
        this.dp = new int[3][row];
    }

    public void init(BufferedReader br) throws IOException {
        for(int i = 0; i < 2; i++) {
            String[] splitted = br.readLine().split(" ");
            for(int j = 0; j < this.row; j++) 
                this.stickers[i][j] = Integer.parseInt(splitted[j]);
        }

        for(int i = 0; i < 2; i++)
            for(int j = 0; j < this.row; j++)
                this.dp[i][j] = -1;
    }

    public int calcSticker(int c, int s) {
        if(c == this.row) return 0;
        if(this.dp[s][c] != -1) return this.dp[s][c];

        int result = calcSticker(c + 1, 0);
        if(s != 1) result = Math.max(result, calcSticker(c+1, 1) + this.stickers[0][c]);
        if(s != 2) result = Math.max(result, calcSticker(c+1, 2) + this.stickers[1][c]);
        this.dp[s][c] = result;
        return result;
    }

    public int solve() {
        return calcSticker(0, 0);
    }

    public void print() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < this.row; j++) {
                System.out.print(this.stickers[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int row = Integer.parseInt(br.readLine());
            
            ProblemSolver solver = new ProblemSolver(row);
            solver.init(br);
            System.out.println(solver.solve());
        }
    }
}