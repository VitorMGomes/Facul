import java.util.*;
import java.io.*;
import java.time.*;

class TP
{
    private long startTime, endTime;

    public void startTime()
    {
        startTime = System.nanoTime();
    }

    public void endTime()
    {
        endTime = System.nanoTime();
    }

    public double Time()
    {
        return (endTime - startTime) / 1000000;
    }

    private int comp = 0, mov = 0;

    public void addMov(int i)
    {
        this.mov += i;
    }

    public void addComp(int i)
    {
        this.comp += i;
    }

    public void pesquisaFile(String name) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(name));
    
            write.printf("Matrícula: 800643\t");
            write.printf("Tempo de execução: " + Time() + "ms" +"\t");
            write.printf("Comparações: " + comp);
    
            write.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void ordenacaoFile(String name) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(name));
    
            write.printf("Matrícula: 800643\t");
            write.printf("Tempo de execução: " + Time() + "ms" + "\t");
            write.printf("Comparações: " + comp + "\t");
            write.printf("Movimentações: " + mov);
    
            write.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
