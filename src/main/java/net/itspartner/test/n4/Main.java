package net.itspartner.test.n4;

/**
 * Task:
 * 1) Implement interface BiggestNumberFinder to provide functionality of finding the biggest number from array
 * 2) Write unit tests for this class with Spock framework (http://spockframework.org/)
 */
public class Main {
    public static void main(String[] args) {
        BiggestNumberFinder biggestNumberFinder = new BiggestNumberFinderImpl();
        int[] arrayInt = {-3, 2, 115, 13, 0, -115};
        System.out.println("Max number of array is: " + biggestNumberFinder.findTheBiggestNumber(arrayInt));

        int[] arrayIntEmpty = {};
        System.out.println("Max number of empty array is: " + biggestNumberFinder.findTheBiggestNumber(arrayIntEmpty));
        System.out.println("Max number of null array is: " + biggestNumberFinder.findTheBiggestNumber(null));

        int[] arrayIntNegative = {-9,-2,-7};
        System.out.println("Max number of array where only negative elements is: " + biggestNumberFinder.findTheBiggestNumber(arrayIntNegative));

    }
}
