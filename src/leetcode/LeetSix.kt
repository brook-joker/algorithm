package leetcode

import java.util.*

/**
 * Created by maqiang on 2018/4/5.
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。`
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class LeetSix {

    //O(n2)
//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        val res = intArrayOf(0, 0)
//        nums.forEachIndexed { index, value ->
//            val index2 = nums.indexOf(target - value)
//            if (index2 != -1 && index != index2) {
//                res[0] = index
//                res[1] = index2
//                return res
//            } else {
//                return@forEachIndexed
//            }
//        }
//        return res
//    }

    //O(n)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(0, 0)
        val hashMap = HashMap<Int, Int>(nums.size)
        nums.forEachIndexed { index, value ->
            val key = target - value
            if (hashMap.containsKey(key) && hashMap[key]!=index) {
                res[0] = index
                res[1] = hashMap[key]?:return@forEachIndexed
                return res
            } else {
                hashMap[value] = index
                return@forEachIndexed
            }
        }
        return res
    }

}