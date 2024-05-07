package GeneralPractice.ModeratorPattern;

public interface Colleague {
    int placeBidAmount(int amount);
    void recieveBiddingNotification(int amount);
    String getName();
}
