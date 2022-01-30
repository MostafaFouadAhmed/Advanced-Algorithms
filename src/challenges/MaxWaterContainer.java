package challenges;

public class MaxWaterContainer {


    public static void main(String[] args) {

        System.out.println(" MAX_AREA : " + maxArea(new int [] {1,3,2,5,25,24,5}));
        System.out.println(" MAX_AREA : " + maxArea(new int [] {1,8,6,2,5,4,8,3,7}));
        System.out.println(" MAX_AREA : " + maxArea(new int [] {1,2,3,4,5,25,24,3,4}));
        System.out.println(" MAX_AREA : " + maxArea(new int [] {1,8,100,2,100,4,8,3,7}));

    }

    public static int maxArea(int[] height) {

        int maxArea = 0;
        int frontPointer = height.length - 1;
        int rearPointer = 0;

        while (frontPointer >= rearPointer){

            maxArea = Math.max(((frontPointer - rearPointer) * ( Math.min(height[frontPointer], height[rearPointer]))) , maxArea);

            if (height[frontPointer] >= height[rearPointer]) {
                rearPointer++;

            } else {
                frontPointer--;
            }
        }
        return maxArea;
    }
}
