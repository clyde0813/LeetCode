class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int result = 0;
        if(low < root.val){
            result += rangeSumBST(root.left, low, high);
        }
        if(high > root.val){
            result += rangeSumBST(root.right, low, high);
        }
        if(low <= root.val && high >= root.val){
            result += root.val;
        }
        return result; 
    }
}