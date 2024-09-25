import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static Pokemon[] pokemons = new Pokemon[801];

    public static void readDB() throws Exception {

        Scanner reader = new Scanner(new FileReader("/tmp/pokemon.csv"));

        reader.nextLine();// pulando a primeira linha do csv

        for (int i = 0; reader.hasNextLine(); i++) {

            String line = reader.nextLine();

            Pokemon pokemon = new Pokemon();

            pokemon.ler(line);

            pokemons[i] = pokemon;
        }

        reader.close();
    }

    public static Pokemon pesquisaBinaria(int pesquisa, int esq, int dir) {
        Pokemon resp;
        int meio = (dir + esq) / 2;

        if (esq > dir) {
            resp = pokemons[meio];
        } else if (pesquisa == pokemons[meio].getId()) {
            resp = pokemons[meio];
        } else if (pesquisa > pokemons[meio].getId()) {
            resp = pesquisaBinaria(pesquisa, meio + 1, dir);
        } else {
            resp = pesquisaBinaria(pesquisa, esq, meio - 1);
        }

        return resp;
    }
    public static void main(String args[]) throws Exception
    {
        readDB();

        Scanner scanf = new Scanner(System.in);

        //realizar uma pesquisa binaria para achar o ID
        for(String input = scanf.nextLine();!input.equals("FIM"); input = scanf.nextLine())
        {
            int find = Integer.parseInt(input);

            pesquisaBinaria(find, 0, 800).mostrar();
        }

        scanf.close();

    }
}
