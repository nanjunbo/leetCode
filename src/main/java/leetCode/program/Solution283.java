package leetCode.program;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            while (nums[fast] == 0){
                fast ++;
                if (fast == nums.length){
                    return;
                }
            }
            while (nums[slow] != 0){
                slow ++;
                if (slow == nums.length){
                    return;
                }
            }
            if (fast > slow){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
            }
            fast ++;
        }
    }

    public static void main(String[] args) {
        Solution283 x = new Solution283();
//        int[] nums = new int[]{0,1,0,3,12,0};
        int[] nums = new int[]{1,0};
        x.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);

        }

    }
}
