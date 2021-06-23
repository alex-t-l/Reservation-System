import java.util.*;

/**
 * Table represents a table in a Cafe.
 * March 9, 2020
 * Alex Lai
 */
public class Table extends ReservableItem {
    int numSeats = 0;

    /**
     * Reads one line form the file and fills in the String ID, and numSeats.
     * @param inFile Scanner inside the file.
     */
   public Table(Scanner inFile) {
        String line = inFile.nextLine();
        String[] arr = new String[2];
        arr = line.split(" ");
        this.numSeats = Integer.parseInt(arr[1]);
        super.ID = arr[0];
    }

    /**
     * @return the number of seats.
     */
    public int getNumSeats() {
        return numSeats;
    }
}
