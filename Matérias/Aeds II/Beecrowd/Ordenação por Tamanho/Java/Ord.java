import java.util.*;

public class Ord {

    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);
        int exec = scanf.nextInt();
        scanf.nextLine();

        for(int z = 0; z < exec; z++)
        {
            String input = scanf.nextLine();

            String[] splitted = input.split(" ");

            
            //bubble sort
            int tam = splitted.length;
            boolean swapped;

            for(int i = 0; i < tam - 1; i++)
            {
                swapped = false;
                for(int j = 0; j < tam - 1 - i; j++)
                {
                    if(splitted[j].length() < splitted[j + 1].length())
                    {
                        String tmp = splitted[j];
                        splitted[j] = splitted[j + 1];
                        splitted[j + 1] = tmp;

                        swapped = true;
                    }
                }

                if(swapped == false)
                {
                    i = tam;
                }
            }

            for(int i = 0; i < splitted.length; i++)
            {
                System.out.print(splitted[i]);
                
                if(i < splitted.length - 1)
                {
                    System.out.print(" ");
                }
            }

            if(z < exec - 1)System.out.println();


        }
        scanf.close();
    }
}
