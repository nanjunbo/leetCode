package self;

/**
 * 快速排序
 */
public class QuickSort {
    public void quickSort(int nums[], int left, int right){
        if (left < right){
            int index = initIndex(nums,left,right);
            quickSort(nums, left, index -1);
            quickSort(nums, index, right);
        }
    }

    private int initIndex(int[] nums, int left, int right) {
        int compare = nums[left];
        while (left <= right){
            while (nums[left] < compare){
                left ++;
            }
            while (nums[right] > compare){
                right -- ;
            }
            if (left <= right){
                swap(nums, left, right);
                left ++;
                right -- ;
            }
        }
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int nums[] = {12,33,11,1,2,3,6,4,3,1,2,5,7};
        int right = nums.length -1;
        quickSort.quickSort(nums,0,right);
        for (int num : nums) {
            System.out.println(num+" ");
        }
    }
}
