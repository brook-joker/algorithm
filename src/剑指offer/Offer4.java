package 剑指offer;

public class Offer4 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0)
            return false;

        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }

        return false;

    }
}
