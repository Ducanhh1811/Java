package GeometryOOP;

import java.util.Scanner;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (!isValid(width, height)) {
            throw new IllegalArgumentException("Width and Height must > 0");
        }
        setSize(width, height);
    }

    public static Rectangle inputRectangle(Scanner scanner) {
        double width;
        double height;

        do {
            System.out.println("Enter width: ");
            width = scanner.nextDouble();
            System.out.println("Enter height: ");
            height = scanner.nextDouble();
            if (width <= 0 || height <= 0) {
                System.out.println("Width and height must > 0");
            }
        } while (width <= 0 || height <= 0);

        return new Rectangle(width, height);
    }

    public void setSize(double width, double height) {
        if (!isValid(width, height)) {
            throw new IllegalArgumentException("Width and Height must > 0");
        }
        this.width = width;
        this.height = height;
    }

    private boolean isValid(double width, double height) {
        return width > 0 && height > 0;
    }

    public void setWidth(double width) {
        setSize(width, this.height);
    }

    public void setHeight(double height) {
        setSize(this.width, height);
    }

    @Override
    public double getPerimeter() {
        if (!isValid(width, height)) {
            throw new IllegalArgumentException("Width and Height must > 0");
        }
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        if (!isValid(width, height)) {
            throw new IllegalArgumentException("Width and Height must > 0");
        }
        return width * height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return String.format("%s: Perimeter = %.2f, Area = %.2f", getName(), getPerimeter(), getArea());
    }
}
