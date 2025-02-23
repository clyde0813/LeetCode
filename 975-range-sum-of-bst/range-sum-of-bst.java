class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int result = 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        if(low <= root.val && high >= root.val){
            result = root.val;
        }
        return result + left + right;
    }
}