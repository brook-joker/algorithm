package leetcode

// n*log(n)
//fun findDuplicate(nums: IntArray): Int {
//    var left = 0
//    var right = nums.size - 1
//    while (left < right) {
//        val mid = left + (right - left) / 2
//        var count = 0
//        nums.forEach { if (it <= mid) count++ }
//        if (count <= mid) {
//            left = mid + 1
//        } else {
//            right = mid
//        }
//
//    }
//    return right
//}


fun findDuplicate(nums: IntArray): Int {
    var fast = 0
    var low = 0
    while (true) {
        fast = nums[nums[fast]]
        low = nums[low]
        if (fast == low) {
            fast = 0
            while (nums[fast] != nums[low]) {
                fast = nums[fast]
                low = nums[low]
            }
            return nums[low]
        }
    }
}

//
//fun lengthOfLIS(nums: IntArray): Int {
//    var leftIndex = 0
//    var maxLength = 0
//
//}