import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int start = lower;

        for (int i = 0; i <= nums.length; i++) {
            int end = (i == nums.length) ? upper : nums[i] - 1;
            if (start <= end) {
                result.add(getRange(start, end));
            }
            start = end + 2;
        }

        return result;
    }

    private String getRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        MissingRanges solution = new MissingRanges();
        List<String> missingRanges = solution.findMissingRanges(nums, lower, upper);
        System.out.println(missingRanges);
    }
}
