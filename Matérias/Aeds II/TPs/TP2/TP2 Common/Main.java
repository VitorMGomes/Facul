import java.time.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class Main 
{
    
    public static Pokemon[] fullDB = new Pokemon[801];
    
    public static void main(String args[]) throws Exception
    {
        fullDB = Pokemon.readDb();

        Scanner scanf = new Scanner(System.in);

        //Puxa diretamente o elemento do CSV importado
        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            int id = Integer.parseInt(input);
            fullDB[id - 1].mostrar();    
        }
        

        scanf.close();

    }
}