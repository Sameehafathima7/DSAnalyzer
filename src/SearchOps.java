import java.util.Arrays;

public class SearchOps {
    public static int steps = 0;   // comparisons made in the last search

    // O(n): check elements one by one
    public static int linearSearch(int[] arr, int key) {
        steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // O(log n): array MUST be sorted; halve the range each step
    public static int binarySearch(int[] arr, int key) {
        steps = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void menu(ArrayOps array) {
        int c;
        do {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search (on the array)");
            System.out.println("2. Binary Search (on sorted copy of the array)");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ");
            if (c >= 1 && c <= 3) {
                int[] arr = array.toArray();
                if (arr.length == 0) {
                    System.out.println("Array is empty! Insert values in Array Operations first.");
                    continue;
                }
                int key = InputHelper.readInt("Enter value to search: ");
                if (c == 1) {
                    int idx = linearSearch(arr, key);
                    System.out.println(idx == -1 ? "Not found." : "Found at index " + idx);
                    System.out.println("Steps: " + steps);
                } else {
                    Arrays.sort(arr);   // binary search needs sorted data
                    System.out.println("Sorted array: " + Arrays.toString(arr));
                    if (c == 2) {
                        int idx = binarySearch(arr, key);
                        System.out.println(idx == -1 ? "Not found." : "Found at index " + idx);
                        System.out.println("Steps: " + steps);
                    } else {
                        linearSearch(arr, key);
                        int linSteps = steps;
                        binarySearch(arr, key);
                        int binSteps = steps;
                        System.out.println("Linear Search steps: " + linSteps);
                        System.out.println("Binary Search steps: " + binSteps);
                    }
                }
            } else if (c != 4) {
                System.out.println("Invalid choice. Enter 1-4.");
            }
        } while (c != 4);
    }
}