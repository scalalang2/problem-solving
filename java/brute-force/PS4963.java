import java.util.Scanner;
import java.util.Stack;

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class ProblemSolver {
    private int[][] check;
    private int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    private int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int width;
    private int height;
    private int answer = 0;

    public ProblemSolver(int width, int height){
        this.check = new int[height][width];
        this.width = width;
        this.height = height;
    }

    public void dfs(int[][] arr, int x, int y) {
        this.check[y][x] = 1;
        // System.out.println("x: " + x + ", y: " + y);

        for(int i = 0; i < 8; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x >= 0 && next_x < width && next_y >= 0 && next_y < height) {
                if(arr[next_y][next_x] == 1 && this.check[next_y][next_x] == 0) {
                    dfs(arr, next_x, next_y);
                }
            }
        }
    }

    public int solve(int[][] arr){
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int y = i;
                int x = j;

                if(this.check[y][x] == 0 && arr[y][x] == 1) {
                    dfs(arr, x, y);
                    this.answer += 1;
                }
            }
        }

        return this.answer;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int width = Integer.parseInt(sc.next());
            int height = Integer.parseInt(sc.next());

            // exit
            if(width == 0 && height == 0) break;

            int map[][] = new int[height][width];
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    int value = Integer.parseInt(sc.next());
                    map[i][j] = value;
                }
            }

            ProblemSolver solver = new ProblemSolver(width, height);
            System.out.println(solver.solve(map));
        }
    }
}