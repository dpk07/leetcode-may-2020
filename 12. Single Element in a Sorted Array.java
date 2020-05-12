class Solution {
  public int singleNonDuplicate(int[] nums) {
      int sum = 0;
      boolean flag = false;
      for(int i=0;i<nums.length;i++){
          if(!flag){
              sum+=nums[i];
          }else{
              if(sum!=nums[i])return sum;
              sum-=nums[i];
          }
          flag=!flag;
      }
      return sum;
  }
}