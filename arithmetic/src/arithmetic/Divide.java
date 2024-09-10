package arithmetic;

public class Divide {
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero is undefined.");
            return Double.NaN;
        }
    }
}
