package leetcode

class Leet852 {
    fun peakIndexInMountainArray(A: IntArray): Int {
        var left = 0
        var right = A.size - 1
        while (left <= right) {
            var mid = (left + right) / 2
            if (A[left] <= A[mid] && A[mid] >=A[right]) {
                if (A[mid - 1] < A[mid]) {
                    while (A[mid] < A[mid + 1]) {
                        mid++
                    }
                } else {
                    while (A[mid] < A[mid - 1]) {
                        mid--
                    }
                }
                return mid

            } else if (A[left] < A[mid] && A[mid] < A[right]) {
                left = mid + 1
            } else if (A[left] > A[mid] && A[mid] > A[right]) {
                right = mid - 1
            }
        }
        return -1
    }

}