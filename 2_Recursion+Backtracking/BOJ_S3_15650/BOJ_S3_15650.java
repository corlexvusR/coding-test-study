/*
* 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램.
*   - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*   - 고른 수열은 오름차순이어야 한다
*/

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] n_list;
    static int[] result_list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        n_list = new int[N];
        for (int i = 0; i < N; ++i) {
            n_list[i] = i + 1;
        }
        result_list = new int[M];
        recursion(0, 1);
    }
    public static void recursion(int depth, int start_index) {
        if (depth == M) {
            for (int now : result_list) {
                System.out.print(now + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start_index; i <= N; ++i) {
            if (i == -1) {
                continue;
            }
            result_list[depth] = i;
            recursion(depth + 1, i + 1);
        }
    }
}