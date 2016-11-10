package arrayStructuresAndAlgorithms;


public class ArrayStructures {

    private int[] theArray;
    private int arraySize;

    public ArrayStructures(int size) {
        arraySize = size;
        theArray = new int[50];
        generateArray();
    }

    private void generateArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    public void displayArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < arraySize; i++) {
            System.out.print(String.format("| %2s " + " ", theArray[i]));
        }
        System.out.println("|");
    }

    public int getValueIndex(int index) {
        if (index < arraySize) {
            return theArray[index];
        }
        return 0;
    }

    public boolean containValue(int value) {
        boolean valueInArray = false;
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void insertValue(int value) {
        if (arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    public void deleteIndex(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    public void linearSearch(int value) {
        boolean valueInArray = false;
        String indexValue = "";

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
                indexValue += i + " ";
            }
        }
        if (!valueInArray) {
            indexValue = "None";
        }
        System.out.println("The value " + value + " was found at the following " + indexValue);
    }

    public void binarySearch(int value) {
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            if (theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else if (theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else {
                System.out.println("The value was found at the index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
    }

    public void bubbleSort() {
        for (int i = arraySize - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    swapValue(j, j + 1);
                }
            }

        }
    }

    private void swapValue(int one, int two) {
        int temp = theArray[one];
        theArray[one] = theArray[two];
        theArray[two] = temp;
    }

    public void selectionSort() {
        for (int x = 0; x < arraySize; x++) {
            int minimum = x;
            for (int y = x; y < arraySize; y++) {
                if (theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValue(x, minimum);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while ((j > 0) && (theArray[j - 1] > toInsert)) {
                theArray[j] = theArray[j - 1];
                j--;
            }
            theArray[j] = toInsert;
        }
    }

    public void shellSort() {
        int inner, outer, temp;
        int interval = 1;

        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (outer = interval; outer < arraySize; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > interval - 1 && theArray[inner - interval] >= temp) {
                    theArray[inner] = theArray[inner - interval];
                    inner -= interval;
                }
                theArray[inner] = temp;
            }
            interval = (interval - 1) / 3;
        }
    }

    public int partitionArray(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (theArray[++leftPointer] < pivot)
                ;
            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swapValue(leftPointer, rightPointer);
            }
        }
        swapValue(leftPointer, right);
        return leftPointer;
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0){
            return;
        }else{
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left,right,pivot);

            quickSort(pivotLocation+1,right);
            quickSort(left,pivotLocation-1);
        }
    }


    public static void main(String[] args) {
        ArrayStructures array = new ArrayStructures(10);

        array.displayArray();
        //array.bubbleSort();
        //array.selectionSort();
        //array.insertionSort();
        //array.shellSort();
        array.quickSort(0,9);
        array.displayArray();


    }
}




















