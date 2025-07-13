# [풀이 코드](./BOJ_S1_13335.java)

<br>

'트럭'은 제한된 크기의 큐(Buffer) 시뮬레이션에 무게 제약 조건이 더해진 문제이다. 다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구해야 한다.

<br>

## 우선순위 큐

우선 다리에 트럭이 하나도 없는 상태를 큐에 무게가 0인 트럭이 차있는 상태로 가정하고 문제를 풀었다. 이는 큐 사용을 쉽게 만들어준다.

```java
Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < w; ++i) {
    q.offer(0);
}
```

<br>
이 문제에서 사용하는 추가 변수는 다음과 같다.

```java
int time = 0;
int now_weight = 0;
int next_truck_index = 0;
```

- time: 현재까지 흐른 시간
- now_weight: 현재 다리 위에 있는 트럭들의 총 무게
- next_truck_index: 다음에 다리에 진입할 트럭의 인덱스

<br>

시뮬레이션 과정은 다음과 같다.

```java
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
```

while 반복문으로 시간의 흐름에 따라 트럭이 다리를 건너는 것을 시뮬레이션한다. 반복문은 모든 트럭이 다리에 진입할 때까지 반복된다. 매 시간 단위마다 다음과 같은 과정을 거친다.

1. 시간 증가: time += 1
2. 트럭 나가기: 다리 맨 앞의 트럭(또는 빈 공간)이 나가고, 해당 무게만큼 현재 하중에서 빼기
3. 트럭 진입 판단:
   - 다음 트럭이 진입해도 최대 하중을 초과하지 않으면 → 트럭 진입
   - 그렇지 않으면 → 빈 공간(0) 추가

반복문 종료 후 time += w는 마지막으로 다리에 진입한 트럭이 완전히 다리를 건너는 시간을 추가한다.

<br>
이렇게 큐의 크기를 다리 길이로 고정하고, 매 시간마다 한 칸씩 이동하는 것을 시뮬레이션하여 트럭의 이동과 무게 제약을 동시에 관리한다.

<br>
