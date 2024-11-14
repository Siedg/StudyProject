package br.com.studyproject.exercises

class RadixSort {
    fun radixSort(arr: IntArray) {
        val max = arr.maxOrNull() ?: return
        var exp = 1
        val output = IntArray(arr.size)

        while (max / exp > 0) {
            countingSortByDigit(arr, output, exp)
            exp *= 10
        }
    }

    fun countingSortByDigit(arr: IntArray, output: IntArray, exp: Int) {
        val count = IntArray(10)

        for (i in arr.indices) {
            count[(arr[i] / exp) % 10]++
        }

        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }

        for (i in arr.size - 1 downTo 0) {
            val digit = (arr[i] / exp) % 10
            output[count[digit] - 1] = arr[i]
            count[digit]--
        }

        System.arraycopy(output, 0, arr, 0, arr.size)
    }
}

/*
Complexidade:
Melhor caso: O(nk) (onde k é o número de dígitos dos números)
Caso médio: O(nk)
Pior caso: O(nk)

Vantagens:
Muito rápido quando os números têm poucos dígitos.
A complexidade não depende da distribuição dos elementos (diferente de Quick Sort ou Merge Sort).

Desvantagens:
Requer que os elementos sejam números inteiros e limitados.
Não é in-place, e pode exigir espaço extra dependendo da implementação.
 */