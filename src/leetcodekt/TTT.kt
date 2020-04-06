package leetcodekt

class TTT {

    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        reverse(1, numRows, result)
        return result
    }

    fun reverse(step: Int, numRows: Int, result: MutableList<MutableList<Int>>) {
        if (step > numRows) {
            return
        }
        val list = mutableListOf(1)
        for (i in 1 until step) {
            if (i == step - 1) {
                list.add(1)
            } else {
                val preList = result[step - 2]
                list.add(preList[i - 1] + preList[i])
            }

        }
        result.add(step - 1, list)
        if (step + 1 > numRows) {
            return
        }
        reverse(step + 1, numRows, result)
    }


}