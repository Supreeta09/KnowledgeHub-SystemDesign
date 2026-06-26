import facade.RateLimiter;
import factory.RateLimiterFactory;
import model.RateLimitResponse;
import strategy.RateLimitingStrategy;

public class Main {
    public static void main(String[] args) {
        RateLimitingStrategy strategy = RateLimiterFactory.create("FIXED_WINDOW");

        RateLimiter rateLimiter = new RateLimiter(strategy);

        String userId = "user123";

        for (int i = 1; i<= 105; i++) {
            RateLimitResponse response = rateLimiter.handleRequest(userId);

            System.out.println(
                    "Request " + i +
                            " Response = " + response.toString());

            if (!response.isAllowed()) {
                break;
            }
        }
    }
}
