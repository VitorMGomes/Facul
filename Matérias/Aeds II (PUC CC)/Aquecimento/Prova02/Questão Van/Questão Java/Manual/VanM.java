import java.util.*;

class Aluno {

    private int distancia;
    private char regiao;
    private String nome;

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegiao(char regiao) {
        this.regiao = regiao;
    }

    public int getDistancia() {
        return distancia;
    }

    public String getNome() {
        return nome;
    }

    public char getRegiao() {
        return regiao;
    }
}

public class VanM {

    public static Aluno[] alunos;

    public static boolean comparar(Aluno i, Aluno j) {
        boolean resp = false;

        if (i.getDistancia() == j.getDistancia()) {
            if (i.getRegiao() == j.getRegiao()) {
                if (i.getNome().equals(j.getNome())) {

                } else {
                    if (i.getNome().compareTo(j.getNome()) < 0) {
                        resp = true;
                    }
                }
            } else {
                if (i.getRegiao() > j.getRegiao()) {
                    resp = true;
                }
            }
        } else {
            if (i.getDistancia() > j.getDistancia()) {
                resp = true;
            }
        }

        return resp;
    }

    public static void ordenar(int num){

        for(int i = 0; i < num - 1; i++)
        {
            int menor = i;

            for(int j = i + 1; j < num; j++)
            {
                if(comparar(alunos[i], alunos[j]))
                {
                    menor = j;
                }
            }
        
            Aluno tmp = alunos[i];

            alunos[i] = alunos[menor];

            alunos[menor] = tmp;

        }
    }

    public static void split(String string, int i) {

        String data[] = string.split(" ");

        Aluno x = new Aluno();

        x.setNome(data[0]);
        x.setRegiao(data[1].charAt(0));
        x.setDistancia(Integer.parseInt(data[2]));

        alunos[i] = x;

    }

    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);

        int num = scanf.nextInt();

        alunos = new Aluno[num];

        scanf.nextLine();

        for (int i = 0; i < num; i++) {
            String string = scanf.nextLine();
            split(string, i);
        }

        ordenar(num);

        for (int i = 0; i < num; i++)
        {
            System.out.println(alunos[i].getNome() + " " + alunos[i].getRegiao() + " " + alunos[i].getDistancia());
        }

        scanf.close();
    }

}
