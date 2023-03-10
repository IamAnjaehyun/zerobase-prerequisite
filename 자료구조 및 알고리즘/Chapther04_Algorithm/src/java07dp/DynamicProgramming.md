> 다이나믹 프로그래밍(DP) , 동적 계획법
- 큰 문제를 부분 문제로 나눈 후 답을 찾아가는 과정에서, 계산된 결과를 기록하고 재활용하며 문제의 답을 구하는 방식
- 중간 계산 결과를 기록하기 위한 메모리가 필요
- 한 번 계산한 문제를 다시 계산하지 않아 속도가 빠름

> 다른 알고리즘과의 차이점
- 분할 정복과의 차이
  - 분할 정복은 부분 문제가 중복되지 않음
  - DP는 부분 문제가 중복되어 재활용에 사용
- 그리디 알고리즘과의 차이
  - 그리디 알고리즘은 순간의 최선을 구하는 방식(근사치)
  - DP는 모든 방법을 확인 후 최적해 구하는 방

> 다이나믹 프로그램 방법
- 타뷸레이션(Tabulation)
  - 상향식 접근 방법
  - 작은 하위 문제부터 풀면서 올라감
  - 모두 계산하며서 차례대로 진행

- 메모이제이션(Memoization)
  - 하향식 접근 방법
  - 큰 문제에서 하위 문제를 확인해가며 진행
  - 계산이 필요한 순간 계산하며 진행 