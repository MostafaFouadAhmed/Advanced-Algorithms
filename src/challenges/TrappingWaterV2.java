package challenges;

public class TrappingWaterV2 {

    public static void main(String[] args) {

        System.out.println(trap(new int []{0,1,0,2,1,0,1,3,2,1,2,1})); // =6
        System.out.println(trap(new int []{4,2,0,3,2,5})); // =9
        System.out.println(trap(new int []{5,2,1,2,1,5})); // =14
        System.out.println(trap(new int []{0,2,0})); // =0
        System.out.println(trap(new int []{4,2,3})); // =1
        System.out.println(trap(new int []{5,4,1,2})); // =1
        System.out.println(trap(new int []{5,5,1,7,1,1,5,2,7,6})); // =23
        System.out.println(trap(new int []{0,7,1,4,6})); // =7
        System.out.println(trap(new int []{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2})); // =26
        System.out.println(trap(new int []{4,9,4,5,3,2})); // =1
        System.out.println(trap(new int []{1,7,8})); // =1
        System.out.println(trap(new int []{1})); // =1

    }

    public static int trap(final int [] heights) {

        int leftPointer = 0;
        int rightPointer = 0;

        for (int i = 0; i < heights.length - 1 ; i++) {

            if(heights[i] > 0 && heights[i] > heights[i+1]) {
                leftPointer = i;
                break;
            }
            leftPointer = -1;
        }

        for (int i = heights.length - 1; i > leftPointer ; i--) {

            if(heights[i] > 0 && heights[i] > heights[i - 1]) {
                rightPointer = i;
                break;
            }
            rightPointer = -1;
        }

        if (leftPointer == -1) {
            return 0;
        }

        if (rightPointer == -1) {
            rightPointer = leftPointer;
        }

        int lastMaxHeightLeft = heights[leftPointer];
        int lastMaxHeightRight = heights[rightPointer];
        int currentCalculationPointer = leftPointer;
        int totalTrappedWater = 0;

        while (leftPointer < rightPointer) {

            if (Math.min(lastMaxHeightLeft, lastMaxHeightRight) - heights[currentCalculationPointer] > 0) {
                totalTrappedWater += Math.min(lastMaxHeightLeft, lastMaxHeightRight) - heights[currentCalculationPointer];

            }

            if (heights[leftPointer] > heights[rightPointer]) {

                rightPointer--;

                currentCalculationPointer = rightPointer;

                if (heights[rightPointer] > lastMaxHeightRight) {
                    lastMaxHeightRight = heights[rightPointer];
                }

            } else {
                leftPointer++;

                currentCalculationPointer = leftPointer;

                if (heights[leftPointer] > lastMaxHeightLeft) {
                    lastMaxHeightLeft = heights[leftPointer];
                }
            }

        }

        return totalTrappedWater;
    }
}
