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

class GraduateParkingBoyTest {

  @Test
  void should_return_ticket_and_park_to_first_parking_lot_when_parking_given_a_car_and_first_parking_lot_has_available_space() {
    Car car = new Car();
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

    Ticket ticket = graduateParkingBoy.park(car);

    assertNotNull(ticket);
    assertEquals(firstParkingLot.pick(ticket), car);
  }

  @Test
  void should_return_ticket_and_park_to_second_parking_lot_when_parking_given_a_car_and_first_parking_lot_is_full_and_second_parking_lot_has_available_space() {
    Car car = new Car();
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    List<ParkingLot> parkingLots = asList(firstParkingLot, secondParkingLot);
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
    graduateParkingBoy.park(new Car());

    Ticket ticket = graduateParkingBoy.park(car);

    assertNotNull(ticket);
    assertEquals(secondParkingLot.pick(ticket), car);
  }

  @Test
  void should_throw_parking_lots_full_exception_when_parking_given_a_car_and_all_parking_lots_are_full() {
    List<ParkingLot> parkingLots = asList(new ParkingLot(1), new ParkingLot(1));
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
    graduateParkingBoy.park(new Car());
    graduateParkingBoy.park(new Car());

    assertThrows(ParkingLotsFullException.class, () -> graduateParkingBoy.park(new Car()));
  }


  @Test
  void should_return_car_when_pick_given_a_ticket_corresponds_to_a_car_in_parking_lots() {
    Car myCar = new Car();
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(singletonList(new ParkingLot(1)));
    Ticket ticket = graduateParkingBoy.park(myCar);

    Car pickedCar = graduateParkingBoy.pick(ticket);

    assertEquals(pickedCar, myCar);
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_given_a_ticket_not_corresponds_to_a_car_in_parking_lots() {
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(singletonList(new ParkingLot(1)));
    graduateParkingBoy.park(new Car());

    assertThrows(NoCarFoundException.class, () -> graduateParkingBoy.pick(new Ticket()));
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_second_time_given_a_ticket_corresponds_to_a_car_in_parking_lots() {
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(singletonList(new ParkingLot(1)));
    Ticket ticket = graduateParkingBoy.park(new Car());
    graduateParkingBoy.pick(ticket);

    assertThrows(NoCarFoundException.class, () -> graduateParkingBoy.pick(ticket));
  }

  @Test
  void should_throw_no_car_found_exception_when_pick_given_no_ticket() {
    GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(singletonList(new ParkingLot(1)));
    graduateParkingBoy.park(new Car());

    assertThrows(NoCarFoundException.class, () -> graduateParkingBoy.pick(null));
  }

}
