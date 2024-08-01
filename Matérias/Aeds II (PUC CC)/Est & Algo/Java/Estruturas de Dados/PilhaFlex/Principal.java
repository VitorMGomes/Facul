public class Principal {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.inserir(10);
        pilha.inserir(20);
        pilha.inserir(30);

        pilha.mostrar();

        System.out.println("Elemento removido: " + pilha.remover());

        pilha.mostrar();
    }
}
