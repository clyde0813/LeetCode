class Solution {
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root!=null){
            bstToGst(root.right);
            root.val += val;
            val = root.val;
            bstToGst(root.left);
        }
        return root;
    }
}