import java.util.*;

class Principal {
    public boolean pesquisaBinaria(CustomArray array)
    {

    }

    public void pesquisaBinaria(CustomArray array, Scanner scanf)
    {

        System.out.println("Digite um número (inteiro) para pesquisar no array: ");
        int pesquisar = scanf.nextInt();

        System.out.println(pesquisaBinaria(array) ? "Está presente no array" : "Não está presente no array;");

    }

    public void pesquisaSequencial(CustomArray array, Scanner scanf)
    {

    }


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
            pesquisaSequencial(array, scanf);

            case 2:
            pesquisaBinaria(array, scanf);

            
        }
        
    }
}
