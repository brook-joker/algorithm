package leetcode;


public class LeetCode846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length < W || hand.length % W != 0) return false;
        int[] array = new int[W];
        for (int i : hand) {
            array[i % W]++;
        }
        for (int i = 0; i < W - 1; i++) {
            if (array[i] != array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int lArea = (C - A) * (D - B);
        int rArea = (G - E) * (H - F);
        if (C <= E || G <= A || B >= H || F >= D) {
            return lArea + rArea;
        } else {
            int lx = Math.max(A, E);
            int ly = Math.max(B, F);
            int rx = Math.min(C, G);
            int ry = Math.min(D, H);
            return lArea + rArea - (rx - lx) * (ry - ly);
        }
    }
}
