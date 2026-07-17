package GeometryOOP;

public abstract class Shape {
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract String getName();

    public void display() {
        System.out.println(this);
    }
}
