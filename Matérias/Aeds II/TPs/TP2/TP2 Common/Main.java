import java.time.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Main 
{
    
    public static Pokemon[] fullDB = new Pokemon[801];
    public static Pokemon[] array;
    public static TP tp = new TP();

    public static boolean pesquisaSequencial(String input)
    {
        boolean resp = false;

        for(int i = 0; i < array.length; i++)
        {
            tp.addComp(1);
            if(array[i].getName().equals(input))
            {
                resp = true;
                break;
            }
        }   

        return resp;
    }
    public static void main(String args[])
    {
        fullDB = Pokemon.readDb();

        Scanner scanf = new Scanner(System.in);

        int numeros[] = new int[100];
        int x = 0;

        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            numeros[x] = Integer.parseInt(input);
            x++;    
        }

        array = new Pokemon[x];
        for(int i = 0; i < x; i++)
        {
            array[i] = fullDB[numeros[i] - 1].myClone();
        }

        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

        tp.startTime();
        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            System.out.println(pesquisaSequencial(input) ? "SIM" : "NAO");
        }
        tp.endTime();
        

        scanf.close();

    }
}
