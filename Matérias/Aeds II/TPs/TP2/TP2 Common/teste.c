#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool toBool(char *input)
{
    return strcmp(input, "VERDADEIRO") == 0;
}

typedef struct Date
{
    int dia, mes, ano;
} Date;

typedef struct Pokemon
{
    int id;
    int generation;
    char name[20];
    char description[40];
    char types[50];
    char abilities[60];
    double weight;
    double height;
    int captureRate;
    bool legendary;
    Date captureDate;


} Pokemon;

void startPoke()
{
    
}

void setDateOfBirth(char dateOfBirth[], Pokemon *x)
{
    char **array = split("/", dateOfBirth);

    x->captureDate.dia = atoi(array[0]);
    x->captureDate.mes = atoi(array[1]);
    x->captureDate.ano = atoi(array[2]);

    freeSplit(array);
}


void freeSplit(char **array)
{
    int i;
    for (i = 0; strcmp(array[i], "cFIM"); i++)
    {
        free(array[i]);
    }

    free(array[i]);

    free(array);
}



char **split(char *regex, char *string)
{

    int len = strlen(string);
    int n = 1;

    for (int i = 0; i < len; i++)
    {
        if (string[i] == regex[0])
            n++;
    }

    char **array = (char **)malloc((n + 1) * sizeof(char *));

    for (int i = 0; i < n + 1; i++)
    {
        array[i] = calloc(200, sizeof(char *));
    }

    strcpy(array[n], "cFIM");

    strcpy(array[0], strsep(&string, regex));

    for (int i = 1; i < n; i++)
    {
        char *temp = strsep(&string, regex);
        strcpy(array[i], temp);
    }

    return array;
}

Pokemon ler(char *string)
{

    // char aux[2000];
    // strcpy(aux, string);
    char **array = split(";", string);

    int pos = 0;
    Pokemon x;

    // for(int i = 0; i < 12; i++)
    // {
    //     printf("%s\n", array[i]);
    // }

    x.id = atoi(array[0]);
    x.generation = atoi(array[1]);
    strcpy(x.name, array[2]);
    strcpy();

    freeSplit(array);

    return x;
}

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
        ler(line);

        //printf("%s\n", line);
    }


    fclose(arq);
}

int main()
{
    //Pokemon fullBD[801];
    importDB("/tmp/pokemon.csv");
}