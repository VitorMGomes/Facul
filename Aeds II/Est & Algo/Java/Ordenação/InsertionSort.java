import java.util.*;

public class InsertionSort
{

    public static void main(String[] args)
    {
        int[] array = {98, 70, 23, 34, 87, 71, 43, 15, 9, 30, 76, 53, 55, 37, 11, 92, 67, 2, 79, 5, 20, 49, 7, 21, 46, 64, 17, 72, 94, 87, 91};
        int len = array.length;


        for(int i = 0; i < len; i++)
        {
            System.out.print("|");

            System.out.print(" " + array[i] + " ");

        }

        System.out.println("\n Ordenando...");

        // algoritmo de inserção
        for(int i = 1; i < len; i++)
        {
            int tmp = array[i];
            int j = i - 1;

            while((j >= 0) && array[j] > tmp)
            {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;
        }


        for(int i = 0; i < len; i++)
        {
            System.out.print("|");

            System.out.print(" " + array[i] + " ");

        }
    }
}