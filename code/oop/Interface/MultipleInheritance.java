package oop.Interface;

/**
 * In Java, a single class cannot inherit multiple classes, but a single class can implement multiple interfaces. 
 * We can see the following programming as an example of Multiple Inheritance.
 */

interface Father {
    float HEIGHT = 6.0f;
}

interface Mother {
    float HEIGHT = 5.8f; // same as: public final float HEIGHT;
}

class Child implements Father, Mother {
    public static void main(String[] args) {
        System.out.println((Father.HEIGHT + Mother.HEIGHT) / 2); // 5.9
    }
}