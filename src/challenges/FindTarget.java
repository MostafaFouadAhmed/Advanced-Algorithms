package challenges;

import java.util.HashMap;

public class FindTarget {

    public static void main(String[] args) {
        int [] nums = {-3,4,3,590};
        int [] solution = twoSum(nums, 0);

        assert solution != null;
        for (Integer element : solution) {
            System.out.println(element);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerMap = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {

            if (integerMap.containsKey(target - nums[i])) {
                return new int[]{i, integerMap.get(target - nums[i])};
            }

            integerMap.put(nums[i],i);

        }
        return null;
    }

}
