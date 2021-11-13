package hello.proxy.pureproxy.decorator.decoratorAbstract;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatterAddAbstractTest {

    @Test
    void noDecorator(){
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatterClient client = new DecoratorPatterClient(timeDecorator);
        client.execute();
    }
}
