#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAXTAM 50


int array[MAXTAM];
int n = 0;


void inserirFim(int x)
{
    if(n >= MAXTAM)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    array[n] = x;
    n++;
}

int removerFim()
{
    if(n < 1)
    {
        printf("A lista já está vazia, erro ao remover");
        exit(1);
    }

    int x = array[n];
    n--;

    return x;
}

void mostrar()
{
    for(int i = 0; i <= n; i++)
    {
        printf("%i ", array[i]);
    }
}


int main()
{
    int entrada;
    
    do{
        
        scanf("%i", &entrada);
        if(entrada != 0)
        {
            for(int i = 0; i < entrada; i++)
            {
                inserirFim(i + 1);
            }
        }    

    }while(entrada != 0);

    return 0;
}