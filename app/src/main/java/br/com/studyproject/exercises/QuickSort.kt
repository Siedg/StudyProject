package br.com.studyproject.exercises

class QuickSort {
    fun quickSort(arr: IntArray, low: Int = 0, high: Int = arr.size - 1) {
        if (low < high) {
            val pi = partition(arr, low, high)
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }
}

/*
Complexidade:
Melhor caso: O(n log n)
Caso médio: O(n log n)
Pior caso: O(n²) (quando o pivô é sempre o menor ou maior elemento)

Vantagens:
Rápido e eficiente na maioria dos casos.
A implementação é feita in-place e não exige memória extra.

Desvantagens:
O pior caso ocorre quando a lista já está ordenada ou quase ordenada (pivô ruim).
Não é estável.
 */