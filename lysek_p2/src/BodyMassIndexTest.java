import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @Test
    public void testCalculateBMI()
    {
        BodyMassIndex b = new BodyMassIndex(72, 180);
        double BMI = b.calculateBMI(72,180);
        assertEquals( 24.4097222222222222, BMI);
    }

    @Test
    public void testCalculateCategoryUnderweight()
    {
        BodyMassIndex b = new BodyMassIndex(72, 100);
        double bmi = b.calculateBMI(72,100);

        String category = b.calculateCategory(bmi);

        assertEquals(category, "Underweight");
    }

    @Test
    public void testCalculateCategoryNormalWeight()
    {
        BodyMassIndex b = new BodyMassIndex(72, 150);
        double bmi = b.calculateBMI(72,160);

        String category = b.calculateCategory(bmi);

        assertEquals(category, "Normal Weight");
    }




    @Test
    public void testCalculateCategoryOverweight()
    {
        BodyMassIndex b = new BodyMassIndex(50, 100);
        double bmi = b.calculateBMI(50,100);

        String category = b.calculateCategory(bmi);

        assertEquals(category, "Overweight");
    }
}