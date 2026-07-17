package GeometryOOP;

import java.util.Scanner;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public static Circle inputCircle(Scanner sc) {
        double radius;
        do {
            System.out.println("Enter Radius: ");
            radius = sc.nextDouble();
            if (radius <= 0) {
                System.out.println("Radius must > 0");
            }
        } while (radius <= 0);

        return new Circle(radius);
    }

    public void setRadius(double radius) {
        if (!isValid(radius)) {
            throw new IllegalArgumentException("Radius must > 0");
        }
        this.radius = radius;
    }

    private boolean isValid(double radius) {
        return radius > 0;
    }

    @Override
    public double getPerimeter() {
        if (!isValid(radius)) {
            throw new IllegalArgumentException("Radius must > 0");
        }
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        if (!isValid(radius)) {
            throw new IllegalArgumentException("Radius must > 0");
        }
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("%s: Perimeter = %.2f, Area = %.2f", getName(), getPerimeter(), getArea());
    }
}
