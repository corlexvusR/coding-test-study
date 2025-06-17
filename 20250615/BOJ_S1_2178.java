/*
* (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static class Node {
        int x, y;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            String str = sc.next();
            for (int j = 0; j < M; ++j) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int start_y, int start_x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start_y, start_x));
        visited[start_y][start_x] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int direction = 0; direction < 4; ++direction) {
                int next_y = now.y + dy[direction];
                int next_x = now.x + dx[direction];

                boolean is_possible_location = (0 <= next_y && next_y < N && 0 <= next_x && next_x < M);
                if (!is_possible_location) {
                    continue;
                } else if (map[next_y][next_x] == 0) {
                    continue;
                } else if (visited[next_y][next_x]) {
                    continue;
                }

                queue.offer(new Node(next_y, next_x));
                map[next_y][next_x] = map[now.y][now.x] + 1;
                visited[next_y][next_x] = true;
            }
        }
    }
}