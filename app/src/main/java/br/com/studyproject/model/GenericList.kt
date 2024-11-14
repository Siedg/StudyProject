package br.com.studyproject.model
import kotlin.collections.List

class GenericList<T> {
    val list = mutableListOf<T>()

    fun add(item: T) = list.add(item)

    fun remove(): T? = if (list.isNotEmpty()) list.removeFirst() else null

    fun get(): T? = list.firstOrNull()

    fun getList(): List<T> = list.toList()
}
