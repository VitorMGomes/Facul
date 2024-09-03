import java.util.*;

public class Q1
{

    static boolean condicional(int x, int y, int parametro)
    {
        boolean resp = false;

        if(x % 2 > y % 2)
        {
            resp = true;
        }
        else{
            if(y % 2 == x % 2)
            {
                if()
            }
            
        }
        return resp;

        
    }


    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);

        int repeticoes = scanf.nextInt();
        int parametro = scanf.nextInt();

        while(repeticoes != 0 || parametro != 0)
        {
            //inicializa o array com o numero dado
            int[] array = new int[repeticoes];

            //preencher o array
            for(int i = 0; i < repeticoes; i++)
            {               
                array[i] = i + 1;
            }

            /*
             * mod parametro
             *  
             *      impar ou par
             * 
             *          impar --> maior para menor
             * 
             *      par --> menor para o maior
            */


            for(int i = 0; i < repeticoes - 1; i++)
            {
                int menor = i;

                for(int j = i + 1; j < repeticoes; j++)
                {
                    if(condicional(array[i], array[j], parametro))
                    {
                        menor = j;
                    }
                }

                int temp = array[i];
                array[i] = array[menor];
                array[menor] = temp;
            }

            for(int i = 0; i < repeticoes; i++)
            {
                System.out.println(array[i]);
            }





            repeticoes = scanf.nextInt();
            parametro = scanf.nextInt();
        }



        scanf.close();
    }
}