package kernel;

public class ApplicationLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
