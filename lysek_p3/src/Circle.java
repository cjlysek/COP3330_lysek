public class Circle extends Shape
{
    private double num1;
    
    public Circle(double num1) {
        this.num1 = num1;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public String getName() {
        return "circle";
    }
}
