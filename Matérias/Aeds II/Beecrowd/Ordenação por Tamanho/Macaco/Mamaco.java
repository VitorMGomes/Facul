import java.util.*;

public class Mamaco {

    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);
        int exec = scanf.nextInt();
        scanf.nextLine();

        for(int z = 0; z < exec; z++)
        {
            String input = scanf.nextLine();

            String[] splitted = input.split(" ");

            int maior = 0;

            for(int i = 0; i < splitted.length; i++)
            {
                if(splitted[i].length() > maior)
                {
                    maior = splitted[i].length();
                }
            }

            for(int i = maior; i > 0; i--)
            {
                for(int j = 0; j < splitted.length; j++)
                {
                    if(splitted[j].length() == i) System.out.print(splitted[j] + " ");
                }
            }

            System.out.println();

        
        }
        scanf.close();
    }
}
