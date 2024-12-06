package br.com.studyproject.model

class NodeRandom(var `val`: Int) {
    var next: NodeRandom? = null
    var random: NodeRandom? = null
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}
