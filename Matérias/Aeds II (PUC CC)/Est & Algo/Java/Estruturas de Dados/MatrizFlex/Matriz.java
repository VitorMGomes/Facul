public class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    private Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        inicializarMatriz();

    }

    private void inicializarMatriz() {
        if (linha > 0 && coluna > 0) {

            inicio = new Celula();
            Celula atual = inicio;

            for (int j = 1; j < coluna; j++) {
                atual.dir = new Celula();
                atual.dir.esq = atual;
                atual = atual.dir;
            }

            Celula linhaAnterior = inicio;

            for (int i = 1; i < linha; i++) {
                atual = linhaAnterior;
                atual.inf = new Celula();
                atual.inf.sup = atual;
                Celula linhaAtual = atual.inf;

                for (int j = 1; j < coluna; j++) {
                    atual = atual.dir;
                    linhaAtual.dir = new Celula();
                    linhaAtual.dir.esq = linhaAtual;
                    linhaAtual = linhaAtual.dir;
                    linhaAtual.sup = atual;
                    atual.inf = linhaAtual;
                }

                linhaAnterior = linhaAnterior.inf;
            }
        }
    }

    public boolean buscar(int x) {
        Celula linhaAtual = inicio;
        while (linhaAtual != null) {
            Celula atual = linhaAtual;
            while (atual != null) {
                if (atual.elemento == x) {
                    return true;
                }
                atual = atual.dir;
            }
            linhaAtual = linhaAtual.inf;
        }
        return false;
    }

    public void mostrar() {
        Celula linhaAtual = inicio;
        while (linhaAtual != null) {
            Celula atual = linhaAtual;
            while (atual != null) {
                System.out.print(atual.elemento + " ");
                atual = atual.dir;
            }
            System.out.println();
            linhaAtual = linhaAtual.inf;
        }
    }


}
