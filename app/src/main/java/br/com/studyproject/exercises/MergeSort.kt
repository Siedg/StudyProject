package br.com.studyproject.exercises

class MergeSort {
    fun mergeSort(arr: IntArray): IntArray {
        if (arr.size <= 1) return arr
        val mid = arr.size / 2
        val left = mergeSort(arr.copyOfRange(0, mid))
        val right = mergeSort(arr.copyOfRange(mid, arr.size))
        return merge(left, right)
    }

    fun merge(left: IntArray, right: IntArray): IntArray {
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) result.add(left[i++])
            else result.add(right[j++])
        }

        result.addAll(left.slice(i until left.size))
        result.addAll(right.slice(j until right.size))

        return result.toIntArray()
    }
}

/*
Complexidade:
Melhor caso: O(n log n)
Caso médio: O(n log n)
Pior caso: O(n log n)

Vantagens:
Complexidade O(n log n), mesmo no pior caso.
Estável.

Desvantagens:
Requer espaço adicional O(n) para armazenar os arrays temporários durante a mesclagem.
 */