public class Lista {
    private Celula primeiro, ultimo;

    public Lista(){ //CRIAÇÃO DO NÓ CABEÇA
        ultimo = primeiro = new Celula();
    }


    public void inserirFim(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void mostrar(){
        System.out.println("[ ");

        //a partir do no cabeça, passa de um por um, verificando se o local onde aponta é null
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.conteudo + " ");
            System.out.println("]");
        }
    }

    public void inserirInicio(int x){
        Celula tmp = new Celula(x);

        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){
            ultimo = tmp;
        }

        tmp = null;
    }

    public int RemoverFim()
    {
        if(primeiro == ultimo)
        {

        }
        Celula i;
        for(i = primeiro.prox; i.prox != ultimo; i = i.prox);
        int elemento = ultimo.conteudo;
        ultimo = i;
        i = ultimo.prox = null;

        return elemento;

    }
}
