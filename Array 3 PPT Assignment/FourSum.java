import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;

            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;

                int left = b + 1;
                int right = n - 1;

                while (left < right) {
                    int currentSum = nums[a] + nums[b] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;

                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum solution = new FourSum();
        List<List<Integer>> quadruplets = solution.fourSum(nums, target);

        for (List<Integer> quadruplet : quadruplets) {
            System.out.println(quadruplet);
        }
    }
}
