class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int numsLen = nums.length;
        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<numsLen-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            left = i+1;
            right = numsLen-1;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum<0){
                    left++;
                } else if(sum>0){
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
}