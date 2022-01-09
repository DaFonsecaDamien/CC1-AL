package fr.esgi.al.kernel;

public final class ApplicationLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
