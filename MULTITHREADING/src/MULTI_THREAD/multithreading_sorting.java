package MULTI_THREAD;

import java.util.Arrays;
import java.util.Scanner;

class BubbleSortThread extends Thread {
    private int[] array;

    public BubbleSortThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        bubbleSort(array);
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap the elements
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public int[] getSortedArray() {
        return array;
    }
}

class MergeThread extends Thread {
    private int[][] sortedSubArrays;
    private int[] mergedArray;

    public MergeThread(int[][] sortedSubArrays, int totalLength) {
        this.sortedSubArrays = sortedSubArrays;
        this.mergedArray = new int[totalLength];
    }

    @Override
    public void run() {
        mergeSortedSubArrays();
    }

    private void mergeSortedSubArrays() {
        int totalLength = mergedArray.length;
        int[] indices = new int[sortedSubArrays.length];

        for (int i = 0; i < totalLength; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < sortedSubArrays.length; j++) {
                if (indices[j] < sortedSubArrays[j].length && sortedSubArrays[j][indices[j]] < minValue) {
                    minValue = sortedSubArrays[j][indices[j]];
                    minIndex = j;
                }
            }

            mergedArray[i] = minValue;
            indices[minIndex]++;
        }
    }

    public int[] getMergedArray() {
        return mergedArray;
    }
}

public class multithreading_sorting {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the number of elements in the array: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        // Get the array elements from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of sub-arrays (and threads): ");
        int n = scanner.nextInt(); // Number of sub-arrays (and threads)

        // Split the array into n sub-arrays
        int length = array.length;
        int[][] subArrays = new int[n][];
        int start = 0;
        int subArraySize = length / n;

        for (int i = 0; i < n; i++) {
            int end = (i == n - 1) ? length : start + subArraySize;
            subArrays[i] = Arrays.copyOfRange(array, start, end);
            start = end;
        }

        // Create and start bubble sort threads for each sub-array
        BubbleSortThread[] sortThreads = new BubbleSortThread[n];
        for (int i = 0; i < n; i++) {
            sortThreads[i] = new BubbleSortThread(subArrays[i]);
            sortThreads[i].start();
        }

        // Wait for all sorting threads to finish
        for (int i = 0; i < n; i++) {
            sortThreads[i].join();
        }

        // Merge the sorted sub-arrays using another thread
        int[][] sortedSubArrays = new int[n][];
        for (int i = 0; i < n; i++) {
            sortedSubArrays[i] = sortThreads[i].getSortedArray();
        }

        MergeThread mergeThread = new MergeThread(sortedSubArrays, array.length);
        mergeThread.start();
        mergeThread.join();

        // Get the merged sorted array
        int[] sortedArray = mergeThread.getMergedArray();

        // Output the sorted array
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
