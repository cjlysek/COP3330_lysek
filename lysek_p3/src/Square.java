//Code written by Connor Lysek

public class Square extends Shape
{
    private double side;

    public Square(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        double area = side * side;
        return area;
    }

    @Override
    public String getName()
    {
        return "square";
    }

    @Override
    public double getVolume()
    {
        return 0;
    }

}
