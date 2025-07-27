/**
 * S의 값을 가장 작게 만들기 위해 A의 수를 재배열하는 문제
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arrayA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrayB = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrayA);
        // 배열 A만 재배열해야 하지만 배열 B를 재배열해도 정답 처리가 된다. 정렬을 어떻게 하든 상관없이 최소값을 구하는 방법은 같기 때문이다.
        Arrays.sort(arrayB);

        int answer = 0;
        for (int i = 0; i < N; ++i) {
            answer += arrayA[i] * arrayB[N - i - 1];
        }

        System.out.println(answer);
    }
}
