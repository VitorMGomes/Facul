public class IsRecursivo {
    
    public static boolean stop(String input)
    {
        boolean stop = false;
        if (input.length() == 3 && input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M') 
        {
        stop = true;
        }

        return stop;
    }

    public static boolean verificarVogal(String input, int len, boolean vogal, int i)
    {
        if(i < len)
        {
            if(input.charAt(i) != 'a' && input.charAt(i) != 'e' && input.charAt(i) != 'i' && input.charAt(i) != 'o' && input.charAt(i) != 'u')
            {
                i = len;   
                vogal = false; 
            }
            
            vogal = verificarVogal(input, len, vogal, ++i);
        }

        return vogal;
    }

    public static boolean verificarConso(String input, int len, boolean conso, int i)
    {
        if(i < len)
        {
            if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
            {
                if(input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U')
                {
                    i = len;
                    conso = false;
                }
            }
            else
            {
                i = len;
                conso = false;
            }

            conso = verificarConso(input, len, conso, ++i);

        }

        return conso;
    }

    public static boolean verificarInt(String input, int len, boolean inteiro, int i)
    {
        if(i < len)
        {
            if(!(input.charAt(i) >= '0' && input.charAt(i) <= '9'))
            {
                inteiro = false;
                i = len;
            }


            inteiro = verificarInt(input, len, inteiro, ++i);
        }

        return inteiro;
    }
    
    public static boolean verificarReal(String input, int len, boolean real, int contador, int i)
    {
        if(i < len)
        {
            if((input.charAt(i) >= '0' && input.charAt(i) <= '9') || (input.charAt(i) == '.' || input.charAt(i) == ',')) 
            {
                if(input.charAt(i) == '.' || input.charAt(i) == ',')
                {
                    contador++;
                }

            }
            else
            {
                real = false;
                i = len;
            }

            real = verificarReal(input, len, real, contador, ++i);
        }

        if(contador > 1)
        { 
            real = false;
        }
        
        return real;
    }

    public static void main(String args[])
    {
        String input = MyIO.readLine();


        while(!stop(input))
        {
            input = input.toLowerCase();

            int len = input.length();

            MyIO.print(verificarVogal(input, len, true, 0) ? "SIM " : "NAO ");

            MyIO.print(verificarConso(input, len, true, 0) ? "SIM " : "NAO ");
    
            MyIO.print(verificarInt(input, len, true, 0) ? "SIM " : "NAO ");
    
            MyIO.println(verificarReal(input, len, true, 0, 0) ? "SIM" : "NAO");


            input = MyIO.readLine();

        }
    }
}
