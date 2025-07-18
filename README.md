# coding-test-study

<br>

**코딩테스트 스터디를 하면서 해결한 문제를 보관하는 저장소입니다.**

<br>
스터디에서 지정한 문제들을 푼 후에 개인적으로 풀이 코드를 보관하고 정리하는 용도입니다. 다른 알고리즘 트레이닝 사이트에서 해결한 문제의 풀이 코드는 기존과 같이 별도로 Private으로 보관하고 있습니다.
<br>
<br>
코딩테스트 스터디에서는 우선 Java으로 문제를 풀려고 합니다. 나중에 추가로 Python이나 C++를 사용해 풀지도 모릅니다.
<br>
<br>

## 1주차 (BFS)

### BFS (너비 우선 탐색)

BFS는 그래프나 트리에서 시작 노드로부터 가까운 노드부터 차례대로 탐색하는 알고리즘입니다. 큐(Queue) 자료구조를 사용하여 구현하며, 한 레벨의 모든 노드를 탐색한 후 다음 레벨로 넘어가는 특징이 있습니다. 특히 최단 경로를 구하는 문제에서 유용하며, 가중치가 없는 그래프에서의 최단 거리를 보장합니다. 2차원 격자에서는 상하좌우 이동을 통한 최단 경로 탐색에 자주 사용되며, 레벨별 탐색이 필요한 문제에서도 효과적입니다. 방문 처리를 통해 무한 루프를 방지하고, 시작점에서 각 지점까지의 최소 단계 수를 구할 수 있습니다.

<br>

**시간 복잡도**: 인접리스트 사용 시 O(V + E), 인접 행렬 사용 시 O(V^2)<br>
**공간 복잡도**: O(V)<br>
(V는 정점 수, E는 간선 수)

<br>

**로직 순서:**

1. 시작점을 큐에 넣고 방문 처리
2. 큐가 빌 때까지 반복: 현재 위치에서 이동 가능한 모든 방향 탐색
3. 조건을 만족하고 미방문인 위치를 큐에 추가
4. 최단 거리가 필요한 경우 거리 배열 함께 관리
5. 다중 시작점이 있는 경우 모든 시작점을 큐에 미리 추가

<br>

