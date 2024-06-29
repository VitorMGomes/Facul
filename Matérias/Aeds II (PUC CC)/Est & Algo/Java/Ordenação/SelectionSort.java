import java.util.*;

public class SelectionSort {
    


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

        // algoritmo de seleção
        for(int i = 0; i < (len - 1); i++)
        {
            int menor = i;
            for(int j = (i + 1); j < len; j++)
            {
                if (array[menor] > array[j])
                {
                    menor = j;
                }
            }

            int aux = array[i];
            array[i] = array[menor];
            array[menor] = aux;

        }

        for(int i = 0; i < len; i++)
        {
            System.out.print("|");

            System.out.print(" " + array[i] + " ");

        }

    }
}

// 3(n-1) movimentações

// c(n) =  (n^2)/2 - n/2

//custo linear no tamanho da entrada para o número de movimentações de registros

//não é adaptavel - não importa se o arquivo está parcialmente ordenado

//algoritmo não estável