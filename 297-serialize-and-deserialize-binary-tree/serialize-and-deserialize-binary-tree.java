public class Codec {
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                sb.append(" ").append(node.left.val);
            } else {
                sb.append(" ").append("null");
            }
            if(node.right!=null){
                queue.add(node.right);
                sb.append(" ").append(node.right.val);
            } else {
                sb.append(" ").append("null");
            }
        }
        return new String(sb);
    }

    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] strList = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!strList[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strList[index]));
                queue.add(node.left);
            }
            index += 1;
            if(!strList[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strList[index]));
                queue.add(node.right);
            }
            index += 1;
        }
        return root;
    }
}