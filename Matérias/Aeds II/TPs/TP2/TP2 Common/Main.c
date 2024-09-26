#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

typedef struct Date
{
    int dia, mes, ano;
} Date;

typedef struct List
{    
    char element[30];
}List;


typedef struct Pokemon
{
    int id;
    int generation;
    char name[20];
    char description[40];
    List types[2];
    List abilities[6];
    double weight;
    double height;
    int captureRate;
    bool legendary;
    Date captureDate;


} Pokemon;

void startPoke()
{
    
}


void importDB(Pokemon lista[], char *fileName)
{
    FILE *arq = fopen(fileName, "r");

    if (arq == NULL)
    {
        printf("ERRO NO ARQUIVO\n");
        exit(1);
    }

    char line[2000];

    fgets(line, 2000, arq);//pula a primeira linha do arquivo

    for (int i = 0; fgets(line, 2000, arq); i++)
    {
        int pos = (int)strcspn(line, "\n\r");
        line[pos] = '\0';
    }

    fclose(arq);
}

int main()
{
    Pokemon fullBD[801];
    importDB(fullBD, "/tmp/pokemon.csv");
}