class Solution {
  public int majorityElement(int[] nums) {
      if(nums.length==1)return nums[0];
      HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
      for(int num:nums){
          if(hm.containsKey(num)){
              int count = hm.get(num);
              //As soon as we come across an element with
              //count more than n/2 we can return
              //dont need to iterate through the hm
              if((count+1)>(nums.length/2))
                  return num;
              hm.put(num,count+1);
          }else{
              hm.put(num,1);
          }
      }
      return 1;
  }
}