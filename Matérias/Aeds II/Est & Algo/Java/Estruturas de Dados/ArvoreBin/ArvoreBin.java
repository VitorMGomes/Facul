public class ArvoreBin {
    private No raiz;

    public ArvoreBin(){
        raiz = null;
    }

    public boolean pesquisar(int x){
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, No no){
        if(no == null){
            return false; 
        }

        else if(x == no.elemento){
            return true;
        }

        else if(x < no.elemento){
           return pesquisar(x, no.esq);
        }
        
        else{
            return pesquisar(x, no.dir);
        }
    }

    public void inserir(int x){
        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No no){
        if(no == null)
        {
            no = new No(x);
        }
        else if(x < no.elemento){
            no.esq = inserir(x, no.esq);
        }
        else if(x > no.elemento){
            no.dir = inserir(x, no.dir);
        }
        else{
            System.out.println("ERRO AO INSERIR");
        }


        return no;
    }


    public void caminharPre(){
        caminharPre(raiz);
    }

    public void caminharPre(No no)
    {
        System.out.print(no.elemento);
        caminharPre(no.esq);
        caminharPre(no.dir);
    }

    public void caminharCentral(){
        caminharPre(raiz);
    }

    public void caminharCentral(No no)
    {
        caminharCentral(no.esq);
        System.out.print(no.elemento);
        caminharCentral(no.dir);
    }

    public void caminharPos(){
        caminharPos(raiz);
    }

    public void caminharPos(No no)
    {
        caminharPos(no.esq);
        caminharPos(no.dir);
        System.out.print(no.elemento);
    }

}
