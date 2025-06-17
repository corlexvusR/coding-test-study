# [풀이 코드](./BOJ_S1_2178.java)

<br>

간단히 설명하자면 주어진 그래프의 (1, 1) 좌표에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 문제다. **그리고 Python으로는 쉽고 간결하게 풀 수 있는 문제가 다른 언어로 풀 때는 얼마나 풀기 싫게 만드는지 보여주는 문제이기도 하다.**

<br>

## `static` 키워드

Python 사용자에게는 낯설게도 Java로 알고리즘 문제를 풀 때는 `static` 키워드를 사용하게 된다.'static' 키워드는 **객체 생성 없이 메서드나 변수에 접근할 수 있게** 해준다. 예를 들어 Java의 `main` 메서드는 프로그램의 진입점으로서 반드시 `static`이어야 한다. `static` 메서드는 같은 클래스의 static 멤버들만 직접 접근할 수 있다. 만약 변수들이 `static`이 아니고 `main`에서 이 변수들을 사용하려면 다음과 같이 객체를 생성하고 접근해야 한다.

```java
Main instance = new Main();
instance.N = 5;
instance.bfs(0, 0);
```

알고리즘 문제를 풀 때는 이러한 객체 생성의 번거로움 없이 바로 변수와 메서드를 사용하기 위해서, 모든 것을 `static`으로 선언하게 된다.

<br>

## Python과 달리 Node 데이터 구조를 만든 이유

Python에서는 다음과 같이 큐를 사용할 때 튜플이나 리스트로 좌표를 간단히 표현할 수 있었다.

```python
queue.append((y, x))
y, x = queue.pop(0)
```

하지만 Java는 강타입 언어이기 때문에, 좌표를 표현하기 위한 데이터 구조가 필요하다. 이 문제에서 `Node` 클래스는 x, y 좌표를 하나로 묶어서 큐에 저장하고 전달하는 역할을 한다.

<br>

```java
public static class Node {
    int x, y;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
```

<br>

그리고 이 데이터 구조를 다른 클래스에서도 접근할 수 있도록 `public`으로 선언했고, 외부 클래스의 인스턴스 없이도 생성할 수 있도록 `static`으로 선언했다.

<br>

## BFS 알고리즘의 로직

당연하게도 Python을 사용할 때와 Java를 사용할 때의 BFS 로직은 같다.
이 문제의 핵심은 BFS를 사용해 최단 거리를 구하는 것이었다. 그래서 다음과 같이 `map` 배열을 방문 거리로 업데이트했다.

```java
map[next_y][next_x] = map[now.y][now.x] + 1;
```

BFS 과정에서 이러한 방식을 사용하면 각 칸은 시작점부터 지금 칸의 최단 거리를 저장하게 된다. Python에서도 같은 방식을 사용할 수 있다.

<br>

## 방향 벡터 활용

Python에서 내가 주로 방향벡터를 정의하고 사용하는 방식은 다음과 같다.

```python
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
```

```python
for dy, dx in directions:
    next_y = now_y + dy
    next_x = now_x + dx
```

정말로 Pythonic 한 방식이 아닐 수 없다! <br>
하지만 당연하게도 Java에서는 이러한 방식을 쓰지 못한다. Java에서는 다음과 같은 방식을 사용한다. 패턴은 같지만 역시나 Python만큼 우아하지는 않다.

```java
static int[] dy = {-1, 1, 0, 0};
static int[] dx = {0, 0, -1, 1};
```

```java
for (int direction = 0; direction < 4; ++direction) {
    int next_y = now.y + dy[direction];
    int next_x = now.x + dx[direction];
```

<br>

## 경계 조건 검사

Python에서 경계 조건 검사는 다음과 같이 간결하게 할 수 있었다.

```python
0 <= next_y < N and 0 <= next_x < M
```

하지만 Java에서는 논리연산자가 Python과 다르고 연쇄비교도 불가능하다. 그러므로 다음과 같이 각각을 명시적으로 비교해야 한다.

```java
boolean is_possible_location = (0 <= next_y && next_y < N && 0 <= next_x && next_x < M);
```
