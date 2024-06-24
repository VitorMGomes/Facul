class No
{
    Character elemento;
    No dir;
    No esq;

    No()
    {
        this(null);
    }

    No(Character elemento)
    {
        this(elemento, null, null);
    }

    No(Character elemento, No dir, No esq)
    {
        this.elemento = elemento;
        this.dir = dir;
        this.esq = esq;
    }
}

class ArvoreBin
{
    No raiz;

    ArvoreBin()
    {
        raiz = null;
    }

    void inserir(Character elemento) throws Exception
    {
        raiz = inserir(elemento, raiz);
    }

    No inserir(Character x, No no) throws Exception
    {
        if(no == null)
        {
            no = new No(x);
        }
        else if(x.getName().compareTo(no.elemento.getName()) > 0)
        {
            no.dir = inserir(x, no.dir);
        }
        else if(x.getName().compareTo(no.elemento.getName()) < 0)
        {
            no.esq = inserir(x, no.esq);
        }

        return no;
    }

    boolean pesquisar(String elemento, TP tp) throws Exception
    {
        return pesquisar(elemento, raiz, tp);
    }

    boolean pesquisar(String x, No no, TP tp) throws Exception
    {
        boolean resp;

        if(no == null)
        {
            //tp.addComp(1);
            resp = false;
        }
        else if(no.elemento.getName().equals(x))
        {
            tp.addComp(1);
            resp = true;
        }
        else if(x.compareTo(no.elemento.getName()) > 0)
        {   
            tp.addComp(2);
            System.out.print("dir ");
            resp = pesquisar(x, no.dir, tp);
        }
        else{
            tp.addComp(2);
            System.out.print("esq ");
            resp = pesquisar(x, no.esq, tp);
        }

        return resp;
    }
}


class No2{
    public No2 esq;
    public int val;
    public ArvoreBin arv;
    public No2 dir;

    No2(){
        this(new ArvoreBin(), 0);
    }
    No2(int val){
        this(new ArvoreBin(), val);
    }
    No2(ArvoreBin arv, int val){
        esq = dir = null;
        this.arv = arv;
        this.val = val;
    }
}

class ArvoreBinaria2{
    No2 raiz;
    
    ArvoreBinaria2() throws Exception{
        raiz = null;
        int[] alturas = { 7, 3, 11, 1, 5, 9, 12, 0, 2, 4, 6, 8, 10, 13, 14 };
        insert(alturas);
    }

    //métodos insert
    public void insertJogador(Character add) throws Exception{
        No2 noInsercao = search(add.getYearOfBirth() % 15);
        if(noInsercao == null)
            throw new Exception("Erro: posicao na arvore de idades nao encontrada");
        noInsercao.arv.inserir(add);
    }

    public void insert(int[] val) throws Exception{
        for(int pos = 0; pos < val.length; pos++){
            raiz = insert(val[pos], raiz);
        }
    }
    private No2 insert(int val, No2 i) throws Exception{
        if(i == null){
            i = new No2(val);
        } else if (val<i.val){
            i.esq = insert(val, i.esq);
        } else if (val>i.val){
            i.dir = insert(val, i.dir);
        } else {
            throw new Exception ("Erro: valor já existente");
        }
        return i;
    }

    //método de pesquisa
    public No2 search (int val){
        No2 tmp = raiz;
        No2 resultado = null;
        while(tmp != null){
            if(val < tmp.val){
                tmp = tmp.esq;
            } else if(val > tmp.val){
                tmp = tmp.dir;
            } else {
                resultado = tmp;
                tmp = null;
            }
        }
        return resultado;
    }
    public boolean searchBool (String test){
        System.out.print("raiz ");
        return searchBool(raiz, test);
    }
    private boolean searchBool (No2 i, String test){
        boolean resultado = false;
        if(i != null){
            resultado = i.arv.searchBool(test);
            if(resultado == false){
                System.out.print("esq ");
                resultado = searchBool(i.esq, test);
            }
            if(resultado == false){
                System.out.print("dir ");
                resultado = searchBool(i.dir, test);
            }
        }
        return resultado;
    }
}