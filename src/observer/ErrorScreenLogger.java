package observer;

/**
 * Prints error message to the command line
 */
public class ErrorScreenLogger implements ErrorObserver {

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
