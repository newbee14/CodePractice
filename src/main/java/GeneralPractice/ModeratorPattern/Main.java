package GeneralPractice.ModeratorPattern;

public class Main {
    public static void main(String[] args) {
        AuctionModerator auctionModerator= new AuctionModerator();

        Colleague c1= new Bidder("B1", auctionModerator);
        Colleague c2= new Bidder("B2", auctionModerator);
        Colleague c3= new Bidder("B3", auctionModerator);
        Colleague c4= new Bidder("B4", auctionModerator);

        c1.placeBidAmount(40);
        c2.placeBidAmount(10);
        c3.placeBidAmount(50);
        c1.placeBidAmount(100);

    }
}
