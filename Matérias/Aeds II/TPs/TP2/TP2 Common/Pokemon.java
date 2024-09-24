import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private String weight;
    private String height;
    private int captureRate;
    private boolean legendary;
    private String captureDate;

    Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = null;
        this.description = null;
        this.types = null;
        this.abilities = null;
        //this.weight = 0;
        this.weight = "0";
        //this.height = 0;
        this.height = "0";
        this.captureRate = 0;
        this.legendary = false;
        this.captureDate = null;
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types, ArrayList<String> abilities,
            String weight,
            String height, int captureRate, boolean legendary, String captureDate) {
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

    // -------------------------------------------------------------- Setters ---//

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    // -------------------------------------------------------------- Getters ---//

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public String getDescription() {
        return description;
    }

    public int getGeneration() {
        return generation;
    }

    public String getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public String getWeight() {
        return weight;
    }

    public boolean isLegendary() {
        return legendary;
    }

    Pokemon myClone() {
        Pokemon clonado = new Pokemon(id, generation, name, description, types, abilities,
                weight,
                height, captureRate, legendary, captureDate);

        return clonado;
    }

    private ArrayList<String> formatTypes(String type1, String type2)
    {
        ArrayList<String> types = new ArrayList<>();

        types.add(type1);
        types.add(type2);

        return types;
    }

    private ArrayList<String> formatAbilitieList(String listAbilities)
    {
        ArrayList<String> abilities = new ArrayList<>();

        String splitted[] = listAbilities.split(",");
        for(int i = 0; i < splitted.length; i++)
        {
            abilities.add(splitted[i]);
        }

        return abilities;
    }

    private void printTypes()
    {
        System.out.print(this.types);
    }

    private void printAbilities()
    {
        System.out.print(this.abilities);
    }

    //[#181 -> Ampharos: Light Pokémon - ['electric'] - ['Static', 'Plus'] - 61.5kg - 1.4m - 45% - false - 2 gen] - 25/05/1999

    void ler(String line) {
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
        //setWeight(Double.parseDouble(splitted[7]));
        //setHeight(Double.parseDouble(splitted[8]));
        setCaptureRate(Integer.parseInt(splitted[9]));
        setLegendary(splitted[10].equals("1"));
        setCaptureDate(splitted[11]);

    }

    void mostrar() {
        System.out.print("[#" + this.id + " -> " + this.name + ": " + this.description + " - ");
        printTypes();
        System.out.print(" - ");
        printAbilities();
        System.out.print(" - " + this.weight + "kg - " + this.height + "m - " + this.captureRate + "% - " + this.legendary + " - " + this.generation + " gen" + "] - "  + this.captureDate);
        
        System.out.println();
    }

}
