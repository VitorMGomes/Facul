#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

typedef struct Duende
{
    char nome[100];
    int idade;

} Duende;

int main()
{

    int rep;
    scanf(" %d", &rep);
    Duende duendes[rep];

    for (int i = 0; i < rep; i++)
    {
        scanf(" %[^ ]", duendes[i].nome);
        getchar();
        scanf(" %d", &duendes[i].idade);
    }

    bool swapped;

    for (int i = 0; i < rep - 1; i++)
    {
        swapped = false;
        for (int j = 0; j < rep - 1 - i; j++)
        {
            if (duendes[j].idade < duendes[j + 1].idade)
            {
                Duende temp = duendes[j];
                duendes[j] = duendes[j + 1];
                duendes[j + 1] = temp;

                swapped = true;
            }
        }
        if (swapped == false)
        {
            i = rep;
        }
    }
    

    for(int i = 0; i < rep/3; i++)
    {
        printf("Time %d\n", i + 1);

        for(int j = i; j < rep; j += rep/3)
        {
            printf("%s %d\n", duendes[j].nome, duendes[j].idade);
        }
        printf("\n");
    }

    return 0;
}