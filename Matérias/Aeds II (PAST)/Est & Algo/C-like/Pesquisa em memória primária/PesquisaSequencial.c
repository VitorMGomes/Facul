#include <stdio.h>
#include <stdbool.h>

bool PsqSequencial(int array[], int len, int x) {
    bool resp = false;

    for (int i = 0; i < len; i++) {
        if (array[i] == x) {
            resp = true;
            break;
        }
    }

    return resp;
}

int main() {
    printf("Digite o número que deseja buscar no array: ");
    int x;
    scanf("%d", &x);

    int vet[] = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82, 23, 34, 46, 55, 64, 72, 76, 87, 92, 98, 37, 53, 67, 79, 91, 94};
    int len = sizeof(vet) / sizeof(vet[0]);

    bool resp = PsqSequencial(vet, len, x);

    if (resp) {
        printf("Está presente no vetor\n");
    } else {
        printf("Não está presente no vetor\n");
    }

    return 0;
}

//Melhor caso: f(n) = 1 --> primeira posição
//Pior caso:   f(n) = n --> ultima posição