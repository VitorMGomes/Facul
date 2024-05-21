#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

struct Aluno
{
    char nome[15];
    char coordenada;
    int distancia;

} typedef Aluno;


bool compare(Aluno i, Aluno j)
{
    bool resp = false;

    if(i.distancia == j.distancia )
    {
        if(i.coordenada == j.coordenada)
        {
            if(strcmp(i.nome, j.nome) < 0)
            {
                resp = true;
            }
        }
        else
        {
            if(i.coordenada > j.coordenada)
            {
                resp = true;
            }
        }
    }
    else
    {
        if(i.distancia > j.distancia)
        {
            resp = true;
        }
    }

    return resp;
}


int main()
{
    int qtdAlunos;

    scanf("%d", &qtdAlunos);

    Aluno lista[qtdAlunos];

    for(int i = 0; i < qtdAlunos; i++)
    {
        Aluno x;
        
        scanf("%14s", x.nome);
        getchar();

        scanf("%c", &x.coordenada);
        
        scanf("%d", &x.distancia);

        lista[i] = x;

    }

    for(int i = 0; i < qtdAlunos - 1; i++)
    {
        int menor = i;
        for(int j = i + 1; j < qtdAlunos; j++)
        {
            if(compare(lista[i], lista[j]))
            {
                menor = j;
            }
        }

        Aluno tmp = lista[i];

        lista[i] = lista[menor];

        lista[menor] = tmp;
    }

    for(int i = 0; i < qtdAlunos; i++)
    {
        printf("%s \n", lista[i].nome);
    }

    return 0;
}