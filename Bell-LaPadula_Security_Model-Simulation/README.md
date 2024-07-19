## **Bell-Lapadula Security Model Simulation in Java**

This Java program simulates the Bell-Lapadula security model, which is a formal model for enforcing confidentiality policies. The model defines rules for how subjects (entities capable of accessing information) can interact with objects (resources containing information) based on their security clearances and permissions.

## **Features**

- **Subjects**: Represented by `Subject` class, subjects have a name, security clearance level (`SecurityLevel`), and permission (`Permission`).
- **Objects**: Represented by `Object` class, objects have a name and a security classification level (`SecurityLevel`).
- **Access Control**: Implements methods to check if subjects can read or write to objects based on the Bell-Lapadula rules:
  - Subjects can read an object if their clearance level is greater than or equal to the object's level or if they have permission to read down.
  - Subjects can write to an object if their clearance level is less than or equal to the object's level.
- **Permissions**: Subjects may have permissions to read down (`CAN_READ_DOWN`) or not write down (`NO_WRITE_DOWN`), affecting their capabilities as per the Bell-Lapadula rules.

## **Implementation**

The main components of the program are:

- **Subject Class**: Represents a subject with methods to check read and write access to objects based on its clearance and permissions.
- **Object Class**: Represents an object with a security classification level.
- **BellLapadulaSimulation Class**: Contains the main method where subjects and objects are instantiated, and access attempts are simulated.

## **Usage**

To run the simulation:

1. Ensure you have Java installed on your system.
2. Compile the `BellLapadulaSimulation.java` file using `javac BellLapadulaSimulation.java`.
3. Run the compiled program using `java BellLapadulaSimulation`.

## **Example**

Here's an example of what you might see in the program's output:

Subject Alice attempting to access Top Secret Document...
Access denied. Subject cannot read Top Secret Document
Subject cannot write to Top Secret Document
Subject can read down
Subject cannot write down

Subject Bob attempting to access Confidential Document...
Access granted. Subject can read Confidential Document
Subject cannot write to Confidential Document
Subject cannot read down
Subject cannot write down

Subject Charlie attempting to access Public Document...
Access granted. Subject can read Public Document
Subject can write to Public Document
Subject cannot read down
Subject can write down


In this example:
- Alice is denied access to the Top Secret Document because her clearance level (`CONFIDENTIAL`) is lower than the document's level (`TOP_SECRET`).
- Bob is granted access to the Confidential Document because his clearance level (`SECRET`) is equal to the document's level (`CONFIDENTIAL`).
- Charlie can read and write the Public Document because his clearance level (`TOP_SECRET`) is higher than the document's level (`UNCLASSIFIED`).

## **Notes**

- This program provides a basic simulation of the Bell-Lapadula security model. Real-world implementations may include additional features and complexity.
- Ensure to adjust permissions and clearances in the `main` method of `BellLapadulaSimulation.java` to explore different access scenarios.

---
Author : Philip Nerrison Boadu