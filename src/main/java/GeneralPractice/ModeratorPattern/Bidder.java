package GeneralPractice.ModeratorPattern;

public class Bidder implements  Colleague{
    String name;
    int bidAmount;
    AuctionModerator auctionModerator;

    Bidder(String name, AuctionModerator auctionModerator){
        this.name=name;
        this.auctionModerator=auctionModerator;
        auctionModerator.li.add(this);
    }

    @Override
    public int placeBidAmount(int amount) {
        this.bidAmount=amount;
        auctionModerator.placeBid(amount,this);
        return amount;
    }

    @Override
    public void recieveBiddingNotification(int amount) {
        System.out.println("Call from "+name+" New bid amount placed "+ amount);

    }

    @Override
    public String getName() {
        return name;
    }
}
