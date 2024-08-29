import java.util.*;

public class TeoremaDourado
{
  public static void main(String args[])
  {
    Scanner scanf = new Scanner(System.in);
    Random rand = new Random();

    int[] array = new int[10];

    for(int i = 0; i < 10; i++)
    {
      array[i] = 0;
    }

    int rep = scanf.nextInt();

    for(int i = 0; i < rep; i++)
    {
      int randola = rand.nextInt(10) + 1;

      array[randola - 1]++;

    }

    System.out.println("Número que cada número aparece dentro de " + rep + " repetições");
    for(int i = 0; i < 10; i++)
    {
      System.out.println((i + 1) + ": " + array[i] + " ");
    }
    
    
    scanf.close();
  }

}

