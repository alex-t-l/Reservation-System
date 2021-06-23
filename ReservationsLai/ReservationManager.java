import java.util.*;

/**
 * Driver class that opens the Scanner for the file.
 * March 5, 2020
 * Alex Lai
 */
public class ReservationManager {
    ArrayList<Reservation> r = new ArrayList<Reservation>(); // ArrayList of Reservations
    ArrayList<ReservableItem> ri = new ArrayList<ReservableItem>(); //ArrayList of Reservable Item.
    ArrayList<String> failedReservations = new ArrayList<String>(); //List of failed reservations.

    /**
     * Adds a reservable item to the list of reservable items.
     * @param item Item to be added to reservable Items.
     */
    public void addReservable(ReservableItem item) {
        ri.add(item);
    }

    public Reservation makeReservation(Reservation trialRes) {
        ArrayList<ReservableItem> greaterThanZero = new ArrayList<ReservableItem> (); //This arrayList stores reservations with a score greater than zero.

        for (int i = 0; i < ri.size(); i++) {
            if (ri.get(i).isAvailable(trialRes.getTime())) { //If timeslot is available, proceed
                if (trialRes.getScore(ri.get(i)) > 0) { //If the reservableItem's score is greater than zero, add it to the greaterThanZero ArrayList
                    greaterThanZero.add(ri.get(i)); 
                }
            }
        }
        if(greaterThanZero.size() > 0){
            trialRes.setResourceId(getGreatestScore(trialRes, greaterThanZero).getID()); //Set the resource ID to the table or boat.
            getGreatestScore(trialRes, greaterThanZero).reserveTime(trialRes.getTime()); //Retrieve the reservableItem of greatest score.
            r.add(trialRes); //Add to the list of Reservations
            return trialRes;
        }
        else
        {
            failedReservations.add("Unsuccessful reservation: " + trialRes.toString());
            return null;
        }
    }

    /**
     * Helper method for makeReservation.
     * @return the ReservableItem with the greatest score.
     * @param trialRes reservation request.
     * @param greaterThanZero an ArrayList with reservation canidates with a score higher than 0.
     */
    public ReservableItem getGreatestScore(Reservation trialRes, ArrayList <ReservableItem> greaterThanZero){
        int greatest = 0;
        int indexOfGreatest = 0;
        for(int i = 0; i < greaterThanZero.size(); i++){
            if(trialRes.getScore(greaterThanZero.get(i)) > greatest){
                indexOfGreatest = i;
                greatest = trialRes.getScore(greaterThanZero.get(i));
            }
        }
        return greaterThanZero.get(indexOfGreatest);
    }

    /**
     * Bubble sort method that sorts the ArrayList of Reservations. Sorts by Customer name.
     */
    public void sortReservations() {
        int size = r.size();
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (r.get(j).getCustomer().compareTo(r.get(j+1).getCustomer()) > 0) {
                    Reservation temp = r.get(j);
                    r.set(j, r.get(j+1));
                    r.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * @return A string format of the failed reservations, then the successful reservations.
     */
    public String toString() {
        String s = "";
        for(String str: failedReservations)
            s += str;
        for (Reservation res : r)
            s += res.toString();

        s += "\n";
        return s;
    }

}

