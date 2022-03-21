package challenges;

import java.util.ArrayList;

public class HouseRobber {

    private static final ArrayList<Node> GRAPH = new ArrayList<>();

    private static class Node {
        final int value;
        int maxMoney;
        final ArrayList<Node> adjacentNodes;

        public int getMaxMoney() {

            return maxMoney;
        }

        public void setMaxMoney(final int maxMoney) {

            this.maxMoney = maxMoney;
        }

        public Node(final int value) {
            this.value = value;
            this.adjacentNodes = new ArrayList<>();
        }

        public int getValue() {

            return value;
        }

    }

    public static void main(String[] args) {

        System.out.println(robV3(new int [] {2,7,9,3,1})); // 12
        System.out.println(robV3(new int [] {1,9,2,2,9,5,2,9})); // 27
        System.out.println(robV3(new int [] {1,2,3,1})); // 4
        System.out.println(robV3(new int [] {0})); // 0
        System.out.println(robV3(new int [] {0,1})); // 1
        System.out.println(robV3(new int [] {1,3,1})); // 3
        System.out.println(robV3(new int [] {1,7,9,4})); // 11
        System.out.println(robV3(new int [] {2,3,2})); // 4
        System.out.println(robV3(new int [] {6,3,10,8,2,10,3,5,10,5,3})); // 39
        System.out.println(robV3(new int [] {8,2,8,9,2})); // 18
        System.out.println(robV3(new int [] {8,9,9,4,10,5,6,9,7,9})); // 45
    }
    public static int robV3(final int[] nums) {
       // =============== Better Performance ==============//
       return calculateMoney(nums);

        // =============== More clear ==============//
        // GRAPH.clear();
        // createGraph(nums);
        // setAdjacentNodes(nums);
        //
        // for (int i = GRAPH.size() - 1 ; i >= 0; i --) {
        //
        //     setMaxMoneyForNode(GRAPH.get(i));
        // }
        //
        // if (GRAPH.size() == 1) {
        //     return GRAPH.get(0).getMaxMoney();
        // }

        // return Math.max(GRAPH.get(0).getMaxMoney(), GRAPH.get(1).getMaxMoney());
    }

    private static void createGraph (final int nums[]) {

        for (final int num: nums) GRAPH.add(new Node(num));
    }

    private static void setAdjacentNodes(final int[] nums) {

        int pointer = 0;

        while (pointer < nums.length - 2) {

            setAdjacencyForCurrentNode(pointer, nums.length);
            pointer++;
        }
    }

    private static void setAdjacencyForCurrentNode(final int nodeIndex, final int numsLength) {

        if (nodeIndex == numsLength - 3) {
            GRAPH.get(nodeIndex).adjacentNodes.add(GRAPH.get(nodeIndex + 2));
            return;
        }

        for (int i = nodeIndex + 2; i < nodeIndex + 4; i++) GRAPH.get(nodeIndex).adjacentNodes.add(GRAPH.get(i));
    }

    private static void setMaxMoneyForNode(final Node node) {

        if (node.adjacentNodes.size() == 0) {

            node.setMaxMoney(node.value);
            return;
        } else if (node.adjacentNodes.size() == 1) {

            node.setMaxMoney(node.value + node.adjacentNodes.get(0).getValue());
            return;
        }

        node.setMaxMoney(node.value + Math.max(node.adjacentNodes.get(0).getMaxMoney(), node.adjacentNodes.get(1).getMaxMoney()));

    }

    private static int calculateMoney(final int[] nums) {

        final int [] money = new int [nums.length];
        int pointer = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            if(i == nums.length - 1) money[pointer] = nums[i];
            else if(i == nums.length - 2) money[pointer] = nums[i];
            else if(i == nums.length - 3) money[pointer] = nums[i] + nums[i + 2];
            else {
                money[pointer] = nums[i] + Math.max(money[pointer - 2], money[pointer - 3]);
            }
            pointer++;
        }

        return Math.max(money[pointer - 1], money[pointer - 2]);
    }

}
