package net.itspartner.test.n4;

public class BiggestNumberFinderImpl implements BiggestNumberFinder {
    @Override
    public int findTheBiggestNumber(int[] numbers) {
        int max = 0;
        if (numbers != null) {
            for (int item : numbers) {
                if (item > max) {
                    max = item;
                }
            }
        }
        return max;
    }
}
