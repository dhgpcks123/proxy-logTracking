package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.DecoratorPatterClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatterTest {

    @Test
    void noDecorator(){
        RealComponent realComponent = new RealComponent();
        DecoratorPatterClient client = new DecoratorPatterClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatterClient client = new DecoratorPatterClient(messageDecorator);
        client.execute();
    }
}
