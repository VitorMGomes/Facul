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
        System.out.println(line);
    }

    public static void main(String args[]) throws Exception {
        
        Scanner reader = new Scanner(new FileReader("/tmp/pokemon.csv"));
        //reader.nextLine();

        for (int i = 0; reader.hasNextLine(); i++) {

            String line = reader.nextLine();

            ler(line);
            
        }

        reader.close();
    }
}
