public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.inserirFim(1);
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.mostrar(); // [ 1 2 3 ]

        lista.inserirInicio(0);
        lista.mostrar(); // [ 0 1 2 3 ]

        lista.inserir(5, 2);
        lista.mostrar(); // [ 0 1 5 2 3 ]

        lista.remover(2);
        lista.mostrar(); // [ 0 1 2 3 ]

        lista.removerFim();
        lista.mostrar(); // [ 0 1 2 ]

        lista.removerInicio();
        lista.mostrar(); // [ 1 2 ]
    }
}
