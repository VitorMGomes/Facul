import java.util.*;

class Aluno {
    int distancia;
    char coordenada;
    String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCoordenada(char coordenada) {
        this.coordenada = coordenada;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}

public class Van {

    static boolean comparar(Aluno i, Aluno j) {
        boolean resp = false;

        if (i.distancia == j.distancia) {
            if (i.coordenada == j.coordenada) {
                if (i.nome.equals(j.nome)) {

                } else {
                    if (i.nome.compareTo(j.nome) < 0) {
                        resp = true;
                    }
                }
            } else {
                if (i.coordenada > j.coordenada) {
                    resp = true;
                }
            }
        } else {
            if (i.distancia > j.distancia) {
                resp = true;
            }
        }

        return resp;
    }

    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);

        int qtdAlunos = scanf.nextInt();

        Aluno[] listaM = new Aluno[qtdAlunos]; // criando array de alunos manualmente

        ArrayList<Aluno> listaN = new ArrayList<>(); // usando classe nativa do java

        for (int i = 0; i < qtdAlunos; i++) {
            Aluno x = new Aluno();

            String nome = scanf.nextLine();
            x.setNome(nome);

            char coordenada = scanf.next().charAt(0);
            x.setCoordenada(coordenada);

            int distancia = scanf.nextInt();
            x.setDistancia(distancia);

            scanf.nextLine();

            listaM[i] = x;

            listaN.add(x);
        }

        for (int i = 0; i < qtdAlunos - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < qtdAlunos; j++) {
                if (comparar(listaM[i], listaM[j])) {
                    menor = j;
                }
            }

            Aluno tmp = listaM[i];

            listaM[i] = listaM[menor];

            listaM[menor] = tmp;
        }

        for (int i = 0; i < qtdAlunos - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < qtdAlunos; j++) {
                if (comparar(listaN.get(i), listaN.get(j))) {
                    menor = j;
                }
            }

            Aluno tmp = listaN.get(i);
            listaN.set(i, listaN.get(menor));
            listaN.set(menor, tmp);

            scanf.close();

        }
    }
}
