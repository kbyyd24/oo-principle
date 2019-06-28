Parking Lot
===

### case about parking

---

**given** there are a vehicle and some avaliable parking spaces

**when** parking the vehicle

**then** return parking ticket

---

**given** there is a vehicle and no avaliable parking space

**when** parking the vehicle

**then** do not return any ticket

---

### case about pick up vehicle

---

**given** there is a ticket maps to a vehicle in the parking lot

**when** pick up the vehicle

**then** return the vehicle

---

**given** there is a ticket not maps to any vehicle in the parking lot

**when** pick up the vehicle

**then** do not return any vehicle

---

**given** there are some vehicles in the parking lot and no ticket here

**when** pick up any vehicle

**then** do not return any vehicle
