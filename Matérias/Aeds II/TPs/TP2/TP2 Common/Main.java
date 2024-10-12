import java.time.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Main 
{
    
    public static Pokemon[] fullDB = new Pokemon[801];
    public static Pokemon[] array;
    public static TP tp = new TP();

    public static void swap(int i, int j)
    {
        Pokemon tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        tp.addMov(3);
    }

    public static boolean compare(int x, int y)
    {
        //compare method
    }

    public static void method(int len)
    {
       //sort or search method
    }


    public static void main(String args[])
    {
        fullDB = Pokemon.readDb();

        Scanner scanf = new Scanner(System.in);

        int numeros[] = new int[100];
        int len = 0;

        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            numeros[len] = Integer.parseInt(input);
            len++;    
        }

        array = new Pokemon[len];

        for(int i = 0; i < len; i++)
        {
            array[i] = fullDB[numeros[i] - 1].myClone();
        }

        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

        tp.startTime();
        //method()
        tp.endTime();

        for(int i = 0; i < len; i++)
        {
            array[i].mostrar();
        }
        
        tp.typeFile("800643_name.txt");

        scanf.close();

    }
}
