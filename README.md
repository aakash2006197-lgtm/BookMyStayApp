# BookMyStayApp 
**Book My Stay** is a simple, structured Java-based Hotel Booking Management System designed to demonstrate core Object-Oriented Programming (OOP) concepts step-by-step through distinct use cases.

## 📖 Overview

This project simulates a hotel booking engine and tracks rooms based on categories like **Single**, **Double**, and **Suite**. It uses a step-by-step learning approach where each core feature of the hotel management system is separated into logical "Use Cases".

### Use Cases Implemented

1. **Use Case 1: Application Entry & Welcome Message**  
   *Class:* `BookMyStayApp.java`  
   *Description:* The entry point of the Hotel Booking Management System. Establishes a predictable application startup and displays welcome checks.

2. **Use Case 2: Room Initialization**  
   *Classes:* `UseCase2RoomInitialization.java`, `Room.java`, `SingleRoom.java`, `DoubleRoom.java`, `SuiteRoom.java`  
   *Description:* Introduces inheritance and OOP design. It sets up different room categories, basic properties (price, capacity, amenities), and demonstrates how to initialize them.

3. **Use Case 3: Inventory Setup**  
   *Classes:* `UseCase3InventorySetup.java`, `RoomInventory.java`  
   *Description:* Manages the hotel's room catalog. Demonstrates how to store, track, and retrieve rooms available in the hotel.

4. **Use Case 4: Room Search**  
   *Classes:* `UseCase4RoomSearch.java`, `RoomSearchService.java`  
   *Description:* Implements searching logic. Allows users to query available rooms based on different criteria like room type or price preferences.

##  Project Structure

```text
BookMyStayApp/
├── src/
│   ├── BookMyStayApp.java                # Main entry point (Use Case 1)
│   ├── Room.java                         # Base model for rooms
│   ├── SingleRoom.java / DoubleRoom.java / SuiteRoom.java # Inherited subclasses
│   ├── RoomInventory.java                # Manages available rooms
│   ├── RoomSearchService.java            # Logic for querying inventory
│   ├── UseCase2RoomInitialization.java   # Demo for Use Case 2
│   ├── UseCase3InventorySetup.java       # Demo for Use Case 3
│   └── UseCase4RoomSearch.java           # Demo for Use Case 4
```

##  How to Run

Ensure you have **Java (JDK 8 or higher)** installed on your system.

### Compiling
Navigate to the `src` folder (or the root directory mapped by your IDE) and run:
```bash
javac *.java
```

### Executing Use Cases
You can run any of the use case classes individually to see their specific outputs:

**Run Main Entry Point:**
```bash
java BookMyStayApp
```

**Run Initialization Demo:**
```bash
java UseCase2RoomInitialization
```

**Run Search Demo:**
```bash
java UseCase4RoomSearch
```

##  Concepts Covered

- **Encapsulation:** Protecting data using private fields and getters/setters.
- **Inheritance:** `SingleRoom`, `DoubleRoom`, and `SuiteRoom` extending the base `Room` class.
- **Polymorphism:** Handling multiple room types seamlessly in the inventory.
- **Separation of Concerns:** Distinct services to handle Inventory vs. Searching.

##  Contributing
Contributions, issues, and feature requests are welcome! Feel free to modify the system to add features like *Customer Booking*, *Payment Processing*, or *Date Tracking!*

