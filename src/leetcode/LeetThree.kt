package leetcode

/**
 * Created by maqiang on 2018/4/4.
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 */
class LeetThree{
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size!=nums.size
    }
}