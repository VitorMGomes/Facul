import java.util.*;

public class PesquisaSequencial
{
    public static boolean PsqSequencial(int[] array, int x)
    {
        boolean resp = false;
        int len = array.length; // array.length != array.length()

        for(int i = 0;  i < len; i++)
        {
            if(array[i] == x)
            {
                resp = true;
                i = len;
            }
        }

        return resp;
    }

    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);

        System.out.println("Digite o número que deseja buscar no array: ");
        int x = scanf.nextInt();

        int[] vet = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82, 23, 34, 46, 55, 64, 72, 76, 87, 92, 98, 37, 53, 67, 79, 91, 94};

        boolean resp = PsqSequencial(vet, x);

        if(resp)
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

//Melhor caso: f(n) = 1 --> primeira posição
//Pior caso:   f(n) = n --> ultima posição