public class BubbleSort {
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

        // algoritmo de bubble
        for(int i = (len - 1); i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < len; i++)
        {
            System.out.print("|");

            System.out.print(" " + array[i] + " ");

        }
    }
}
