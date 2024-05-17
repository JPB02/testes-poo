import java.util.ArrayList;
import java.util.Scanner;

public class PolyAsListTest {

    public static void main(String[] args) {

        PolyAsList poly = new PolyAsList();

        // Example:
        // 2.2x3 + 1.3x − 4.7 is represented by the list [−4.7, 1.3, 0, 2.2]
        poly.addMonomial(3, 2.2);
        poly.addMonomial(1, 1.3);
        poly.addMonomial(0, -4.7);

        ArrayList<Double> polynomial = poly.getPolyList();
        System.out.println("Polynomial List: " + polynomial);

        System.out.println("Degree of polynomial is: " + poly.getDegree());

        Scanner scn = new Scanner(System.in);
        System.out.print("Input the value of x: ");
        double x = scn.nextDouble();

        double calcRes = poly.calculatePolynomial(x);

        System.out.println("Solved the polynomial for x = " + x + "\nResult is: " + calcRes);

        PolyAsList derivativePoly = poly.derivative();
        ArrayList<Double> polynomialDerivative = derivativePoly.getPolyList();
        System.out.println("Derivative: " + polynomialDerivative);

    }

}
