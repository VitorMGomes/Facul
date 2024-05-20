public class Fila {
    private Celula primeiro, ultimo;

    public Fila(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x){ //insere no fim
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover(){ //remove no inicio
        if(primeiro == ultimo){
            System.out.println("ERRO!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        
        int elemento = primeiro.elemento;

        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public void mostrar(){
        System.out.print("[");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }
}
