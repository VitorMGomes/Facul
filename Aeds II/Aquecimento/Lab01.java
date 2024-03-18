import java.util.*;

public class Lab01 {

    public static boolean stop(String Input) // função que verifica se o input é equivalente a "FIM", e retorna falso se
                                             // não e verdadeiro se for
    {
        boolean stop = false; // incia a variavel como false
        if (Input.length() == 3 && Input.charAt(0) == 'F' && Input.charAt(1) == 'I' && Input.charAt(2) == 'M') {
            stop = true; // muda o valor inicial para verdadeiro se a palavra for "FIM"
        }

        return stop; // retorna o valor
    }

    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in); // inicialização do Scanner

        String Input = scanf.nextLine(); // inicia a variavel a ser lida pelo arquivo enquanto

        while (!stop(Input)) // enquanto a função stop retornar false o programa irá continuar
        {
            int contador = 0;
            int tamanho = Input.length();

            for (int i = 0; i < tamanho; i++) // percorre todo o input
            {
                if (Input.charAt(i) >= 'A' && Input.charAt(i) <= 'Z') // verifica se a letra é maiúscula e caso sim,
                                                                      // incrementa 1 ao contador
                {
                    contador++;
                }

            }

            System.out.println(contador); // printa o contador com a quebra de linha ()
            Input = scanf.nextLine(); // puxa um novo valor da entrada e reinicia o loop
        }

        scanf.close();

    }

}