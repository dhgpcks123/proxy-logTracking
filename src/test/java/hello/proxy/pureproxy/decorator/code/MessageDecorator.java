package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private Component componet;

    public MessageDecorator(Component componet) {
        this.componet = componet;
    }

    @Override
    public String operation() {
        log.info("MessegeDecorator execute");

        String result = componet.operation();
        String decoResult = "*****" + result + "*****";
        log.info("MessageDecorator 꾸미기 전 ={}, 꾸미기 후 = {}", result, decoResult);
        return decoResult;
    }
}
