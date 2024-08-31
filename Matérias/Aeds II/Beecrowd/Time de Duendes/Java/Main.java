import java.util.*;
import java.io.*;

class Duende {

    String nome;
    int idade;

    Duende() {
    }

    Duende(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Main {
    public static void main(String args[]) 
    {
        ArrayList<Duende> lista = new ArrayList<>();

        Scanner scanf = new Scanner(System.in);

        int rep = scanf.nextInt();
        scanf.nextLine();

        for(int j = 0; j < rep; j++)
        {
            String input = scanf.nextLine();

            String splitted[] = input.split(" ");
        
            for(int i = 0;i < splitted.length - 1; i++)
            {
                Duende duende = new Duende(splitted[i],Integer.parseInt(splitted[i+1]));
                lista.add(duende);
            }
        }

        boolean swapped;

        for(int i = 0; i < lista.size(); i++)
        {
            swapped = false;
            for(int j = 0; j < lista.size() - 1 - i; j++)
            {
                if(lista.get(j).idade < lista.get(j + 1).idade)
                {
                    swapped = true;
                    Collections.swap(lista, j, j + 1);
                }
            }
            if(!swapped)
            {
                i = lista.size();
            }
        }

        for(int i = 0; i < rep/3; i++)
        {
            System.out.println("Time " + (i + 1));

            for(int j = i; j < rep; j += rep/3)
            {
                System.out.println(lista.get(j).nome + " " + lista.get(j).idade);
            }
            System.out.println();
        }
        
        scanf.close();
        
    }
}
