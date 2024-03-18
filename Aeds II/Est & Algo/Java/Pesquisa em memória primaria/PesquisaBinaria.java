import java.util.*;

public class PesquisaBinaria 
{
    public static boolean PsqBinaria(int[] array, int x)
    {
        boolean resp = false;

        int dir = (array.length - 1);
        int esq = 0;
        int meio;

        while(esq <= dir)
        {
            meio = (esq + dir) / 2;
            if(x == array[meio])
            {
                resp = true;
                esq = dir + 1;
            }
            else if(x > array[meio])
            {
                esq = meio + 1;
            }
            else
            {
                dir = meio - 1;
            }
        }

        return resp;
    }


    public static boolean PsqBinariaRec(int[] array, int x, int esq, int dir)
    {   
        boolean resp;
        int meio = (esq + dir) / 2;

        if(esq > dir)
        {
            resp = false;
        }
        else if(x == array[meio])
        {
            resp = true;
        }
        else if(x > array[meio])
        {
            resp = PsqBinariaRec(array, x, esq + 1, dir);
        }
        else
        {
            resp = PsqBinariaRec(array, x, esq, meio - 1);
        }

        return resp;
    }



    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);

        
        int[] array = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 23, 30, 34, 37, 43, 46, 49, 53, 55, 64, 67, 70, 71, 72, 76, 79, 82, 87, 91, 92, 94, 98};
        System.out.println("Digite o número que deseja buscar no array da pesquisa iterativa: ");
        int x = scanf.nextInt();
        
        boolean resp = PsqBinaria(array, x);
        
        if(resp)
        {
            System.out.println("Está presente no vetor");
        }
        else
        {
            System.out.println("Não está presente no vetor");
        }
        
        System.out.println("Digite o número que deseja buscar no array da pesquisa recursiva: ");
        x = scanf.nextInt();

        boolean respRec = PsqBinariaRec(array, x, 0, array.length - 1);

        if(respRec)
        {
            System.out.println("Está presente no vetor");
        }
        else
        {
            System.out.println("Não está presente no vetor");
        }

        scanf.close();
    }
}

//Melhor caso: f(n) = 1 --> Meio do vetor
//Pior caso:   f(n) = 2 x ln(n) --> Ultima posição de procura ou não está no vetor

//O array tem de estar ordenado