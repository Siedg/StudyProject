package br.com.studyproject.exercises

class InsertionSort {
    fun insertionSort(arr: IntArray) {
        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j -= 1
            }
            arr[j + 1] = key
        }
    }
}

/*
Complexidade:
Melhor caso: O(n) (quando o array já está ordenado)
Caso médio: O(n²)
Pior caso: O(n²)

Vantagens:
Mais eficiente que o Bubble Sort e o Selection Sort para arrays quase ordenados.
Estável (não altera a ordem de elementos com o mesmo valor).

Desvantagens:
Ineficiente para arrays grandes.
 */