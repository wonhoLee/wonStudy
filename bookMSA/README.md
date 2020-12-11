# 마이크로 서비스 패턴
---
## 2장 분해전략
### 2.1
### 2.2 마이크로서비스 아키텍처 정의
- 아키텍쳐 정의
  - 1단계 : 애플리케이션 요건을 핵심 요청으로 추출
  - 2단계 : 어떻게 여러 서비스로 분해할지 결정 하는 것
  - 3단계 : 서비스별로 API를 정의 하는 일
- 분해과정 장애물
  - 네트워크 지연(network latency)
  - 서비스 간 동기 통신으로 인해 가용성이 떨어지는 문제
    - 해결책 : 자기 완비형 서비스(self-contained service)(3장)
  - 데이터 일관성 지키기
    - 해결책 : 사가(4장)
  - 만능 클래스
    - 해결책 : DDD 개념
#### 2.2.1 시스템 작업 식별
- 시스템 작업 정의
- 사용자 스토리와 사용자 시나리오등의 애플리케이션 요건
- 1단계 : 고수준의 도메인 모델을 생성
- 2단계 : 도메인 모델 관점에서 기술
#### 2.2.2 서비스 정의: 비즈니스 능력 패턴별 분해
- 1 : 비즈니스 능력에 따라 분해하는 것
- 비즈니스 능력은 곧 조직이 하는 일이다
- 비즈니스 능력 식별
- 비즈니스 능력을 여러 서비스로
#### 2.2.3 서비스 정의: 하위 도메인 패턴별 분해
- DDD
  - 하위 도메인(sub-domain)
  - 경계 컨텍스트(bounded context)
#### 2.2.4 분해 지침
- 단일 책임 원칙(SRP, Single Responsibility Principle)
- 공동 폐쇄 원칙(CCP, Common Closure Principle)
#### 2.2.5 서비스 분해의 장애물
- 네트워크 지연
  - 해결책
    - 한 차례 왕복으로 여러 객체를 한 번에 가져오는 배치 API
    - 값비싼 IPC를 언어 수준의 메서드나 함수 호출로 대체하는 식
- 동기 IPC로 인한 가용성 저하
  - 비동기 메시징(3장)
- 여러 서비스에 걸쳐 데이터 일관성 유지
- 일관된 데이터 뷰 확보
- 만능 클래스는 분해의 걸림돌
#### 2.2.6 서비스 API 정의
- 시스템 작업을 서비스로 배정
- 서비스 간 협동 지원에 필요한 API 확정
---
## 3장 프로세스 간 통신
### 3.1 마이크로서비스 아키텍처 IPC 개요
#### 3.1.1 상호 작용 스타일
- 일대일 / 일대다 여부
- 동기 / 비동기 여부
- 일대일
  - 요청/응답(request / response)
  - 비동기 요청/응답(asynchronous request / response)
  - 단방향 알림(one-way notification)
- 일대다
  - 발행/구독(publish/subscribe)
  - 발행/비동기 응답(publish/async response)
#### 3.1.2 마이크로서비스 API 정의
#### 3.1.3 API 발전시키기
- 시맨틱 버저닝(Semvers, Semantic Versioning specification)
  - MAJOR : 하위 호환되지 않는 변경분
  - MINOR : 하위 호환되는 변경분
  - PATCH : 하위 호환 되는 오류 수정
- 하위 호환되는 소규모 변경
- 중대한 대규모 변경
#### 3.1.4 메시지 포맷
- 텍스트 메시지 포맷 : JSON, XML
- 이진 메시지 포맷 : 프로토콜 버퍼, 아브로

### 3.2 동기 RPI 패턴 응용 통신
#### 3.2.1 동기 RPI 패턴 : REST
- REST 성숙도 모델
  - 레벨 0 : 서비스별 유일한 URL 끝점에 HTTP POST요청을 하여 서비스를 호출
  - 레벨 1 : 서비스는 리소스 개념을 지원
  - 레벨 2 : 서비스는 HTTP 동사(GET, POSt, PUT 등) 를 이용해서 액션을 수행
  - 레벨 3 : HATEOAS(Hypertext As The Engine Of Application State) 원칙에 기반하여 설계
    - HATEOAS : GET 요청으로 반환딘 리소스 표현형에 그 리소스에 대한 액션의 링크도 함께 태워 보내자는 생각
- REST API : Swagger
- 요청 한 번으로 많은 리소스를 가져오기 어렵다
- 작업을 HTTP 동사에 매핑하기 어렵다
- REST의 장단점
#### 3.2.2 동기 RPI 패턴: gRPC
#### 3.2.3 부분 실패 처리: 회로 차단기 패턴
- 견고한 RPI 프록시 설계
  - 네트워크 타임아웃
  - 미처리 요청개수 제한
  - 회로 차단기 패턴
