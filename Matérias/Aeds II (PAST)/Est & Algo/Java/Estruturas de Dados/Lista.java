import java.util.*;

public class Lista {
    private int[] array;
    private int n;

    /**
     * Construtor da classe.
     */
    public Lista() {
        this(6);
    }

    public Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    public void inserirInicio(int x) throws Exception {

        if (n >= array.length) {
            throw new Exception("Erro ao inserir!"); 
        } //verifica se a lista está cheia

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }//move os elementos para a direita e insere no inicio(esquerda)

        array[0] = x; // insere na posicao inicial
        n++; // adiciona 1 ao tamanho da lista
    }

    public void inserirFim(int x) throws Exception {

        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }//verifica se a lista esta cheia

        array[n] = x; //insere no final 
        n++;//adiciona um ao tamanho da lista
    }

    public void inserir(int x, int pos) throws Exception {

        // verifica se a lista esta cheia
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos apos a posicao para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;//adiciona na pos
        n++;//aumenta o numero de elementos presentes na lista
    }

    public int removerInicio() throws Exception {

        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }//verifica se a lista esta cheia

        int resp = array[0]; //guarda o elemento da posicao
        n--; //tira um do tamanho da lista (elementos presentes)

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1]; // passa os numeros para a esquerda sobreponto o elemento retirado
        }

        return resp;//retorna o elemento retirado
    }

    public int removerFim() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];//retira o valor de n diminuindo o tamanho da lista, fazendo com que o elemento seja sobreposto no proximo inserir
    }

    public int remover(int pos) throws Exception {

        // validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        int resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public boolean pesquisar(int x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i] == x);
        }
        return retorno;
    }

}
