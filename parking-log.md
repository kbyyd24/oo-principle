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

**then** return the vechile

---

**given** there is a ticket maps to a vehicle not in the parking lot

**when** pick up the vechile

**then** do not return any vechile

---

**given** there are some vechiles in the parking lot and no ticket here

**when** pick up any vechile

**then** do not return any vechile
