package br.com.studyproject.exercises

class BubbleSort {
    fun bubbleSort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
    }
}

/*
Complexidade:
Melhor caso: O(n) (quando o array já está ordenado)
Caso médio: O(n²)
Pior caso: O(n²)

Vantagens:
Simples de entender e implementar.
Estável (não altera a ordem de elementos com o mesmo valor).

Desvantagens:
Muito ineficiente para grandes arrays.
 */
