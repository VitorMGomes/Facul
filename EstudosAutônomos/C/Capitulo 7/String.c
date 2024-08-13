#include <stdio.h>
#include <stdlib.h>

int main()
{
    //declarando a string
    char declarando [20] =  "Hello World!";

    //trocando um elemento da palavra --> Teste -> Leste
    char elemental [6] = "Teste";
    elemental[0] = 'L';

    //char str [20] = declarando;

    // copiar uma string pra outra assim não funcionoa --> char por char
    char copiada [20];
    
    int i;
    for(i = 0; declarando[i] != '\0'; i++)
    {
        copiada[i] = declarando[i];
    }
    copiada[i] = '\0';

    //para ser ler uma string se pode usar gets() ou fgets()

    //char strGet [20];

    //gets(strGet);

    //printf("%s", strGet);

    char strFget[30];

    fgets(strFget, 30, stdin);

    printf("%s", strFget);





    return 0;
}