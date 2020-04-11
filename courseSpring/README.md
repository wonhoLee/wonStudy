# 예제로 배우는 스프링 입문

## CH5 - Inversion of Control
- https://www.youtube.com/watch?v=NZ_lPFvu9oU&list=PLfI752FpVCS8_5t29DWnsrL9NudvKDAKY&index=5
- https://martinfowler.com/articles/injection.html
- 의존성관리를 사용할 클래스가 아닌 외부에서 선언해서 전달해줌
- 빈 : 스프링이 관리하는 객체

## CH6 - Ioc 컨테이너
- https://www.youtube.com/watch?v=NOAajiABq6A&list=PLfI752FpVCS8_5t29DWnsrL9NudvKDAKY&index=6
- ApplicationContext <- BeanFactory 상속
- Ioc 컨테이너 : Bean 을 만들고 엮어주며 제공
- 의존성주입은 Bean 끼리만 가능
- Bean은 싱글톤Scope 로 사용

## CH7 - bean
- https://www.youtube.com/watch?v=qaIQfl0ob84&list=PLfI752FpVCS8_5t29DWnsrL9NudvKDAKY&index=7
- Ioc 컨테이너가 관리하는 객체
- Component Scanning
  - @Component
    - @Repository
    - @Service
    - @Controller
    - @Configuration

## CH8 - 의존성 주입(Dependency Injection)
- https://www.youtube.com/watch?v=IVzYerodIyg&list=PLfI752FpVCS8_5t29DWnsrL9NudvKDAKY&index=8
- 생성자 / setter / 필드
- 생성자 @Autowired spring 4.3 에서 삭제가능해짐
- 생성자
  - 필요한 Bean 강제할수 있음
  - 순환참조 발생 방지

## CH9 - AOP
- https://www.youtube.com/watch?v=GeLBZ-Fe38s&list=PLfI752FpVCS8_5t29DWnsrL9NudvKDAKY&index=9
- Spring 3가지 주요개념
  - IOC // AOP // PSA