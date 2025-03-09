class Solution {
    int prev = Integer.MIN_VALUE + 100000;
    int minDiff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) minDiffInBST(root.left);
        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        if(root.right != null) minDiffInBST(root.right);
        return minDiff;
    }
}