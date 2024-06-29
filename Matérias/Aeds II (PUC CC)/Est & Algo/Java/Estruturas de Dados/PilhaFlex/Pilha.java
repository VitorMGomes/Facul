public class Pilha {
    private Celula topo;

    public Pilha() {
        topo = null;
    }

    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
    }

    public int remover() {
        if (topo == null) {
            System.out.println("ERRO! Pilha vazia.");
        }

        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;

        return elemento;
    }

    public void mostrar() {
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.println(i.elemento);
        }
    }

}