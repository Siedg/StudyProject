package br.com.studyproject.exercises

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    var currentLine = mutableListOf<String>()
    var currentLength = 0

    for (word in words) {
        if (currentLength + currentLine.size + word.length > maxWidth) {
            val spaces = maxWidth - currentLength
            if (currentLine.size == 1) {
                result.add(currentLine[0] + " ".repeat(spaces))
            } else {
                val evenSpace = spaces / (currentLine.size - 1)
                val extraSpace = spaces % (currentLine.size - 1)

                val justifiedLine = StringBuilder()
                for (i in currentLine.indices) {
                    justifiedLine.append(currentLine[i])
                    if (i < currentLine.size - 1) {
                        justifiedLine.append(" ".repeat(evenSpace + if (i < extraSpace) 1 else 0))
                    }
                }
                result.add(justifiedLine.toString())
            }
            currentLine = mutableListOf()
            currentLength = 0
        }
        currentLine.add(word)
        currentLength += word.length
    }

    if (currentLine.isNotEmpty()) {
        val lastLine = currentLine.joinToString(" ")
        result.add(lastLine + " ".repeat(maxWidth - lastLine.length))
    }

    return result
}
