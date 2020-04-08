/**
 * Calculates the factorial of the given number n
 *
 * @param n >= 0
 *
 * @return factorial value
 */
public static long factorial(long n) {
    // write your code here
        return LongStream.rangeClosed(1, n).reduce(1, (acc, elem) -> acc * elem);
}