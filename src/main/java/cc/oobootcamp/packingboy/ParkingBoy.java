package cc.oobootcamp.packingboy;

import cc.oobootcamp.parkinglot.Car;
import cc.oobootcamp.parkinglot.ParkingLot;
import cc.oobootcamp.parkinglot.Ticket;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ParkingBoy {

  private final List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket park(Car car) {
    return parkingLots.stream()
        .filter(ParkingLot::hasAvailableSpace)
        .max(Comparator.comparingInt(ParkingLot::getAvailableSpace))
        .orElseThrow(ParkingLotsFullException::new)
        .park(car);
  }

  public Car pick(Ticket ticket) {
    return parkingLots.stream()
        .map(parkingLot -> parkingLot.pick(ticket))
        .filter(Objects::nonNull)
        .findFirst()
        .orElseThrow(NoCarFoundException::new);
  }
}
