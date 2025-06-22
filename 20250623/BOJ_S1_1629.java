/*
* 자연수 A를 B번 곱한 수를 구하는 프로그램(단, 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구한다.)
* A, B, C는 모두 2,147,483,647 이하의 자연수이다.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(power(A, B, C));
    }

    public static int power(int A, int B, int C) {
        if (B == 0) {
            return 1;
        } else if (B == 1) {
            return A % C;
        }

        int half = power(A, B / 2, C);

        if (B % 2 == 0) {
            return (int)(((long)half * half) % C);
        } else {
            return (int)((((long)half * half) % C * (A % C)) % C);
        }
    }
}