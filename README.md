# Java &mdash; Advanced Concepts

Implementation of advanced concepts of Java. Doesn't contain the basics of Java programming. I've made this repository for my personal reference/practice, feel free to refer to this repository and/or contribute to the repository. I'm very active on GitHub where I make repositories like this as my programming notes/revision.

**NOTE**: This repository might not contain all the advanced concepts in Java. It will only contain concepts that I presume are important in Java that are uniquely available only in Java (or) specific to Java (or) if the implementation of the concept might be different in Java.

## Table of Contents

- **Miscellaneous**
  - `StringBuffer`/`StringBuilder` vs. `String` Objects: [StringBuffer.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/misc/StringBuffer/StringBufferExample.java)
  - Usage of `static {...}` a.k.a. static block: [StaticBlockExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/misc/StaticBlock/StaticBlockExample.java)
  - Using `InputStream` to check closed streams: [InputStreamTest.java](./fileio/InputStreamTest.java)

- **Object Oriented Programming**
  - IS-A Relationship using Inheritance `extends`: [InheritanceExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/InheritanceExample/InheritanceExample.java)
  - Concept of Overloading (a.k.a. Static Polymorphism or Compile Time Polymorphism or Early Binding), Method Signatures & Automatic Promotion: [OverloadingExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Overloading/OverloadingExample.java)
  - Concept of Overriding (a.k.a. Dynamic Polymorphism or Runtime Polymorphism or Late Binding): [OverridingExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Overriding/OverridingExample.java)
  - Method Hiding for static methods & Overriding class attributes (not possible): [MethodHidingExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/MethodHiding/MethodHidingExample.java)
  - The saga of the `super` keyword
    1. `super` keyword and Super Class' Constructor being called automatically by the `javac` when the Child Class' Constructor is Not Defined: [SuperExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Super/SuperExample/SuperExample.java)
    2. The enforcement of Super Class' default (no-arg) Constructor to be defined: [SuperExample1.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Super/SuperExample1/SuperExample1.java)
  - Inheriting and using abstract classes and methods using `abstract` keyword: [AbstractClassExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/AbstractClass/AbstractClassExample.java)
  - Interfaces using the `interface` keyword and implementing interfaces using `implements` keyword: [InterfaceExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Interface/InterfaceExample.java)
  - Multiple Inheritance using Interfaces: [MultipleInheritance.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/oop/Interface/MultipleInheritance.java)

- **Exception Handling**
  - Handling Exceptions using `try` and `catch` blocks: [TryCatchExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/exceptions/TryCatch/TryCatchExample.java)
  - Writing Cleanup code inside the `finally` block: [FinallyExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/exceptions/Finally/FinallyExample.java)
  - Using `throw` keyword to explicitly raise an exception: [ThrowExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/exceptions/Throw/ThrowExample.java)
  - Using `throws` keyword to delegate an exception to the calling method: [ThrowsExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/exceptions/Throws/ThrowsExample.java)
  - Making custom defined exceptions by extending `RuntimeException` class: [UserDefinedExceptionExample.java](https://github.com/Ch-sriram/java-advanced-concepts/blob/master/exceptions/UserDefinedException/UserDefinedExceptionExample.java)

- **Generics**
  - What are Generics: [Generics.java](./generics/Generics.java)
  - Covariance, Contravariance & Invariance (Producer Extends, Consumer Super): [PECS.java](./generics/PECS.java)

- **Lambdas & Functional Interfaces**
  - Lambdas & Functional Interface Introduction: [LambdaAndFunctionalInterfaceTest.java](./lambda/LambdaAndFunctionalInterfaceTest.java)
  - Lambda Expression Syntax & Usage: [LambdaSyntaxAndUsageExample.java](./lambda/LambdaSyntaxAndUsageExample.java)
  - More about Lambda Expressions: [MoreLambdaExpressions.java](./lambda/MoreLambdaExpressions.java) [Operation.java](./lambda/Operation.java)
  - Functional Interfaces, Consumer and Predicate: [FunctionalInterfaceConsumerAndPredicate](./lambda/FunctionalInterfaceConsumerAndPredicate.java)

- **Streams**
  - Traditional Looping vs. Streams: [Streams.java](./streams/Streams.java)
