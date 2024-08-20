import java.util.*;

public class Main {
    
    public static void main(String args[])
    {   
        Scanner scanf = new Scanner(System.in);
        Random gerador = new Random();

        System.out.println("Digite o tamanho do array que você quer fazer a pesquisa");
        int tam = scanf.nextInt();
        int array[tam];

        for(int i = 0; i < tam; i++)
        {
            array[i] = gerador.nextInt(tam);
        }

        for(int i = 0; i < tam; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
