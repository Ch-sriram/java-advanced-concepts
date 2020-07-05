package oop.AbstractClass;

/**
 * Abstract Classes have abstract methods, which are methods which have no body. It means that whichever class inherits an
 * abstract class, needs to definitely implement all of the methods which are abstract.
 * 
 * Example:
 * So in general, we can have a Vehicle abstract class where in, we might have an abstract method say "noOfWheels()". 
 * Now, if the class "Car" (which is a non-abstract class) is going to inherit the Vehicle class (which is abstract and has 
 * abstract methods), then Car class has to definitely implement the noOfWheels() method.
 * 
 * But in abstract classes, we can also have non-abstract methods which actually are defined and have a body. This is the
 * key difference between an interface and an abstract class. An abstract class can have methods/attributes which are 
 * non-abstract, but an interface can only have abstract methods/attributes.
 */

abstract class Vehicle {
    public abstract void noOfWheels();

    public void speed() {
        System.out.println("60 km/h");
    }
}

class Car extends Vehicle {
    public void noOfWheels() {
        System.out.println("Number of Wheels: 4");
    }

    @Override // We can override pre-existing methods same as we did during inheritance of a non-abstract class
    public void speed() {
        System.out.println("130 km/h");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.noOfWheels(); // Number of Wheels: 4
        c.speed(); // 130 km/h

        // Vehicle v = new Vehicle(); // Compilation Error because we can never create an object for an abstract class.

        Vehicle v = new Car(); // this is legal, because Vehicle is the parent of Car class and a Child class' object can be referred by Parent class' reference, which is Dynamic Polymorphism
        v.noOfWheels(); // Number of Wheels: 4
        v.speed(); // 100 km/h
    }
}