import java.util.*;

public class Batuke
{
    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);

        int dimensaoI = scanf.nextInt();

        int dimensao = dimensaoI * dimensaoI;

        int pi = scanf.nextInt();
        int pj = scanf.nextInt();

        int p = 0;

        int[][] matriz = new int[dimensao][dimensao];

        //construir

        for(int i = dimensaoI; i < dimensaoI * 2; i++)
        {
            for(int j = dimensaoI; j < dimensaoI * 2; j++)
            {
                matriz[i][j] = ++p;
            }

        }




        // for(int i = 0; i < dimensao; i++)
        // {
        //     for(int j = 0; j < dimensao; j++)
        //     {
        //         System.out.print(matriz[i][j] + "  ");
        //     }

        //     System.out.println();
        // }


        int contador = 0;
        int andar = 1;

        System.out.print(matriz[dimensaoI + pi][dimensaoI + pj] + " ");

        while(contador < dimensaoI*2)
        {
            for(int i = 0 ; i < andar; i++)
            {
                pj += 1;

                if(matriz[dimensaoI + pi][dimensaoI + pj] != 0)
                {
                    System.out.print(matriz[dimensaoI + pi][dimensaoI + pj] + " ");
                    contador++;
                }
            }

            for(int i = 0 ; i < andar; i++)
            {
                pi += 1;

                if(matriz[dimensaoI + pi][dimensaoI + pj] != 0)
                {
                    System.out.print(matriz[dimensaoI + pi][dimensaoI + pj] + " ");
                    contador++;
                }
            }

            andar++;

            for(int i = 0 ; i < andar; i++)
            {
                pj -= 1;

                if(matriz[dimensaoI + pi][dimensaoI + pj] != 0)
                {
                    System.out.print(matriz[dimensaoI + pi][dimensaoI + pj] + " ");
                    contador++;
                }
            }

            for(int i = 0 ; i < andar; i++)
            {
                pi -= 1;

                if(matriz[dimensaoI + pi][dimensaoI + pj] != 0)
                {
                    System.out.print(matriz[dimensaoI + pi][dimensaoI + pj] + " ");
                    contador++;
                }
            }

            andar++;

        }

        System.out.println();
        System.out.println(contador);


        scanf.close();
    }

}