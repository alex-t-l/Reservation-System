import java.util.ArrayList;

/**
 * This class represents an item that can be reserved.
 * Alex Lai
 * March 9, 2020
 */
abstract public class ReservableItem {
    protected boolean[] timeSlots = new boolean[10]; //The 10 time slots that can be reserved/requested by the user.
    protected String ID;

    /**
     * @return the ID.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Changes a timeSlot to taken.
     *
     * @param t timeslot.
     */
    public void reserveTime(int t) {
        timeSlots[t] = true;
    }

    /**
     * @param t time slot
     * @return Whether or not a time slot is taken.
     * @throws RuntimeException If an invalid time slot is passed in.
     */
    public boolean isAvailable(int t) throws RuntimeException {
        if (t > 9 || t < 0)
            throw new RuntimeException(t + " is not a valid reservation slot, choose 0 to 9.");
        if(timeSlots[t] == false) 
            return true; //If timeslot is to false, then it is available- since false is a boolean's default value.
        else
            return false; //Otherwise, it is taken, return false.
    }
}

