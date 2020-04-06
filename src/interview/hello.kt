package interview

import leetcodekt.TTTT

open class B constructor(
    text: String?,
    a: Boolean
)

class A @JvmOverloads constructor(
    text: String?,
    a: Boolean = true,
    private val b: Boolean = true
) : B(text, a) {
    fun t() {

        val var4 = 4
        val s = var4 and 4 != 0
        println(s)
    }
}

fun main(args: Array<String>) {
   TTTT().getRow(3)
}

