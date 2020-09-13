import java.util.*;
public class Encrypter
{
    public String encrypt(String StringToEncrypt){
        int[] EncryptStringToIntArray = StringToArray(StringToEncrypt);
        String FinalEncryptedString = IntArrayToString(EncryptStringToIntArray);

        return FinalEncryptedString;
    }

    public int[] StringToArray(String str)
    {
        int[] intArray = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            intArray[i] = (((str.charAt(i)- '0') + 7) % 10);
        }
        int[] swappedArray = swapIntArray(intArray);


        return swappedArray;
    }

    public int[] swapIntArray(int [] BeforeSwapped)
    {
        //Empty list to hold values when swapping
        int [] placeHolder = new int[4];

        //Store the values of second and fourth digit
        placeHolder[1] = BeforeSwapped[1];
        placeHolder[2] = BeforeSwapped[3];

        //Swap the values of second and fourth digit
        BeforeSwapped[1] = placeHolder[2];
        BeforeSwapped[3] = placeHolder[1];

        //Store the values of first and third digit
        placeHolder[1] = BeforeSwapped[0];
        placeHolder[2] = BeforeSwapped[2];

        //Swap the values of first and third digit
        BeforeSwapped[0] = placeHolder[2];
        BeforeSwapped[2] = placeHolder[1];

        int[] swappedArray = SwapBeforeAndAfterArray(BeforeSwapped);

        return swappedArray;
    }

    public int[] SwapBeforeAndAfterArray(int [] oldArray)
    {
        int[] newArray = new int[4];
        for(int i = 0; i < 4; i++){
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    public String IntArrayToString(int [] finalArray)
    {
        String finalString = Arrays.toString(finalArray);
        finalString = finalString.replaceAll(", ", "").replace("[", "").replace("]", "");
        return finalString;
    }

}


