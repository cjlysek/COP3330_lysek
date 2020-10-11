public class Triangle extends Shape
{
    private double num1;
    private double num2;

    public Triangle(double num1, double num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public double getArea()
    {
        double area = (0.5 * (num1 * num2));
        return area;
    }

    @Override
    public String getName()
    {
        return "triangle";
    }

    @Override
    public double getVolume()
    {
        return 0;
    }
}
