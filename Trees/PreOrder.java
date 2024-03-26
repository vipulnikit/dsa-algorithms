import java.util.Stack;

public class PreOrder {
    // TC: O(N) | SC: O(N)
    // TC = O(N) or O(height of tree) for skewed tree.
    void preOrderRec(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    // TC: O(N) | SC: O(N)
    void preOrderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if (cur == null)
            return;
        stack.push(cur);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.data);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }
}
