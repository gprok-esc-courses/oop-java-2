package observer;

public class ErrorEmail implements ErrorObserver {
    @Override
    public void error(String message) {
        System.out.println("... sending email ... with message: " + message);
    }
}