| BOJ 문제번호 | 난이도   | 문제                                                       | 풀이 코드                    |
| ------------ | -------- | ---------------------------------------------------------- | ---------------------------- |
| 2178         | Silver 1 | [미로 탐색](https://www.acmicpc.net/problem/2178)          | [Java](./1_BFS/BOJ_S1_2178/) |
| 7576         | Gold 5   | [토마토](https://www.acmicpc.net/problem/7576)             | Java                         |
| 4179         | Gold 3   | [불!](https://www.acmicpc.net/problem/4179)                | Java                         |
| 2206         | Gold 3   | [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206) | Java                         |
| 11967        | Gold 2   | [불켜기](https://www.acmicpc.net/problem/11967)            | Java                         |

<br>

## 2주차 (재귀 / 백트래킹)

### 재귀 (Recursion)

재귀는 함수가 자기 자신을 호출하는 프로그래밍 기법으로, 복잡한 문제를 작은 하위 문제로 분할하여 해결하는 분할정복의 기초가 된다. 기저 조건(Base Case)과 재귀 호출로 구성되며, 기저 조건은 재귀를 종료시키는 역할을 한다. 수학적 점화식을 직접적으로 코드로 표현할 수 있어 이해하기 쉽지만, 중복 계산이 발생할 수 있어 메모이제이션과 함께 사용할 수도 있다. 트리 구조 탐색, 팩토리얼, 피보나치 수열 등에서 자연스럽게 사용되며, 백트래킹의 기반이 된다.

<br>

**시간 복잡도**: 문제에 따라 다름 (일반적으로 O(2^n) ~ O(n!))<br>
**공간 복잡도**: O(깊이) - 콜 스택 공간<br>

<br>

### 백트래킹 (Backtracking)

백트래킹은 해를 찾는 도중 막다른 길에 도달하면 직전 분기점으로 돌아가서 다른 선택지를 탐색하는 알고리즘이다. 가능한 모든 경우를 체계적으로 탐색하되, 조건에 맞지 않는 경우 더 이상 진행하지 않고 이전 단계로 되돌아가는 가지치기(Pruning)를 통해 효율성을 높인다. N-Queen, 순열 생성, 조합 생성 등에 주로 사용되며, DFS와 유사하지만 불필요한 탐색을 피한다는 점에서 차이가 있다. 해의 개수를 구하거나 조건을 만족하는 모든 경우를 찾을 때 유용하다.

<br>

**시간 복잡도**: O(b^d)<br>
b(branch)는 분기 수, d(depth)는 깊이 (가지치기로 실제로는 더 적음)<br>

**공간 복잡도**: O(d)<br
d(depth)는 재귀 깊이<br>

<br>

**로직 순서:**

1. 현재 상태에서 가능한 모든 선택지 확인
2. 각 선택지에 대해 유효성 검사 (가지치기)
3. 유효한 경우에만 다음 단계로 진행 (재귀 호출)
4. 목표에 도달하면 해를 기록하거나 개수를 증가
5. 재귀 호출 후 상태 복구 (백트래킹)

<br>

| BOJ 문제번호 | 난이도     | 문제                                                  | 풀이 코드                                                 |
| ------------ | ---------- | ----------------------------------------------------- | --------------------------------------------------------- |
| 1629         | Silver 1   | [곱셈](https://www.acmicpc.net/problem/1629)          | [Java](./2_Recursion+Backtracking/BOJ_S1_1629/)           |
| 15649        | Silver 3   | [N과 M(1)](https://www.acmicpc.net/problem/15649)     | [Java](./2_Recursion+Backtracking/BOJ_S3_15649/)          |
| 15650        | Silver 3   | [N과 M(2)](https://www.acmicpc.net/problem/15650)     | [Java](./2_Recursion+Backtracking/BOJ_S3_15650/README.md) |
| 9663         | Gold 4     | [N-Queen](https://www.acmicpc.net/problem/9663)       | Java                                                      |
| 1941         | Gold 3     | [소문난 칠공주](https://www.acmicpc.net/problem/1941) | Java                                                      |
| 1799         | Platinum 5 | [비숍](https://www.acmicpc.net/problem/1799)          | Java                                                      |

<br>

## 3주차 (시뮬레이션)

### 시뮬레이션 (Simulation)

시뮬레이션은 주어진 조건과 규칙에 따라 상황을 단계별로 모방하여 결과를 도출하는 알고리즘이다. 복잡한 로직을 순서대로 구현하되, 문제에서 제시한 규칙을 정확히 이해하고 빠뜨리지 않고 구현하는 것이 핵심이다. 2차원 배열에서의 이동, 회전, 상태 변화 등이 자주 등장하며, 구현력과 디버깅 능력이 중요하다. SW 역량테스트에서 자주 출제되는 유형으로, 긴 지문을 차근차근 읽고 요구사항을 놓치지 않는 것이 중요하다. 시간 흐름에 따른 상태 변화, 여러 객체의 상호작용, 복잡한 이동 패턴 등을 정확히 모델링해야 한다.

<br>

**시간 복잡도**: 문제의 시뮬레이션 단계 수에 비례 (보통 O(시간 × 연산))<br>
**공간 복잡도**: O(격자 크기) 또는 O(상태 저장 공간)<br>

<br>

**로직 순서:**

1. 문제의 모든 규칙과 예외 상황을 정확히 파악
2. 시뮬레이션 한 단계를 구현하고 테스트
3. 방향 이동이 있는 경우 dx, dy 배열 활용
4. 상태 변화는 임시 배열을 사용해 동시 적용
5. 디버깅을 위해 중간 상태를 출력하는 함수 작성

<br>

| BOJ 문제번호 | 난이도     | 문제                                                            | 풀이 코드                                     |
| ------------ | ---------- | --------------------------------------------------------------- | --------------------------------------------- |
| 13335        | Silver 1   | [트럭](https://www.acmicpc.net/problem/13335)                   | [Java](./3_Simulation/BOJ_S1_13335/README.md) |
| 14503        | Gold 5     | [로봇 청소기](https://www.acmicpc.net/problem/14503)            | Java                                          |
| 20057        | Gold 3     | [마법사 상어와 토네이도](https://www.acmicpc.net/problem/20057) | Java                                          |
| 21611        | Gold 1     | [마법사 상어와 블리자드](https://www.acmicpc.net/problem/21611) | Java                                          |
| 23289        | Platinum 5 | [온풍기 안녕!](https://www.acmicpc.net/problem/23289)           | Java                                          |

<br>

## 4주차 (DP)

### 1차원 DP (Dynamic Programming)

| BOJ 문제번호 | 난이도   | 문제                                                      | 풀이 코드                            |
| ------------ | -------- | --------------------------------------------------------- | ------------------------------------ |
| 9095         | Silver 3 | [1,2,3 더하기](https://www.acmicpc.net/problem/9095)      | [Java](./4_DP/BOJ_S3_9095/README.md) |
| 2579         | Silver 3 | [계단 오르기](https://www.acmicpc.net/problem/2579)       | Java                                 |
| 11659        | Silver 3 | [구간 합 구하기 4](https://www.acmicpc.net/problem/11659) | Java                                 |
| 2302         | Gold 5   | [극장 좌석](https://www.acmicpc.net/problem/2302)         | Java                                 |
| 4883         | Silver 1 | [삼각 그래프](https://www.acmicpc.net/problem/4883)       | Java                                 |

<br>

## 5주차 (DP 심화)

### 2차원 DP

### Top-Down DP

### 트리 DP

| BOJ 문제번호 | 난이도 | 문제                                                  | 풀이 코드 |
| ------------ | ------ | ----------------------------------------------------- | --------- |
| 9251         | Gold 5 | [LCS](https://www.acmicpc.net/problem/9251)           | Java      |
| 9084         | Gold 5 | [동전](https://www.acmicpc.net/problem/9084)          | Java      |
| 1351         | Gold 5 | [무한 수열](https://www.acmicpc.net/problem/1351)     | Java      |
| 1937         | Gold 3 | [욕심쟁이 판다](https://www.acmicpc.net/problem/1937) | Java      |
| 1949         | Gold 2 | [우수 마을](https://www.acmicpc.net/problem/1949)     | Java      |

<br>

## 6주차 (그리디)

### 그리디 (Greedy Algorithm)

| BOJ 문제번호 | 난이도   | 문제                                                    | 풀이 코드 |
| ------------ | -------- | ------------------------------------------------------- | --------- |
| 11047        | Silver 4 | [동전 0](https://www.acmicpc.net/problem/11047)         | Java      |
| 1931         | Gold 5   | [회의실 배정](https://www.acmicpc.net/problem/1931)     | Java      |
| 2217         | Silver 4 | [로프](https://www.acmicpc.net/problem/2217)            | Java      |
| 1026         | Silver 4 | [보물](https://www.acmicpc.net/problem/1026)            | Java      |
| 1700         | Gold 1   | [멀티탭 스케줄링](https://www.acmicpc.net/problem/1700) | Java      |
| 8980         | Gold 1   | [택배](https://www.acmicpc.net/problem/8980)            | Java      |

<br>

## 7주차 (이분 탐색)

### 이분 탐색 (Binary Search)

| BOJ 문제번호 | 난이도   | 문제                                                 | 풀이 코드 |
| ------------ | -------- | ---------------------------------------------------- | --------- |
| 1920         | Silver 4 | [수 찾기](https://www.acmicpc.net/problem/1920)      | Java      |
| 10816        | Silver 4 | [숫자 카드 2](https://www.acmicpc.net/problem/10816) | Java      |
| 18870        | Silver 2 | [좌표 압축](https://www.acmicpc.net/problem/18870)   | Java      |
| 2295         | Gold 4   | [세 수의 합](https://www.acmicpc.net/problem/2295)   | Java      |
| 2412         | Gold 4   | [암벽 등반](https://www.acmicpc.net/problem/2412)    | Java      |
| 2473         | Gold 3   | [세 용액](https://www.acmicpc.net/problem/2473)      | Java      |

<br>

## 8주차 (자료구조)

### 이진 검색 트리

### 우선 순위 큐 (Priority Queue)

| BOJ 문제번호 | 난이도   | 문제                                                     | 풀이 코드 |
| ------------ | -------- | -------------------------------------------------------- | --------- |
| 7662         | Gold 4   | [이중 우선순위 큐](https://www.acmicpc.net/problem/7662) | Java      |
| 11286        | Silver 1 | [절댓값 힙](https://www.acmicpc.net/problem/11286)       | Java      |
| 1715         | Gold 4   | [카드 정렬하기](https://www.acmicpc.net/problem/1715)    | Java      |
| 1202         | Gold 2   | [보석 도둑](https://www.acmicpc.net/problem/1202)        | Java      |
| 1781         | Gold 2   | [컵라면](https://www.acmicpc.net/problem/1781)           | Java      |

<br>

## 9주차 (그래프와 트리)

### 그래프 (Graph)

### 트리 (Tree)

| BOJ 문제번호 | 난이도   | 문제                                                       | 풀이 코드 |
| ------------ | -------- | ---------------------------------------------------------- | --------- |
| 1260         | Silver 2 | [DFS와 BFS](https://www.acmicpc.net/problem/1260)          | Java      |
| 11725        | Silver 2 | [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)  | Java      |
| 1991         | Silver 1 | [트리 순회](https://www.acmicpc.net/problem/1991)          | Java      |
| 5214         | Gold 2   | [환승](https://www.acmicpc.net/problem/5214)               | Java      |
| 2250         | Gold 2   | [트리의 너비와 높이](https://www.acmicpc.net/problem/2250) | Java      |

<br>

## 10주차 (그래프 심화)

### 위상 정렬 (Topological Sort)

### 최소 신장 트리 (Minimum Spanning Tree)

| BOJ 문제번호 | 난이도   | 문제                                                     | 풀이 코드 |
| ------------ | -------- | -------------------------------------------------------- | --------- |
| 2252         | Gold 3   | [줄 세우기](https://www.acmicpc.net/problem/2252)        | Java      |
| 1197         | Gold 4   | [최소 스패닝 트리](https://www.acmicpc.net/problem/1197) | Java      |
| 9372         | Silver 4 | [상근이의 여행](https://www.acmicpc.net/problem/9372)    | Java      |
| 2637         | Gold 2   | [장난감 조립](https://www.acmicpc.net/problem/2637)      | Java      |
| 1368         | Gold 2   | [물대기](https://www.acmicpc.net/problem/1368)           | Java      |

<br>

## 11주차 (최단경로)

### 다익스트라 (Dijkstra)

### 플로이드-워셜 (Floyd-Warshall)

| BOJ 문제번호 | 난이도 | 문제                                                        | 풀이 코드 |
| ------------ | ------ | ----------------------------------------------------------- | --------- |
| 1753         | Gold 4 | [최단경로](https://www.acmicpc.net/problem/1753)            | Java      |
| 11779        | Gold 3 | [최소 비용 구하기 2](https://www.acmicpc.net/problem/11779) | Java      |
| 11780        | Gold 2 | [플로이드 2](https://www.acmicpc.net/problem/11780)         | Java      |
| 1238         | Gold 3 | [파티](https://www.acmicpc.net/problem/1238)                | Java      |
| 1719         | Gold 3 | [택배](https://www.acmicpc.net/problem/1719)                | Java      |
