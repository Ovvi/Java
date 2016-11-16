package hashTable;


import java.util.Arrays;

public class HashFunction {

    private String[] theArray;
    private int arraySize;

    public HashFunction(int size) {
        arraySize = size;
        theArray = new String[arraySize];
        Arrays.fill(theArray, "-1");
    }


    public static void main(String[] args) {
        HashFunction theFunc = new HashFunction(30);
        String[] elementsToAdd = {"3","21","15","4","25","11","7"};
        String[] elementsToAdd2 = { "218", "210", "170", "214", "268", "317",
                "235", "809", "900", "723", "678", "1", "16", "999", "890",
                "320", "998", "978", "754", "990", "640", "984", "320", "321",
                "400", "415", "379", "50", "660", "624" };
        //theFunc.hashFunctionOne(elementsToAdd,theFunc.theArray);
        theFunc.hashFunctionTwo(elementsToAdd2,theFunc.theArray);
        theFunc.display();
        System.out.println(theFunc.findKey("640"));

    }


    public void display() {
        int increment = 0;

        for (int m = 0; m < 3; m++) {
            increment += 10;

            for (int i = increment - 10; i < increment; i++) {
                System.out.format("| %3s " + " ", i);
            }
            System.out.println("|");

            for (int i = increment - 10; i < increment; i++) {
                if (theArray[i].equals("-1")) System.out.print("|      ");
                else System.out.print(String.format("| %3s " + " ", theArray[i]));
            }
            System.out.println("|");
            System.out.println();
        }
    }


    public void hashFunctionOne(String[] stringForArray, String[] theArray) {

        for (int i = 0; i < stringForArray.length; i++) {
            String newElement = stringForArray[i];
            theArray[Integer.parseInt(newElement)] = newElement;
        }
    }

    public void hashFunctionTwo(String[] stringForArray, String[] theArray) {

        for (int i = 0; i < stringForArray.length; i++) {
            String newElement = stringForArray[i];
            int indexValue = Integer.parseInt(newElement) % 29;

            while (theArray[indexValue] != "-1") {
                ++indexValue;
                indexValue %= arraySize;
            }
            theArray[indexValue] = newElement;
        }
    }

    public String findKey(String key) {

        int arrayIndexHash = Integer.parseInt(key) % 29;
        int counter = 0;
        String notFound = "The key was not found";

        while (theArray[arrayIndexHash] != "-1" && counter < theArray.length){
            if (theArray[arrayIndexHash] == key){
                System.out.println(key+" was found at index "+arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;
            arrayIndexHash %= arraySize;
            counter++;
        }
        return notFound;
    }


}
