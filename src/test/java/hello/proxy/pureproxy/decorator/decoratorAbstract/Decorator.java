package hello.proxy.pureproxy.decorator.decoratorAbstract;

public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
