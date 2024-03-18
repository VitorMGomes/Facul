#include <stdio.h>
#include <stdbool.h>

bool PsqBinaria(int array[], int len, int x) {
    bool resp = false;

    int esq = 0;
    int dir = len - 1;
    int meio;

    while (esq <= dir) {
        meio = (esq + dir) / 2;
        if (x == array[meio]) {
            resp = true;
            break;
        } else if (x > array[meio]) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }
    }

    return resp;
}

bool PsqBinariaRec(int array[], int x, int esq, int dir) {
    if (esq > dir) {
        return false;
    }

    int meio = (esq + dir) / 2;

    if (x == array[meio]) {
        return true;
    } else if (x > array[meio]) {
        return PsqBinariaRec(array, x, meio + 1, dir);
    } else {
        return PsqBinariaRec(array, x, esq, meio - 1);
    }
}

int main() {
    int array[] = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 23, 30, 34, 37, 43, 46, 49, 53, 55, 64, 67, 70, 71, 72, 76, 79, 82, 87, 91, 92, 94, 98};
    int len = sizeof(array) / sizeof(array[0]);

    printf("Digite o número que deseja buscar no array da pesquisa iterativa: ");
    int x;
    scanf("%d", &x);

    bool resp = PsqBinaria(array, len, x);

    if (resp) {
        printf("Está presente no vetor\n");
    } else {
        printf("Não está presente no vetor\n");
    }

    printf("Digite o número que deseja buscar no array da pesquisa recursiva: ");
    scanf("%d", &x);

    bool respRec = PsqBinariaRec(array, x, 0, len - 1);

    if (respRec) {
        printf("Está presente no vetor\n");
    } else {
        printf("Não está presente no vetor\n");
    }

    return 0;
}

//Melhor caso: f(n) = 1 --> Meio do vetor
//Pior caso:   f(n) = 2 x ln(n) --> Ultima posição de procura ou não está no vetor

//O array tem de estar ordenado