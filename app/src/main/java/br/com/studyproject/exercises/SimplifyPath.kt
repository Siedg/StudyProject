package br.com.studyproject.exercises

fun simplifyPath(path: String): String {
    val stack = mutableListOf<String>()
    val parts = path.split("/")

    for (part in parts) {
        when (part) {
            "", "." -> continue
            ".." -> if (stack.isNotEmpty()) stack.removeAt(stack.size - 1)
            else -> stack.add(part)
        }
    }

    return "/" + stack.joinToString("/")
}
