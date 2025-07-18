/*
* 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램
*/

import java.util.Scanner;

public class Main {
    static int[] array = new int[12];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i <= 10; ++i) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            System.out.println(array[n]);
        }
    }
}