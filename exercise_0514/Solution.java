package exercise.exercise_0514;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return null;
        }
        permuteHelper(result,nums,0);
        return result;
    }
    private void permuteHelper(List<List<Integer>> result,int[] nums, int i){
        if(i == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for(int k=0; k<nums.length; k++){
                list.add(nums[k]);
            }
            result.add(list);
            return;
        }else{
            for(int j=i; j<nums.length; j++){
                swap(nums, i ,j);
                permuteHelper(result,nums,i+1);
                swap(nums, i ,j);
            }
        }
    }
    private void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}