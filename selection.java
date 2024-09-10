
comparacoes = 0;
//n = array.length;
for(int i = 0; i < n - 1; i++)
{
    int menor = i;
    for(int j = i + 1; j < n; j++)
    {   
        comparacores++;
        if(array[j] < array[menor])
        {
            menor = j;
        }
    }
    swap(array, j, i);
}

print comparacoes;





comparacoes = 0;
for(int i = 0; i < tam - 1; i++)
{
    for(int j = 0; tam - i - 1)
    {
        if(array[j] > array[j+1])
        {
            swap(array, j, j+1);
        }
    }
}