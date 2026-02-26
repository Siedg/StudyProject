package br.com.studyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.studyproject.exercises.isPalindrome
import br.com.studyproject.exercisesII.isValidParentheses
import br.com.studyproject.exercisesII.runBestTimeToBuySellTests
import br.com.studyproject.exercisesII.runContainsDuplicateTests
import br.com.studyproject.exercisesII.runFibonacciTests
import br.com.studyproject.exercisesII.runFirstUniqueCharTests
import br.com.studyproject.exercisesII.runHappyNumberTests
import br.com.studyproject.exercisesII.runIntersectionTests
import br.com.studyproject.exercisesII.runMergeTests
import br.com.studyproject.exercisesII.runMissingNumberTests
import br.com.studyproject.exercisesII.runMoveZeroTests
import br.com.studyproject.exercisesII.runReverseStringTests
import br.com.studyproject.exercisesII.runTwoSumTests
import br.com.studyproject.exercisesII.runValidAnagramTests
import br.com.studyproject.exercisesII.runValidParenthesesTests
import br.com.studyproject.ui.theme.StudyProjectTheme

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

    runFirstUniqueCharTests()

}
