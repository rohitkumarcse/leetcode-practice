class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean isPlace = false;

            for (int j = 0; j < n; j++) {
                if (fruits[i] <= baskets[j]) {
                    isPlace = true;
                    baskets[j] = -1;
                    break;
                }
            }

            if (!isPlace) {
                unplaced++;
            }
        }

        return unplaced;
    }
}