package br.com.studyproject.model

class MinHeap {
    private val heap = mutableListOf<Int>()

    fun insert(value: Int) {
        heap.add(value)
        bubbleUp(heap.size - 1)
    }

    fun remove(): Int? {
        if (heap.isEmpty()) return null
        val min = heap[0]
        heap[0] = heap[heap.size - 1]
        heap.removeAt(heap.size - 1)
        bubbleDown(0)
        return min
    }

    private fun bubbleUp(index: Int) {
        var currentIndex = index
        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2
            if (heap[currentIndex] >= heap[parentIndex]) break
            heap.swap(currentIndex, parentIndex)
            currentIndex = parentIndex
        }
    }

    private fun bubbleDown(index: Int) {
        var currentIndex = index
        val size = heap.size
        while (currentIndex < size) {
            val leftChild = 2 * currentIndex + 1
            val rightChild = 2 * currentIndex + 2
            var smallest = currentIndex

            if (leftChild < size && heap[leftChild] < heap[smallest]) smallest = leftChild
            if (rightChild < size && heap[rightChild] < heap[smallest]) smallest = rightChild

            if (smallest == currentIndex) break

            heap.swap(currentIndex, smallest)
            currentIndex = smallest
        }
    }

    private fun MutableList<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun printHeap() {
        println(heap)
    }
}