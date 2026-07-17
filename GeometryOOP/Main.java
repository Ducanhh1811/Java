package GeometryOOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        Triangle triangle = Triangle.inputTriangle(sc);
        Circle circle = Circle.inputCircle(sc);
        Rectangle rectangle = Rectangle.inputRectangle(sc);

        triangle.display();
        circle.display();
        rectangle.display();

        sc.close();
    }
}
