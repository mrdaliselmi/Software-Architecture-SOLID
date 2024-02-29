# Software Architecture Labs: Lab1 

## How to use SOLID principles to improve an existing code

### 1- Single Responsibility Principle (SRP)

#### Problem

In the original code, the CarManager class violates the Single Responsibility Principle (SRP) by handling multiple responsibilities:

It manages a list of cars (_carsDb) and provides methods to retrieve cars from this list.
It calculates and returns the best car based on a specific criterion (the model name).
It formats the names of all cars in the list into a single string.
This violates SRP because a class should have only one reason to change, but CarManager has multiple reasons to change. For example, if the format of the output string needs to change, or if the logic for calculating the best car needs to be updated, CarManager would need to be modified.

#### Solution

The refactored solution introduces three new classes to address each responsibility separately:

CarRepository: Manages the storage and retrieval of Car objects.
CarMetrics: Calculates metrics related to cars, such as finding the best car.
CarFormatter: Formats car data for display.

![image](out/Single%20Resposibility%20Principal.png)

Each class now has a single responsibility, adhering to the SRP. This separation of concerns makes the code more maintainable and easier to extend. Each class can be modified or replaced without affecting the others, improving the overall design of the application.

### 2- Open Closed Principal (OCP)

#### Problem

In the original code, the ResourceAllocator class violates the Open/Closed Principle (OCP) by being open for modification when new types of resources are introduced. The allocate and free methods use a switch statement to handle different types of resources (ResourceType enum), which means that every time a new resource type is added, these methods need to be modified.

This violates OCP because the ResourceAllocator class should be closed for modification but open for extension. Adding a new resource type should not require modifying the ResourceAllocator class.

#### Solution

The refactored solution introduces an abstract Resource class and concrete subclasses TimeSlot and SpaceSlot for each type of resource. Each subclass implements methods for checking if the resource is free, marking it as busy or free, and finding a free resource. This allows for the ResourceAllocator class to be closed for modification, as it now depends on abstractions (Resource and its subclasses) rather than specific resource types.

![uml](out/Open%20Closed%20Principal.png)

This adheres to the OCP because adding a new resource type involves creating a new subclass of Resource without modifying existing code. The ResourceAllocator class can work with any type of resource that extends the Resource class, making it easier to extend and maintain.

### 3- Liskov Substitution Principal (LSP)

#### Problem

In the original code, the ElectronicDuck class violates the Liskov Substitution Principle (LSP) by not behaving as a proper subtype of Duck. While it implements the quack and swim methods, it throws exceptions when these methods are called while the duck is off. This behavior is different from that of a regular duck, which does not throw exceptions in these cases.

#### Solution
The refactored solution introduces an IDuck interface that defines the swim and quack methods. Both RegularDuck and ElectronicDuck classes implement this interface, ensuring that they both adhere to the same contract.

![uml](out/Liskov%20Substitution%20Principle.png)

By using the IDuck interface, the Pool class can accept any implementation of IDuck, whether it be a RegularDuck or an ElectronicDuck. This adheres to the LSP because objects of ElectronicDuck can now be substituted for objects of RegularDuck without affecting the correctness of the program.

The ElectronicDuck class still has the turnOn and turnOff methods, which are specific to electronic ducks but do not affect the LSP compliance of the class. These methods can be considered as additional functionality specific to ElectronicDuck.

### 4- Interface Segregation Principal (ISP)

#### Problem

In the original code, both the TimedDoor and SensingDoor classes implement the Door interface, which contains methods for both locking/unlocking and opening/closing the door, as well as timeOutCallback and proximityCallback methods. However, not all doors need to support both timeout and proximity callbacks. For example, a simple door that does not have any sensors may not need the proximityCallback method.

#### Solution

The refactored solution introduces two new interfaces, Timed and SensorDependant, to segregate the responsibilities of supporting timeout callbacks and proximity callbacks, respectively. The Door interface now contains only methods related to locking/unlocking and opening/closing the door, which are common to all doors.

![uml](out/Interface%20Segregation%20Principal.png)

The TimedDoor class implements the Timed interface, providing the timeOutCallback method required for timed doors. The SensingDoor class implements the SensorDependant interface, providing the proximityCallback method required for sensing doors.

This segregation of interfaces ensures that each class implements only the methods relevant to its functionality, adhering to the Interface Segregation Principle. It also allows for easier extension and modification of the code, as new types of doors can implement only the interfaces that are relevant to them.

### 5- Dependency Inversion Principal

#### Problem

In the original code, both the TimedDoor and SensingDoor classes implement the Door interface, which contains methods for both locking/unlocking and opening/closing the door, as well as timeOutCallback and proximityCallback methods. However, not all doors need to support both timeout and proximity callbacks. For example, a simple door that does not have any sensors may not need the proximityCallback method.

#### Solution

The refactored solution introduces two new interfaces, DataReader and DataWriter, to abstract the data reading and writing operations. The EncodingModule class now depends on these interfaces instead of concrete implementations. This allows different implementations of data reading and writing operations to be used without modifying the EncodingModule class, making it more flexible and easier to maintain.

![uml](out/Dependency%20Inversion%20Principle.png)

The File and Network classes implement the DataReader interface, providing different ways to read data. The Database class implements the DataWriter interface, providing a way to write data to a database. The EncodingModule class now takes these interfaces as dependencies in its constructor, adhering to the DIP.

This separation of concerns allows for easier testing, as mock implementations of DataReader and DataWriter can be used in tests, and for easier extension, as new implementations of DataReader and DataWriter can be added without modifying existing code.