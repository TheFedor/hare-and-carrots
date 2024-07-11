public class HareAndCarrots {
    private static int[] carrots = {14, 3, 0, 0, 10}; //ответ 23

    private static final int MAX_TRIPS = 10;
    private static final int MAX_WEIGHT = 5;
    private static final int[][][] CARROT_COMB_FOR_EACH_TRIP_OPTION = {
            {{5,0,0,0,0}},
            {{3,1,0,0,0},{4,0,0,0,0}},
            {{1,2,0,0,0},{2,0,1,0,0},{2,1,0,0,0},{3,0,0,0,0}},
            {{0,1,1,0,0},{0,2,0,0,0},{1,0,0,1,0},{1,0,1,0,0},{1,1,0,0,0},{2,0,0,0,0}},
            {{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0},{0,1,0,0,0},{1,0,0,0,0}}
    };

    public static void main(String[] args) {
        int[] result = maxNumberOfCarrots();
        System.out.println("резульат = " + result[0] + " ; число ходок: " + result[1]);
    }

    private static int[] maxNumberOfCarrots() {
        int totalCarrots = 0;
        int numberOfTrips = 0;

        for (int i = 0; i < CARROT_COMB_FOR_EACH_TRIP_OPTION.length; ++i) {
            for (int j = 0; j < CARROT_COMB_FOR_EACH_TRIP_OPTION[i].length; ++j) {
                while (canPerformCombination(carrots, CARROT_COMB_FOR_EACH_TRIP_OPTION[i][j])) {
                    totalCarrots += MAX_WEIGHT - i;
                    numberOfTrips += 1;
                    if (numberOfTrips == MAX_TRIPS)
                        return new int[] {totalCarrots, numberOfTrips};
                }
            }
        }

        return new int[] {totalCarrots, numberOfTrips};
    }

    private static boolean canPerformCombination(int[] arr1, int[] arr2) {
        for (int i = 0; i < 5; ++i) {
            if (arr1[i] - arr2[i] < 0)
                return false;
        }
        subtractTheCombination(arr2);
        return true;
    }

    private static void subtractTheCombination(int[] arr) {
        for (int i = 0; i < 5; ++i) {
            carrots[i] -= arr[i];
        }
    }

}
