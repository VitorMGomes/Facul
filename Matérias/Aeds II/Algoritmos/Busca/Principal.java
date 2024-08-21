import java.util.*;

class Principal {

    static int comparacoes;

    public static boolean pesquisaBinaria(CustomArray array, int pesquisa, int esq, int dir) {
        boolean resp;
        int meio = (dir + esq) / 2;

        comparacoes++;

        if (esq > dir) {
            resp = false;
        } else if (pesquisa == array.array[meio]) {
            resp = true;
        } else if (pesquisa > array.array[meio]) {
            resp = pesquisaBinaria(array, pesquisa, meio + 1, dir);
        } else {
            resp = pesquisaBinaria(array, pesquisa, esq, meio - 1);
        }

        return resp;
    }

    public static void pesquisaBinaria(CustomArray array, Scanner scanf)
    {
        comparacoes = 0;

        System.out.println("Digite um número (inteiro) para pesquisar no array: ");

        int pesquisar = scanf.nextInt();
        //array.customShuffle();
        array.printArray();
        System.out.println(pesquisaBinaria(array, pesquisar, 0, array.getTam() - 1) ? "Está presente no array" : "Não está presente no array;");

        System.out.println("Foram feitas " + comparacoes + " comparações");

        



    }

    // public void pesquisaSequencial(CustomArray array, Scanner scanf)
    // {

    // }


    public static void main(String args[])
    {   
        Scanner scanf = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do array que deseja: ");
        int tam = scanf.nextInt();
        CustomArray array = new CustomArray(tam);

        // array.printArray();
        // array.customShuffle();
        // array.printArray();

        System.out.println("(1) Pesquisa Sequencial; \n(2) Pesquisa Binária\nDigite qual deseja utilizar: ");
        int choose = scanf.nextInt();
        switch(choose)
        {
            case 1:
            //pesquisaSequencial(array, scanf);
            break;

            case 2:
            pesquisaBinaria(array, scanf);
            break;

            
        }
        
    }
}
