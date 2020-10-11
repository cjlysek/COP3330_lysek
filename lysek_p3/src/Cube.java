//Code written by Connor Lysek

public class Cube extends Shape3D
{
    private double side;

    public Cube(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        double area = 6 * (Math.pow(side, 2));
        return area;
    }

    @Override
    public String getName()
    {
        return "cube";
    }

    @Override
    public double getVolume()
    {
        double volume = Math.pow(side, 3);
        return volume;
    }
}
