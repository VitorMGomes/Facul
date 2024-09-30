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

typedef struct Types
{
    int n;
    char type1[20];
    char type2[20];

}Types;

typedef struct Pokemon
{
    int id;
    int generation;
    char name[20];
    char description[40];
    // Types types;
    char types[100];
    char abilities[60];
    double weight;
    double height;
    int captureRate;
    // bool legendary;
    char legendary[80];
    // Date captureDate;
    char captureDate[100];
} Pokemon;

Pokemon pokemons[1000];

void printPokemon(Pokemon pokemons[], int pos) {
    printf("[#%d -> %s: %s - [%s] - [%s] - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n", 
           pokemons[pos].id,                // ID
           pokemons[pos].name,              // Nome
           pokemons[pos].description,       // Descrição
           pokemons[pos].types,             // Tipos
           pokemons[pos].abilities,         // Habilidades
           pokemons[pos].weight,            // Peso
           pokemons[pos].height,            // Altura
           pokemons[pos].captureRate,       // Taxa de Captura
           pokemons[pos].legendary,         // Legendary (0 ou 1)
           pokemons[pos].generation,        // Geração
           pokemons[pos].captureDate);      // Data de Captura
}



// void startPoke(Pokemon *x)
// {
//     x->id = 0;
//     x->generation = 0;
//     x->name =
// }

// void setDateOfBirth(char dateOfBirth[], Pokemon *x)
// {
//     char **array = split("/", dateOfBirth);

//     x->captureDate.dia = atoi(array[0]);
//     x->captureDate.mes = atoi(array[1]);
//     x->captureDate.ano = atoi(array[2]);

//     freeSplit(array);
// }


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

    for (int i = 0; i < n; i++)
    {
        //strcpy(array[0], strsep(&string, regex));
        char *temp = strsep(&string, regex);
        strcpy(array[i], temp);
    }

    return array;
}

char* tratarAbilities(char *array)
{
    int tam = strlen(array);
    char* newLine = malloc((tam-3) * sizeof(char));
    int pos = 0;
    for(int i = 0; i < tam; i++)
    {
        if (array[i] != '"' && array[i] != '[' && array[i] != ']') {
                    newLine[pos] = array[i];
                    pos++;
                }
    }

    return newLine;
}

// void inserirType(Pokemon *x, char *array1, char *array2)
// {
//     if(array2 == NULL)
//     {   
//         strcmp(x->types.type1, array1);
//         strcmp(x->types.type2, array2);
//     }
//     else{
//         strcmp(x->types.type1, array1);
//     }
// }

Pokemon ler(char *string)
{

    // char aux[2000];
    // strcpy(aux, string);
    char **array = split(";", string);

    static int pos = 0;
    Pokemon x;

    // if(strcmp(array[0], "19") == 0)
    // for(int i = 0; i < 12; i++)
    // {
    //     printf("%s\n", array[i]);
    // }

    pokemons[pos].id = atoi(array[0]);              
    pokemons[pos].generation = atoi(array[1]);
    strcpy(pokemons[pos].name, array[2]);             
    strcpy(pokemons[pos].description, array[3]);    
    strcpy(pokemons[pos].types, "'");
    strcat(pokemons[pos].types, array[4]);
    strcat(pokemons[pos].types, "'");
    if (array[5][0] != 0) 
    {
        strcat(pokemons[pos].types, ", '");
        strcat(pokemons[pos].types, array[5]);
        strcat(pokemons[pos].types, "'");
    }

    strcpy(pokemons[pos].abilities, array[6]);        
    pokemons[pos].weight = atof(array[7]);            
    pokemons[pos].height = atof(array[8]);           
    pokemons[pos].captureRate = atoi(array[9]);       
    array[10][0] == '1' ? strcpy(pokemons[pos].legendary, "true") : strcpy(pokemons[pos].legendary, "false");
    strcpy(pokemons[pos].captureDate, array[11]);    

    // printPokemon(pokemons, pos); 

    pos++;

    freeSplit(array);

    return x;
}

char* handleLine(char* line){
    int leng = strlen(line);
    char* formatted = malloc(leng * sizeof(char));
    bool control = true;
    int j = 0;
    for(int i=0; i<leng; i++){
        if(line[i] == '"') control = !control;
        else if(line[i] == ',' && control) formatted[j++] = ';';
        else if(line[i] != '[' && line[i] != ']') formatted[j++] = line[i];
    }
    formatted[j] = 0;
    return formatted;
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

        char* formatted = handleLine(line);

        // passar para  funcao
        // int tam = strlen(line);
        // int aux = 1;
        // for (int i = 0; i < tam; i++)
        // {
        //     if (line[i] == '"') aux++;
        //     else if (line[i] == ',' && (aux % 2)) line[i] = ';';
        // }

        //printf("%s\n", line);
        
        ler(formatted);

        //printf("%s\n", formatted);
    }


    fclose(arq);
}

int main()
{
    //Pokemon fullBD[801];
    importDB("/tmp/pokemon.csv");

    char input[80];
    scanf(" %s", input);
    while(strcmp(input, "FIM"))
    {
        printPokemon(pokemons, atoi(input) - 1);
        scanf(" %s", input);
    }
}