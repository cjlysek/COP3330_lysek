public class Square extends Shape {
    private double side;

    public Square(double num1) {
        this.side = num1;
    }

    @Override
    public double getArea() {
        double area = side * side;
        return area;
    }

    @Override
    public String getName() {
        return "square";
    }

}
