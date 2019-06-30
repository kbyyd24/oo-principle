package cc.oobootcamp.parkinglot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotTest {

  private static final int TOTAL_SPACES = 30;
  private ParkingLot parkingLot;

  @BeforeEach
  void setUp() {
    parkingLot = new ParkingLot(TOTAL_SPACES);
  }

  @Test
  void should_return_ticket_when_parking_given_a_vehicle_and_has_available_parking_space() {
    Car car = new Car();

    Ticket ticket = parkingLot.park(car);

    assertThat(ticket).isNotNull();
  }

  @Test
  void should_not_return_ticket_when_parking_given_a_vehicle_and_has_no_avaliable_parking_space() {
    Car car = new Car();
    thereIsNoAvailableSpace(parkingLot);

    Ticket ticket = parkingLot.park(car);

    assertThat(ticket).isNull();
  }

  private void thereIsNoAvailableSpace(ParkingLot parkingLot) {
    IntStream.range(0, TOTAL_SPACES).forEach(i -> parkingLot.park(new Car()));
  }

  @Test
  void should_return_vehicle_when_pick_up_given_a_ticket_maps_to_vehicle_in_parking_lot() {
    Ticket ticket = oneTicketMapsVehicleInParkingLot(parkingLot);

    Car carFound = parkingLot.pick(ticket);

    assertThat(carFound).isNotNull();
  }

  private Ticket oneTicketMapsVehicleInParkingLot(ParkingLot parkingLot) {
    Car parkedCar = new Car();
    return parkingLot.park(parkedCar);
  }

  @Test
  void should_not_return_vehicle_when_pick_up_given_a_ticket_not_maps_to_any_vehicle_in_parking_lot() {
    parkedSomeVehicles(parkingLot);
    Ticket ticket = new Ticket();

    Car car = parkingLot.pick(ticket);

    assertThat(car).isNull();
  }

  @Test
  void should_not_return_vehicle_when_pick_up_given_no_ticket() {
    parkedSomeVehicles(parkingLot);

    Car car = parkingLot.pick(null);

    assertThat(car).isNull();
  }

  private void parkedSomeVehicles(ParkingLot parkingLot) {
    parkingLot.park(new Car());
    parkingLot.park(new Car());
    parkingLot.park(new Car());
  }
}
