package oop.Interface;


/**
 * Interfaces are pure abstract classes, which means that they're a 100% abstract. All the methods or members defined inside
 * an interface are abstract and don't need a body. An interface needs to be implemented by a class using the  "implements" 
 * keyword.
 * 
 * EXAMPLE: If we have an interface named "Vehicle" and class named "Car", and if Car implements Vehicle interface, in that
 * case, Car has to implement all the methods of the Vehicle class because Vehicle is an interface.
 * 
 * An interface is like a contract to the class that implements that interface. An interface never contains any body for any
 * method, it only contains method signatures of the abstract methods.
 */

interface Vehicle {
    int x = 100; // by default interface variables are public static final.

    // by default, all the methods inside an interface are abstract.
    void noOfWheels();   // same as: public abstract void noOfWheels()

    void speed(); // by default interface methods are public and abstract
}

class Car implements Vehicle {
    @Override
    public void noOfWheels() {
        System.out.println("Number of wheels: 4");
    }

    @Override
    public void speed() {
        System.out.println("120 km/h");
    }
}

class InterfaceExample {
    public static void main(String[] args) {
        Car c = new Car();
        c.noOfWheels(); // Number of wheels: 4
        c.speed(); // 120 km/h
        // c.x = 500; // Compilation Error: The final Vehicle.x cannot be assigned


        // Vehicle v = new Vehicle();  // This is illegal because an interface has only pure abstract methods/attributes, and so, we cannot make an object of Vehicle interface

        Vehicle v = new Car(); // legal, because an interface 
        v.noOfWheels(); // Number of wheels: 4
        v.speed(); // 120 km/h
        // v.x = 500; // Same error as in line 42
    }
}

/**
 * One final advantage of using interface is that, a class can only extend one class at a time, but a class can implement
 * more than 1 interface at a time. Which is the concept of Multiple Inheritance in Java.
 */