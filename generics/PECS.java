package generics;

/*
* Producer Extends, Consumer Super (PECS) is a mnemonic for understanding the usage of generics in the context of variance.
*
* What's Variance?
* ---------------
* Variance is the relationship between the inputs and outputs of a function.
* More technically:
*   Variance is about the assignment compatibility between containers and functions composed of parameters
*   that are connected via a Type Hierarchy.
*
* There are 3 types of it:
* 1. Covariance
* 2. Contravariance
* 3. Invariance
*
* To understand this, let's take an example:
*
* Assume the following:
*
* y = f(x)
* z = g(x)
*
* And,
*
* (1) COVARIANCE
* f(x) = x^2; and if we assume that x1 > x2, then "y1 ?? y2" (=> what's the relationship between y1 and y2)?
*             if x1 > x2 => y1 > y2
*
* For this function f(x), the operator > is called covariant because f(x) maintains the same relationship between
* its inputs (x1 and x2) and outputs (y1 and y2).
*
* (2) CONTRAVARIANCE
* g(x) = 1/x; and if we assume that x1 > x2, then "z1 ?? z2" (=> what's the relationship between z1 and z2)?
*            if x1 > x2 => z1 < z2
*
* For this function g(x), the operator < is called contravariant because g(x) reverses the relationship between
* its inputs (x1 and x2) and outputs (z1 and z2).
*
* ----------------
*
* In summary:
* - f(x) is covariant for > and < operator
* - g(x) is contravariant for < and > operator
*
*
* ----------------
*
* (3) INVARIANCE
* For certain f(x), if we cannot imply that y1 ?? y2, then we say that f(x) is invariant, because it's neither covariant nor contravariant.
*
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Understanding Variance in Java using Set Theory Concepts
* --------------------------------------------------------

* Fundamentally, when we've a type hierarchy, we can say that:
*   class A extends B {} // A ⊂ B; A is a subset of B
*
* In the same way, if we've the following hierarchy:
*
* Person        p1, p2
*   Student     s1, s2
*   Teacher     t1, t2
*
* And if we've a List of Person as follows:
*
*   List<Person> pList = new ArrayList<>();
*   pList.add(s1); // (✅) allowed, since Student is a Person.
*   pList.addAll(sList); // (✅) allowed, since Student is a Person.
*
* Now if we've another list of Student as follows:
*
*   List<Student> sList = new ArrayList<>();
*   sList.add(p1); // (❌) not allowed, since Person is not a Student
*   sList.addAll(pList); // (❌) not allowed because ArrayList<Person> != ArrayList<Student>
*
* To understand this, if we take the ArrayList::add and ArrayList::addAll method:
*   public boolean add(E e) { ... }
*   public boolean addAll(Collection<? extends E> items) { ... }
*
*       ? extends E: means that the Collection can be of any type that extends E (or E itself).
*
* So theoretically, we can say that (not related to Java, true in general):
*
* If in some language:
*   A ⊂ B => List<A> ⊂ List<B> // if this happens in a language, then in that language, all generics are covariant by default.
*
* In the context of Java, if covariance was the default behaviour, then the following would've been allowed:
*   A extends B => List<A> extends List<B>
*
* But in Java, this is not the case. In Java, generics are invariant by default,
* and therefore we use the wildcard operator with extends keyword to make java generics covariant as follows:
*
* List<E> is invariant               (default Java behaviour)
* List<? extends E> is covariant
* List<? super E> is contravariant
*
* */
public class PECS {
    static class Person {}
    static class Student extends Person {}
    static class Teacher extends Person {}

    private static void takeInTeacherParent(List<? super Teacher> teachers) {
        teachers.add(new Teacher());
        teachers.add(new Teacher());
        teachers.add(new Teacher());
    }

    private static void takeInStudentParent(List<? super Student> students) {
        students.add(new Student());
        students.add(new Student());
        students.add(new Student());
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        Student s1 = new Student();
        Student s2 = new Student();

        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();

        List<Person> pList = new ArrayList<>();
        List<Student> sList = new ArrayList<>();

        pList.add(s1); // (✅) allowed, since Student is a Person.
//        sList.add(p1); // (❌) not allowed, since Person is not a Student
        pList.addAll(sList); // (✅) allowed, since covariance for ArrayList::addAll method is allowed via `Collection<? extends E> items`

        // Best example to understand the usage of PECS is `Collections::copy` method.
        Collections.copy(pList, sList); // (✅) allowed, since covariance for Collections::copy method is allowed via `List<? extends T> src`

        /*
        * The definition of Collections::copy method is as follows:
        *   public static <T> void copy(List<? super T> dest, List<? extends T> src) { ... }
        *
        * If we assume:
        *   src => List<S>   |
        *   dest => List<D>  | To perform the copy, src has to be copied to dest, which means; "S extends D"
        *
        * Java defines a fictional type in-between S and D, which is called T, which in-turn means:
        *   S extends T extends D (or S ⊂ T ⊂ D) (or S extends D => "S extends T" and "T extends D")
        *
        * The reason why we've Collections::copy method defined as:
        *   public static <T> void copy(List<? super T> dest, List<? extends T> src) { ... }
        * is because we cannot use "? extends ?" as we cannot say for sure whether `src`'s type is a subtype of `dest`'s type or not.
        *
        * Hence,
        * - S extends T => ? extends T, and
        * - T extends D => ? super T (because "T extends ?" is not allowed in Java, instead we use "? super T")
        *
        * ? super T: means that the expected type is a supertype of T (or T itself).
        *            In other words, the type expected is something that T extends, which is the supertype of T.
        * */

        takeInTeacherParent(pList); // (✅) allowed, since contravariance
        takeInStudentParent(pList); // (✅) allowed, since contravariance
    }

}
