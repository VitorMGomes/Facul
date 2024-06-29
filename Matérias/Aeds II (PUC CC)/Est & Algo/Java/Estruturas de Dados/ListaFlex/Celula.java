public class Celula {
    int conteudo; // elemento contido na celula

    Celula prox; // ponteiro para a próxima celula


    public Celula(){
        this.conteudo = 0;

        this.prox = null;
    }

    public Celula(int conteudo){
        this.conteudo = conteudo;

        this.prox = null;
    }

}


//Nó cabeça
//--> Celula vazia  
//--> Usado como referencia inicial para primeiro e ultimo
//--> A lista estará vazia quando primeiro e ultimo apontam para nó cabeça
//--> Economiza um if