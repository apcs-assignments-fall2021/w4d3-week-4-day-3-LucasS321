import sun.jvm.hotspot.utilities.IntArray;

import java.util.Arrays;

public class MyMain {
    // Write a method that prints out all the even numbers in an array backwards
    // Ex: printEvensBackwards([1, 2, 3, 4, 5, 6]) =>
    //     6
    //     4
    //     2
    public static void printEvensBackwards(int[] arr) {
        int[] newlist = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            if (arr[arr.length-x-1] % 2 == 0) {
                System.out.println(arr[arr.length - x - 1]);
            }
        }
        // REPLACE THIS WITH YOUR CODE
        return;
    }
    public static int[] returnBackwrds(int[] arr) {
        int[] newlist = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            newlist[x] = arr[arr.length-x-1];
        }
        // REPLACE THIS WITH YOUR CODE
        return newlist;
    }

    // Next, write a method that checks if an array is sorted in
    // strictly increasing order (i.e. each element must be greater
    // than the previous element)
    // Ex: isIncreasing([1, 2, 3, 4, 5, 6]) => true
    //     isIncreasing([1, 1, 3, 6, 7]) => false (because 1 is not > 1)
    //     isIncreasing([1, 2, 3, 2, 4, 5, 8]) => false
    public static boolean isIncreasing(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        /*
        int[] withoutduplicates = new int[0];
        int[] withoutduplicatesold = new int[0];
        for (int x: arr) {
            boolean found = false;
            for (int y: withoutduplicates) {
                if (x == y) {
                    found = true;
                }
            }
            if (!found) {
                withoutduplicatesold = withoutduplicates;
                withoutduplicates = new int[withoutduplicatesold.length + 1];
                for (int z = 0; z< withoutduplicatesold.length; z++) {
                    withoutduplicates[z] = withoutduplicatesold[x];
                }
            }
        }
        for (w)
            */
        int old = 0;
        for (int x: arr) {
            if (x <= old) {
                return false;
            } else {
                old = x;
            }
        }
        return true;
    }

    // (Maybe Optional):
    // Write a method that checks if an array is "balanced". An array
    // is balanced if the first and last values differ by at most 2, and
    // if the second and second to last values differ by at most 2, and so on
    // Ex: isBalanced([1, 2, 3, 2, 1]) => true
    //     isBalanced([1, 2, 3, 4, 1, -1]) => true
    //     isBalanced([1, 2, 3, 7, 2, 1]) => false (because 7 - 3 > 2)
    public static boolean isBalanced(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        int[] bkg = returnBackwrds(arr);
        for (int x = 0; x< arr.length;x++) {
            if (x < arr.length / 2) {
                if (!(Math.abs(arr[x] - bkg[x] ) <= 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Write a method that takes an array and checks if it contains
    // any duplicate values
    // Ex: containsDuplicates([1, 2, 3, 2, 1]) => true
    //     containsDuplicates([7, 2, 3, 4, 1, 5]) => false
    public static boolean containsDuplicates(int[] arr) {
        for (int x: arr) {
            int count = 0;
            for (int y:arr) {
                if (y == x) {
                    count ++;
                }
            }
            if (count > 1) {
                return true;
            }
        }
        // REPLACE THIS WITH YOUR CODE
        return false;
    }

    // Sorting:
    // Implement the bubble sort algorithm that we discussed in class
    // to sort our code
    // This algorithm returns the sorted array
    public static int[] bubbleSort(int[] arr) {
        int[] newarr = arr;
        for (int x = 0; x <arr.length; x++) {
          for (int y = 0; y < newarr.length-1; y++) {
              if (newarr[y+1] < newarr[y]) {
                  int temp = newarr[y+1];
                  newarr[y+1] = arr[y];
                  newarr[y] = temp;
              }
          }
        }
        return newarr;
    }


    public static void main(String[] args) {
        System.out.println("printEvensBackwards Tests:");
        printEvensBackwards(new int[] {1, 2, 3, 4, 5, 6});
        // 6
        // 4
        // 2

        System.out.println();
        System.out.println("isIncreasing Tests:");
        System.out.println(isIncreasing(new int[] {1, 2, 3, 4, 5, 6})); // true
        System.out.println(isIncreasing(new int[] {1, 1, 3, 6, 7})); // false (because 1 is not > 1)
        System.out.println(isIncreasing(new int[] {1, 2, 3, 2, 4, 5, 8})); // false

        System.out.println();
        System.out.println("isBalanced Tests:");
        System.out.println(isBalanced(new int[] {1, 2, 3, 2, 1})); // true
        System.out.println(isBalanced(new int[] {1, 2, 3, 4, 1, -1})); //true
        System.out.println(isBalanced(new int[] {1, 2, 3, 7, 2, 1})); // false (because 7 - 3 > 2)

        System.out.println();
        System.out.println("containsDuplicates Tests:");
        System.out.println(containsDuplicates(new int[] {1, 2, 3, 2, 1})); // true
        System.out.println(containsDuplicates(new int[] {7, 2, 3, 4, 1, 5})); // false

        System.out.println();
        System.out.println("Bubble Sort Tests");
        System.out.println(Arrays.toString(bubbleSort(new int[] {6, 1, 3, 8, 2, 9}))); // [1, 2, 3, 6, 8, 9]
        System.out.println(Arrays.toString(bubbleSort(new int[] {12, 5, 23, 74, 12, 86, 2}))); // [2, 5, 12, 23, 74, 86]
    }
}