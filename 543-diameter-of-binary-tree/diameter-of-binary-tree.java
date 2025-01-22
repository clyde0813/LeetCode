class Solution {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.longest;    
    }
    
    public int dfs(TreeNode node){
        if(node == null) return -1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        this.longest = Math.max(this.longest, left+right+2);
        return Math.max(left, right) + 1;
    }
}