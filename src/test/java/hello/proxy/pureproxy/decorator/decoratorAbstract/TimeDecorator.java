package hello.proxy.pureproxy.decorator.decoratorAbstract;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator extends Decorator{

    public TimeDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("Abstract TimeDecorator execute");
        long startTime = System.currentTimeMillis();
        String result = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeDecorator 종료 resultTime = {}", resultTime);
        return result;
    }
}
