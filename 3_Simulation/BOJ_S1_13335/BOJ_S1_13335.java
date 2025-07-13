/*
* 제한된 크기의 큐(Buffer) 시뮬레이션 + 무게 제약 조건
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 메인 함수
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();

        int[] n_array = new int[n];
        for (int i = 0; i < n; ++i) {
            n_array[i] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < w; ++i) {
            q.offer(0);
        }

        int time = 0;
        int now_weight = 0;
        int next_truck_index = 0;

        while (next_truck_index < n) {
            time += 1;
            now_weight -= q.poll();

            if (now_weight + n_array[next_truck_index] <= L) {
                q.offer(n_array[next_truck_index]);
                now_weight += n_array[next_truck_index];
                next_truck_index += 1;
            } else {
                q.offer(0);
            }
        }

        time += w;
        System.out.println(time);
    }
}