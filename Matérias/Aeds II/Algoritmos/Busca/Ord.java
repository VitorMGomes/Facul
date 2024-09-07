import java.util.*;

public class Ord {
    int comparacoes;
    int movimentacoes;

    public static void selectionSort(CustomArray array, Scanner scanf)
    {
        //Selection Sort

        CustomArray Copia1 = array;

        
    }

    public static void bubbleSort(CustomArray array, Scanner scanf)
    {
        CustomArray Copia1 = array;

    }

    public static void insertionSort(CustomArray array, Scanner scanf)
    {
        CustomArray Copia1 = array;

    }   

    public static void main()
    {
        Scanner scanf = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do array que deseja: ");
        int tam = scanf.nextInt();
        CustomArray array = new CustomArray(tam);

        // array.printArray();
        array.customShuffle();
        // array.printArray();

        System.out.println("(1) Selection Sort; \n(2) Bubble Sort\n (3) Insertion Sort \nDigite qual deseja utilizar: ");
        int choose = scanf.nextInt();
        switch(choose)
        {
            case 1:
            selectionSort(array, scanf);
            break;

            case 2:
            bubbleSort(array, scanf);
            break;

            case 3:
            insertionSort(array, scanf);
            break;

            
        }   
        
        scanf.close();
    }
}
