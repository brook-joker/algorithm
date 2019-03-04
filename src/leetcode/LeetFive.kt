package leetcode

/**
 * Created by maqiang on 2018/4/4.
 * 将包含 n 个元素的数组向右旋转 k 步。

   例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 */
class LeetFive {
    fun rotate(nums: IntArray, k: Int): Unit {

        val turns = k % nums.size
        val middle = nums.size - turns

        reverse(0, middle-1, nums)
        reverse(middle, nums.size - 1, nums)
        reverse(0, nums.size - 1, nums)

        nums.forEach { print(it) }
    }

    private fun reverse(l: Int, r: Int, nums: IntArray) {
        var left = l
        var right = r
        while (left <= right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}