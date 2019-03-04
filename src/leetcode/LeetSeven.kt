package leetcode

/**
 * Created by maqiang on 2018/4/5.
 */
class LeetSeven {
    fun rotate(matrix: Array<IntArray>): Unit {
        matrix.forEachIndexed { m, value ->
            value.forEachIndexed { n, v ->
                matrix[m][n]
            }
        }
    }
}