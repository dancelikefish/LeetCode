import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(myTwoSum(new int[]{2, 4, 6, 8, 9}, 13)));
    }

    public static int[] myTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int sum = number + nums[j];
                if (sum == target) {
                    return new int[]{i,j};
                }
            }

        }
        return null;
    }

    /*
    * It turns out we can do it in one-pass.
    * While we iterate and inserting elements into the table,
    * we also look back to check if current element's complement already exists in the table.
    * If it exists, we have found a solution and return immediately.
    */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
