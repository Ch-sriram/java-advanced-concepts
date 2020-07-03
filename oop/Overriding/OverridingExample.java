package oop.Overriding;

/**
 * Overriding is the ability to implement Dynamic Polymorphism (a.k.a Runtime Polymorphism or Late Binding) where a Child
 * class has the ability to override the implementation of its Parent class' methods if the Child class wants to have a 
 * different result using that particular Child class.
 * 
 * Overriding is a.k.a Dynamic Polymorphism (a.k.a Runtime Polymorphism or Late Binding) because the resolution of which 
 * method to be executed happens during runtime, i.e., the binding of the call to the method is handled by the JVM during 
 * runtime.
 */

class AddTwoIntegers {
    public void add(int x, int y) {
        System.out.println(x + y);
    }
}

class AddTwoIntegersWithHundred extends AddTwoIntegers {
    @Override
    public void add(int x, int y) { // We can see that the method signature is same as the parent class
        System.out.println(x + y + 100);
    }

    // Remember that the method signature doesn't change when we override, it only does during overloading.
}

public class OverridingExample {
    public static void main(String[] args) {
        // Case 1
        AddTwoIntegers a1 = new AddTwoIntegers();
        a1.add(100, 100); // 200

        // Case 2
        AddTwoIntegersWithHundred a2 = new AddTwoIntegersWithHundred();
        a2.add(100, 100); // 300

        // Case 3 - Dynamic Polymorphism => Child class object being referred by a Parent Class' Reference
        AddTwoIntegers a3 = new AddTwoIntegersWithHundred();
        a3.add(100, 100); // 300 => But here, Child class' method is bounded, but called through Parent class' reference

        // Case 4
        // AddTwoIntegersWithHundred a4 = new AddTwoIntegers();

        // Code in line 43 is illegal because a child class' reference cannot refer to a parent class' object
    }
}