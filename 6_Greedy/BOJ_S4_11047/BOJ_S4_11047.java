/*
* 동전을 적절히 사용해서 그 가치의 합을 K로 만들 때, 필요한 동전 개수의 최솟값을 구하는 프로그램
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 배열 끝에서부터 순회하면서 가치가 높은 동전부터 차감할 수 있을 만큼 차감하고 사용한 동전 개수 추가
        int answer = 0;
        for (int i = N - 1; i > -1; --i) {
            int count = K / coins[i];
            answer += count;
            K -= coins[i] * count;
        }

        System.out.println(answer);
    }
}