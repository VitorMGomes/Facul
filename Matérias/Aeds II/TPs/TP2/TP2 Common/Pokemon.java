import java.util.*;
import java.io.*;
import java.time.*;

public class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList types;
    private ArrayList abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean legendary;
    private Date captureDate;

    Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = null;
        this.description = null;
        this.types = null;
        this.abilities = null;
        this.weight = 0;
        this.height = 0;
        this.captureRate = 0;
        this.legendary = false;
        this.captureDate = null;
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList types, ArrayList abilities,
            double weight,
            double height, int captureRate, boolean legendary, Date captureDate) {
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

    public void setAbilities(String abilities) {
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

    public void setHeight(double height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLegendary(int legendary) {
        this.legendary = legendary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // -------------------------------------------------------------- Getters ---//

    public ArrayList getAbilities() {
        return abilities;
    }

    public Date getCaptureDate() {
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

    public double getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getTypes() {
        return types;
    }

    public double getWeight() {
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

    void mostrar() {

    }

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

                if (currentChar != '"' && currentChar != '[' && currentChar != ']' && currentChar != '\'') {
                    newLine += currentChar;
                }
            }
        }

        line = newLine;

        String splitted[] = line.split(",");
        
        this.id = Integer.parseInt(splitted[1]);
        this.generation = Integer.parseInt(splitted[2]);
    }

}
