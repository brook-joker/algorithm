package leetcode

import kotlin.math.max


fun maxDepth(root: TreeNode?): Int {
//    if (root == null) return 0
//    val left = maxDepth(root.left)
//    val right = maxDepth(root.right)
//    return if (left > right) left + 1 else right + 1
//
    return if (root == null) {
        0
    } else {
        Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}



