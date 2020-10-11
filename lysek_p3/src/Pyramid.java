import static java.lang.Math.sqrt;

public class Pyramid extends Shape
{
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea()
    {
        double area = length * width + length * sqrt(Math.pow((width / 2), 2) + Math.pow(height, 2)) + width * sqrt((Math.pow(length / 2, 2) + Math.pow(height, 2)));
        return area;
    }

    @Override
    public String getName()
    {
        return "pyramid";
    }

    @Override
    public double getVolume()
    {
        double volume = length * width * (height / 3);
        return volume;
    }
}
