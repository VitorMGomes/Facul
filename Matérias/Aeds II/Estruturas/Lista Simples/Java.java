import java.util.*;

class MyList {
    private int[] array;
    private int n;

    public void start(int size) {
        array = new int[size];
        n = 0;
    }

    void insertEnding(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("The list is full, failed to insert in the end");
        }

        array[n] = x;
        n++;
    }

    void insertBeginning(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("List is full, failed to insert in the beginning");
        }

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        n++;
    }

    void insert(int x, int pos) throws Exception {
        if (n >= array.length) {
            throw new Exception("Failed to insert, list is full");
        }
        if (pos < 0 || pos > n) {
            throw new Exception("Invalid position");
        }

        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        n++;
    }

    int remove(int pos) throws Exception {
        if (n == 0) {
            throw new Exception("Impossible to remove, the list is empty");
        }

        if (pos < 0 || pos >= n) {
            throw new Exception("Invalid position");
        }

        int resp = array[pos];

        for (int i = pos; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        n--;

        return resp;
    }

    int removeEnding() throws Exception {
        if (n == 0) {
            throw new Exception("The list is already empty");
        }
        int resp = array[n - 1];
        n--;

        return resp;
    }

    int removeBeginning() throws Exception {
        if (n == 0) {
            throw new Exception("The list is already empty");
        }

        int resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    void printList() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

public class Java {
    public static void main(String[] args) {
        try {
            MyList list = new MyList();
            list.start(5);

            // Insert elements
            list.insertEnding(10);
            list.insertEnding(20);
            list.insertEnding(30);
            list.insertBeginning(5);
            list.insert(15, 2);

            // Print the list
            System.out.println("List after inserts:");
            list.printList();

            // Remove elements
            System.out.println("Removed element from beginning: " + list.removeBeginning());
            System.out.println("Removed element from end: " + list.removeEnding());
            System.out.println("Removed element from position 1: " + list.remove(1));

            // Print the list
            System.out.println("List after removals:");
            list.printList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
