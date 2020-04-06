package leetcodekt

class `1` {
    fun reverseString(s: CharArray): Unit {
        reverseString(0, s.size - 1, s)
    }

    fun reverseString(l: Int, r: Int, s: CharArray) {
        if (l >= r) {
            return
        }
        val tmp = s[l]
        s[l] = s[r]
        s[r] = tmp
        reverseString(l+1, r-1, s)
    }
}