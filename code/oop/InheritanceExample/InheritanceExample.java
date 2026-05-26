package oop.InheritanceExample;

class Person {
	public void m1() {
		System.out.println("Inside Person::m1() method!");
	}
}

class Athlete extends Person {
	public void m2() {
		System.out.println("Inside Athlete::m2() method!");
	}
}

/*
The inheritance above makes sense because Athlete IS-A a Person and therefore Athlete extends the features of Person.
*/

public class InheritanceExample {
	public static void main(String[] args) {
		Person p = new Person();
		p.m1();	// "Inside Person::m1() method!"
		// p.m2();	// Compilation Error

		Athlete a = new Athlete();
		a.m1();	// "Inside Person::m1() method!"
		a.m2();	// "Inside Athlete::m2() method!"	
	}
}