- 불능 서비스 복구
#### 3.2.4 서비스 디스커버리
- 서비스 디스커버리 개요
  - 애플리케이션 서비스 인스턴스의 네트워크 위치를 DB화한 서비스 레지스트리
- 애플리케이션 수준의 서비스 디스커버리 패턴 적용 (스프링 클라우드 등)
  - 첫째, 자가 등록 패턴
  - 둘째, 클라이언트 쪽 디스커버리 패턴
- 플랫폼에 내장된 서비스 디스커버리 패턴 적용 (필자 권장)

### 3.3 비동기 메시징 패턴 응용 통신
#### 3.3.1 메시징 개요
- 메시지 : 헤더와 본문으로 구성
  - 메시지 종류 : 문서, 커맨드, 이벤트
- 메시지 채널 : 메시지는 채널을 통해 교환
  - 점대점 채널, 발행구독 채널
#### 3.3.2 메시징 상호 작용 스타일 구현
- 요청/응답 및 비동기 요청/응답
- 단방향 알림
- 발행/구독
- 발행/비동기 응답
#### 3.3.3 메시징 기반 서비스의 API 명세 작성
- 비동기 작업 문서화
  - 요청/비동기 응답 스타일 API
  - 단방향 알림 스타일 API
- 발행 이벤트 문서화
#### 3.3.4 메시지 브로커
- 서비스가 서로 통신할 수 있게 해주는 인프라 서비스
- 브로커리스 메시징 : 메시지를 서로 직접 교환
- 브로커 기반 메시징 개요
  - 모든 메시지가 지나가는 중간 지점
- 메시지 브러커로 메시지 채널 구현
- 브로커 기반 메시징의 장단점
  - 장점
    - 느슨한 결합
    - 메시지 버퍼링
    - 유연한 통신
    - 명시적 IPC
  - 단점
    - 성능 병목 가능성
    - 단일 장애점 가능성
    - 운영 복잡도 부가
#### 3.3.5 수신자 경합과 메시지 순서 유지
- 샤딩된 채널을 이용
  - 1.  샤딩된 채널은 복수의 샤드로 구성, 각 샤드는 채널처럼 작동
  - 2. 송신자는 메시지 헤더에 샤드 키를 지정
       - 메시지 브로커는 메시지를 샤드 키별로 샤드/파티션에 배정
  - 3. 메시징 브로커는 여러 수신자 인스턴스를 묶어 마치 동일한 논리 수신자처럼 취급
    - 메시지 브로커는 각 샤드를 하나의 수신자에 배정, 수신자가 시동/종료하면 샤드를 재배정
#### 3.3.6 중복 메시지 처리
- 멱등한(idempotent) 메시지 핸들러 작성
- 메시지 추적과 중복 메시지 솎아 내기
#### 3.3.7 트랜잭셔널 메시징
- DB 테이블을 메시지 큐로 활용
- 이벤트 발행 : 폴링 발행기 패턴
- 이벤트 발행 : 트랜잭션 로그 테일링 패턴
#### 3.3.8 메시징 라이브러리/ 프레임워크

### 3.4 비동기 메시징으로 가용성 개선
#### 3.4.1 동기 통신으로 인한 가용성 저하
#### 3.4.2 동기 상호 작용 제거
- 비동기 상호 작용 스타일

## 4장 트랜잭션 관리 : 사가
### 4.1 마이크로서비스 아키텍처에서의 트랜잭션 관리
#### 4.1.1 분산 트랜잭션의 필요성
#### 4.1.2 분산 트랜잭션의 문제점
#### 4.1.3 데이터 일관성 유지: 사가 패턴
- 사가와 ACID 트랜잭션은 두 자기 중요한 차이점
  - ACID 트랜잭션에 있는 격리성이 사가에는 없음
  - 사가는 로컬 트랜잭션마다 변경분을 커밋하므로 보상 트랜잭션을 걸어 롤백
- 사가는 보상 트랜잭션으로 변경분을 롤백한다
### 4.2 사가 편성
- 코레오그래피(choreography) : 의사 결정과 순서화를 사가 참여자에게 맡김. 사가 참여자는 주로 이벤트 교환 방식으로 통신
- 오케스트레이션(orchetration) : 사가 편성 로직을 사가 오케스트레이터에 중앙화. 사가 오케스트레이터는 사가 참여자에게 커맨드 메시지를 보내 수행할 작업을 지시
#### 4.2.1 코레오그래피 사가