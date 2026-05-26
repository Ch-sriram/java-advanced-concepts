package oop.Super.SuperExample;

class Parent {
    public Parent() {
        System.out.println("Inside Parent::no-arg constructor");
    }
}

class SuperExample extends Parent {
    // public SuperExample() {
    //     super();
    // }
    // The code above is automatically added by the javac during compilation. We need not add it explicitly.

    public static void main(String[] args) {
        SuperExample d = new SuperExample(); // Inside Parent::no-arg constructor

        // We can see that the output we get is "Inside Parent::no-arg constructor" because javac, during the compilation
        // adds in a default constructor (which takes in no parameters), and in that default constructor (in this case, it
        // is for SuperExample class), javac calls the super class' constructor first, which is in this case the Parent 
        // class. In general, if the constructor is not defined for a class, then javac during compilation adds a 
        // constructor of its own, which is a no-param constructor that calls the super class' constructor (if the class in 
        // question actually inherits features from some other class) or the no-param constructor is just an empty 
        // definition, which also works.
    }
}