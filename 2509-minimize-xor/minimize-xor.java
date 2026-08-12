class Solution {
    public static int countSetBit(int num) {
        int cnt = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                cnt++;
            }
        }

        return cnt;
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int requiredSetBitCount = countSetBit(num2);
        int currentSetBitCount = countSetBit(x);

        int bit = 0; // position of the bit

        if (currentSetBitCount < requiredSetBitCount) {
            while (currentSetBitCount < requiredSetBitCount) {
                if (!isSet(x, bit)) {
                    x = setBit(x, bit);
                    currentSetBitCount++;
                }
                bit++;
            }

        } else if (currentSetBitCount > requiredSetBitCount) {
            while (currentSetBitCount > requiredSetBitCount) {
                if (isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    currentSetBitCount--;
                }
                bit++;
            }
        }

        return x;
    }

    public static boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public static int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public static int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }
}