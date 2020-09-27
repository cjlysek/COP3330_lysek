import java.util.ArrayList;
import java.util.Scanner;
public class App
{
    public static int count = 0;

    public static boolean moreInput()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to calculate your BMI? Please enter 'Y' or 'N'.");
        String userInputChoice = in.nextLine();

        while(!(userInputChoice.equalsIgnoreCase("Y")) && !(userInputChoice.equalsIgnoreCase("N")))
        {
            System.out.println("Invalid option, please try again");
            userInputChoice = in.nextLine();
        }
        if(userInputChoice.equalsIgnoreCase("Y"))
        {
            return true;
        }
        else if(userInputChoice.equalsIgnoreCase("N"))
        {
            return false;
        }
        return true;
    }

    public static double getUserHeight()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your height in inches: ");
        double height = in.nextDouble();
        in.nextLine();

        while(height <= 0)
        {
            System.out.println("Invalid/Not positive input, please enter a correct height: ");
            height = in.nextDouble();
            in.nextLine();
        }
        return height;
    }

    public static double getUserWeight()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your weight in pounds: ");
        double weight = in.nextDouble();
        in.nextLine();

        while(weight <= 0)
        {
            System.out.println("Invalid/Not positive input, please enter a correct weight: ");
            weight = in.nextDouble();
            in.nextLine();
        }
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        double bodyMassIndex = bmi.calculateBMI(bmi.height, bmi.weight);
        String category = bmi.calculateCategory(bodyMassIndex);

        count++;
        System.out.println("\nBMI " + count + "'s Calculations: ");
        System.out.printf("BMI: %.1f\n", bodyMassIndex);
        System.out.println("Category: " + category);
        System.out.println("\n");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        double average = 0;
        double BMIHolder = 0;
        int count = 0;
        for(BodyMassIndex b: bmiData)
        {
            BMIHolder = b.calculateBMI(b.height, b.weight);
            average += b.calculateBMI(b.height, b.weight);
            count++;
            System.out.printf("Input " + count + "'s BMI Calculation: %.1f\n", BMIHolder);
        }
        average = average / count;
        System.out.printf("Average BMI score of data: %.1f\n", average);
    }
    
    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    
}
