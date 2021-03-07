import java.util.*;
import java.io.*;

class MapReader {
    private int width;
    private int height;
    private char[][] maps;

    public MapReader(int width, int height) {
        this.width = width;
        this.height = height;
        this.maps = new char[height][width];
    }

    public void read(BufferedReader br) throws IOException {
        for(int i = 0; i < height; i++) {
            String line = br.readLine();
            this.maps[i] = line.toCharArray();
        }
    }

    public void printMap() {
        for(int i = 0; i < height; i++) {
            System.out.println(this.maps[i]);
        }
    }

    public int solve() {
        int answer = 999999;
        for(int i = 0; i < height-7; i++) {
            for(int j = 0; j < width-7; j++) {
                char[][] cropped = this.cropMap(j, i);
                int replaceCnt = this.findCount(cropped, 'W');
                answer = Math.min(replaceCnt, answer);

                cropped = this.cropMap(j, i);
                replaceCnt = this.findCount(cropped, 'B');
                answer = Math.min(replaceCnt, answer);
            }
        }
        return answer;
    }

    public char[][] cropMap(int x, int y) {
        char[][] result = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                result[j][i] = this.maps[y + i][x + j];
            }
        }

        return result;
    }

    public int findCount(char[][] map, char start) {
        int cnt = 0;
        int[] dx = {-1, 0};
        int[] dy = {0, -1};

        if(map[0][0] != start) {
            map[0][0] = start;
            cnt++;
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                for(int k = 0; k < 2; k++) {
                    int prev_x = j + dx[k];
                    int prev_y = i + dy[k];

                    if(prev_x >= 0 && prev_y >= 0) {
                        char p_ch = map[prev_y][prev_x];
                        char curr = map[i][j];
                        if(p_ch == curr) {
                            if(curr == 'W') map[i][j] = 'B';
                            if(curr == 'B') map[i][j] = 'W';
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int height = Integer.parseInt(line.split(" ")[0]);
        int width = Integer.parseInt(line.split(" ")[1]);

        // 체스판 정보를 읽는다.
        MapReader mapReader = new MapReader(width, height);
        mapReader.read(br);

        // 임의의 점에서 체스를 8x8로 분할한다.
        int answer = mapReader.solve();
        System.out.println(answer);
    }
}