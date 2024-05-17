import java.util.ArrayList;

import static java.lang.Math.pow;

/*
Polynomial functions:

public void addMonomial(int degree , double coef);
public double calculate(double x);
public int degree ();
public PolyAsList derivative ();
*/

public class PolyAsList {

    // Class variables
    private ArrayList<Double> polyList;

    // Initialization
    public PolyAsList() {
        polyList = new ArrayList<>();
    }

    // Getters & Setters
    public ArrayList<Double> getPolyList() {
        return new ArrayList<>(this.polyList);
    }

    public void setPolyList(ArrayList<Double> polyList) {
        this.polyList = polyList;
    }

    public int getDegree() {
        return this.polyList.size()-1;
    }

    // Methods

    // Function to add a monomial to the polynomial list
    public void addMonomial(int degree, double coef) {
        // Find the location to add (search by degree == index)
        // Example: if degree == 3, then index = 3 else 0.0

        // If degree is 0, just add in the beginning
        if(degree == 0 && !this.polyList.isEmpty()) {
            this.polyList.set(0, coef);
        }

        else if (degree == 0) {
            this.polyList.add(0, coef);
        }

        // Else, get space for adding
        else if (this.polyList.size() <= degree){
            while(this.polyList.size() <= degree) {
                this.polyList.add(this.polyList.size(), (double) 0);
            }
            this.polyList.set(degree, coef);
        }

        else  {
            this.polyList.set(degree, coef);
        }

    }

    public double calculatePolynomial(double x) {

        double res = 0.0;

        for(int i = 0; i < this.polyList.size(); i++) {
            res += this.polyList.get(i) * pow(x, i);
        }

        return res;
    }

    public PolyAsList derivative() {

        PolyAsList derivativePoly = new PolyAsList();

        for(int i = 1; i < this.polyList.size(); i++) {
            double monomial = this.polyList.get(i)*i;
            derivativePoly.addMonomial(i-1, monomial);
        }

        return derivativePoly;
    }

}
