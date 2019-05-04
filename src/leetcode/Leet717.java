package leetcode;

public class Leet717 {
    public boolean isOneBitCharacter(int[] bits) {
        boolean flag = false;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                flag = false;
                i++;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
