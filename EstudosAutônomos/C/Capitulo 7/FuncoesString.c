#include <stdlib.h>
#include <stdio.h>

int main()
{
    char teste [15] = "Papala";

    printf("%i \n", strlen(teste));

    char str [15];

    strcpy(str, teste);

    printf("%s", str);

    return 0;
}