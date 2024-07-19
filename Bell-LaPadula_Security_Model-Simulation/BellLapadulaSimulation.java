import java.util.*;

// Enum for the security levels of objects
enum SecurityLevel {
    TOP_SECRET,
    SECRET,
    CONFIDENTIAL,
    UNCLASSIFIED
}

// Enum for the permissions of subjects
enum Permission {
    CAN_READ_DOWN,
    NO_WRITE_DOWN
}

// Class representing a Subject
class Subject {
    private String name;
    private SecurityLevel clearance;
    private Permission permission;

    public Subject(String name, SecurityLevel clearance, Permission permission) {
        this.name = name;
        this.clearance = clearance;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public SecurityLevel getClearance() {
        return clearance;
    }

    public Permission getPermission() {
        return permission;
    }

    // Method to check if subject can read an object
    public boolean canRead(Object object) {
        // Check if subject's clearance is greater than or equal to object's level
        if (this.clearance.compareTo(object.getLevel()) >= 0) {
            return true;
        }

        // Check if subject can read down
        if (this.permission == Permission.CAN_READ_DOWN) {
            // Additional check: Subject can read down only if it is not higher than CONFIDENTIAL
            if (this.clearance == SecurityLevel.CONFIDENTIAL && object.getLevel() != SecurityLevel.TOP_SECRET) {
                return true;
            }
        }

        return false;
    }

    // Method to check if subject can write to an object
    public boolean canWrite(Object object) {
        // Check if subject's clearance is less than or equal to object's level
        return this.clearance.compareTo(object.getLevel()) <= 0;
    }

    // Method to check if subject can read down (subject permission)
    public boolean canReadDown() {
        return this.permission == Permission.CAN_READ_DOWN;
    }

    // Method to check if subject can write down (subject permission)
    public boolean canWriteDown() {
        return this.permission != Permission.NO_WRITE_DOWN;
    }
}

// Class representing an Object
class Object {
    private String name;
    private SecurityLevel level;

    public Object(String name, SecurityLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public SecurityLevel getLevel() {
        return level;
    }
}

public class BellLapadulaSimulation {
    public static void main(String[] args) {
       

        // Printing author information
        System.out.println("----- Written By: Nerrison Philip Boadu -----");
        
         // Adding space before the simulation starts
        System.out.println("\n\n\n");

        // Creating subjects
        Subject alice = new Subject("Alice", SecurityLevel.CONFIDENTIAL, Permission.CAN_READ_DOWN);
        Subject bob = new Subject("Bob", SecurityLevel.SECRET, Permission.NO_WRITE_DOWN);
        Subject charlie = new Subject("Charlie", SecurityLevel.TOP_SECRET, Permission.NO_WRITE_DOWN);

        // Creating objects
        Object topSecretDocument = new Object("Top Secret Document", SecurityLevel.TOP_SECRET);
        Object confidentialDocument = new Object("Confidential Document", SecurityLevel.CONFIDENTIAL);
        Object publicDocument = new Object("Public Document", SecurityLevel.UNCLASSIFIED);

        // Simulating access attempts
        simulateAccess(alice, topSecretDocument);
        simulateAccess(alice, confidentialDocument);
        simulateAccess(alice, publicDocument);

        simulateAccess(bob, topSecretDocument);
        simulateAccess(bob, confidentialDocument);
        simulateAccess(bob, publicDocument);

        simulateAccess(charlie, topSecretDocument);
        simulateAccess(charlie, confidentialDocument);
        simulateAccess(charlie, publicDocument);
    }

    // Method to simulate access attempt
    private static void simulateAccess(Subject subject, Object object) {
        System.out.println("Subject " + subject.getName() + " attempting to access " + object.getName() + "...");

        // Check if subject can read the object
        if (subject.canRead(object)) {
            System.out.println("Access granted. Subject can read " + object.getName());
        } else {
            System.out.println("Access denied. Subject cannot read " + object.getName());
        }

        // Check if subject can write to the object
        if (subject.canWrite(object)) {
            System.out.println("Subject can write to " + object.getName());
        } else {
            System.out.println("Subject cannot write to " + object.getName());
        }

        // Check if subject can read down
        if (subject.canReadDown()) {
            System.out.println("Subject can read down");
        } else {
            System.out.println("Subject cannot read down");
        }

        // Check if subject can write down
        if (subject.canWriteDown()) {
            System.out.println("Subject can write down");
        } else {
            System.out.println("Subject cannot write down");
        }

        System.out.println(); // Adding a newline for clarity
    }
}
