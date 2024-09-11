#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>


#define flag puts("------------FLAG------------");

struct lingua
{
    char idioma[20];
    char traducao[40];

}typedef lingua;

struct pessoa
{
    lingua materna;
    char nome[20];

}typedef pessoa;


int main()
{
    int tam;
    scanf(" %d", &tam);

    lingua listaLinguas[tam];

    for(int i = 0; i < tam; i++)
    {
        scanf(" %20[^\n]", listaLinguas->idioma);
        scanf(" %40[^\n]", listaLinguas->traducao);
    }

    int pessoas 
}

