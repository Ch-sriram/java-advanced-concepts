package lambda;

/**
 * Operation is a functional interface used for defining a
 * lambda expression for performing an operation on two operands.
 *
 * @param <T> any invariant type (e.g. Integer, String, etc.)
 */
@FunctionalInterface
public interface Operation<T> {
    T operate(T t1, T t2);
}
