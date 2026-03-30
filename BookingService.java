import java.util.List;

public class BookingService {
    SeatLockService seatLockService;

    public Booking createBooking(List<ShowSeat> seats) {

        //Lock seats
        for (ShowSeat seat : seats) {
            if (!seatLockService.lockSeat(seat)) {
                throw new RuntimeException("Seat not available");
            }
        }

        // Step 2: Calculate price
        double total = 0;
        for (ShowSeat seat : seats) {
            total += seat.price;
        }

        Booking booking = new Booking();
        booking.seats = seats;
        booking.amount = total;
        booking.status = BookingStatus.pending;

        return booking;
    }

    public void confirmBooking(Booking booking) {
        for (ShowSeat seat : booking.seats) {
            seat.status = SeatStatus.booked;
        }
        booking.status = BookingStatus.confirmed;
    }

    public void failBooking(Booking booking) {
        for (ShowSeat seat : booking.seats) {
            seat.status = SeatStatus.available;
        }
        booking.status = BookingStatus.failed;
    }
}
