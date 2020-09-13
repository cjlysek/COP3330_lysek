import java.util.*;
public class Decrypter
{
    public String decrypt(String StringToDecrypt){
        int[] DecryptStringToIntArray = StringToArray(StringToDecrypt);
        int[] SwappedString = DecryptSwappedArray(DecryptStringToIntArray);
        String FinalDecryptedString = IntArrayToString(SwappedString);

        return FinalDecryptedString;

    }

    public int[] StringToArray(String str)
    {
        int[] intArray = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            intArray[i] = (str.charAt(i) - '0');
        }
        int[] swappedArray = swapIntArray(intArray);

        return swappedArray;
    }

    int[] swapIntArray(int[] BeforeSwapped)
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

    public int[] DecryptSwappedArray(int[] SwappedArray)
    {
        for(int i = 0; i < 4; i++){
            SwappedArray[i] = SwappedArray[i] - 7;
            if(SwappedArray[i] < 0){
                SwappedArray[i] = 10 + SwappedArray[i];
            }
        }
        return SwappedArray;
    }

    public String IntArrayToString(int [] finalArray)
    {
        String finalString = Arrays.toString(finalArray);
        finalString = finalString.replaceAll(", ", "").replace("[", "").replace("]", "");
        return finalString;
    }
}
