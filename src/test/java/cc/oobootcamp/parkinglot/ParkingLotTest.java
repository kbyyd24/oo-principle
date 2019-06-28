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
    Vehicle vehicle = new Vehicle();

    Ticket ticket = parkingLot.parking(vehicle);

    assertThat(ticket).isNotNull();
  }

  @Test
  void should_not_return_ticket_when_parking_given_a_vehicle_and_has_no_avaliable_parking_space() {
    Vehicle vehicle = new Vehicle();
    thereIsNoAvailableSpace(parkingLot);

    Ticket ticket = parkingLot.parking(vehicle);

    assertThat(ticket).isNull();
  }

  private void thereIsNoAvailableSpace(ParkingLot parkingLot) {
    IntStream.range(0, TOTAL_SPACES).forEach(i -> parkingLot.parking(new Vehicle()));
  }

  @Test
  void should_return_vehicle_when_pick_up_given_a_ticket_maps_to_vehicle_in_parking_lot() {
    Ticket ticket = oneTicketMapsVehicleInParkingLot(parkingLot);

    Vehicle vehicleFound = parkingLot.pickUp(ticket);

    assertThat(vehicleFound).isNotNull();
  }

  private Ticket oneTicketMapsVehicleInParkingLot(ParkingLot parkingLot) {
    Vehicle parkedVehicle = new Vehicle();
    return parkingLot.parking(parkedVehicle);
  }

  @Test
  void should_not_return_vehicle_when_pick_up_given_a_ticket_not_maps_to_any_vehicle_in_parking_lot() {
    parkedSomeVehicles(parkingLot);
    Ticket ticket = new Ticket();

    Vehicle vehicle = parkingLot.pickUp(ticket);

    assertThat(vehicle).isNull();
  }

  @Test
  void should_not_return_vehicle_when_pick_up_given_no_ticket() {
    parkedSomeVehicles(parkingLot);

    Vehicle vehicle = parkingLot.pickUp(null);

    assertThat(vehicle).isNull();
  }

  private void parkedSomeVehicles(ParkingLot parkingLot) {
    parkingLot.parking(new Vehicle());
    parkingLot.parking(new Vehicle());
    parkingLot.parking(new Vehicle());
  }
}
