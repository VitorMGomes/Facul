public class CustomArray{

    private int tam;
    private int array[];

    public CustomArray(int tam)
    {
        this.tam = tam;
        this.array = new int[tam];
    }

    public fillArray()
    {
        for(int i = 0; i < tam; i++)
        {
            this.array[i] = i;
        }
    }
}