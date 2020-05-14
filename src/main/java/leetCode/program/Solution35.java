package leetCode.program;

import leetCode.entity.ListNode;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 */
public class Solution35 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1,0,nums,0,m);
        int p1=0,p2=0,p=0;
        while(p1<m&&p2<n){
            if(nums[p1]<=nums2[p2]){
                nums1[p]=nums[p1];
                p1++;
            }else{
                nums1[p]=nums2[p2];
                p2++;
            }
            p++;
        }
        while(p1<m){
            nums1[p]=nums[p1];
            p1++;
            p++;
        }
        while(p2<n){
            nums1[p]=nums2[p2];
            p2++;
            p++;
        }
    }
}
