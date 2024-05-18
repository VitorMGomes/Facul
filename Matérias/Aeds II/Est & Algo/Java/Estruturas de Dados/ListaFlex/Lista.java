public class Lista {
    private Celula primeiro, ultimo;

    public Lista(){ //CRIAÇÃO DO NÓ CABEÇA
        ultimo = primeiro = new Celula();
    }


    public void inserirFim(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
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

    public void inserir(int x, int pos){
        int tamanho = getTamanho();

        if(pos < 0 || pos > tamanho){
            System.out.println("Erro!");
        }
        else if(pos == 0){ 
            inserirInicio(x);
        }
        else if(pos == tamanho){
            inserirFim(x);
        }
        else{
            Celula i = primeiro;

            for(int j = 0; j < pos; j++, i = i.prox);
            
            Celula tmp = new Celula(x);
            
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }
    
    public void mostrar(){
        System.out.print("[ ");

        //a partir do no cabeça, passa de um por um, verificando se o local onde aponta é null
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.conteudo + " ");
        }
        System.out.println("]");
    }

    public int getTamanho()
    {
        int tamanho = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox, tamanho++);

        return tamanho;
    }

    public int removerFim()
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

    public int removerInicio() {
        if(primeiro == ultimo){
            System.out.println("Erro");
        }

        Celula tmp = primeiro.prox;         // Assim ocorre a remoção física e lógica, caso queira fazer somente a lógica --> Celula tmp = primeiro;
        primeiro.prox = primeiro.prox.prox; //                                                                                primeiro = primeiro.prox;

        int elemento = tmp.conteudo;        //                                                                                int elemento = primeiro.elemento;

        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public int remover(int pos)
    {
        int tamanho = getTamanho();
        int elemento;

        if(primeiro == ultimo|| pos < 0 || pos >= tamanho){
            System.out.println("Erro!"); 
            return -1;
        }
        else if(pos == 0){
            elemento = removerInicio();
        }
        else if(pos == tamanho - 1){
            elemento = removerFim();
        }
        else{
            Celula i = primeiro;

            for(int j = 0; j < pos; j++, i = i.prox);
            
            Celula tmp = i.prox;
            elemento = tmp.conteudo;
            
            i.prox = tmp.prox;

            tmp.prox = null;
            i = tmp = null;


        }

        return elemento;
    }

}
