package challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;


public class TrappingRainWater {

    public static void main(String[] args) {

        // System.out.println(trap(new int []{0,1,0,2,1,0,1,3,2,1,2,1})); // =6
        // System.out.println(trap(new int []{4,2,0,3,2,5})); // =9
        // System.out.println(trap(new int []{5,2,1,2,1,5})); // =14
        // System.out.println(trap(new int []{0,2,0})); // =0
        // System.out.println(trap(new int []{4,2,3})); // =1
        // System.out.println(trap(new int []{5,4,1,2})); // =1
        // System.out.println(trap(new int []{5,5,1,7,1,1,5,2,7,6})); // =23
        // System.out.println(trap(new int []{0,7,1,4,6})); // =7
        // System.out.println(trap(new int []{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2})); // =26
        System.out.println(trap(new int []{4,9,4,5,3,2})); // =1

    }

    public static int trap(int[] heights) {

        int trappedWater = 0;
        final int[] heightAndIndex = getStartHeightAndItsIndex(heights);
        final int [] endHeightAndIndex = getEndHeightAndItsIndex(heights);
        if (Objects.isNull(heightAndIndex)) {
            return 0;
        }
        final LinkedList<Integer> clusterIndices = getClusters(heights, heightAndIndex[1]);
        int currentIndex = heightAndIndex[1] + 1;

        // IF THERE IS NO CLUSTERS
        if (clusterIndices.size() == 0) {

            int startHeight = heightAndIndex[0];
            int referenceHeight = Math.min(startHeight, heights[endHeightAndIndex[0]]);

            if (referenceHeight == 0 ) {
                return 0;
            }

            // IF THERE IS NO CLUSTERS BUT THE END HEIGHT IS LESS THAN THE START HEIGHT --> THERE IS WATER LEAKS SO WE NEED TO ITERATE OVER EACH BUILDING
            if (heights[heightAndIndex[1]] > heights[heights.length - 1]) {
                for (int i = 1; i < heights.length - 1; i++){
                    if(heights[i] < heights[heightAndIndex[1]] && heights[i] < heights[i+1]) {
                        trappedWater = trappedWater + Math.abs(heights[i] - referenceHeight);
                    }
                }
                return trappedWater;
            }

            // IF THERE IS NO CLUSTERS BUT THE START HEIGHT IS EQUAL OR TALLER THAN THE END HEIGHT --> THERE IS NO WATER LEAKS
            while (currentIndex < heights.length - 1) {
                trappedWater = trappedWater + Math.abs(heights[currentIndex] - referenceHeight);
                currentIndex++;
            }
            return trappedWater;
        }

        // IF THERE ARE SOME CLUSTERS --> ITERATE ON BUILDINGS BETWEEN EACH 2 CONSECUTIVE CLUSTERS
        int previousCluster = currentIndex - 1;
        final int [] trappedWaterAndPreviousCluster = getTrappedWaterOfCluster(clusterIndices, heights, previousCluster);
        trappedWater = trappedWaterAndPreviousCluster[0];
        previousCluster = trappedWaterAndPreviousCluster[1];

        final int [] beyondHeights = Arrays.copyOfRange(heights, previousCluster, heights.length);
        final LinkedList<Integer> beyondClusters = getBeyondClusters(beyondHeights);
        if (!beyondClusters.isEmpty()) {
            trappedWater = trappedWater + getTrappedWaterOfBeyondCluster(beyondClusters, beyondHeights, beyondClusters.pop())[0];
        }

        return trappedWater;
    }

    private static int [] getStartHeightAndItsIndex(final int [] heights) {
        for (int i = 0; i < heights.length - 1 ; i++) {

            if(heights[i] > 0 && heights[i] > heights[i+1]) {
                return new int [] {heights[i], i};
            }
        }
        return null;
    }

    private static int [] getEndHeightAndItsIndex(final int [] heights) {
        int currentEnd = Integer.MAX_VALUE;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= heights[i - 1]) {
                return new int []{heights[i], i};
            }
        }
        return null;
    }

    private static LinkedList<Integer> getClusters(final int [] heights, final int startIndex) {
        final LinkedList<Integer> clusters = new LinkedList<>();
        int currentMaxHeight = heights[startIndex];

        for (int i = startIndex + 1 ; i < heights.length; i++) {

            if (i == heights.length - 1 && heights[i] > heights[i - 1] && heights[i] >= currentMaxHeight) {
                clusters.add(i);
                break;
            }
            if (heights[i] >= currentMaxHeight && heights[i + 1] < heights[i]) {
                clusters.add(i);
                currentMaxHeight = heights[i];
            }
        }

        return clusters;
    }

    private static int [] getTrappedWaterOfCluster(final LinkedList<Integer> clusterIndices, final int [] heights, int previousCluster) {
        int trappedWater = 0;
        while (!clusterIndices.isEmpty()) {

            int currentCluster = clusterIndices.pop();
            int referenceHeight = Math.min(heights[previousCluster], heights[currentCluster]);

            for (int i = previousCluster; i < currentCluster; i++) {
                trappedWater = trappedWater + Math.abs(heights[i] - referenceHeight);
            }
            previousCluster = currentCluster;
        }
        return new int []{trappedWater,previousCluster};
    }

    private static int [] getTrappedWaterOfBeyondCluster(final LinkedList<Integer> clusterIndices, final int [] heights, int previousCluster) {
        int trappedWater = 0;
        while (!clusterIndices.isEmpty()) {

            int currentCluster = clusterIndices.pop();
            int referenceHeight = Math.min(heights[previousCluster], heights[currentCluster]);

            for (int i = previousCluster + 1; i < currentCluster; i++) {
                trappedWater = trappedWater + Math.abs(heights[i] - referenceHeight);
            }
            previousCluster = currentCluster;
        }
        return new int []{trappedWater,previousCluster};
    }

    private static LinkedList<Integer> getBeyondClusters(final int [] heights) {

        if (heights.length == 1) {
            return new LinkedList<>();
        }

        final LinkedList<Integer> beyondClusters = new LinkedList<>();
        final int [] heightAndIndex = getStartHeightAndItsIndex(heights);

        assert heightAndIndex != null;
        final int startIndex = heightAndIndex[1];
        beyondClusters.add(startIndex);
        beyondClusters.addAll(getClusters(heights, startIndex + 1));

        return beyondClusters;
    }

}
