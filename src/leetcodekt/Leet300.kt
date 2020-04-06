package leetcodekt

class Leet300 {
    fun lengthOfLIS(nums: IntArray): Int {
        var max = nums[0]
        var result = 0
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                max += nums[i]
            } else {
                result = Math.max(result, max)
                max = nums[i]
            }
        }
        return result
    }
}