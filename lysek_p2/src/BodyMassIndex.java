public class BodyMassIndex
{
    public double height;
    public double weight;


    public BodyMassIndex(double height, double weight)
    {

        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI(double height, double weight)
    {
        double calculatedBMI = (703 * weight) / (Math.pow(height, 2));
        return calculatedBMI;
    }

    public String calculateCategory(double bodyMassIndex)
    {
        if(bodyMassIndex < 18.5 )
        {
            return "Underweight";
        }
        else if(bodyMassIndex >= 18.5 && bodyMassIndex <= 24.9)
        {
            return "Normal Weight";
        }
        else if(bodyMassIndex >= 25 && bodyMassIndex <= 29.9)
        {
            return "Overweight";
        }
        else
            return "Obesity";
    }

}
