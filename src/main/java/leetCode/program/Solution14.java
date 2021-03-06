package leetCode.program;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String commonStr = strs[0];
        for (int i=1; i<strs.length; i++){
            while (strs[i].indexOf(commonStr) != 0){
                commonStr = commonStr.substring(0, commonStr.length()-1);
                if (commonStr.length() == 0){
                    return "";
                }
            }
        }
        return commonStr;
    }
}
