Parking Lot
===

### case about parking

---

**given** there are a car and some avaliable parking spaces

**when** parking the car

**then** return parking ticket

---

**given** there is a car and no avaliable parking space

**when** parking the car

**then** do not return any ticket

---

### case about pick up car

---

**given** there is a ticket maps to a car in the parking lot

**when** pick up the car

**then** return the car

---

**given** there is a ticket not maps to any car in the parking lot

**when** pick up the car

**then** do not return any car

---

**given** there are some vehicles in the parking lot and no ticket here

**when** pick up any car

**then** do not return any car
