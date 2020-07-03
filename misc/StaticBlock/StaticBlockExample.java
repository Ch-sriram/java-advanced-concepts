package misc.StaticBlock;

/**
 * Any code inside a "static {...}" aka static block is always executed even before the main() method is executed. We use static block when we use Java for
 * backend purposes in JDBC. We also use the static block for preprocessing purposes.
 */

public class StaticBlockExample {
    static {
        System.out.println("Inside static {...} a.k.a static block");
    }

    public static void main(String[] args) {
        System.out.println("Inside main() method");
    }
}

/**
 * Output
 * ------
 *  
 * Inside static {...} a.k.a static block
 * Inside main() method
 */