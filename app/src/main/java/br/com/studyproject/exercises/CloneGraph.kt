package br.com.studyproject.exercises

class Node(var `val`: Int) {
    var neighbors: List<Node> = mutableListOf()
}

fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    val visited = mutableMapOf<Node, Node>()

    fun dfs(current: Node): Node {
        if (visited.contains(current)) return visited[current]!!

        val clone = Node(current.`val`)
        visited[current] = clone

        for (neighbor in current.neighbors) {
            clone.neighbors = clone.neighbors + dfs(neighbor)
        }

        return clone
    }

    return dfs(node)
}
