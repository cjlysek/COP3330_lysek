//Code written by Connor Lysek

public class Circle extends Shape2D
{
    private double radius;
    private final double pi = 3.14159;
    
    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        double area = pi * (Math.pow(radius, 2));
        return area;
    }

    @Override
    public String getName()
    {
        return "circle";
    }


}
