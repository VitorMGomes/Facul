#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>


#define flag puts("------------FLAG------------");

struct lingua
{
    char idioma[200];
    char traducao[400];

}typedef lingua;

int main()
{
    int tamLinguas;
    scanf(" %d", &tamLinguas);

    lingua listaLinguas[tamLinguas];

    for(int i = 0; i < tamLinguas; i++)
    {
        scanf(" %200[^\n\r]", listaLinguas[i].idioma);
        scanf(" %400[^\n\r]", listaLinguas[i].traducao);
    }

    int tamPessoas;

    scanf(" %d", &tamPessoas);

    for(int i = 0; i < tamPessoas; i++)
    {
        char pessoa[200];
        scanf(" %200[^\n\r]", pessoa);
        char idiomaFalado[200];
        scanf(" %200[^\n\r]", idiomaFalado);

        printf("%s\n", pessoa);
        //printf("%s\n", idiomaFalado);
        
        for(int j = 0; j < tamLinguas; j++)
        {
            if(!(strcmp(idiomaFalado, listaLinguas[j].idioma)))
            {
                printf("%s", listaLinguas[j].traducao);
            }
        }
        printf("\n\n");

    }


}

