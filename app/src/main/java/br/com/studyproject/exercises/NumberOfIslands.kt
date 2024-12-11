package br.com.studyproject.exercises

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var islandCount = 0

    fun dfs(i: Int, j: Int) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') return
        grid[i][j] = '0'
        dfs(i - 1, j)
        dfs(i + 1, j)
        dfs(i, j - 1)
        dfs(i, j + 1)
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == '1') {
                islandCount++
                dfs(i, j)
            }
        }
    }

    return islandCount
}
