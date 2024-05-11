import java.util.*;

public class Lab02 {
    
    public static boolean stop(String input)
    {
        boolean stop = false;

        if(input.length() == 3 && input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M')
        {
            stop = true;
        }

        return stop;
    }

    public static int contador(String input, int i, int contador)
    {
        if(i < input.length())
        {
            if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
            {
                contador++;
            }

            contador = contador(input, ++i, contador); //usar ++1 não dará certo devido ao fato de ++i incrementar antes da chamada recursiva, e i++ não.
        }

        return contador;
    }

    public static void main(String Args[])
    {
        Scanner scanf = new Scanner(System.in);

        String input = scanf.nextLine();

        while(!stop(input))
        {
            int contadorFinal = contador(input, 0, 0);
            System.out.println(contadorFinal);

            input = scanf.nextLine();

        }

        scanf.close();
    }
}
