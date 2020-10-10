public class Square extends Shape {
    private double area;

    public Square(double i) {
        this.area = area;
        area = i;
    }

    @Override
    public double getArea() {
        return area * area;
    }

    @Override
    public String getName() {
        return "square";
    }

}
