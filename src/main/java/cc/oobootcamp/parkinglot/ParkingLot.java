package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private final int totalSpaces;
  private final Map<Ticket, Car> records;

  public ParkingLot(int totalSpaces) {
    this.totalSpaces = totalSpaces;
    records = new HashMap<>(totalSpaces, 1f);
  }

  public Ticket park(Car car) {
    if (!hasAvailableSpace()) {
      return null;
    }
    Ticket ticket = new Ticket();
    records.put(ticket, car);
    return ticket;
  }

  public boolean hasAvailableSpace() {
    return records.size() < totalSpaces;
  }

  public Car pick(Ticket ticket) {
    return records.remove(ticket);
  }

  public int getAvailableSpace() {
    return totalSpaces - records.size();
  }
}
