package br.com.studyproject.exercises

class CacheLRU<T>(val size: Int = 10) {
    private val cache: HashMap<T, T> = hashMapOf()
    private val lru: MutableList<T> = mutableListOf()

    fun get(key: T): T? {
        if (!cache.containsKey(key)) return null

        lru.remove(key)
        lru.add(key)

        return cache[key]
    }

    fun put(item: Pair<T, T>) {
        val (key, value) = item

        if (cache.containsKey(key)) {
            cache[key] = value
            lru.remove(key)
            lru.add(key)
            return
        }

        if (cache.size >= size) {
            val first = lru.removeFirst()
            cache.remove(first)
        }

        cache[key] = value
        lru.add(key)
    }
}
