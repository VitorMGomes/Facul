import java.util.*;

class Lista
{
    public int[] array;
    public int n; 

    public Lista(int tamanho)
    {
        array = new int[tamanho];
        n = 0;
    }

    //void inserirInicio(int x)
    //{}

    void inserirFim(int x) throws Exception 
    {   
        if(n >= array.length)
        {
            throw new Exception("Lista cheia!");
        }

        array[n] = x;
        n++;
    }

    //void inserir(int x)
    //{}

    //void removerFim(int x)
    //{}

    //void remover(int x)
    //{}

    int removerInicio() throws Exception
    {
        if(n == 0)
        {
            throw new Exception("Lista vazia! Erro ao remover");
        }

        int resp = array[0];
        n--;

        for(int i = 0; i < n; i++)
        {
            array[i] = array[i + 1];
        }

        return resp;
    }

    void mostrar()
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}

class J
{
    public static void main(String[] args) throws Exception
    {   
        Scanner scanf = new Scanner(System.in);
        int entrada;
        do
        {
            entrada = scanf.nextInt();

            if(entrada != 0)
            {
                Lista lista = new Lista(entrada);

                int n = entrada;

                for(int i = 1; i <= n; i++)
                {
                    lista.inserirFim(i);
                }

                lista.mostrar();

                while(n > 1)
                {
                    removerInicio;
                }
            }

        }while(entrada != 0);
    
        scanf.close();
    }
}

