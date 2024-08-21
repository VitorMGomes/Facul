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

    return;
}

void preencherLista(Lista *lista, int tam)
{
    lista->tam = tam;                    // Define o número de elementos na lista
    for (int i = 0; i < lista->tam; i++) // Corrige o loop para começar de 0
    {
        lista->arr[i] = i + 1; // Preenche a lista com números de 1 a tam
    }

    return;
}

int removerInicio(Lista *lista)
{
    if (lista->tam == 0)
    {
        printf("Erro ao remover, lista vazia!");
        exit(1);
    }

    int resp = lista->arr[0];
    lista->tam--;

    for (int i = 0; i < lista->tam; i++)
    {
        lista->arr[i] = lista->arr[i + 1];
    }

    return resp;
}

void inserirFim(Lista *lista, int num)
{
    if (lista->tam == lista->maxTam)
    {
        printf("Erro ao inserir, lista cheia!");
        exit(1);
    }

    lista->arr[lista->tam] = num;

    lista->tam++;

    return;
}

int main(void)
{
    Lista lista;
    Lista discard;
    int tam;

    scanf("%d", &tam);

    while (tam != 0)
    {

        // "Construtor" da lista
        iniciarLista(&lista, tam);
        iniciarLista(&discard, tam);

        // Preenche a lista com valores
        preencherLista(&lista, tam);
        
        
        // Libera a memória alocada
        free(lista.arr);
        free(discard.arr);

        scanf("%d", &tam);
    }

    return 0;
}
