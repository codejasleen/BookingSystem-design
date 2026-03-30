public class ShowSeat {
    int id;
    int showId;
    int seatId;
    double price;
    SeatStatus status;
    long lockTine;
     long lockTime;
    public ShowSeat(int id, int showId, int seatId, double price) {
        this.id = id;
        this.showId = showId;
        this.seatId = seatId;
        this.price = price;
        this.status = SeatStatus.available;
    }

}
