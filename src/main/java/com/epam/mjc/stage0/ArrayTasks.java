package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "fall"};

    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i > 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i : arr) {
            if (i > 0) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        int[][] result = new int[arr.length][];
        int[] lengths = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lengths[i] = arr[i].length;
        }
        // Sort the lengths in ascending order
        for (int i = 0; i < lengths.length - 1; i++) {
            for (int j = i + 1; j < lengths.length; j++) {
                if (lengths[i] > lengths[j]) {
                    int tempLength = lengths[i];
                    lengths[i] = lengths[j];
                    lengths[j] = tempLength;
                    int[] tempArray = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempArray;
                }
            }
        }
        // Sort the elements within each array in ascending order
        for (int i = 0; i < arr.length; i++) {
            result[i] = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j];
            }
            for (int j = 0; j < result[i].length - 1; j++) {
                for (int k = j + 1; k < result[i].length; k++) {
                    if (result[i][j] > result[i][k]) {
                        int temp = result[i][j];
                        result[i][j] = result[i][k];
                        result[i][k] = temp;
                    }
                }
            }
        }
        return result;
    }
}
