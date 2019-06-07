package leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet987 {

    List<Location> locations;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        preOrder(root, 0, 0);
        Collections.sort(locations);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int prex = locations.get(0).x;
        for (Location location : locations) {
            if (location.x != prex) {
                prex = location.x;
                result.add(new ArrayList<>());
            }

            result.get(result.size() - 1).add(location.val);

        }
        return result;
    }

    void preOrder(TreeNode root, int x, int y) {
        if (root != null) {
            locations.add(new Location(x, y, root.val));
            preOrder(root.left, x - 1, y - 1);
            preOrder(root.right, x + 1, y - 1);
        }

    }
    class Location implements Comparable<Location> {
        private int x;
        private int y;
        private int val;

        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(@NotNull Location o) {
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            } else if (this.y != o.y) {
                return Integer.compare(this.y, o.y);
            } else {
                return Integer.compare(this.val, o.val);
            }
        }
    }
}
