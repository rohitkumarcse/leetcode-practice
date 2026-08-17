class NumArray {
    int n;
    int segment[];

    public NumArray(int[] nums) {
        n = nums.length;
        segment = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums, segment);
    }

    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n - 1, segment);
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, n - 1, segment);
    }

    public static void buildSegmentTree(int i, int l, int r,
                                        int[] arr, int[] segment) {
        if (l == r) {
            segment[i] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * i + 1, l, mid, arr, segment);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr, segment);

        segment[i] = segment[2 * i + 1] + segment[2 * i + 2];
    }

    public static void updateSegmentTree(int index, int val, int i,
                                         int l, int r, int[] segment) {
        if (l == r) {
            segment[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            updateSegmentTree(index, val, 2 * i + 1, l, mid, segment);
        } else {
            updateSegmentTree(index, val, 2 * i + 2, mid + 1, r, segment);
        }

        segment[i] = segment[2 * i + 1] + segment[2 * i + 2];
    }

    public static int sumRange(int start, int end, int i,
                               int l, int r, int[] segment) {
        if (l > end || r < start) {
            return 0;
        }

        if (start <= l && r <= end) {
            return segment[i];
        }

        int mid = l + (r - l) / 2;

        return sumRange(start, end, 2 * i + 1, l, mid, segment)
             + sumRange(start, end, 2 * i + 2, mid + 1, r, segment);
    }
}