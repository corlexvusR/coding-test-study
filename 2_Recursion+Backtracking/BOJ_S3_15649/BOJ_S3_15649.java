/*
* 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램.
*   - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*/

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] n_list;
    static boolean[] visited;
    static int[] result_list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        n_list = new int[N];
        visited = new boolean[N];
        result_list = new int[N];
        for (int i = 0; i < N; ++i) {
            n_list[i] = i + 1;
        }
        backtracking(0);
    }

    public static void backtracking(int count) {
        if (count == M) {
            for (int i = 0; i < M; ++i) {
                System.out.print(result_list[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (visited[i]) {
                continue;
            }
            result_list[count] = n_list[i];
            visited[i] = true;
            backtracking(count + 1);
            visited[i] = false;
        }
    }
}