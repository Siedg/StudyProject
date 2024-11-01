package br.com.studyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.studyproject.exercises.FindTheIndexOfTheFirstOccurrenceInAString
import br.com.studyproject.exercises.MergeKSortedLists
import br.com.studyproject.exercises.PlusOne
import br.com.studyproject.ui.theme.StudyProjectTheme
import br.com.studyproject.model.printListNode
import br.com.studyproject.model.toArrayListOfListNode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }
}

fun main() {
    val nestedList: List<List<Int>> = listOf(
        listOf(1, 4, 5),
        listOf(1, 3, 4),
        listOf(2, 6)
    )

    val listNode = toArrayListOfListNode(nestedList)
    val solution = PlusOne()
    println(solution.plusOne(intArrayOf(9, 9)))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyProjectTheme {
        Greeting("Android")
    }
}