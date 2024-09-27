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

    setId(array[pos++], &x);

    setName(array[pos++], &x);

    setAlternativeNames(array[pos++], &x);

    setHouse(array[pos++], &x);

    setAncestry(array[pos++], &x);

    setSpecies(array[pos++], &x);

    setPatronus(array[pos++], &x);

    setHogwartsStaff(array[pos++], &x);

    setHogwartsStudent(array[pos++], &x);

    setActorName(array[pos++], &x);

    setAlive(array[pos++], &x);

    // Para pular o atributo não usado
    pos++;

    setDateOfBirth(array[pos++], &x);

    setYearOfBirth(array[pos++], &x);

    setEyeColour(array[pos++], &x);

    setGender(array[pos++], &x);

    setHairColour(array[pos++], &x);

    setWizard(array[pos++], &x);

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


        printf("%s\n", line);
    }


    fclose(arq);
}

int main()
{
    //Pokemon fullBD[801];
    importDB("/tmp/pokemon.csv");
}