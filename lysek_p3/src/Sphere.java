public class Sphere extends Shape
{
    private double radius;
    private final double pi = 3.14159;

    public Sphere(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        double area = 4 * pi * Math.pow(radius, 2);
        return area;
    }

    @Override
    public String getName()
    {
        return "sphere";
    }

    @Override
    public double getVolume()
    {
        double volume = 4 * pi * (Math.pow(radius, 3) / 3);
        return volume;
    }
}
