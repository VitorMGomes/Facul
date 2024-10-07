import java.util.*;
import java.io.*;
import java.time.*;

class TP
{
    private Instant start, end;

    public void startTime()
    {
        this.start = Instant.now();
    }

    public void endTime()
    {
        this.end = Instant.now();
    }

    public double Time()
    {
        return Duration.between(start, end).getNano() / 1000000000.0;
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

    public void pesquisaFile(String name) throws Exception
    {
        PrintWriter write = new PrintWriter(new FileWriter(name));

        write.printf("Matrícula: 800643\t");
        write.printf("Tempo de execução: " + Time() + "\t");
        write.printf("Comparações: " + comp);

        write.close();
    }

    public void ordenacaoFile(String name) throws Exception
    {
        PrintWriter write = new PrintWriter(new FileWriter(name));

        write.printf("Matrícula: 800643\t");
        write.printf("Tempo de execução: " + Time() + "\t");
        write.printf("Comparações: " + comp + "\t");
        write.printf("Movimentações: " + mov);

        write.close();
    }
}