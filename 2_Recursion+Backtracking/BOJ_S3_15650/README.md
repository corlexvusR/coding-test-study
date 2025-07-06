# [풀이 코드](./BOJ_S3_15650.java)

<br>

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 구하는 문제이다. 단, 수열은 사전 순으로 증가하는 순서로 출력해야 한다는 조건이 있다.

<br>

## 백트래킹

조합 문제를 해결하기 위한 백트래킹 로직을 사용했다. 오름차순 조건을 만족하기 위해 start_index 매개변수를 사용하여 이전에 선택한 수보다 큰 수만 선택하도록 했다.

```java
public static void recursion(int depth, int start_index) {
    if (depth == M) {
        for (int now : result_list) {
            System.out.print(now + " ");
        }
        System.out.println();
        return;
    }

    for (int i = start_index; i <= N; ++i) {
        result_list[depth] = i;
        recursion(depth + 1, i + 1);
    }
}
```

<br>
이 문제의 백트래킹에서 상태관리는 다음과 같은 변수들로 이루어진다.

- start_index
  - 다음에 선택할 수 있는 가장 작은 수 (오름차순 보장)
- result_list[]
  - 현재까지 선택한 수열을 저장

<br>

백트래킹 과정은 다음과 같다.

1. 기저 조건 충족(depth == M)이면 완성된 수열 출력
2. 수열이 완성되지 않았으면 start_index부터 N까지의 수 중 하나를 선택
3. 선택한 수를 result_list에 저장하고 재귀 호출 (다음 start_index는 현재 선택한 수 + 1)
4. 재귀에서 돌아오면 자동으로 백트래킹 완료 (별도의 상태 복원 불필요)

visited 배열을 사용하지 않고 start_index 매개변수로 오름차순 조건과 중복 방지를 동시에 해결했다. 이는 조합(Combination) 문제의 전형적인 해결 방식이다.

<br>

해당 코드의 시간복잡도는 O(C(N,M))이다. 이는 N개 중에서 M개를 선택하는 조합의 수와 같다. <br>

```text
조합의 수: C(N,M) = N! / (M! × (N-M)!)
```

순열과 달리 조합은 순서를 고려하지 않기 때문에 더 효율적이다. start_index를 사용함으로써 불필요한 중복 탐색을 방지하여 시간복잡도를 O(C(N,M))로 구현할 수 있다.
<br>
