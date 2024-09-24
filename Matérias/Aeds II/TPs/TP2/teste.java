import java.util.*;
import java.io.*;
import java.time.*;

public class teste {

    static void ler(String line) {
        String newLine = "";
        boolean insideQuotes = false;
        int tam = line.length();

        for (int i = 0; i < tam; i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                insideQuotes = !insideQuotes;
            }

            if (!insideQuotes) {

                if (currentChar == ',') {
                    newLine += ';';
                } else if (currentChar != '"') {
                    newLine += currentChar;
                }
            } else {

                if (currentChar != '"' && currentChar != '[' && currentChar != ']' && currentChar != '\'') {
                    newLine += currentChar;
                }
            }
        }

        line = newLine;

        String splitted[] = line.split(";");
        
        // setId(Integer.parseInt(splitted[1]));
        // setGeneration(Integer.parseInt(splitted[2]));
        // setName(splitted[3]);
        // setDescription(splitted[4]);
        // setTypes(formatTypes(splitted[4], splitted[5]));

        for(int i = 0; i < splitted.length; i++)
        {
            System.out.println("Posicao: " + i);
            System.out.println(splitted[i]);
        }


    }

    public static void main(String args[]) throws Exception {
        
        Scanner reader = new Scanner(new FileReader("/tmp/pokemon.csv"));
        reader.nextLine();

        for (int i = 0; i < 1; i++) {

            String line = reader.nextLine();

            ler(line);
            
        }

        reader.close();
    }
}
