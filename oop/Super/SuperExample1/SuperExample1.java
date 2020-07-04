package oop.Super.SuperExample1;

// class Parent {
//     public Parent(int x) {
//         System.out.println("Inside Parent::int-arg constructor");
//     }
// }

// class SuperExample1 extends Parent {
//     public static void main(String[] args) {
//         SuperExample1 s = new SuperExample1(); // Compile Time Error

//         // Implicit super constructor Parent() is undefined for default constructor. Must define an explicit constructor.
//         // Therefore, if we fix this issue, it will look as the following: 
//     }
// }

class Parent {
    // we can define the Parent class' default constructor here as follows:
    // public Parent() {
    //     System.out.println("Inside Parent::no-arg constructor");
    // }

    // or we can need not define the constructor above and define the constructor for SuperExample1 as in line 32
    
    public Parent(int x) {
        System.out.println("Inside Parent::int-arg constructor");
    }
}

class SuperExample1 extends Parent {
    public SuperExample1() {
        super(10);
    }

    public static void main(String[] args) {
        SuperExample1 s = new SuperExample1(); // Inside Parent::int-arg constructor
    }
}