package base;

public class MyClosableResource implements AutoCloseable {

    @Override
    public void close() {

        throw new Execption01("in close");
    }
}
