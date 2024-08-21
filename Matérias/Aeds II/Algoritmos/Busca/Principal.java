import java.util.*;

class Principal {
    
    public static void main(String args[])
    {   
        Scanner scanf = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do array que deseja: ");
        int tam = scanf.nextInt();

        CustomArray array = new CustomArray(tam);

        
    }
}
