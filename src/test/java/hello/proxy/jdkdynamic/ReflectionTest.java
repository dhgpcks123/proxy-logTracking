package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0(){
        Hello target = new Hello();

        //공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result = {}", result1);
        //공통 로직1 종료

        //공통 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result = {}", result2);
        //공통 로직2 종료

        //로직1과 로직2는 호출하는 메서드만 다름
        //리플렉션은 클래스나 메서드의 정보를 받아서 사용함.
        //요즘엔 람다로 해결. 리플렉션 학습해봅시다.
    }

    @Test
    void reflection1() throws Exception {
        //클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        //callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);

        log.info("result1={}", result1);

        //callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);

        log.info("result2={}", result2);

    }

    @Test
    void reflection2() throws Exception{
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);

        /**
         * 주의 : 리플렉션을 사용해서 메타 정보 사용해서 애플리케이션 동적으로 만들 수 있다.
         * 하지만 리플렉션은 런타임에 동작하기 떄문에(문자 넣었잖아) 컴파일 시점에서는... 오류를 알 수 없다.
         * 서비스 할 때 오류가 나타날 수 있다는 것.
         * 그래서 일반적으로 잘 사용 안 한다... 프로그래밍 언어는 타입 정보를 기반으로
         * 컴파일 시점에 오류를 잡는 게 큰 이점인데 리플렉션은 역행하는 방식이다.
         */

    }

    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result ={}", result);
    }

    @Slf4j
    static class Hello {
        public String callA(){
            log.info("call A");
            return "A";
        }
        public String callB(){
            log.info("call B");
            return "B";
        }
    }
}
