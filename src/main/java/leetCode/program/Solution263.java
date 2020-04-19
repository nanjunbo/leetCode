package leetCode.program;

public class Solution263 {
    public boolean isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;
        int two = num%2;
        if (two >0){
            int three = num%3;
            if (three > 0){
                int five = num%5;
                if (five > 0){
                    return false;
                }else {
                    return isUgly(num/5);
                }
            }else {
                return isUgly(num/3);
            }
        }else {
            return isUgly(num/2);
        }

    }

    public static void main(String[] args) {
        Solution263 solution263 = new Solution263();

        System.out.println(solution263.isUgly(15));
    }
}
