#include <stdio.h>
#include <stdlib.h>

typedef struct Lista
{
    int maxTam;
    int tam;
    int *arr;
} Lista;

void iniciarLista(Lista *lista, int tam)
{
    lista->maxTam = tam; // Usa o tam passado para definir maxTam
    lista->tam = 0;      // Inicializa tam como 0
    lista->arr = (int *)malloc(lista->maxTam * sizeof(int));
}

void preencherLista(Lista *lista, int tam)
{
    lista->tam = tam;                    // Define o número de elementos na lista
    for (int i = 0; i < lista->tam; i++) // Corrige o loop para começar de 0
    {
        lista->arr[i] = i + 1; // Preenche a lista com números de 1 a tam
    }
}

int main(void)
{
    Lista lista;
    Lista discard;
    int tam;

    scanf("%d", &tam);

    while(){

    // "Construtor" da lista
    iniciarLista(&lista, tam);
    iniciarLista(&discard, tam);

    // Preenche a lista com valores
    preencherLista(&lista, tam);

    /*
     * PROBLEMA
     */

    // Libera a memória alocada
    free(lista.arr);
    free(discard.arr);

    }
    
    return 0;
}
