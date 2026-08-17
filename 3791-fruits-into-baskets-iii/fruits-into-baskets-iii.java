class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int segment[] = new int[4 * n];
        Arrays.fill(segment, -1);

        buildSegment(0, 0, n - 1, segment, baskets);

        int unplaced = 0;

        for (int fruit : fruits) {
            if (querySegmentTree(0, 0, n - 1, segment, fruit) == false) {
                unplaced++;
            }
        }

        return unplaced;
    }

    public static void buildSegment(int i, int l, int r,
                                    int[] segment, int[] baskets) {
        if (l == r) {
            segment[i] = baskets[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegment(2 * i + 1, l, mid, segment, baskets);
        buildSegment(2 * i + 2, mid + 1, r, segment, baskets);

        segment[i] = Math.max(segment[2 * i + 1], segment[2 * i + 2]);
    }

    public static boolean querySegmentTree(int i, int l, int r,
                                           int[] segment, int fruit) {
        if (segment[i] < fruit) {
            return false;
        }

        if (l == r) {
            segment[i] = -1;
            return true;
        }

        int mid = l + (r - l) / 2;
        boolean place = false;

        if (segment[2 * i + 1] >= fruit) {
            place = querySegmentTree(
                2 * i + 1, l, mid, segment, fruit
            );
        } else {
            place = querySegmentTree(
                2 * i + 2, mid + 1, r, segment, fruit
            );
        }

        segment[i] = Math.max(segment[2 * i + 1], segment[2 * i + 2]);

        return place;
    }
}