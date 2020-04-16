package leetCode.program;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class Solution168 {

    public String convertToTitle(int n) {
        int count = n;
        StringBuffer chars=new StringBuffer();
        while(count >0){
            int num = count%26;
            count = count/ 26;
            if(num == 0){
                num = 26;
                count -= 1;
            }
            chars.insert(0,(char)(65 + num -1));
        }
        return chars.toString();
    }
}
