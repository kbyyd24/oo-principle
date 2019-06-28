package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private final int totalSpaces;
  private final Map<Ticket, Vehicle> records;

  public ParkingLot(int totalSpaces) {
    this.totalSpaces = totalSpaces;
    records = new HashMap<>(totalSpaces, 1f);
  }

  public Ticket parking(Vehicle vehicle) {
    if (!hasAvailableSpace()) {
      return null;
    }
    Ticket ticket = new Ticket();
    records.put(ticket, vehicle);
    return ticket;
  }

  private boolean hasAvailableSpace() {
    return records.size() < totalSpaces;
  }

  public Vehicle pickUp(Ticket ticket) {
    return records.get(ticket);
  }
}
