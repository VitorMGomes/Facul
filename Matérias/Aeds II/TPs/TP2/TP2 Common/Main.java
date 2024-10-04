import java.time.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Main 
{
    
    public static Pokemon[] fullDB = new Pokemon[801];
    public static void main(String args[])
    {
        fullDB = Pokemon.readDb();

        Scanner scanf = new Scanner(System.in);

        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            fullDB[Integer.parseInt(input) - 1].mostrar();    
        }

        scanf.close();

    }
}
