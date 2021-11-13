package hello.proxy.pureproxy.decorator.decoratorAbstract;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator {

    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("Abstract MessegeDecorator execute");

        String result = component.operation();
        String decoResult = "*****" + result + "*****";
        log.info("Abstract MessageDecorator 꾸미기 전 ={}, 꾸미기 후 = {}", result, decoResult);
        return decoResult;
    }
}
