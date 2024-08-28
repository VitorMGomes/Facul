//https://judge.beecrowd.com/pt/problems/view/1103

import java.util.*;
import java.io.*;

public class Alarme
{
    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);

        String input = new String();
        
        for(input = scanf.nextLine(); !(input.equals("0 0 0 0")); input = scanf.nextLine())
        {

            String[] array = input.split(" ");
            int[] time = new int[array.length];

            for (int i = 0; i < time.length; i++) {
                time[i] = Integer.parseInt(array[i]);
            }
            
            int minutosDia1 = (time[0] * 60) + time[1];
            int minutosDia2 = (time[2] * 60) + time[3];

            int resultado = 0;

            if(minutosDia1 < minutosDia2)
            {
                resultado = minutosDia2 - minutosDia1;
            }
            else if(minutosDia1 > minutosDia2)
            {
                resultado = 1440 - minutosDia1 + minutosDia2;
            }

            if(resultado != 0)System.out.println(resultado);
        }

        scanf.close();
    }
}