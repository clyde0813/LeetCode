class Solution {
    public int dfs(TreeNode node){
        if(node==null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}