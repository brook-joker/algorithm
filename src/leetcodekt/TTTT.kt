package leetcodekt

class TTTT {
    fun getRow(rowIndex: Int): List<Int> {
        val row = ArrayList<Int>(rowIndex + 1)
        for (i in 0..rowIndex) {
            row.add(1)
            if (i >= 2) {
                for (j in i - 1 downTo 1) {
                    row[j] += row[j - 1]
                }
            }
        }
        return row
    }
}