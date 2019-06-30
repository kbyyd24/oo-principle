package cc.oobootcamp.packingboy;

import cc.oobootcamp.parkinglot.Car;
import cc.oobootcamp.parkinglot.ParkingLot;
import cc.oobootcamp.parkinglot.Ticket;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket park(Car car) {
    return parkingLots.stream()
        .filter(ParkingLot::hasAvailableSpace)
        .max(Comparator.comparingInt(ParkingLot::getAvailableSpace))
        .orElseThrow(ParkingLotsFullException::new)
        .park(car);
  }
}
