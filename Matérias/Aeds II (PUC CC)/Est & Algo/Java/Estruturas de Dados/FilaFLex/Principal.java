public class Principal {
    public static void main(String args[]) {

        Fila fila = new Fila();

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);


        System.out.println("Fila após inserções:");
        fila.mostrar();

        System.out.println("Elemento removido: " + fila.remover());
        System.out.println("Fila após remoção:");
        fila.mostrar();

        System.out.println("Elemento removido: " + fila.remover());
        System.out.println("Fila após remoção:");
        fila.mostrar();


        fila.inserir(50);
        fila.inserir(60);


        System.out.println("Fila após novas inserções:");
        fila.mostrar();
    }
}