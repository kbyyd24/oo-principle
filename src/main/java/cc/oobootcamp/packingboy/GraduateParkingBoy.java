package cc.oobootcamp.packingboy;

import cc.oobootcamp.parkinglot.Car;
import cc.oobootcamp.parkinglot.ParkingLot;
import cc.oobootcamp.parkinglot.Ticket;
import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{

  public GraduateParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket park(Car car) {
    return parkingLots.stream()
        .filter(ParkingLot::hasAvailableSpace)
        .findFirst()
        .map(parkingLot -> parkingLot.park(car))
        .orElseThrow(ParkingLotsFullException::new);
  }
}
