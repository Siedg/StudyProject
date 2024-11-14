package br.com.studyproject.exercises

class HeapSort {
    fun heapSort(arr: IntArray) {
        val n = arr.size
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
        }
        for (i in n - 1 downTo 1) {
            val temp = arr[0]
            arr[0] = arr[i]
            arr[i] = temp
            heapify(arr, i, 0)
        }
    }

    fun heapify(arr: IntArray, n: Int, i: Int) {
        var largest = i
        val left = 2 * i + 1
        val right = 2 * i + 2
        if (left < n && arr[left] > arr[largest]) largest = left
        if (right < n && arr[right] > arr[largest]) largest = right
        if (largest != i) {
            val temp = arr[i]
            arr[i] = arr[largest]
            arr[largest] = temp
            heapify(arr, n, largest)
        }
    }
}

/*
Complexidade:
Melhor caso: O(n log n)
Caso médio: O(n log n)
Pior caso: O(n log n)

Vantagens:
A complexidade no pior caso é O(n log n), o que é muito bom.
In-place, não requer espaço adicional.

Desvantagens:
Não é estável.
A implementação pode ser mais complexa do que o Quick Sort ou Merge Sort.
 */