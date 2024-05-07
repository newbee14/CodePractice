package GeneralPractice.ModeratorPattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionModerator {
    List<Colleague> li= new ArrayList<>();


    public void placeBid(int amount, Bidder bidder) {
        li.stream().forEach(colleague -> {
            if(!colleague.equals(bidder))
                colleague.recieveBiddingNotification(amount);
        });
    }
}
