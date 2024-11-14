package br.com.studyproject.exercises

class SelectionSort {
    fun selectionSort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
            }
        }
    }
}

/*
Complexidade:
Melhor caso: O(n²)
Caso médio: O(n²)
Pior caso: O(n²)

Vantagens:
Simples de entender e implementar.
Não requer espaço adicional, pois é feito in-place.

Desvantagens:
Muito ineficiente para grandes arrays.
 */