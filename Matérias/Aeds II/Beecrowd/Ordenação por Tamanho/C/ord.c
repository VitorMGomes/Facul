#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

struct palavras
{
    char string[20];
    int len;

}typedef palavras;

#define flag (puts("----***----"))

int main()
{
    int entrada;
    scanf(" %d", &entrada);

    for(int rep = 0; rep < entrada; rep++)
    {
        char linha[1000];
        scanf(" %1000[^\n]", linha);

        palavras palavra[50];

        char *token = strtok(linha, " ");
        int contadorPalavras = 0;

        while(token)
        {
            strcpy(palavra[contadorPalavras].string, token);
            palavra[contadorPalavras].len = strlen(token);
            contadorPalavras++;
            
            token = strtok(NULL, " ");
        }

        for(int i = 0; i < contadorPalavras - 1; i++)
        {
            bool swapped = false;
            for(int j = 0; j < contadorPalavras - 1 - i; j++)
            {
                if(palavra[j].len < palavra[j+1].len)
                {
                    swapped = true;
                    palavras temp = palavra[j+1];
                    palavra[j+1] = palavra[j];
                    palavra[j] = temp;
                }
            }
            if(!swapped)
            {
                i = contadorPalavras;
            }
        }

        for(int i = 0; i < contadorPalavras; i++)
        {
            printf("%s ", palavra[i].string);
        }

        printf("\n");

    }

    return 0;
}
