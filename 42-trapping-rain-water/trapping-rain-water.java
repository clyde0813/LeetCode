class Solution {
    public int trap(int[] height) {
        int h_len = height.length;
        int volume = 0;
        int left = 0;
        int right = h_len-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax){
                volume += leftMax - height[left];
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}