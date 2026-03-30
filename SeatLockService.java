import java.util.HashMap;
import java.util.Map;

public class SeatLockService {
    Map<Integer, Long> lockedSeats = new HashMap<>();
    long LOCK_TIMEOUT = 300; // seconds

    public boolean lockSeat(ShowSeat seat) {
        if (seat.status != SeatStatus.available) return false;

        seat.status = SeatStatus.locked;
        seat.lockTime = System.currentTimeMillis();

        return true;
    }

    public void unlockSeat(ShowSeat seat) {
        seat.status = SeatStatus.available;
}
public void validateLock(ShowSeat seat) {
        if (seat.status == SeatStatus.locked &&
            (System.currentTimeMillis() - seat.lockTime) > LOCK_TIMEOUT * 1000) {
            seat.status = SeatStatus.available;
        }
    }
}
