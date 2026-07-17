package GeometryOOP;

import java.util.Scanner;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {}

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid Triangle");
        }
        setSides(sideA, sideB, sideC);
    }

    public void setSides(double sideA, double sideB, double sideC) {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid Triangle");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private static boolean isValid(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
            && a + b > c
            && a + c > b
            && b + c > a;
    }

    public static Triangle inputTriangle(Scanner sc) {
        double sideA;
        double sideB;
        double sideC;

        do {
            System.out.println("Enter side A: ");
            sideA = sc.nextDouble();
            System.out.println("Enter side B: ");
            sideB = sc.nextDouble();
            System.out.println("Enter side C: ");
            sideC = sc.nextDouble();

            if (!isValid(sideA, sideB, sideC)) {
                System.out.println("Triangle Invalid");
            }
        } while (!isValid(sideA, sideB, sideC));

        return new Triangle(sideA, sideB, sideC);
    }

    public void setSideA(double sideA) {
        setSides(sideA, this.sideB, this.sideC);
    }

    public void setSideB(double sideB) {
        setSides(this.sideA, sideB, this.sideC);
    }

    public void setSideC(double sideC) {
        setSides(this.sideA, this.sideB, sideC);
    }

    @Override
    public double getPerimeter() {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid Triangle");
        }
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid Triangle");
        }
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("%s: Peremeter = %.2f, Area = %.2f", getName(), getPerimeter(), getArea());
    }
}
