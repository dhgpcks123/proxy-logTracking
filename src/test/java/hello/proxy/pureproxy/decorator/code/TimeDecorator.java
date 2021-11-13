package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private Component componet;

    public TimeDecorator(Component componet) {
        this.componet = componet;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator execute");
        long startTime = System.currentTimeMillis();
        String result = componet.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeDecorator 종료 resultTime = {}", resultTime);
        return result;
    }
}
