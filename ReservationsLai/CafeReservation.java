/**
 * CafeReservation represents a request for a table at a specific time slot.
 * March 9, 2020
 * Alex Lai
 */
public class CafeReservation extends Reservation {
    int numSeatsNeeded = 0; //The number of seats the customer desires.

    /**
     * Constructor.
     *
     * @param name Sent to the super class. Name of the customer.
     * @param timeSlot Sent to the super class, the desired timeSlot
     * @param numSeatsNeeded How many seats the customer desires.
     */
    public CafeReservation(String name, int timeSlot, int numSeatsNeeded) {
        super(name, timeSlot);
        this.numSeatsNeeded = numSeatsNeeded;
    }

    /**
     * The getScore method for Tables..
     * @param res The item.
     * @return -1 of item is not a table, 100 if perfect fit, 99-97 if good fit, 0 if no fit.
     */
    @Override
    public int getScore(ReservableItem res) {
        if (!(res instanceof Table))
            return -1; //Returns -1 if res is not an instance of Table
        Table theTable = (Table) res;
        if (theTable.getNumSeats() == numSeatsNeeded)
            return 100; //the table's number of seats match the customer's need exactly, return a score of 100.
        if (theTable.getNumSeats() > numSeatsNeeded)
            return 100 - (theTable.getNumSeats() - numSeatsNeeded); //Returns 99 - 97 depending on match
        return 0;
    }
}
