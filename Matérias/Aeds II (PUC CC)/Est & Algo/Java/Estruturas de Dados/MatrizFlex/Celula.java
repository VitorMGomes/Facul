class Celula{
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula(){
        this(0);
    }

    public Celula(int x){
        this.elemento = x;
        
        this.inf = null;
        this.sup = null;
        this.esq = null;
        this.dir = null;
    }   
}