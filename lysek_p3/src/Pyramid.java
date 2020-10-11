public class Pyramid extends Shape
{
    private double side1;
    private double side2;
    private double side3;

    public Pyramid(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea()
    {
        return 0;
    }

    @Override
    public String getName()
    {
        return "pyramid";
    }

    @Override
    public double getVolume()
    {
        return 0;
    }
}
