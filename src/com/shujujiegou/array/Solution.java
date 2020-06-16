package com.shujujiegou.array;
/*示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]*/
public class Solution {
 /*   private int elemts;
    private int length;*/
    private static int nums[]=new int[]{3,2,4,6};
    public int[] twoSum(int[] nums,int target){
        int instr[] = new int[2];
        int i,j;
        for(i=0;i<nums.length;i++){
            for(j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target&&i<j){
                    instr[0]=i;
                        instr[1]=j;
                    break;
                }
            }
        }
        return instr;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int intnums[]=solution.twoSum(nums,6);
        for(int i=0;i<intnums.length;i++){
            System.out.println(intnums[i]);
        }
    }
}
