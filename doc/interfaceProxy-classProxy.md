# 인터페이스 기반 프록시와 클래스 기반 프록시

프록시 덕분에 원본 코드 수정하지 않고 애플리케이션에 LogTrace 로그 추적기 기능을 사용할 수 있었다.

인터페이스 없어도 클래스 기반으로 상속해서 프록시 생성할 수 있었다.
클래스는 상속한 한 클래스에만
인터페이스는 인터페이스를 구현한 모든 곳에 적용할 수 있다.
마치 체인 처럼 사용이 가능하다.

클래스 기반 프록시 상속의 제약
- 부모 클래스 생성자를 호출해야한다.
- 클래스에 final 키워드가 붙으면 상속 불가능
- 메서드에 final 키워드가 붙으면 해당 메서드 오버라이딩 불가능.

인터페이스 기반 상속 제약에서 자유롭다.
하지만... 인터페이스 만들어야해. ㅠㅠ

역할과 구현 나누어서 구현체를 편리하게 변경할 수 있다.
하지만 실제로는 구현을 거의 변경할 일이 없는 클래스도 많다.
구현 변경 가능성 있는 곳에 인터페이스 쓰고, 그냥 클래스 기반으로 할 수 도 있음.

실무에서는 Controller, Service Repository
컨트롤러는 그냥 사용하잖아. 구체 클래스로 사용할 수도 있겠지?

근데 문제는 뭐야?
너무 많은 프록시 클래스를 만들어야 함.
지금까지 프록시를 사용해서 기존 코드를 변경하지 않고, 로그 추적기라는 부가 기능이 적용 가능했다.
하지만 프록시 클래스를 너무 많이 만들어야 한다. LogTrace..만 쓰는건데 로직도 너무 많고.
만약 클래스가 100개면 프록시 클래스도 100개 만들어야 한다.

원 코드에 손을 안 대도 되지만... 역시 100번 반복하는 작업을 해야하는 건 다르지 않다.

### 여기서 동적 프록시 기술이 이 문제를 해결해준다.
