package hello.proxy.pureproxy.decorator.decoratorAbstract;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {

    @Override
    public String operation() {
        log.info("Abstract RealComponent execute");
        return "data";
    }
}
