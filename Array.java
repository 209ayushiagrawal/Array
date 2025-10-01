// Sorting logic branch 

import java.util.Scanner;

public class Array {

    // Selection Sort (no built-in sorting)
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Find second smallest and second largest (without relying on sort)
    static int[] findSecondMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            // update min and secondMin
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num > min && num < secondMin) {
                secondMin = num;
            }

            // update max and secondMax
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num < max && num > secondMax) {
                secondMax = num;
            }
        }

        return new int[]{secondMin, secondMax};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 different integers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }

        // Sort array
        selectionSort(numbers);

        // Find second smallest and second largest
        int[] result = findSecondMinMax(numbers);

        // Print results
        System.out.print("Sorted array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nSecond smallest: " + result[0]);
        System.out.println("Second largest: " + result[1]);

        sc.close();
    }
}

