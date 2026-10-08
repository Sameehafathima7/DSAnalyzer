public class ArrayOps {
    private int[] data;   // stores the values
    private int size;     // how many values are stored right now

    public ArrayOps(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Insert at the end
    public void insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full!");
            return;
        }
        data[size++] = value;
        System.out.println("Inserted " + value);
    }

    // Insert at a given index (shift elements to the right)
    public void insertAt(int index, int value) {
        if (size == data.length) {
            System.out.println("Array is full!");
            return;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index! Valid range: 0 to " + size);
            return;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        System.out.println("Inserted " + value + " at index " + index);
    }

    // Delete first occurrence of a value (shift elements to the left)
    public void delete(int value) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        int idx = search(value);
        if (idx == -1) {
            System.out.println(value + " not found.");
            return;
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println("Deleted " + value);
    }

    // Returns index of value, or -1 if not found
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Returns a copy of the filled part (used by searching)
    public int[] toArray() {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        return copy;
    }

    public void menu() {
        int c;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (end)");
            System.out.println("2. Insert at index");
            System.out.println("3. Delete value");
            System.out.println("4. Search value");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ");
            switch (c) {
                case 1:
                    insert(InputHelper.readInt("Enter value: "));
                    break;
                case 2: {
                    int idx = InputHelper.readInt("Enter index: ");
                    int v = InputHelper.readInt("Enter value: ");
                    insertAt(idx, v);
                    break;
                }
                case 3:
                    delete(InputHelper.readInt("Enter value to delete: "));
                    break;
                case 4: {
                    int v = InputHelper.readInt("Enter value to search: ");
                    int idx = search(v);
                    if (idx == -1) System.out.println(v + " not found.");
                    else System.out.println(v + " found at index " + idx);
                    break;
                }
                case 5:
                    display();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-6.");
            }
        } while (c != 6);
    }
}