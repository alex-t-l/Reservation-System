import java.util.*;

/**
 * The boat reservation class.
 * Alex Lai
 * March 11, 2020
 */
public class BoatReservation extends Reservation {
    protected ArrayList<String> preference = new ArrayList<String>(); //List of boats the customer prefers.

    /**
     * Constructor
     *
     * @param customerName Sent to the super class, customer's name.
     * @param timeSlot     Sent to the super class, desired timeslot.
     */
    public BoatReservation(String customerName, int timeSlot) {
        super(customerName, timeSlot);
    }

    /**
     * Add a boat to the list of boats the customer prefers.
     *
     * @param boatName The boat the customer prefers
     */
    public void addBoatPreference(String boatName) {
        preference.add(boatName);
    }

    /**
     * The getScore method for Boats.
     *
     * @param res
     * @return -1 of item is not a boat, 100 if perfect fit, 99-97 if good fit, 0 if no fit.
     */
    @Override
    public int getScore(ReservableItem res) {
        if (!(res instanceof Boat))
            return -1;
        //Shouldn't happen, but return -1 if res is not an instance of boat.
        Boat theBoat = (Boat) res;
        for (int i = 0; i < preference.size(); i++) {
            if (preference.get(i).equals(theBoat.getID())) {
                return (100 - i); //Returns 99 to 97 depending on match.
            }
        }
        return 0; //If all of their preferences don't equal the boat ID, return a score of 0.
    }
}
