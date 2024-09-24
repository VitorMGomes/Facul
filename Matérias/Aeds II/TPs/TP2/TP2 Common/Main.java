import java.io.FileReader;
import java.util.Scanner;

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
    public static void main(String args[]) throws Exception
    {
        readDB();

        for(int i = 0; i < 801; i++)
        {
            pokemons[i].mostrar();
        }
    }
}
