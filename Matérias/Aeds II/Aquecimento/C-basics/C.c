#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    char string[20];

    fgets(string, sizeof(string), stdin);

    printf("%s", string);

    getchar();

    char string2[20];

    scanf("%s", string2);
    printf("%s", string2);


    return 0;
}