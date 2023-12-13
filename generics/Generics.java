package generics;

import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {
        System.out.println("Hello, World! (Generics)");

        /*
        * If there's a tree or a linked list, we can use generics to make such data structures.
        * To make them accept any type of data, we can use generics.
        * Example below is restricted int[] array (or String[] array, or any other type of array), which is not a generic construct.
        * */

        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"a", "b", "c", "d", "e"};

        /*
        * To seemingly make a generic array, we can use Object[] array (or ArrayList<Object>), but it faces its own challenges.
        * */

        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList.add(1);
        objectArrayList.add("a");
        objectArrayList.add(1.0);
        objectArrayList.add(true);

        System.out.println(objectArrayList);

        /*
        * If we look into ArrayList::add method, we can see that it accepts a fictional type E; which is a generic type.
        * So if we specify the type of the ArrayList, we can make it accept only that type of data. Example below.
        * */

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
//        integerArrayList.add(true); // This will throw an error, because we specified the type of the ArrayList to be Integer.

        System.out.println(integerArrayList);

        /*
        * Definition of ArrayList::add method:
        * public boolean add(E e) { ... } // Here, E is a generic type, which is fictional in nature.
        *                                 // When creating `integerArrayList`, we specified the type of the ArrayList to be Integer.
        *                                 // And so, E here is replaced by Integer.
        * */

        /*
        * IMPORTANT NOTE:
        * --------------
        *
        * Generics are only used at compile time, and not at runtime. Therefore, by this understanding, we can say that
        * generics are a compile time construct, and both `objectArrayList` and `integerArrayList` are the same at runtime.
        *
        * */
    }
}
