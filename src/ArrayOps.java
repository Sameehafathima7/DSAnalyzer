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
}
