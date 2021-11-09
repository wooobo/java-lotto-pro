# 3단계 - 로또(자동)

## 3단계 실습 시작

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 힌트

- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### 기능 목록

1. 구입 금액을 입력 받는다
    1. "구입금액을 입력해 주세요." 출력한다.
    2. 숫자만 입력 가능하다.
2. 로또는 개당 1000원이므로 구입 할 수 있는 만큼 로또 번호를 자동생성한다.
    1. 구입금액 / 1000원으로 총 구매가능 갯수를 구한다.
    2. 로또번호(6개)를 생성하고, 구매가능 갯수만큼 반복한다.
        1. 로또 리스트가 생성된다.
3. 구매된 로또번호 리스트를 출력한다.
4. 지난 주 당첨 번호를 입력 받는다
    1. 6개 숫자로 이루어진 리스트다.
    2. 6자리의 "," 로 분리되게 입력받아야한다.
    3. 문자가 있으면 다시 입력요구한다.
    4. 숫자가 6개가 아니면 예외처리한다.
    5. 1-45 범위에 대한것도 여기서 해야할까?
5. 자동생성 로또번호와 비교하여 당첨을 계산한다
    1. 1등:6개, 2등:5개, 3등:4개, 4등 3개 그 외는 당첨없음 이다.
    2. 1등 부터 4등까지는 다른 상금을 가진다.
    3. 총 상금은 해당등수 상금 * 해당등수 일치 갯수 이다.
    4. 수익률 총상금 / 구입한 총비용 이다.
6. 당첨 통계를 출력한다.


- 로또번호 생성
    - [X] 1-45의 숫자를 가지는 로또번호 객체생성
    - [X] 로또번호를 가지는 LottoNumbers 객체생성(6개의 로또번호를 가짐, 중복 X)
    - [X] 구입금액에 가능한 로또 최대 구매수 구하기
    - [X] 최대 구매수 만큼 로또 목록 생성하기
    - [X] 랜덤 로또 숫자 생성
    - [X] 구매후 불변객체로 수정불가 리턴하기
- 서비스
    - [X] 컨트롤러 - 도메인 연결 서비스 만들기
    - [X] 컨트롤러에서 사용할 Dto 만들기
- 로또 당첨 결과
    - [X] 지난 주 로또 번호와 비교하여 일치 카운팅하기
    - [X] 당첨결과 당첨금액구하기
    - [X] 총 당첨금액과 구입금액에 대한 총 수익률 구하기
- InputView
    - [X] 사용자에게 로또 구매 금액 입력받기
    - [X] 지난 주 당첨 번호 입력 받기
- ResultView
    - [X] 로또 번호 목록 출력
    - [X] 당첨 통계 출력

# 4단계 - 로또(2등)

## 추가된 요구 사항 정리

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.

## 힌트 정리

- 일급 콜렉션을 쓴다.
    - 6개의 숫자 값을 가지는 java collection 을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum 을 활용해 상수 값을 제거한다. 즉, enum 을 활용해 일치하는 수를 로또 등수로 변경해 본다.

## 4 단계 기능 목록

- [X] 보너스 숫자한개 입력받기
- [X] LottoRank 보너스 숫자 추가
- [X] LottoRank 2등은 5개 일치 + 보너스볼 일치로 변경된 부분으로 로직 변경하기
- [X] View static 메소드로 변경하여 인스턴스 변수를 줄여보기,
  `Utility Class`로 `pricate` 생성자하여 불필요한 인스턴스화 막기
- [X] Amount 에 대해 검증로직 추가하기
- [X] 불필요한 코드 제거하기 (LottoProviderStrategy)
- [X] RandomNumbers.java 초기화 블럭
  적용하기 [참고 링크](https://velog.io/@tomato2532/%EC%B4%88%EA%B8%B0%ED%99%94-%EB%B8%94%EB%9F%AD%EA%B3%BC-%EC%83%9D%EC%84%B1%EC%9E%90)
- [X] DTO 개선하기
- [X] `lottoRanksOf`() 테스트 추가
- [X] LottoNumbers 에서 불필요한 NumbersStrategy 사용 제거
- [X] Dto 정리 하면서 Controller, Service, View 통합 리팩토링 진행
- [X] 도메인 객체 테스트 코드 추가 및 개선

# 5단계 - 로또(수동)

## 추가된 요구 사항 정리

- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 5 단계 기능 목록

- [X] 수동 구매 갯수 받기
- [X] 수동 로또 번호 받기
- [X] Amount 에서 수익률 계산 추가
- [X] validBonus 중복 검증코드 제거
- [X] WinningLotto 추가 (지난주 우승 로또번호, 보너스볼)
- [ ] LottoRanks -> LottoResult 고민해보기
- [X] view,controller,service 플로우 리팩토링

### 프로젝트 구조

```text

 |-controller
   |-LottoController.java                   // 로또 진행 컨트롤러
   
 |-dto
   |-LottoWinNumbersRequestDto.java         // 지난주 우승 로또 번호 
   |-LottoBonusNumberRequestDto.java        // 보너스 로또 번호
   |-LottoBuyRequestDto.java                // 주문할 금액
    
   |-LottoBuyResponseDto.java               // 구입한 로또목록
   |-LottoStatisticsResponseDto.java        // 로또 당첨 통계
   |-LottoResultDto.java                    // 로또 당첨 통계 세부 데이터
 
 |-common
   |-exception                     // 커스텀 exception
     |-BaseException.java
     |-InvalidParamException.java
     |-ErrorMessage.java
 
 |-service
   |-LottoServiceImpl.java      // LottoService.java 구현체
 
 |-view                         // UI
   |-InputView.java 
   |-ResultView.java
 
 |-domain
   |-Amount.java                // 주문금액 객체
   |-LottoNumber.java           // 1-45숫자를 가지는 객체
   |-LottoNumbers.java          // LottoNumber 일급 콜렉션
   |-LottoNumbersBundle.java    // LottoNumbers 일급 콜렉션, 로또랭킹 계산 수행

   |-LottoRank.java             // 등수별 일치갯수와 당첨금 ENUM
   |-LottoRanks.java            // LottoRank 일급컬렉션, 등수별 당첨갯수 카운팅
        |- CountDown            // Rank 별 당첨 카운트
        |- LottoRankResult      // 인스턴스 변수 : LottoRank(Enum), winningCount(LottoRank 의 당첨갯수) 
  
   |-LottoProvider.java         // 로또구입 과 당첨결과(LottoResult) 수행
   |-LottoResult.java           // 총 수익금액 과 수익률 계산, LottoRanks 를 가짐
   |-LottoService.java          // 로또구입, 통계결과 메소드를 가지는 인터페이스
   |-strategy
     |-numbers
       |-RandomLottoNumbers.java // 로또자동번호 생성기(NumbersStrategy 구현체)
       |-NumbersStrategy.java    // getNumbers() 메소드를 가지는 인터페이스

```
