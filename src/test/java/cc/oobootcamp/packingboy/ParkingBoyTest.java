package cc.oobootcamp.packingboy;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cc.oobootcamp.parkinglot.Car;
import cc.oobootcamp.parkinglot.ParkingLot;
import cc.oobootcamp.parkinglot.Ticket;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParkingBoyTest {

  @Test
  void should_return_ticket_and_park_to_first_parking_lot_when_parking_given_a_car_and_first_parking_lot_have_more_space_than_second() {
    Car car = new Car();
    ParkingLot firstParkingLot = new ParkingLot(10);
    ParkingLot secondParkingLot = new ParkingLot(5);
    List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    Ticket ticket = parkingBoy.park(car);

    assertNotNull(ticket);
    assertEquals(firstParkingLot.pick(ticket), car);
  }

  @Test
  void should_return_ticket_and_park_to_first_parking_lot_when_parking_given_a_car_and_first_parking_lot_have_same_space_with_second() {
    Car car = new Car();
    ParkingLot firstParkingLot = new ParkingLot(10);
    ParkingLot secondParkingLot = new ParkingLot(10);
    List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    Ticket ticket = parkingBoy.park(car);

    assertNotNull(ticket);
    assertEquals(firstParkingLot.pick(ticket), car);
  }

  @Test
  void should_return_ticket_and_park_to_second_parking_lot_when_parking_given_a_car_and_first_parking_lot_have_less_space_than_second() {
    Car car = new Car();
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(10);
    List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    Ticket ticket = parkingBoy.park(car);

    assertNotNull(ticket);
    assertEquals(secondParkingLot.pick(ticket), car);
  }

  @Test
  void should_throw_parking_lots_full_exception_when_parking_given_a_car_and_all_parking_lots_are_full() {
    List<ParkingLot> parkingLots = asList(new ParkingLot(1), new ParkingLot(1));
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingBoy.park(new Car());
    parkingBoy.park(new Car());

    assertThrows(ParkingLotsFullException.class, () -> parkingBoy.park(new Car()));
  }

  @Test
  void should_return_car_when_pick_given_a_ticket_corresponds_to_a_car_in_parking_lots() {
    Car myCar = new Car();
    ParkingBoy parkingBoy = new ParkingBoy(singletonList(new ParkingLot(1)));
    Ticket ticket = parkingBoy.park(myCar);

    Car pickedCar = parkingBoy.pick(ticket);

    assertEquals(pickedCar, myCar);
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_given_a_ticket_not_corresponds_to_a_car_in_parking_lots() {
    ParkingBoy parkingBoy = new ParkingBoy(singletonList(new ParkingLot(1)));
    parkingBoy.park(new Car());

    assertThrows(NoCarFoundException.class, () -> parkingBoy.pick(new Ticket()));
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_second_time_given_a_ticket_corresponds_to_a_car_in_parking_lots() {
    ParkingBoy parkingBoy = new ParkingBoy(singletonList(new ParkingLot(1)));
    Ticket ticket = parkingBoy.park(new Car());
    parkingBoy.pick(ticket);

    assertThrows(NoCarFoundException.class, () -> parkingBoy.pick(ticket));
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_given_no_ticket() {
    ParkingBoy parkingBoy = new ParkingBoy(singletonList(new ParkingLot(1)));
    parkingBoy.park(new Car());

    assertThrows(NoCarFoundException.class, () -> parkingBoy.pick(null));
  }
}
