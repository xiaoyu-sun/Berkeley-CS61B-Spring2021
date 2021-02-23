/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {


    /**
     * Returns the next number in a Collatz sequence, after input n
     * @param n
     * @return
     */
//    public static int nextNumber(int n) {
//        if (n % 2 == 0) {
//            return n / 2;
//        } else {
//            return 3 * n + 1;

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n  == 128) {
            return 1;
        } else if (n == 5) {
            return 3 * n + 1;
        } else {
            return n * 2;

        }
    }

    public static void main(String[] args) {
        int n = 5;
//        do {
//            System.out.print(n + " ");
//            n = nextNumber(n);
//        } while (n > 1);
//        System.out.print(n);

        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();

    }
}

