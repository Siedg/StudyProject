package br.com.studyproject.model

class List<T> {
    val list = mutableListOf<T>()

    fun add(item: T) = list.add(item)

    fun remove(): T? = if (list.isNotEmpty()) list.removeFirst() else null

    fun get(): T? = if (list.isNotEmpty()) list.first() else null

    fun getList(): MutableList<T> = list
}