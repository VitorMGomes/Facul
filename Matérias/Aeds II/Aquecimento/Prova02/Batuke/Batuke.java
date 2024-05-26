import java.util.*;

public class Batuke
{
    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);

        int dimensao = scanf.nextInt();

        int[][] matriz = new int[dimensao][dimensao];
        int p = 0;


        //Construir

        for(int i = 0; i < dimensao; i++)
        {
            for(int j = 0; j < dimensao; j++)
            {
                System.out.print(matriz[i][j] + " ");
                
            }
            System.out.println();
        }

        scanf.close();
    }

}