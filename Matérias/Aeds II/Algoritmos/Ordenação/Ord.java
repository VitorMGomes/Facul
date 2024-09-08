import java.util.*;

public class Ord {
    static int comparacoes;
    static int movimentacoes;

    public static void selectionSort(CustomArray array, Scanner scanf)
    {
        CustomArray Copia1 = array;
        

        movimentacoes = 0;
        comparacoes = 0;

        System.out.println("O array inicial é esse: ");
        array.printArray();
        int tam = array.getTam();
        
        //Selection sort

        for(int i = 0; i < tam - 1; i++)
        {
            int menor = i;
            for(int j = i + 1; j < tam; j++)
            {   
                comparacoes += 2;
                if(array.array[menor] > array.array[j])
                {
                    menor = j;
                }
            }
            movimentacoes += 3;
            int temp = array.array[menor];
            array.array[menor] = array.array[i];
            array.array[i] = temp;
        }

        System.out.println("Após ordenação: ");
        array.printArray();
        System.out.println("Foram feitas " + comparacoes + " comparacoes e " + movimentacoes + " movimentaçoẽs");


        array = Copia1;
        movimentacoes = 0;
        comparacoes = 0;
        //Selection sort Optimized

        for(int i = 0; i < tam / 2; i++)
        {
            int menor = i;
            int maior = i;
            for(int j = i + 1; j < tam - i; j++)
            {   
                if(array.array[menor] > array.array[j])
                {
                    comparacoes += 2;
                    menor = j;
                }
                else if(array.array[maior] < array.array[j])
                {
                    maior = j;
                }
                comparacoes += 4;
            }
            movimentacoes += 3;
            int temp = array.array[menor];
            array.array[menor] = array.array[i];
            array.array[i] = temp;

            if (maior == i) {
                maior = menor;
            }

            movimentacoes += 3;
            temp = array.array[maior];
            array.array[maior] = array.array[tam - i - 1];
            array.array[tam - i - 1] = temp;
        }

        System.out.println("Após ordenação otimizada: ");
        array.printArray();
        System.out.println("Foram feitas " + comparacoes + " comparacoes e " + movimentacoes + " movimentaçoẽs");
        
    }

    public static void bubbleSort(CustomArray array, Scanner scanf)
    {
        CustomArray Copia1 = array;

    }

    public static void insertionSort(CustomArray array, Scanner scanf)
    {
        CustomArray Copia1 = array;

    }   

    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do array que deseja: ");
        int tam = scanf.nextInt();
        CustomArray array = new CustomArray(tam);

        // array.printArray();
        array.customShuffle();
        // array.printArray();

        System.out.println("(1) Selection Sort; \n(2) Bubble Sort\n(3) Insertion Sort\nDigite qual deseja utilizar: ");
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
