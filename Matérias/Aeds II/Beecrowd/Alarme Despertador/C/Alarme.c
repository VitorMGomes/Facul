#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main()
{
    int hora1, minuto1, hora2, minuto2;
    
    scanf(" %d %d %d %d", &hora1, &minuto1, &hora2, &minuto2);

    getchar();

    while(!(hora1 == 0 && minuto1 == 0 && hora2 == 0 && minuto2 == 0))
    {

        int minutosDia1 = hora1 * 60 + minuto1;
        int minutosDia2 = hora2 * 60 + minuto2;


        int resultado = 0;
        if(minutosDia1 < minutosDia2)
        {
            resultado = minutosDia2 - minutosDia1;
        }
        else if(minutosDia2 < minutosDia1)
        {
            resultado = 1440 - minutosDia1 + minutosDia2;
        }

        printf("%d\n", resultado);

        scanf(" %d %d %d %d", &hora1, &minuto1, &hora2, &minuto2);

        getchar();

    }
    return 0;
}