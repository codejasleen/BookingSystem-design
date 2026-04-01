**Class-Design**

<img width="987" height="421" alt="BookingSystem1 drawio" src="https://github.com/user-attachments/assets/2761e897-dc31-4583-84bd-955759a90f70" />

Core Design
-A City contains multiple Theatres
-Each Theatre has multiple Screens
-Each Screen contains multiple Seats
-A Show represents a movie running on a screen at a specific time
-ShowSeat is used to track seat availability for a particular show

**Overview **

Key Design Decisions
1. ShowSeat Abstraction

Instead of directly using Seat, we use ShowSeat to manage availability per show.
This ensures the same seat can be booked for different shows independently.

2. Seat Locking Mechanism

To prevent double booking:

Seat transitions: AVAILABLE - LOCKED - BOOKED
Seats are temporarily locked during payment
If payment fails or times out, seats are released
3. Booking Flow
User selects seats
System locks selected seats
Payment is processed
On success - booking confirmed
On failure - seats released
4. Payment Strategy Pattern

Payment is handled using a strategy pattern, allowing support for multiple methods like:

Credit Card
UPI

Highlights
Prevents race conditions using seat locking
Clean separation of entities and services
Scalable and extensible design
