package riddle2;

public class ErrorTweet implements ErrorObserver {
    @Override
    public void error(String message) {
        System.out.println("TWEET: " + message);
    }
}
