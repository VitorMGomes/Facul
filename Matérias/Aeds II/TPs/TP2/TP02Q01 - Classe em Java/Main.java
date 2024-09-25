import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private Double weight;
    private Double height;
    private int captureRate;
    private boolean legendary;
    //private Date captureDate;
    private String captureDate;

    // -------------------------------------------------------------- Construtor Vazio -------------------------------------------------------------- //    
    public Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.legendary = false;
        this.captureDate = "";
        //this.captureDate = new Date();
    }
    // -------------------------------------------------------------- Construtor -------------------------------------------------------------- //
    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types,
            ArrayList<String> abilities,
            Double weight,
            Double height, int captureRate, boolean legendary, String captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.legendary = legendary;
        this.captureDate = captureDate;
    }

    // -------------------------------------------------------------- Getters & Setters -------------------------------------------------------------- //
    public void setAbilities(ArrayList<String> abilities) { this.abilities = abilities; }
    public ArrayList<String> getAbilities() { return abilities; }
    public void setCaptureDate(String captureDate) { this.captureDate = captureDate; } //substituido Date por String por que a formatacao nao da certo
    public String getCaptureDate() { return captureDate; } //substituido Date por String por que a formatacao nao da certo
    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }
    public int getCaptureRate() { return captureRate; }
    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
    public void setGeneration(int generation) { this.generation = generation; }
    public int getGeneration() { return generation; }
    public void setHeight(Double height) { this.height = height; }
    public Double getHeight() { return height; }
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    public void setLegendary(boolean legendary) { this.legendary = legendary; }
    public boolean isLegendary() { return legendary; }
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public void setTypes(ArrayList<String> types) { this.types = types; }
    public ArrayList<String> getTypes() { return types; }
    public void setWeight(Double weight) { this.weight = weight; }
    public Double getWeight() { return weight; }
    // -------------------------------------------------------------- Getters & Setters -------------------------------------------------------------- //

    public Pokemon myClone() {
        Pokemon clonado = new Pokemon(id, generation, name, description, types, abilities,
                weight,
                height, captureRate, legendary, captureDate);

        return clonado;
    }

    // -------------------------------------------------------------- Formatando Types -------------------------------------------------------------- //
    private ArrayList<String> formatTypes(String type1, String type2) {
        ArrayList<String> types = new ArrayList<>();
        if (type1 != "") {
            String type1Fixed = "\'" + type1 + "\'";
            types.add(type1Fixed.trim());
        }
        if (type2 != "") {
            String type2Fixed = "\'" + type2 + "\'";
            types.add(type2Fixed.trim());
        }
        return types;
    }

    // -------------------------------------------------------------- Formatando Abilidades -------------------------------------------------------------- //
    private ArrayList<String> formatAbilitieList(String listAbilities) {
        ArrayList<String> abilities = new ArrayList<>();

        String splitted[] = listAbilities.split(",");
        for (int i = 0; i < splitted.length; i++) {
            abilities.add(splitted[i].trim());
        }

        return abilities;
    }

    public void ler(String line) throws Exception {
        String newLine = "";
        boolean insideQuotes = false;
        int tam = line.length();

        //substituindo as virgulas que separam o as colunas do csv por ";"
        for (int i = 0; i < tam; i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                insideQuotes = !insideQuotes;
            }

            if (!insideQuotes) {

                if (currentChar == ',') {
                    newLine += ';';
                } else if (currentChar != '\"') {
                    newLine += currentChar;
                }
            } else {

                if (currentChar != '"' && currentChar != '[' && currentChar != ']') {
                    newLine += currentChar;
                }
            }
        }

        line = newLine;

        String splitted[] = line.split(";");

        setId(Integer.parseInt(splitted[0]));
        setGeneration(Integer.parseInt(splitted[1]));
        setName(splitted[2]);
        setDescription(splitted[3]);
        setTypes(formatTypes(splitted[4], splitted[5]));
        setAbilities(formatAbilitieList(splitted[6]));
        if(splitted[7] != "") setWeight(Double.parseDouble(splitted[7]));
        if(splitted[8] != "") setHeight(Double.parseDouble(splitted[8]));
        setCaptureRate(Integer.parseInt(splitted[9]));
        setLegendary(splitted[10].equals("1"));
        setCaptureDate(splitted[11]);


        //NAO TA DANDO CERTO
        // if (splitted[11].isEmpty()) {
        //     this.captureDate = null;
        // } else {
        //     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //     this.captureDate = formatter.parse(splitted[11]);
        // }
    }

    public void mostrar() {
        System.out.println("[#" + this.id + " -> " + this.name + ": " + this.description + " - " + types + " - "
                + abilities + " - " + this.weight + "kg - " + this.height + "m - " + this.captureRate + "% - "
                + this.legendary + " - " + this.generation + " gen" + "] - " + this.captureDate);
    }

}



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

    public static Pokemon searchID(int pesquisa, int esq, int dir) {
        Pokemon resp;
        int meio = (dir + esq) / 2;

        if (esq > dir) {
            resp = pokemons[meio];
        } else if (pesquisa == pokemons[meio].getId()) {
            resp = pokemons[meio];
        } else if (pesquisa > pokemons[meio].getId()) {
            resp = searchID(pesquisa, meio + 1, dir);
        } else {
            resp = searchID(pesquisa, esq, meio - 1);
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

            searchID(find, 0, 800).mostrar();
        }

        scanf.close();

    }
}
