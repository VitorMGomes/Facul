class Celula{
    int elemento;
    Celula prox;


    Celula(){
        this(0);
    }

    Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}