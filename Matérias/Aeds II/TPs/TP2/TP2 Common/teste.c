#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

// typedef struct Date
// {
//     int dia, mes, ano;
// } Date;

// typedef struct List
// {    
//     char element[30];
// }List;


// typedef struct Pokemon
// {
//     int id;
//     int generation;
//     char name[20];
//     char description[40];
//     List types[2];
//     List abilities[6];
//     double weight;
//     double height;
//     int captureRate;
//     bool legendary;
//     Date captureDate;


// } Pokemon;

// void startPoke()
// {
    
// }

void handleLine(char *line)
{
    bool insideQuotes = false;
    int tam = strlen(line);

    for(int i = 0; i < tam; i++)
    {

        if(line[i] == '\"')
        {
            insideQuotes = !insideQuotes;
        }

        if(!insideQuotes)
        {
            if (line[i] == ',')
            {
                line[i] = ';';
            }
        }
    }

}


void importDB(char *fileName)
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

        handleLine(line);


        printf("%s\n", line);
    }


    fclose(arq);
}

int main()
{
    //Pokemon fullBD[801];
    importDB("/tmp/pokemon.csv");
}