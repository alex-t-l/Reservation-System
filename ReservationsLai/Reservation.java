/**
 * Represents a request to the system to reserve an item for a specific time slot.
 * Alex Lai
 * March 9, 2020
 */
public abstract class Reservation implements Comparable{
    protected String customer = ""; //Customer's name
    protected int time; //Customer's time slot
    protected String resourceID; //Customer's reserved item
    /**
     * Constructor.
     * @param customerName Customer's name
     * @param timeslot Timeslot customer desires.
     */
    public Reservation(String customerName, int timeslot) {
        customer = customerName;
        time = timeslot;
    }
 
    /**
     * Abstract method that returns a score, must be implemented in Boat and Table.
     * @return score.
     */
    public abstract int getScore(ReservableItem res);

    /**
     * @return the Customer's name.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @return the Customer's time slot.
     */
    public int getTime() {
        return time;
    }

    /**
     * @return resource ID.
     */
    public String getResourceID() {
        return resourceID;
    }

    /**
     * @return Customer, time slot and score in a string.
     */
    @Override
    public String toString() {
        return "Reservation customer: " + getCustomer() + " timeSlot:" + getTime() + ", Resource ID: " + getResourceID() + System.lineSeparator();
    }

    /**
     * Sets the ID of the reservable item, IDs are read from files.
     *
     * @param id ID of reservable item.
     */
    public void setResourceId(String id) {
        resourceID = id;
    }

    /**
     * Compares customers names and returns a value of difference
     *
     * @param o Object
     * @return Value of difference between customer names, -1 if invalid object.
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Reservation) || (o == null))
            return -1;
        Reservation that = (Reservation) o;
        return this.getCustomer().compareTo(that.getCustomer());
    }
}
