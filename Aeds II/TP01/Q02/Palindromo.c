#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAX 1000

bool verificarPal(char input[], int len)
{
    bool is = true;

    for(int i = 0; i < len; i++)
    {
        if(input[i] != input[len - 1 - i])
        {
            is = false;
            i = len;
        }
    }


    return is;
}

bool stop(char input[], int len)
{
    bool stop = false;

    if(len == 3 && input[0] == 'F' && input[1] == 'I' && input[2] == 'M')
    {
        stop = true;
    }

    return stop;
}

int main()
{

    char input[MAX];

    fgets(input, MAX, stdin);

    int len = strlen(input);

    while(stop(input, len))
    {
        bool is = verificarPal(input, len);

        printf(is ? "SIM" : "NAO");

        fgets(input, MAX, stdin);
    }


}